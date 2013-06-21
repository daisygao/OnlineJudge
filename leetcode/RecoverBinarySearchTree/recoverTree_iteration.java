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
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<TreeNode> list = new ArrayList<TreeNode>(4);
        Stack<TreeNode> st = new Stack<TreeNode>();
        if (root == null) return;
        st.push(root);
        TreeNode p = root, prev = null;
        while (!st.empty()) {
            while (p.left != null) {
                p = p.left;
                st.push(p);
            }
            p = st.pop();           
            if (prev != null && prev.val > p.val) {
                list.add(prev);
                list.add(p);
            }
            prev = p;
            while (p.right == null && !st.empty()) {
                p = st.pop();
                if (prev != null && prev.val > p.val) {
                    list.add(prev);
                    list.add(p);
                }
                prev = p;
            }
            p = p.right;
            if (p != null) st.push(p);
        }
        int x = list.get(0).val;
        list.get(0).val = list.get(list.size() - 1).val;
        list.get(list.size() - 1).val = x;
    }
}

