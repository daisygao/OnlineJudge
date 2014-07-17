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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !st.empty()) {
            if (cur != null) {
                st.push(cur);
                if (cur.left != null) cur = cur.left;
                else cur = cur.right;
            } else {
                TreeNode prev = st.pop();
                list.add(prev.val);
                while (!st.empty() && prev == st.peek().right) {
                    prev = st.pop();
                    list.add(prev.val);
                }
                if (st.empty()) {
                    break;
                } else cur = st.peek().right;
            }
        }
        return list;
    }
}