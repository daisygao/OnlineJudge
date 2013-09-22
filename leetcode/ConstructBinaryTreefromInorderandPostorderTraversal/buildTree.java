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
        int len = inorder.length;
        if (len == 0) return null;
        int x = postorder[len - 1], mid = indexOf(inorder, x);
        TreeNode root = new TreeNode(x);
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, mid), Arrays.copyOfRange(postorder, 0, mid));
        root.right = buildTree(Arrays.copyOfRange(inorder, mid + 1, len), Arrays.copyOfRange(postorder, mid, len - 1));
        return root;
    }
    private int indexOf(int arr[], int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) return i;
        }
        return -1;
    }
}