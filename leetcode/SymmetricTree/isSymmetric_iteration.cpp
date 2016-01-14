/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TreeNode left = q.remove();
            TreeNode right = q.remove();
            if (left != null && right != null) {
                if (left.val != right.val) return false;
                q.add(left.left);
                q.add(right.right);
                q.add(left.right);
                q.add(right.left);
            } else if (left != right) return false;
        }
        return true;
    }
}
