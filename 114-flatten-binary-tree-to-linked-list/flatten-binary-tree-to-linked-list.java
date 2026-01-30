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
    public void flatten(TreeNode root) {
        dfs(root);
    }
    public void dfs(TreeNode node){
        if(node == null || node.left == null && node.right == null) return;
        dfs(node.left);
        dfs(node.right);
        flat(node);
    }
    public void flat(TreeNode node){
        if (node.left == null) return;
        TreeNode l = node.left;
        TreeNode r = node.right;
        while(l.right != null){
            l = l.right;
        }
        l.right = node.right;
        node.right = node.left;
        node.left = null;
        return; 
    }
}