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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode currentNode = root;
        TreeNode left;
        while(currentNode != null){
            if(currentNode.left == null){
                list.add(currentNode.val);
                currentNode = currentNode.right;
            } else{
                left = currentNode.left;
                while(left.right != null && left.right != currentNode){
                    left = left.right;
                }
                if(left.right == null){
                    left.right = currentNode;
                    currentNode = currentNode.left;
                } else{
                    left.right = null;
                    list.add(currentNode.val);
                    currentNode = currentNode.right;
                }
            }
        }
        return list;
    }
}