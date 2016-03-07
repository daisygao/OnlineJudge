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
    ListNode* swapPairs(ListNode* head) {
        ListNode dummy(0);
        dummy.next = head;
        ListNode *prev = &dummy, *cur = head;
        while (cur && cur->next) {
            ListNode *next = cur->next->next;
            prev->next = cur->next;
            prev->next->next = cur;
            cur->next = next;
            prev = cur;
            cur = cur->next;
        }
        return dummy.next;
    }
};
