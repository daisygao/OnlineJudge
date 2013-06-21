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
        ListNode fakeHead = new ListNode(Integer.MAX_VALUE), start = head, end = head, prev = fakeHead;
        fakeHead.next = head;
        while (start != null) {
            while (end.next != null && end.next.val == start.val) end = end.next;
            if (start == end) {
                prev = start;
            } else {
                prev.next = end.next;
            }
            start = end = end.next;
        }
        return fakeHead.next;
    }
}