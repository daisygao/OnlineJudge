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
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }
    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null) return false;
        else {
            return left.val == right.val && isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);   
        }
    }
}