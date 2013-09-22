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
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (root == null) return ans;
        ArrayList<Integer> row = new ArrayList<Integer>();
        ArrayList<TreeNode> current = new ArrayList<TreeNode>(), next = new ArrayList<TreeNode>();
        current.add(root);
        int idx = 0;
        while (!current.isEmpty()) {
            for (TreeNode node : current) {
                if (idx % 2 == 0) row.add(node.val);
                else row.add(0, node.val);
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            ans.add(row);
            row = new ArrayList<Integer>();
            current = next;
            next = new ArrayList<TreeNode>();
            idx++;
        }
        return ans;
    }
}