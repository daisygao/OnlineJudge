Solution for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if (inorder.size() != postorder.size() || !inorder.size()) return NULL;
        TreeNode *root = new TreeNode(postorder.back()), *p;
        stack<TreeNode *> st;
        st.push(root);
        postorder.pop_back();
        
        while (!postorder.empty()) {
            if (inorder.back() != st.top()->val) {
                p = new TreeNode(postorder.back());
                st.top()->right = p;
                st.push(p);
                postorder.pop_back();
            } else {
                p = st.top();
                st.pop();
                inorder.pop_back();
                
                if (!st.empty() && inorder.back() == st.top()->val) continue;
                
                p->left = new TreeNode(postorder.back());
                postorder.pop_back();
                st.push(p->left);
            }
        }
        return root;
    }
};
