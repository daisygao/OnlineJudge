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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (root == null) return ans;
        ArrayList<TreeNode> current = new ArrayList<TreeNode>(), next = new ArrayList<TreeNode>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        current.add(root);
        while (!current.isEmpty()) {
            for (TreeNode node : current) {
                row.add(node.val);
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            ans.add(row);
            row = new ArrayList<Integer>();
            current = next;
            next = new ArrayList<TreeNode>();
        }
        return ans;
    }
}