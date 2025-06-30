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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        rec(root);
        return diameter-1;
    }
    public int rec(TreeNode node){
        int leftLength = 0, rightLength = 0;
        if(node.left != null){
            leftLength = rec(node.left);
        }
        if(node.right != null){
            rightLength = rec(node.right);
        }
        diameter = Math.max(diameter, rightLength + leftLength + 1);

        return 1 + Math.max(leftLength, rightLength);
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