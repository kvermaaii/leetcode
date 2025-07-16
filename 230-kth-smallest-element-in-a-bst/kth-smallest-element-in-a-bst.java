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
    int kth;
    int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        kth = k;
        getPostorder(root);
        return result;
    }
    public void getPostorder(TreeNode node){
        if(node == null) return;
        getPostorder(node.left);
        if(result != -1){
            return;
        }//early return
        kth--;
        if(kth == 0) {
            result = node.val;
        };
        if(result != -1){
            return;
        }
        getPostorder(node.right);
    }
}