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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) return result;
        Stack<ArrayList<Integer>> st = new Stack<ArrayList<Integer>>();
        ArrayList<TreeNode> layer1 = new ArrayList<TreeNode>(),
	    layer2 = new ArrayList<TreeNode>();
        layer1.add(root);
        while (layer1.size() != 0) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (TreeNode node : layer1) {
                list.add(node.val);
                if (node.left != null) layer2.add(node.left);
                if (node.right != null) layer2.add(node.right);
            }
            st.push(list);
            layer1 = layer2;
            layer2 = new ArrayList<TreeNode>();
        }
        while (!st.empty()) {
            result.add(st.pop());
        }
        return result;
    }
}