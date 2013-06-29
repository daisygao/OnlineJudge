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
    int sum;
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        sum = 0;
        helper(root, "");
        return sum;
    }
    private void helper(TreeNode root, String path) {
        if (root == null) return;
        path += root.val;
        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(path);
        }
        helper(root.left, path);
        helper(root.right, path);
    }
}