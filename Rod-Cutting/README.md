Title: Rod Cutting

Difficulty: Medium
Accuracy: 60.66%
Submissions: 183K+
Average Time: 20m
Points: 4

Problem
Given a rod of length n and a 1-indexed array price where price[i] denotes the value of a piece of length i, determine the maximum value obtainable by cutting up the rod and selling the pieces.

Note: n = price.length, and price is 1-indexed conceptually (i.e., price is the price of length 1).

Examples

Input: price = [1, 5, 8, 9, 10,
Output: 22
Explanation: Cut into lengths 2 and 6 → 5 + 17 = 22.

Input: price = [3, 5, 8, 9, 10,
Output: 24
Explanation: Cut into eight pieces of length 1 → 8 × price = 8 × 3 = 24.

Input: price =
Output: 3
Explanation: Only piece of length 1 is possible.

Constraints

1 ≤ price.length ≤ 10^3

1 ≤ price[i] ≤ 10^6

Expected Complexities

Time: O(n^2)

Space: O(n)

Approach
This is an unbounded knapsack problem. Let dp[L] be the maximum value for rod length L. For each L from 1 to n, try the first cut of size k (1 ≤ k ≤ L) and combine its price with dp[L − k].

Pseudocode (1D DP)

Initialize dp array of size n + 1 with zeros.

For L in 1..n:

For k in 1..L:

dp[L] = max(dp[L], price[k] + dp[L − k]) // price is 1-indexed

Answer is dp[n].
