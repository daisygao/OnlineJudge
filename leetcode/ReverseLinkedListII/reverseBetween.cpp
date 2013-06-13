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
  ListNode *reverseBetween(ListNode *head, int m, int n) {
    // Start typing your C/C++ solution below
    // DO NOT write int main() function
    if (m == n) return head;
    int idx = 1;
    ListNode *cur = head->next, *end = head;
    if (m == 1) {
      while (idx < n) {
	end->next = cur->next;
	cur->next = head;
	head = cur;
	cur = end->next;
	idx++;
      }
    } else {
      ListNode *pre = head;
      idx = 1;
      while (idx < m - 1) {
	pre = pre->next;
	idx++;
      }
      end = pre->next;
      cur = end->next;
      idx++;
      while (idx < n) {
	end->next = cur->next;
	cur->next = pre->next;
	pre->next = cur;
	cur = end->next;
	idx++;
      }
    }
    return head;
  }
};
