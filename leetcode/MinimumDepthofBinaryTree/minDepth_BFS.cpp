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
    queue<TreeNode*> que;
    int minDepth(TreeNode* root) {
        if (!root) return 0;
        que.push(root);
        int depth = 1;
        while (!que.empty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode *n = que.front();
                if (!n->left && !n->right) return depth;
                if (n->left) que.push(n->left);
                if (n->right) que.push(n->right);
                que.pop();
            }
            depth++;
        }
    }
};
