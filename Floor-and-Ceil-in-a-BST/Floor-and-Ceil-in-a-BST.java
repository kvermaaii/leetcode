/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {
    int ceil = Integer.MAX_VALUE;
    int floor = Integer.MIN_VALUE;
    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        List<Integer> result = new LinkedList<>();
        findCeil(root, key);
        findFloor(root, key);
        if(floor > Integer.MIN_VALUE){
            result.add(floor);
        } else{
            result.add(-1);
        }
        if(ceil < Integer.MAX_VALUE){
            result.add(ceil);
        } else{
            result.add(-1);
        }
        return result;
    }
    public void findCeil(TreeNode node, int key){
        if(node == null) return;
        if(node.data >= key){
            ceil = Math.min(node.data,ceil);
            findCeil(node.left, key);
        } else{
            findCeil(node.right, key);
        }
    }
    public void findFloor(TreeNode node, int key){
        if(node == null) return;
        if(node.data <= key){
            floor = Math.max(node.data,floor);
            findFloor(node.right, key);
        } else{
            findFloor(node.left, key);
        }
    }
    
}
