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
    int rob(TreeNode* root) {
        auto res = dp(root);
        return max(res[0], res[1]);
    }
    
    vector<int> dp(TreeNode *root) {
        vector<int> res(2, 0);
        if (!root) return res;
        auto left = dp(root->left), right = dp(root->right);
        res[0] = max(left[0], left[1]) + max(right[0], right[1]);
        res[1] = root->val + left[0] + right[0];
        return res;
    }
};
