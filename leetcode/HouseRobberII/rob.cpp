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
    unordered_map<TreeNode*, int> map;
    
    int rob(TreeNode* root) {
        if (!root) return 0;
        if (map.find(root) != map.end()) return map[root];
        int left = 0, right = 0;
        if (root->left) left = rob(root->left->left) + rob(root->left->right);
        if (root->right) right = rob(root->right->left) + rob(root->right->right);
        int ans = max(root->val + left + right, rob(root->left) + rob(root->right));
        map[root] = ans;
        return ans;
    }
};
