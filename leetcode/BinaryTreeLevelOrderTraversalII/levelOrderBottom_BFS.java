/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root == null) return ans;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> lvl = new LinkedList<Integer>();
            while (size-- > 0) {
                TreeNode node = q.remove();
                lvl.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            ans.add(0, lvl);
        }
        return ans;
    }
}
