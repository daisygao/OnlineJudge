/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        int n = 0; 
        ListNode cur = head, prev = cur;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        cur = head;
        Stack<ListNode> st = new Stack<ListNode>();
        for (int i = 0; i < n; i++) {
            if (i > n / 2) {
                st.push(cur);
                prev.next = null;
            }
            prev = cur;
            cur = cur.next;
        }
        cur = head;
        while (!st.empty()) {
            ListNode back = st.pop(), next = cur.next;
            cur.next = back;
            back.next = next;
            cur = next;
        }
    }
}