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
    private class Pair {
        public int min, max;
        Pair() {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
        }
    }
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper(root) != null;
    }
    private Pair helper(TreeNode root) {
        Pair ans = new Pair();
        if (root == null) return ans;
        Pair left = helper(root.left), right = helper(root.right);
        if (left == null || right == null || left.max >= root.val || right.min <= root.val) return null;
        ans.min = Math.min(root.val, left.min);
        ans.max = Math.max(root.val, right.max);
        return ans;
    }
}