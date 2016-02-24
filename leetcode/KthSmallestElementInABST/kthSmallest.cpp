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
    int kthSmallest(TreeNode* root, int &k) {
        if (!root) return -1;
        int x = kthSmallest(root->left, k);
        return !k ? x : (--k ? kthSmallest(root->right, k) : root->val);
    }
};
