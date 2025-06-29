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
    private class Pair {
        int index;
        TreeNode node;
        Pair(int index, TreeNode node) {
            this.index = index;
            this.node = node;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
       Queue<Pair> q = new LinkedList<>();
       q.add(new Pair(0,root));
       int maxWidth = 0;
       while( !q.isEmpty()){
            int size = q.size();
            int minIndexPerLevel = q.peek().index;
            int first = 0, last = 0;
            for(int i = 0; i < size; i++){
                Pair curr = q.poll();
                if(i == 0) first = curr.index;
                if(i == size-1) last = curr.index;
                if(curr.node.left != null){
                    q.add(new Pair( 2*(curr.index - minIndexPerLevel) + 1, curr.node.left));
                }
                if(curr.node.right != null){
                    q.add(new Pair( 2*(curr.index - minIndexPerLevel) + 2, curr.node.right));
                }
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
       }
       return maxWidth;
    }
}
// level order 
// 0 based indexing