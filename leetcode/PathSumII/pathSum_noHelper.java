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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (root == null) return ans;
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(root.val);
            ans.add(list);
        } else {
            for (ArrayList<Integer> list : pathSum(root.left, sum)) {
                list.add(0, root.val);
                ans.add(list);
            }
            for (ArrayList<Integer> list : pathSum(root.right, sum)) {
                list.add(0, root.val);
                ans.add(list);
            }
        }
        return ans;
    }
}