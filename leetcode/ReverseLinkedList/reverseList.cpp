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
    ListNode* reverseList(ListNode* head) {
        if (!head) return head;
        ListNode *tail = head, *newHead = NULL;
        while (tail->next) {
            newHead = tail->next;
            tail->next = newHead->next;
            newHead->next = head;
            head = newHead;
        }
        return head;
        
    }
};
