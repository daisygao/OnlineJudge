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
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode last = root.left;
        while (last != null && last.right != null) last = last.right;
        if (last != null) {
            last.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}