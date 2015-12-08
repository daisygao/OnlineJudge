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
        else if (root == p) return root;
        else if (root == q) return root;
        bool leftp = contains(root->left, p), rightq = contains(root->right, q);
        if ((leftp && rightq) || (!leftp && !rightq)) return root;
        else if (leftp && !rightq) return lowestCommonAncestor(root->left, p, q);
        else if (!leftp && rightq) return lowestCommonAncestor(root->right, p, q);
    }
    bool contains(TreeNode* root, TreeNode* p) {
        if (root == p) return true;
        if (!p) return true;
        if (!root) return false;
        return contains(root->left, p) || contains(root->right, p);
    }
};
