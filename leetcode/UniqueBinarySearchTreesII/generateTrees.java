
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
    private ArrayList<TreeNode> helper(int low, int high) {
        ArrayList<TreeNode> ans = new ArrayList<TreeNode>();
        if (low >= high) {            TreeNode root = low == high ? new TreeNode(low) : null;
            ans.add(root);
        } else {
            for (int i = low; i <= high; i++) {
                for (TreeNode left : helper(low, i - 1)) {
                    for (TreeNode right : helper(i + 1, high)) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        ans.add(root);
                    }
                }
            }
        }
        return ans;        
    }
}

