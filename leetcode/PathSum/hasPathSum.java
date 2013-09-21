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
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return false;
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) return true;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}