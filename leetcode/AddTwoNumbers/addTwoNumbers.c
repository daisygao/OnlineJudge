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
  ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
    // Start typing your C/C++ solution below
    // DO NOT write int main() function
    ListNode *p1 = l1, *p2 = l2, *p = NULL, *res = NULL;
    int cur = 0, next = 0;
    while (p1 != NULL || p2 != NULL) {
      int v1 = p1 == NULL ? 0 : p1->val;
      int v2 = p2 == NULL ? 0 : p2->val;
      cur = v1 + v2 + next;
      next = cur / 10;
      ListNode *tmp = new ListNode(cur % 10);
      if (!res) {
	res = p = tmp;
      } else {
	p->next = tmp;
	p = p->next;
      }
      if (p1) p1 = p1->next;
      if (p2) p2 = p2->next;
    }
    if (next > 0) p->next = new ListNode(next);
    return res;
  }
};
