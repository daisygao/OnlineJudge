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
    public void helper(TreeNode root, String pathSum) {
        if (root == null) return;
        pathSum += String.valueOf(root.val);
        if (root.left == null && root.right == null) sum += Integer.valueOf(pathSum);
        if (root.left != null) helper(root.left, pathSum);
        if (root.right != null) helper(root.right, pathSum);
    }
}