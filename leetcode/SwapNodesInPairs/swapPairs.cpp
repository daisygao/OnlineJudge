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
  ListNode *swapPairs(ListNode *head) {
    // Start typing your C/C++ solution below
    // DO NOT write int main() function
    ListNode *p = head, *prev, *next;
    while (p != NULL && p->next != NULL) {
      next = p->next->next;
      if (p == head) {
	prev = p;
	head = p->next;
	head->next = prev;
	prev->next = next;              
      } else {
	prev->next = p->next;
	prev->next->next = p;
	p->next = next;
	prev = p;
      }
      p = next;
    }
    return head;
  }
};
