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
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (p == q) return p;
        int rp = root->val - p->val, rq = root->val - q->val;
        if (rp * rq > 0) return rp > 0 ? lowestCommonAncestor(root->left, p, q) : lowestCommonAncestor(root->right, p, q);
        else return root;
    }
};
