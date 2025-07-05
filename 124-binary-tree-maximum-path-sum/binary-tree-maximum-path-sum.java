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
        int maxLTR;
        int maxPS;
        Tuple(int maxLTR, int maxPS){
            this.maxLTR = maxLTR;
            this.maxPS = maxPS;
        }
    }
    public int maxPathSum(TreeNode root) {
        return rec(root).maxPS;
    }
    public Tuple rec(TreeNode root){
        if(root == null) return new Tuple(0,Integer.MIN_VALUE);

        Tuple left = rec(root.left);
        Tuple right = rec(root.right);
        int maxLTR = 
            Math.max(
                Math.max(
                    left.maxLTR + root.val, right.maxLTR + root.val),
                    root.val
            );
        int maxPS = 
        Math.max(
            Math.max(
                Math.max(
                    left.maxPS, right.maxPS
                ),maxLTR
            ),left.maxLTR + root.val + right.maxLTR
        );
        return new Tuple(maxLTR, maxPS);
    }
}