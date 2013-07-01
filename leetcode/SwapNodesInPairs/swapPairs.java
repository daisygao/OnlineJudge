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
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode fake = new ListNode(-1), prev = fake, cur = head, next;
        fake.next = head;
        while (cur != null && cur.next != null) {
            next = cur.next;
            cur.next = next.next;
            prev.next = next;
            next.next = cur;
            prev = cur;
            cur = cur.next;
        }
        return fake.next;
    }
}