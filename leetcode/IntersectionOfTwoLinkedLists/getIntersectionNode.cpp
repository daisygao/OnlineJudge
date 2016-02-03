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
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int lenA = 0, lenB = 0;
        ListNode *pA = headA, *pB = headB;
        while (pA) {
            lenA++;
            pA = pA->next;
        }
        while (pB) {
            lenB++;
            pB = pB->next;
        }
        ListNode *first = lenA > lenB ? headA : headB, *second = first == headA ? headB : headA;
        for (int i = abs(lenA - lenB); i > 0; i--) first = first->next;
        while (first && second) {
            if (first == second) return first;
            first = first->next;
            second = second->next;
        }
        return NULL;
    }
};
