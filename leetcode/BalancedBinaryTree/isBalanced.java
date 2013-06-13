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
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return balanceHelper(root) == -1 ? false : true;
    }
    
    private int balanceHelper(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = balanceHelper(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = balanceHelper(root.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) < 2) return 1 + Math.max(leftHeight, rightHeight);
        else return -1;
    }
}