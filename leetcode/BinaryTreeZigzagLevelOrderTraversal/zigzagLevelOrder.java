/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) return result;
        Stack<TreeNode> layer1 = new Stack<TreeNode>(),
	    layer2 = new Stack<TreeNode>();
        layer1.push(root);
        int layer = 0;
        while (!layer1.empty()) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            while (!layer1.empty()) {
                TreeNode node = layer1.pop();
                list.add(node.val);
                if (layer % 2 == 0) {
                    if (node.left != null) layer2.push(node.left);
                    if (node.right != null) layer2.push(node.right);                    
                } else {
                    if (node.right != null) layer2.push(node.right);
                    if (node.left != null) layer2.push(node.left);                    
                }
            }
            result.add(list);
            layer1 = layer2;
            layer2 = new Stack<TreeNode>();
            layer++;
        }
        return result;
    }
}