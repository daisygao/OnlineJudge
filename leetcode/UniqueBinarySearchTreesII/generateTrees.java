/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper(1, n);
    }
    private ArrayList<TreeNode> helper(int start, int end) {
        ArrayList<TreeNode> ans = new ArrayList<TreeNode>();
        if (start > end) ans.add(null);
        for (int mid = start; mid <= end; mid++) {
            for (TreeNode lc : helper(start, mid - 1)) {
                for (TreeNode rc : helper(mid + 1, end)) {
                    TreeNode root = new TreeNode(mid);
                    root.left = lc;
                    root.right = rc;
                    ans.add(root);
                }
            }
        }
        return ans;
        
    }
}