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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode p1 = l1, p2 = l2, prev = null;
        while (p2 != null) {
            if (p1 != null && p1.val <= p2.val) {
                prev = p1;
                p1 = p1.next;
            } else {
                ListNode next = p2.next;
                if (prev != null) {
                    prev.next = p2;
                } else {
                    l1 = p2;
                }
                prev = p2;
                p2.next = p1;
                p2 = next;
            }
        }
        if (prev != null && p2 != null) {
            prev.next = p2;
        }
        return l1;
    }
}