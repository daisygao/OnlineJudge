/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (node == null) return null;
        ArrayList<UndirectedGraphNode> queue = new ArrayList<UndirectedGraphNode>();
        ArrayList<UndirectedGraphNode> queue_ans = new ArrayList<UndirectedGraphNode>();
        HashMap<Integer, Integer> label2idx = new HashMap<Integer, Integer>();
        queue.add(node);
        queue_ans.add(new UndirectedGraphNode(node.label));
        label2idx.put(node.label, queue.size() - 1);
        int idx = 0;
        while (idx < queue.size()) {
            UndirectedGraphNode orinode = queue.get(idx++);
            for (UndirectedGraphNode oc : orinode.neighbors) {
                if (label2idx.containsKey(oc.label)) continue;
                queue.add(oc);
                queue_ans.add(new UndirectedGraphNode(oc.label));
                label2idx.put(oc.label, queue.size() - 1);
            }
        }
        for (idx = queue.size() - 1; idx >= 0; idx--) {
            UndirectedGraphNode orinode = queue.get(idx);
            for (UndirectedGraphNode oc : orinode.neighbors) {
                queue_ans.get(idx).neighbors.add(queue_ans.get(label2idx.get(oc.label)));
            }
        }
        return queue_ans.get(0);
    }
}