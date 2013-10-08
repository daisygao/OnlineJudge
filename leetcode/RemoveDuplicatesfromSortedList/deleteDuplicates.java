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
        ListNode current = head;
        while (current != null) {
            while (current.next != null && current.next.val == current.val) current.next = current.next.next;
            current = current.next;
        }
        return head;
    }
}