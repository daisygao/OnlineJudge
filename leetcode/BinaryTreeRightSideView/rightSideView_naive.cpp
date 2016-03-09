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
    void helper(TreeNode *root, vector<int>& ans, int layer) {
        if (!root) return;
        if (layer > ans.size()) ans.push_back(root->val);
        else ans[layer - 1] = root->val;
        helper(root->left, ans, layer + 1);
        helper(root->right, ans, layer + 1);
    }
    vector<int> rightSideView(TreeNode* root) {
        vector<int> ans;
        helper(root, ans, 1);
        return ans;
    }
};
