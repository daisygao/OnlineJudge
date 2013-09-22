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
        int len = num.length, mid = len >> 1;
        if (len == 0) return null;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(num, 0, mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(num, mid + 1, len));
        return root;
    }
}