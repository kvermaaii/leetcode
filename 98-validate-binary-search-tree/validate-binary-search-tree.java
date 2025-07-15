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
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    // public boolean checkBST(TreeNode root, int rightMin, int leftMax){
    //     if(root == null) return true;
    //     rightMin = Math.max(root.val,rightMin);
    //     leftMax = Math.min(root.val,leftMax);
    //     TreeNode r = root.right;
    //     TreeNode l = root.left;
    //     if(l == null && r == null){
    //         return true;
    //     } else if(l == null){
    //         if(root.val >= r.val){
    //             return false;
    //         }
    //     } else if(r == null){
    //         if( root.val <= l.val){
    //             return false;
    //         }
    //     } else if(
    //             root.val >= r.val 
    //                 || root.val <= l.val 
    //                 || r.val <= rightMin 
    //                 || l.val > leftMax
    //             ){
    //         return false;
    //     }
    //     return checkBST(root.left, rightMin, leftMax) && 
    //             checkBST(root.right, rightMin, leftMax);
    // }
    public boolean checkBST(TreeNode root, long leftTh, long rightTh){
        if(root == null) return true;
        if( !(leftTh < root.val && rightTh > root.val) ) return false;
        return checkBST(root.left, leftTh, root.val) && 
                checkBST(root.right, root.val, rightTh);
    }
}