
/**
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(root, sum, result, list);
        return result;
    }
    private void helper(TreeNode root, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list) {
        if (root == null) return;
        sum -= root.val;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == 0) result.add(new ArrayList<Integer>(list));
        } else {
            helper(root.left, sum, result, list);
            helper(root.right, sum, result, list);
        }
        sum += root.val;
        list.remove(list.size() - 1);
    }
}