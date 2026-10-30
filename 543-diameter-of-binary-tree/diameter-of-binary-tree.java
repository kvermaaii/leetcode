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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int ans = 0;
        while(!q.isEmpty()){
            int leftmax = maxdepth(q.peek().left);
            int rightmax = maxdepth(q.peek().right);
            ans = Math.max(ans, leftmax + rightmax );
            if(q.peek().left != null){
                q.add(q.peek().left);
            }
            if(q.peek().right != null){
                q.add(q.peek().right);
            }
            q.poll();
        }
        return ans;
    }
    public int maxdepth(TreeNode root){
        if(root == null) return 0;
        int leftmax = 0;
        int rightmax = 0;
        leftmax = 1 + maxdepth(root.left);
        rightmax = 1 + maxdepth(root.right);
        return Math.max(leftmax, rightmax);
    }
}