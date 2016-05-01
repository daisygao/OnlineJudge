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
    pair<TreeNode*, TreeNode*> helper(TreeNode *root) {
        if (!root) return pair<TreeNode*, TreeNode*>(NULL, NULL);
        auto left = helper(root->left), right = helper(root->right);
        root->right = left.first ? left.first : right.first;
        root->left = NULL;
        if (left.second) left.second->right = right.first;
        return pair<TreeNode*, TreeNode*>(root, right.second ? right.second : (left.second ? left.second : root));
        
    }
    void flatten(TreeNode* root) {
        helper(root);
    }
};
