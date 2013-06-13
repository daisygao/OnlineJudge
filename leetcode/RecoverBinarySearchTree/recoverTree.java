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
    
    ArrayList<TreeNode> list;
    TreeNode prev;
    
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        list = new ArrayList<TreeNode>();
        prev = null;
        inorder(root);
        int size = list.size();
        int tmp = list.get(size - 1).val;
        list.get(size - 1).val = list.get(0).val;
        list.get(0).val = tmp;        
    }
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null && prev.val >= root.val) {
            if (!list.contains(prev)) list.add(prev);
            if (!list.contains(root)) list.add(root);
        }
        prev = root;
        inorder(root.right);
    }
}