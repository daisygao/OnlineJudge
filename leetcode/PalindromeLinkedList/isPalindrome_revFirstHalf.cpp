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
        if (!head || !head->next) return true;
        ListNode *p = head, dummy(0);
        dummy.next = head;
        int len = 0;
        while (p) {
            len++;
            p = p->next;
        }
        int halfLen = len / 2;
        while (--halfLen > 0) {
            ListNode *next = head->next->next;
            head->next->next = dummy.next;
            dummy.next = head->next;
            head->next = next;
        }
        ListNode *q = len % 2 ? head->next->next : head->next;
        p = dummy.next;
        while (q) {
            if (p->val != q->val) return false;
            p = p->next;
            q = q->next;
        }
        return true;
    }
};
