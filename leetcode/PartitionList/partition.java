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
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode fakeHead = new ListNode(0), i = fakeHead, prev = null, current = head;
        fakeHead.next = head;
        while (current != null) {
            if (current.val >= x) {
                prev = current;
                current = current.next;
            } else if (prev != null) {
                prev.next = current.next;
                current.next = i.next;
                i.next = current;
                i = current;
                current = prev.next;
            } else {
                i = current;
                current = current.next;
            }
        }
        return fakeHead.next;
    }
}