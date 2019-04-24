/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return addNums(l1, l2, null);
	}
	
	public ListNode addNums(ListNode l1, ListNode l2, ListNode temp) {
		if (l1 == null && l2 == null && temp == null) {
			return null;
		}
		int value = add(l1, l2, temp);
		int currentValue = value % 10;
		int nextValue = value / 10;
		ListNode next1 = null;
		ListNode next2 = null;		
		ListNode temp1 = null;
		if (l1 != null) {
			next1 = l1.next;
		}
		if (l2 != null) {
			next2 = l2.next;
		}
		if (nextValue != 0) {
			temp1 = new ListNode(nextValue);
		}
		ListNode nextNode = addNums(next1, next2, temp1);
		ListNode currentNode = new ListNode(currentValue);
		currentNode.next = nextNode;
		return currentNode;
	}
	
	public int add(ListNode node1, ListNode node2, ListNode temp) {
		int result = 0;
		if (node1 != null) {
			result += node1.val;
		}
		if (node2 != null) {
			result += node2.val;
		}
		if (temp != null) {
			result += temp.val;
		}
		return result;
	}
}