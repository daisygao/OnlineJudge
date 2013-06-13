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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode node = null, p = null;
        int k = lists.size();
        if (k == 0) return node;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(k, new Comparator<ListNode>() {
		public int compare(ListNode n1, ListNode n2) {
		    return n1.val - n2.val;
		}
	    });
        
        for (ListNode n : lists) {
            if (n != null) q.offer(n);
        }
        while (q.size() != 0) {
            ListNode n = q.poll();
            if (node == null) {
                node = n;
                p = n;
            } else {
                p.next = n;
                p = p.next;
            }
            n = n.next;
            if (n != null) q.offer(n);
        }
        return node;
    }
}