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
    int max;
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        max = Integer.MIN_VALUE;
        return Math.max(helper(root), max);
    }
    
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int sum = root.val;
        if (left > 0) sum += left;
        if (right > 0) sum += right;
        max = Math.max(max, sum);
        return Math.max(root.val, root.val + Math.max(left, right));
    }
}