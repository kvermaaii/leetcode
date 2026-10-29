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
    public boolean isValidBST(TreeNode root) {
        return rec(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    public boolean rec(TreeNode node, Long max, Long min){
        if(node == null) return true;
        if(node.val >= max || node.val <= min) return false;
        boolean left = rec(node.left, (long) node.val, min);
        boolean right = rec(node.right, max, (long) node.val);
        return (left && right);
    }
}