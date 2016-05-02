/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
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
    ListNode *p;
    TreeNode* helper(int cur, int n) {
        if (!n || !p) return NULL;
        TreeNode *left = helper(cur, n / 2);
        TreeNode *root = new TreeNode(p->val);
        root->left = left;
        p = p->next;
        root->right = helper(cur + 1, n - n / 2 - 1);
        return root;
    }
    TreeNode* sortedListToBST(ListNode* head) {
        p = head;
        int n = 0;
        while (p) {
            n++;
            p = p->next;
        }
        p = head;
        return helper(1, n);
    }
};
