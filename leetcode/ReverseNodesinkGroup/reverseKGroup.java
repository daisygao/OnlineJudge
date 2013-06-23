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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode cur = head, fake = new ListNode(Integer.MIN_VALUE), prev = fake, end = fake;
        fake.next = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int cnt = len / k;
        while (cnt-- > 0) {
            //cur = null;
            if (end != null && end.next != null) {
                prev = end;
                end = end.next;
                cur = end.next;
            }
            int kk = k;
            while (--kk > 0 && cur != null) {
                end.next = cur.next;
                cur.next = prev.next;
                prev.next = cur;
                cur = end.next;
            }
        }
        return fake.next;
    }
}