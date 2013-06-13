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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = postorder.length;
        if (len == 0) return null;
        int rootVal = postorder[len - 1];
        int left = 0;
        for (left = 0; left < len; left++) {
            if (inorder[left] == rootVal) {
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, left),
			      Arrays.copyOfRange(postorder, 0, left));
        root.right = buildTree(Arrays.copyOfRange(inorder, left + 1, len),
			       Arrays.copyOfRange(postorder, left, len - 1));
        return root;
    }
}