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
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        rec(root);
        return flag;
    }
    public void rec(TreeNode node){
        int leftLength = 0, rightLength = 0;
        if(node.left != null){
            leftLength = maxDepth(node.left, 0);
        }
        if(node.right != null){
            rightLength = maxDepth(node.right, 0);
        }
        if(Math.abs(rightLength - leftLength) > 1){
            flag = false;
            return;
        }
        if(node.left != null){
            rec(node.left);
        }
        if(node.right != null){
            rec(node.right);
        }
    }

    public int maxDepth(TreeNode node, int level) {
        if (node == null) {
            return level;
        }
        int leftDepth = maxDepth(node.left, level + 1);
        int rightDepth = maxDepth(node.right, level + 1);
        return Math.max(leftDepth, rightDepth);
    }
}