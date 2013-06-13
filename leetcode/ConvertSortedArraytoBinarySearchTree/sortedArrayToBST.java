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
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = num.length;
        if (len == 0) return null;
        TreeNode root = new TreeNode(num[len / 2]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(num, 0, len / 2));
        root.right = sortedArrayToBST(Arrays.copyOfRange(num, len / 2 + 1, len));
        return root;
    }
}