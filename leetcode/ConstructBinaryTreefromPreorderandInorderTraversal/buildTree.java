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
        int len = inorder.length;
        if (len == 0) return null;
        int x = preorder[0], mid;
        for (mid = 0; mid < len; mid++) {
            if (inorder[mid] == x) break;
        }
        TreeNode root = new TreeNode(x);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid + 1), Arrays.copyOfRange(inorder, 0, mid));
        root.right = buildTree(Arrays.copyOfRange(preorder, mid + 1, len), Arrays.copyOfRange(inorder, mid + 1, len));
        return root;
    }
}