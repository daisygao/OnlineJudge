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
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(1000);
        if (root == null) return result;
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(root.val);
                result.add(list);               
            }
        } else {
            for (ArrayList<Integer> list : pathSum(root.left, sum)) {
                list.add(0, root.val);
                result.add(list);
            }
            for (ArrayList<Integer> list : pathSum(root.right, sum)) {
                list.add(0, root.val);
                result.add(list);
            }
        }
        return result;
    }
}