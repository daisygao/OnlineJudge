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
        helper(root);
        return max;
    }
    int max3(int x, int y, int z) {
        return Math.max(x, Math.max(y, z));
    }
    int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left), right = helper(root.right);
        int sum = max3(root.val + left, root.val + right, root.val);
        max = max3(max, sum, root.val + left + right);
        return sum;
    }
}