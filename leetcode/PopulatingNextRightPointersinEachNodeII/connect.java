/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return;
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }
        TreeLinkNode p = root.next, next;
        while (p != null && p.left == null && p.right == null) p = p.next;
        next = p == null ? null : (p.left == null ? p.right : p.left);
        if (root.right != null) root.right.next = next;
        else if (root.left != null) root.left.next = next;
        connect(root.right);
        connect(root.left);
    }
}