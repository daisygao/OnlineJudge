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
    int pi;
    int pp;
    TreeNode *helper(vector<int>& inorder, vector<int>& postorder, TreeNode *root) {
        if (pp < 0 || pi < 0) return NULL;
        TreeNode *p = new TreeNode(postorder[pp--]);
        
        if (inorder[pi] != p->val) {
            p->right = helper(inorder, postorder, p);
        }
        
        pi--;
        if (!root || inorder[pi] != root->val) {
            p->left = helper(inorder, postorder, root);
        }
        
        return p;
        
    }
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        pi = pp = inorder.size() - 1;
        return helper(inorder, postorder, NULL);
    }
};
