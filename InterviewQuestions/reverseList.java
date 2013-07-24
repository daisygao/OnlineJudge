/*
Reverse a single-linked list

Solutions:
1 2 3 4 5 
2 1 3 4 5
* 3 2 1 4 5 
current pointer - 4
prev pointer - 1
head pointer - 3
*/
public ListNode reverseList(ListNode head) {
	ListNode prev = head, current = head == null ? null : head.next;
	while (current != null) {
		prev.next = current.next;
		current.next = head;
		head = current;
		current = prev.next;
	}
	return head;
}