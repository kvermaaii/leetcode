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
    int currentPI = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return rec(preorder, inorder, 0, preorder.length-1);
    }
    public TreeNode rec(int[] preorder, int[] inorder, int start, int end){
        if(currentPI >= preorder.length || preorder.length == 0 || start > end) return null;
        TreeNode root = new TreeNode(preorder[currentPI++]);
        int i = start;
        while(inorder[i] != root.val){
            i++;
        }
        // int rightSize = root - start;
        // int leftSize = end - root;
        // TreeNode r = new TreeNode(root);
        // TreeNode leftN = null, rightN = null;
        // if(preorder.length > 1){
        //     leftN = new TreeNode(preorder[1]);
        // }
        // if(preorder.length > leftSize + 1){
        //     rightN = new TreeNode(preorder[leftSize + 1])
        // }
        // if(left != null){
        //     r.left = left;
        // }
        // if(right != null){
        //     r.right = right;
        // }
        root.left = rec(preorder, inorder, start, i-1);
        root.right = rec(preorder, inorder, i+1, end);

        return root;
    }
}