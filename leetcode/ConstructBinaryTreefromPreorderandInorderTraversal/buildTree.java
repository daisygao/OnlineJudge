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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = preorder.length;
        if (len == 0) return null;
        int rootVal = preorder[0], left;
        for (left = 0; left < len; left++) {
            if (inorder[left] == rootVal) break;
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + left),
			      Arrays.copyOfRange(inorder, 0, left));
        root.right = buildTree(Arrays.copyOfRange(preorder, 1 + left, len),
			       Arrays.copyOfRange(inorder, 1 + left, len));
        return root;
    }
}