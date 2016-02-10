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
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> ans;
        if (!root) return ans;
        vector<string> left = binaryTreePaths(root->left), right = binaryTreePaths(root->right);
        ans.insert(ans.end(), left.begin(), left.end());
        ans.insert(ans.end(), right.begin(), right.end());
        if (!ans.size()) ans.push_back(to_string(root->val));
        else {
            for (string &s : ans) {
                s = to_string(root->val) + "->" + s;
            }
        }
        return ans;
    }
};
