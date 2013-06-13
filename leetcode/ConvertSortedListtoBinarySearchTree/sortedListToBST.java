/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    ListNode p;
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = 0;
        p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        p = head;
        return helper(0, len);
    }
    private TreeNode helper(int start, int end) {
        if (start >= end || p == null) return null;
        int mid = start + (end - start) / 2;
        TreeNode left = helper(start, mid);
        TreeNode root = new TreeNode(p.val);
        p = p.next;
        TreeNode right = helper(mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
        
        
    }
}