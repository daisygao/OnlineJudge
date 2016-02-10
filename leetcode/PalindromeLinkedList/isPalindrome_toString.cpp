/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    bool isPalindrome(ListNode* head) {
        string str = "";
        while(head) {
            str += head->val;
            head = head->next;
        }
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str[i] != str[len - 1 - i]) return false;
        }
        return true;
    }
};
