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
    int postInc;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postInc = postorder.length - 1;
        return buildTreeHelper(inorder, postorder, 0, postorder.length - 1);
    }
    public TreeNode buildTreeHelper(int[] inorder, int[] postorder, int start, int end){
        if(start > end || postorder.length == 0 ) return null;
        TreeNode root = new TreeNode(postorder[postInc--]);
        int n = 0;
        while(inorder[n] != root.val){
            n++;
        }
        root.right = buildTreeHelper(inorder, postorder, n + 1, end);
        root.left = buildTreeHelper(inorder, postorder, start, n - 1);
        return root;
    }
}