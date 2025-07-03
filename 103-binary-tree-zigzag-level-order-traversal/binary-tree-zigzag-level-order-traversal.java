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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;
        List<Integer> list = new LinkedList<>();
        q.add(root);
        int zigzag = 0;
        while( !q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                TreeNode curr = q.poll();
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
                list.add(curr.val);
            }
            if((zigzag % 2) == 0){
                result.add(new LinkedList<>(list));
            } else{
                Collections.reverse(list);
                result.add(new LinkedList<>(list));               
            }
            zigzag++;
            list.clear();
        }
        return result;
    }
}