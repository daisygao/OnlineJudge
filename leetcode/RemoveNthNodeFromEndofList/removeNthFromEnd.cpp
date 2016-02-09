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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode dummy = ListNode(0), *first = &dummy, *second = &dummy;
        dummy.next = head;
        while (n-- > 0 && first) first = first->next;
        while (first && first->next) {
            first = first->next;
            second = second->next;
        }
        if (second && second->next) second->next = second->next->next;
        return dummy.next;
    }
};
