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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> li = new ArrayList<>();
            int s = q.size();
            for(int i = 0; i < s; i++){
                if(q.peek().left != null){
                    q.add(q.peek().left);
                }
                if(q.peek().right != null){
                    q.add(q.peek().right);
                }
                li.add(q.poll().val);
            }
            result.add(new ArrayList<>(li));
            li.clear();
        }
        return result;
    }
}