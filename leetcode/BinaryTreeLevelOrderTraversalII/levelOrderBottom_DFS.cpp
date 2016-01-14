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
    vector<vector<int>> ans;
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        helper(root, 0);
        reverse(ans.begin(), ans.end());
        return ans;
    }
    void helper(TreeNode *root, int n) {
        if (!root) return;
        if (ans.size() <= n) {
            ans.push_back(vector<int>());
        } 
        ans[n].push_back(root->val);
        helper(root->left, n + 1);
        helper(root->right, n + 1);
    }
};
