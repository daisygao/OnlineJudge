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
    void dfs(TreeNode* root, int cur, int& ans) {
        if (!root) return;
        cur = cur * 10 + root->val;
        if (!root->left && !root->right) ans += cur;
        dfs(root->left, cur, ans);
        dfs(root->right, cur, ans);
    }
    int sumNumbers(TreeNode* root) {
        int ans = 0, cur = 0;
        dfs(root, cur, ans);
        return ans;
    }
};
