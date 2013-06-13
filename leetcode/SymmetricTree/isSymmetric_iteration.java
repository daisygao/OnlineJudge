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
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return true;
        Queue<TreeNode> leftQ = new LinkedList<TreeNode>(), rightQ = new LinkedList<TreeNode>();
        leftQ.offer(root.left);
        rightQ.offer(root.right);
        TreeNode left, right;
        while (leftQ.size() != 0) {
            left = leftQ.poll();
            right = rightQ.poll();
            if (left == null && right == null) continue;
            else if (left == null || right == null) return false;
            if (left.val == right.val) {
                leftQ.offer(left.left);
                rightQ.offer(right.right);
                leftQ.offer(left.right);
                rightQ.offer(right.left);
            } else {
                return false;
            }
        }
        return true;
    }
}