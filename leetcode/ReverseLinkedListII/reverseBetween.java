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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode fakeHead = new ListNode(Integer.MIN_VALUE), prev = fakeHead, end = fakeHead, cur = null;
        fakeHead.next = head;
        while (m-- > 0 && end != null) {
            prev = end;
            end = end.next;
            n--;
        }
        if (end != null) {
            cur = end.next;
        }
        while (n-- > 0 && cur != null) {
            end.next = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            cur = end.next;
        }
        return fakeHead.next;
    }
}