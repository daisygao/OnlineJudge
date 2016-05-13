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
    TreeNode* helper(vector<int>& inorder, int ins, int ine, vector<int>& postorder, int posts, int poste) {
        if (ine - ins != poste - posts || posts == poste) return NULL;
        int rootVal = postorder[poste - 1];
        TreeNode *root = new TreeNode(rootVal);
        int pos = find(inorder.begin() + ins, inorder.begin() + ine, rootVal) - inorder.begin();
        root->left = helper(inorder, ins, pos, postorder, posts, pos - ins + posts);
        root->right = helper(inorder, pos + 1, ine, postorder, pos - ins + posts, poste - 1);
        return root;
    }
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        return helper(inorder, 0, inorder.size(), postorder, 0, postorder.size());
    }
};
