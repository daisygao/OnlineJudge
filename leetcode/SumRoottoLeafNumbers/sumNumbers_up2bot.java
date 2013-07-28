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
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sum = 0;
        for (String s : helper(root)) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
    private ArrayList<String> helper(TreeNode root) {
        ArrayList<String> ans = new ArrayList<String>();
        if (root == null) return ans;
        if (root.left == null && root.right == null) {
            ans.add(String.valueOf(root.val));
        } else {
            for (String s : helper(root.left)) {
                ans.add(root.val + s);
            }
            for (String s : helper(root.right)) {
                ans.add(root.val + s);
            }
        }
        return ans;
    }
}