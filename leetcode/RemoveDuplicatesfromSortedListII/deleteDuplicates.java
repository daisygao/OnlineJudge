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
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ListNode fakeHead = new ListNode(0), prev = fakeHead, current = head, end = current;
        fakeHead.next = head;
        while (end != null) {
            while (end.next != null && end.next.val == current.val) end = end.next;
            if (end == current) {
                prev = current;
            } else {
                prev.next = end.next;
            }
            end = current = end.next;
        }
        return fakeHead.next;
    }
}