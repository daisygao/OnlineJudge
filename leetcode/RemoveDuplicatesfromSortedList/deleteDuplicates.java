/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.next.val == cur.val) cur.next = cur.next.next;
            cur = cur.next;
        }
        return head;
    }
}