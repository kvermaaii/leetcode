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
    List<Integer> inorder;
    public boolean findTarget(TreeNode root, int k) {
        inorder = new ArrayList<>();
        inorder(root);
        int start = 0;
        int end = inorder.size() - 1;
        while(start < end){
            int sum = inorder.get(start) + inorder.get(end);
            if(sum > k){
                end--;
            } else if(sum < k){
                start++;
            } else{
                return true;
            }
        }
        return false;
    }
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        inorder.add(root.val);
        inorder(root.right);
    }
}