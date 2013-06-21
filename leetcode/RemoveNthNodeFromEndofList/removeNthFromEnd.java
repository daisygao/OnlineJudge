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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null) return head;
        ListNode fakeHead = new ListNode(Integer.MAX_VALUE), prev = fakeHead, cur = fakeHead;
        fakeHead.next = head;
        while (n-- > 0) cur = cur.next;
        while (cur.next != null) {
            cur = cur.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return fakeHead.next;
    }
}