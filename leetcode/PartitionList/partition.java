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
        ListNode cur = head, tail = null, backtail = null, back = null, next = null;
        while (cur != null) {
            next = cur.next;
            if (cur.val >= x) {
                backtail = cur;
                if (back == null) {
                    back = cur;
                } 
            } else {
                if (back != null) {
                    backtail.next = next;
                    cur.next = back;                                    
                    if (tail == null) {
                        head = cur;
                    } else {
                        tail.next = cur;
                    }
                }
                tail = cur;
            }
            cur = next;
        }
        return head;
    }
}