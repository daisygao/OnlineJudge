/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        return !root || helper(root->left, root->right);
    }
    bool helper(TreeNode *left, TreeNode *right) {
        if (!left || !right) return left == right;
        return (left->val == right->val) && helper(left->left, right->right) && helper(left->right, right->left);
    }
};
