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
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (root == null) return ans;
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null || !st.isEmpty()) {
            while (current != null) {
                st.push(current);
                current = current.left;
            }
            while ((current == null || current.right == null) && !st.isEmpty()) {
                current = st.pop();
                ans.add(current.val);
            }
            current = current.right;
        }
        return ans;
    }
}