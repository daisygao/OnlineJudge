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
    ListNode ld;
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = 0;
        ld = head;
        while (ld != null) {
            ld = ld.next;
            n++;
        }
        ld = head;
        return helper(0, n);
    }
    private TreeNode helper(int start, int end) {
        if (start == end) return null;
        int mid = start + (end - start >> 1);
        TreeNode left = helper(start, mid);
        TreeNode root = new TreeNode(ld.val);
        ld = ld.next;
        TreeNode right = helper(mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}