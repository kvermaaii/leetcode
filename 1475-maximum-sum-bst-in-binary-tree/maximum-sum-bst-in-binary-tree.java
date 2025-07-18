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
    static class Tuple{
        boolean isBST;
        int sum;
        int minVal;
        int maxVal;
        public Tuple(boolean isBST, int sum, int minVal, int maxVal){
            this.isBST = isBST;
            this.sum = sum;
            this.minVal = minVal;
            this.maxVal = maxVal;
        }
    }
    int maxSum = Integer.MIN_VALUE;
    public int maxSumBST(TreeNode root) {
        maxSumBSTHelper(root);
        if(maxSum != Integer.MIN_VALUE && maxSum >= 0){
            return maxSum;
        } else{
            return 0;
        }
    }
    private Tuple maxSumBSTHelper(TreeNode node){
        if(node == null) return new Tuple(false,-1,-1,-1);
        if(node.right == null && node.left == null){
            maxSum = Math.max(node.val, maxSum);
            return new Tuple(true,node.val,node.val,node.val);
        };
        Tuple left = maxSumBSTHelper(node.left);
        Tuple right = maxSumBSTHelper(node.right);
        if(node.left != null && node.right != null && node.val < node.right.val && node.val > node.left.val 
            && left.isBST && right.isBST && right.minVal > node.val && left.maxVal < node.val){
            maxSum = Math.max(left.sum + node.val + right.sum, maxSum);
            return new Tuple(true, left.sum + node.val + right.sum, Math.min(node.val, Math.min(left.minVal, right.minVal)), Math.max(node.val, Math.max(left.maxVal, right.maxVal)));
        }
        if(node.left == null && right.isBST &&  node.val < node.right.val && right.minVal > node.val){
            maxSum = Math.max(node.val + right.sum, maxSum);
            return new Tuple(true, node.val + right.sum, Math.min(node.val, right.minVal), Math.max(node.val, right.maxVal) );
        }
        if(node.right == null && left.isBST && node.val > node.left.val && left.maxVal < node.val){
            maxSum = Math.max(left.sum + node.val, maxSum);
            return new Tuple(true, left.sum + node.val, Math.min(node.val, left.minVal), Math.max(node.val, left.maxVal));
        }
        return new Tuple(false,-1,-1,-1);
    }
}