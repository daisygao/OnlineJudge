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
    public ListNode insertionSortList(ListNode head) {
        ListNode fakehead = new ListNode(-1);
        fakehead.next = head;
        ListNode end = head;
        while (end != null && end.next != null) {
            ListNode cur = end.next, small = fakehead, big = small.next;
            if (cur.val >= end.val) {
                end = end.next;
            } else {
                while (big != cur && big.val <= cur.val) {
                    small = big;
                    big = big.next;
                }
                end.next = cur.next;
                small.next = cur;
                cur.next = big;
            }
        }
        return fakehead.next;
    }
}