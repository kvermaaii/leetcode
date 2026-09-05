#!/usr/bin/env python3
import html
import os
import re
from collections import defaultdict

ROOT = os.path.abspath(os.path.join(os.path.dirname(__file__), ".."))
EXTS = (".java", ".py", ".cpp", ".c", ".js", ".ts", ".go", ".cs", ".rb", ".kt")


def clean_text(s: str) -> str:
    s = html.unescape(s)
    s = re.sub(r"<[^>]+>", " ", s)
    s = s.replace("\xa0", " ")
    return re.sub(r"\s+", " ", s).strip()


def folder_title(name: str) -> str:
    x = re.sub(r"^\d+\s*[-_]?\s*", "", name).strip()
    x = re.sub(r"[-_]", " ", x)
    x = re.sub(r"\s+", " ", x).strip()
    return x.title() if x else name


def folder_slug(name: str) -> str:
    x = re.sub(r"^\d+\s*[-_]?\s*", "", name).strip().lower()
    return re.sub(r"[^a-z0-9]+", "-", x).strip("-")


def has_any(text: str, *keys: str) -> bool:
    return any(k in text for k in keys)


def topic_list(text_blob: str):
    topics = []
    if has_any(text_blob, "tree", "bst", "binary tree", "lca", "serialize", "inorder", "preorder", "postorder"):
        topics.append("Trees & BST")
    if has_any(text_blob, "linked list", "listnode", "reverse list", "merge two sorted lists", "copy list", "palindrome linked", "middle of the linked"):
        topics.append("Linked List")
    if has_any(text_blob, "graph", "island", "flood fill", "rotting oranges", "celebrity", "robot simulation", "word squares", "bfs", "dfs"):
        topics.append("Graphs (BFS/DFS)")
    if has_any(text_blob, "sliding window", "substring", "subarray", "window", "max consecutive ones iii", "nice subarrays"):
        topics.append("Sliding Window")
    if has_any(text_blob, "two sum", "3sum", "two pointers", "palindrome", "intersection", "remove duplicates", "reverse words"):
        topics.append("Two Pointers")
    if has_any(text_blob, "stack", "parentheses", "asteroid", "next greater", "monotonic", "stock span", "min stack"):
        topics.append("Stack / Monotonic Stack")
    if has_any(text_blob, "queue", "deque", "level order", "zigzag", "populate", "kth largest element in a stream"):
        topics.append("Queue / Deque")
    if has_any(text_blob, "heap", "priority queue", "kth largest", "top k"):
        topics.append("Heap / Priority Queue")
    if has_any(text_blob, "binary search", "sorted array", "search in rotated", "kth smallest", "single element in a sorted array", "floor and ceil"):
        topics.append("Binary Search")
    if has_any(text_blob, "dynamic programming", "house robber", "coin change", "triangle", "target sum", "partition equal subset", "knapsack", "rod cutting", "subset sum", "perfect sum", "perfect-sum", "count subsets with sum", "unique paths", "minimum path sum"):
        topics.append("Dynamic Programming")
    if has_any(text_blob, "backtracking", "permutations", "subsets", "combination sum", "n-queens", "palindrome partitioning"):
        topics.append("Backtracking")
    if has_any(text_blob, "greedy", "assign cookies", "can place flowers", "minimum penalty for a shop"):
        topics.append("Greedy")
    if has_any(text_blob, "prefix sum", "subarray sum equals k", "target sum", "nice subarrays"):
        topics.append("Prefix Sum")
    if has_any(text_blob, "hash", "frequency", "distinct", "two sum", "repeated dna", "majority"):
        topics.append("Hashing")
    if has_any(text_blob, "bitwise", "power of two", "power of three", "power of four", "xor", "monobit", "binary reflection"):
        topics.append("Bit Manipulation")
    if has_any(text_blob, "string", "roman", "prefix", "atoi", "repeated string", "vowel", "reverse words", "palindrome"):
        topics.append("Strings")
    if has_any(text_blob, "math", "gcd", "prime", "count commas"):
        topics.append("Math")
    if has_any(text_blob, "design", "lru cache", "lfu cache", "min stack", "implement queue", "implement stack", "iterator", "serialize and deserialize"):
        topics.append("Design")
    if has_any(text_blob, "sort", "permutation", "kth", "top k", "lexicographically", "swap"):
        topics.append("Sorting / Ordering")
    if has_any(text_blob, "array", "nums", "subarray", "sum", "maximum", "minimum"):
        topics.append("Arrays")

    seen = set()
    topics = [t for t in topics if not (t in seen or seen.add(t))]
    return topics or ["Arrays"]


def load_entries():
    entries = []
    candidate_dirs = []
    for dirpath, dirnames, filenames in os.walk(ROOT):
        rel = os.path.relpath(dirpath, ROOT)
        if rel == ".":
            dirnames[:] = [d for d in dirnames if not d.startswith(".")]
            continue
        parts = rel.split(os.sep)
        if any(p.startswith(".") for p in parts):
            dirnames[:] = []
            continue
        if "README.md" in filenames:
            candidate_dirs.append(rel)

    for name in sorted(candidate_dirs):
        folder = os.path.join(ROOT, name)
        readme = os.path.join(folder, "README.md")
        if not os.path.exists(readme):
            continue

        text = open(readme, encoding="utf-8", errors="ignore").read()
        lines = [ln.strip() for ln in text.splitlines() if ln.strip()]

        m = re.search(r'<h2><a href="([^"]+)">([^<]+)</a></h2>', text)
        if m:
            lc_url = m.group(1).strip()
            title = clean_text(m.group(2))
        else:
            title = folder_title(name)
            lc_url = ""
            md_link = re.search(r"\((https?://leetcode\.com/problems/[^)]+)\)", text)
            if md_link:
                lc_url = md_link.group(1)

        diff = "Unknown"
        m = re.search(r"Difficulty-([A-Za-z]+)", text)
        if m:
            diff = m.group(1).capitalize()
        else:
            m = re.search(r"Difficulty:\s*([A-Za-z]+)", text)
            if m:
                diff = m.group(1).capitalize()
            elif lines and lines[0].lower() in {"easy", "medium", "hard"}:
                diff = lines[0].capitalize()

        desc = ""
        after = text.split("<hr>", 1)[1] if "<hr>" in text else text
        for m in re.finditer(r"<p>(.*?)</p>", after, flags=re.S):
            t = clean_text(m.group(1))
            if not t:
                continue
            low = t.lower()
            if any(x in low for x in ("example", "constraints", "follow-up", "input:", "output:")):
                continue
            desc = t
            break

        if not desc:
            for ln in lines:
                low = ln.lower()
                if any(low.startswith(x) for x in ("easy", "medium", "hard", "topics:", "companies:", "hint", "example", "constraints", "follow-up", "follow up", "input:", "output:")):
                    continue
                if ln.startswith("!["):
                    continue
                t = clean_text(ln)
                if len(t) >= 45:
                    desc = t
                    break

        if not desc:
            desc = clean_text(after)[:180]
        if len(desc) > 120:
            desc = desc[:117].rstrip() + "..."

        code_files = [f for f in os.listdir(folder) if f.lower().endswith(EXTS)]
        solution = ""
        if code_files:
            code_files.sort(key=lambda x: (0 if x.lower().endswith(".java") else 1, x.lower()))
            solution = f"./{name}/{code_files[0]}"

        num = "N/A"
        m = re.match(r"^(\d+)", name)
        if m:
            num = m.group(1)

        if not lc_url and num.isdigit() and folder_slug(name):
            lc_url = f"https://leetcode.com/problems/{folder_slug(name)}"

        blob = " ".join([name, title, desc, lc_url]).lower()
        topics = topic_list(blob)

        high_ids = {
            "1", "2", "3", "15", "20", "21", "53", "98", "102", "104", "105", "106", "110", "124", "131", "138", "146", "155", "160", "169", "198", "206", "209", "213", "215", "230", "236", "239", "277", "297", "322", "347", "416", "494", "560", "733"
        }
        if num in high_ids:
            importance = "High"
        elif num.isdigit() and int(num) >= 3000:
            importance = "Low"
        elif diff == "Hard":
            importance = "High"
        else:
            importance = "Medium"

        entries.append({
            "folder": name,
            "num": num,
            "title": title,
            "leetcode": lc_url,
            "difficulty": diff,
            "description": desc,
            "solution": solution,
            "topics": topics,
            "importance": importance,
            "has_code": bool(code_files),
            "standard_readme": bool(re.search(r'<h2><a href="([^"]+)">([^<]+)</a></h2>', text)),
        })

    return entries


def dedupe(entries):
    by_id = {}
    non_id = []

    def score(e):
        return (
            1 if e["has_code"] else 0,
            1 if e["standard_readme"] else 0,
            1 if e["leetcode"] else 0,
            len(e["description"]),
        )

    for e in entries:
        if e["num"] == "N/A":
            non_id.append(e)
            continue
        cur = by_id.get(e["num"])
        if cur is None or score(e) > score(cur):
            by_id[e["num"]] = e

    return list(by_id.values()) + non_id


def build_readme(entries):
    topic_map = defaultdict(list)
    for e in entries:
        for t in e["topics"]:
            topic_map[t].append(e)

    preferred = [
        "Arrays", "Hashing", "Two Pointers", "Sliding Window", "Prefix Sum", "Binary Search", "Sorting / Ordering",
        "Stack / Monotonic Stack", "Queue / Deque", "Heap / Priority Queue", "Linked List", "Trees & BST",
        "Graphs (BFS/DFS)", "Dynamic Programming", "Backtracking", "Greedy", "Strings", "Bit Manipulation", "Math", "Design",
    ]
    topics = [t for t in preferred if t in topic_map] + sorted(t for t in topic_map if t not in preferred)

    out = []
    out.append("# LeetCode Interview Prep Tracker\n")
    out.append("This repository is organized topic-wise so you can quickly revise for DSE interviews.\n")
    out.append("> **How to use:** Tick the checkbox in each topic table when you revise that question. Some questions intentionally appear in multiple topics/patterns.\n")
    out.append(f"\n**Total questions indexed:** {len(entries)}\n")
    out.append("\n## Topic Index\n")

    for t in topics:
        anchor = t.lower().replace("&", "").replace("/", "").replace("(", "").replace(")", "").replace(" ", "-")
        out.append(f"- [{t}](#{anchor}) ({len(topic_map[t])})")
    out.append("")

    for t in topics:
        out.append(f"## {t}\n")
        out.append("| Revise | # | Question | Difficulty | Importance | Local | LeetCode | Description |")
        out.append("|---|---:|---|---|---|---|---|---|")
        rows = sorted(topic_map[t], key=lambda e: (10**9 if not e["num"].isdigit() else int(e["num"]), e["title"].lower()))
        for e in rows:
            question = f"[{e['title']}](./{e['folder']}/README.md)"
            code = f"[Code]({e['solution']})" if e["solution"] else "—"
            lc = f"[Link]({e['leetcode']})" if e["leetcode"] else "—"
            num = e["num"] if e["num"] != "N/A" else "—"
            out.append(f"| - [ ] | {num} | {question} | {e['difficulty']} | {e['importance']} | {code} | {lc} | {e['description']} |")
        out.append("")

    out.append("---\n")
    out.append("### Notes\n")
    out.append("- **Importance** is an interview-oriented estimate (High/Medium/Low), not an official LeetCode metric.")
    out.append("- If a question is shown in multiple sections, that is intentional for multi-pattern revision.")
    out.append("- You can use GitHub markdown checkboxes in-place to track revision progress.")
    return "\n".join(out) + "\n"


def main():
    entries = dedupe(load_entries())
    readme_text = build_readme(entries)
    out_path = os.path.join(ROOT, "README.md")
    with open(out_path, "w", encoding="utf-8") as f:
        f.write(readme_text)
    print(f"Wrote {out_path} with {len(entries)} unique questions")


if __name__ == "__main__":
    main()
