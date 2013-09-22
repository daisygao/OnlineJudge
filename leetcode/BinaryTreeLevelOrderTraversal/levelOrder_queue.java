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
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        queue.add(root);
        queue.add(null);
        int idx = 0;
        while (idx < queue.size()) {
            TreeNode node = queue.get(idx++);
            if (node == null) {
                ans.add(row);
                row = new ArrayList<Integer>();
                if (idx == queue.size()) break;
                queue.add(null);
                continue;
            }
            row.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);            
        }
        return ans;
    }
}