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
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode st1, TreeNode st2){
        if(st1 == null && st2 == null) return true;
        if(st1 == null || st2 == null) return false;
        if(st1.val != st2.val) return false;
        return isSymmetric(st1.left, st2.right) && isSymmetric(st1.right, st2.left);
    }
}