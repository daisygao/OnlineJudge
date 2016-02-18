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
    vector<int> preorderTraversal(TreeNode* root) {
        stack<TreeNode *> st;
        vector<int> ans;
        TreeNode *p = root;
        while (p) {
            ans.push_back(p->val);
            if (p->right) st.push(p->right);
            p = p->left;
            if (!p && !st.empty()) {
                p = st.top();
                st.pop();
            }
        }
        return ans;
    }
};
