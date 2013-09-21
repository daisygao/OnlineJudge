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
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return 0;
        int left = minDepth(root.left), right = minDepth(root.right);
        return 1 + (root.left != null && root.right != null ? Math.min(left, right) : Math.max(left, right));
    }
}