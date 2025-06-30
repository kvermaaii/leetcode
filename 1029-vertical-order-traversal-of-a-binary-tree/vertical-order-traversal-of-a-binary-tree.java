/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Tuple{
        TreeNode node;
        int level;
        int col;
        public Tuple(TreeNode node, int level, int col){
            this.node = node;
            this.level = level;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Tuple> q = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        q.add(new Tuple(root,0,0));
        while( !q.isEmpty()){
            Tuple curr = q.poll();
            if(!map.containsKey(curr.col)){
                map.put(curr.col, new TreeMap<>());
            }
            if(!map.get(curr.col).containsKey(curr.level)){
                map.get(curr.col).put(curr.level, new PriorityQueue<>());
            }
            map.get(curr.col).get(curr.level).add(curr.node.val);
            if(curr.node.left != null){
                q.add(new Tuple(curr.node.left, curr.level + 1, curr.col - 1));
            }
            if(curr.node.right != null){
                q.add(new Tuple(curr.node.right, curr.level + 1, curr.col + 1));
            }
        }
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> m : map.values()){
            for(PriorityQueue<Integer> pq : m.values()){
                while(!pq.isEmpty()){
                    list.add(pq.poll());
                }
            }
            result.add(new LinkedList<>(list));
            list.clear();
        }
        return result;
    }
}