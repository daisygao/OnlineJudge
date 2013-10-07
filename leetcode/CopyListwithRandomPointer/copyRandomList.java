/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (head == null) return null;
        ArrayList<RandomListNode> queue_ans = new ArrayList<RandomListNode>();
        HashMap<Integer, Integer> label2idx = new HashMap<Integer, Integer>();
        queue_ans.add(new RandomListNode(head.label));
        label2idx.put(head.label, queue_ans.size() - 1);
        RandomListNode current = head;
        while (current != null) {
            if (current.next != null) {
                if (!label2idx.containsKey(current.next.label)) {
                    queue_ans.add(new RandomListNode(current.next.label));
                    label2idx.put(current.next.label, queue_ans.size() - 1);
                }
                queue_ans.get(label2idx.get(current.label)).next = queue_ans.get(label2idx.get(current.next.label));
            }
            if (current.random != null) {
                if (!label2idx.containsKey(current.random.label)) {
                    queue_ans.add(new RandomListNode(current.random.label));
                    label2idx.put(current.random.label, queue_ans.size() - 1);
                }
                queue_ans.get(label2idx.get(current.label)).random = queue_ans.get(label2idx.get(current.random.label));
            }
            current = current.next;
        }
        return queue_ans.get(0);
    }
}