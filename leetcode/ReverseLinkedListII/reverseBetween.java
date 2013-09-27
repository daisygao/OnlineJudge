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
        ListNode fakeHead = new ListNode(0), current = head, prev = fakeHead, last = current;
        fakeHead.next = head;
        n -= m;
        while (--m > 0) {
            prev = current;
            current = current.next;
        }
        last = current;
        current = current.next;
        while (n-- > 0) {
            ListNode next = current.next;
            current.next = prev.next;
            prev.next = current;
            last.next = next;
            current = next;
        }
        return fakeHead.next;
    }
}