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
    ListNode *detectCycle(ListNode *head) {
        ListNode *fast = head, *slow = head;
        bool cycle = false;
        while (fast && fast->next) {
            fast = fast->next->next;
            slow = slow->next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }
        slow = head;
        while (cycle && fast != slow) {
            fast = fast->next;
            slow = slow->next;
        }
        return cycle ? fast : NULL;
    }
};
