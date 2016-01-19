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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        queue<TreeNode *> que;
        if (!root) return ans;
        que.push(root);
        while (!que.empty()) {
            int n = que.size();
            vector<int> row;
            while (n-- > 0) {
                TreeNode *node = que.front();
                row.push_back(node->val);
                que.pop();
                if (node->left) que.push(node->left);
                if (node->right) que.push(node->right);
            }
            ans.push_back(row);
        }
        return ans;
    }
};
