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
        else if (root.left == null && root.right == null) return;
        else if (root.left != null && root.right != null) root.left.next = root.right;
        TreeLinkNode next = root.next;
        while (next != null && next.left == null && next.right == null) next = next.next;
        if (next != null) next = (next.left != null) ? next.left : next.right;
        if (root.right != null) root.right.next = next;
        else root.left.next = next;
        connect(root.right);
        connect(root.left);
    }
}