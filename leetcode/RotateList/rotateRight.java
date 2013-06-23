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
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null) return null;
        int len = 1;
        ListNode end = head, prev = head;
        while (end != null && end.next != null) {
            len++;
            end = end.next;
        }
        if (n % len == 0) return head;
        n %= len;
        len -= n;
        while (--len > 0) {
            prev = prev.next;
        }
        end.next = head;
        head = prev.next;
        prev.next = null;
        return head;
    }
}