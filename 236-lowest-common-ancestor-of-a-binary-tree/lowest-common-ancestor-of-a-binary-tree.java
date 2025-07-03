/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    class Tuple {
        boolean pFlag;
        boolean qFlag;
        TreeNode LCS;
        public Tuple(boolean pFlag, boolean qFlag, TreeNode LCS) {
            this.pFlag = pFlag;
            this.qFlag = qFlag;
            this.LCS = LCS;
        }
    }

    TreeNode LCS;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Tuple result = rec(root, p, q);
        return result.LCS;
    }

    public Tuple rec(TreeNode root, TreeNode p, TreeNode q) {
        Tuple tp = new Tuple(false, false, null);
        if (root == null) return tp;

        if (root == p) tp.pFlag = true;
        if (root == q) tp.qFlag = true;

        Tuple x = rec(root.left, p, q);
        Tuple y = rec(root.right, p, q);

        tp.pFlag |= x.pFlag || y.pFlag;
        tp.qFlag |= x.qFlag || y.qFlag;

        if (x.LCS != null) {
            tp.LCS = x.LCS;
        } else if (y.LCS != null) {
            tp.LCS = y.LCS;
        } else if ((x.pFlag && y.qFlag) || (x.qFlag && y.pFlag)) {
            tp.LCS = root;
        } else if (tp.pFlag && (x.qFlag || y.qFlag)) {
            tp.LCS = root;
        } else if (tp.qFlag && (x.pFlag || y.pFlag)) {
            tp.LCS = root;
        }

        // if ((x.pFlag || x.qFlag) && (y.pFlag || y.qFlag) && x.LCS == null && y.LCS == null) {
        //     return new Tuple(true, true, root);
        // } else if (tp.pFlag && tp.qFlag && tp.LCS == null ) {
        //     tp.LCS = root;
        // }
        return tp;
    }
}
