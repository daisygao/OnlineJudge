/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private class Ret {
        public boolean isValid;
        public int max, min;
        Ret() {
            this.isValid = true;
            this.max = Integer.MIN_VALUE;
            this.min = Integer.MAX_VALUE;
        }
    }
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper(root).isValid;
    }
    private Ret helper(TreeNode root) {
        Ret ret = new Ret();
        if (root == null) return ret;
        Ret left = helper(root.left), right = helper(root.right);
        if (!left.isValid || !right.isValid || root.val <= left.max || root.val >= right.min) {
            ret.isValid = false;
            return ret;
        }
        ret.min = Math.min(root.val, left.min);
        ret.max = Math.max(root.val, right.max);
        return ret;
    }
}