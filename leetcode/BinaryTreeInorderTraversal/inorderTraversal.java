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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<TreeNode> st = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        TreeNode node = root;
        st.push(node);
        while (!st.empty()) {
            while (node.left != null) {
                node = node.left;
                st.push(node);
            }
            node = st.pop();
            result.add(node.val);
            while (node.right == null && !st.empty()) {
                node = st.pop();
                result.add(node.val);
            }
            if (node.right != null) {
                node = node.right;
                st.push(node);
            }
        }
        return result;
    }
}