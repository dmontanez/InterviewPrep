package chapter2_linked_lists;

import java.util.HashSet;

public class Question2_1 {
/*
 * Write code to remove duplicates from an unsorted linked list.
 * How would you do this if a temporary buffer is not allowed?
 */

	Node LinkedListNode;
	
	public Question2_1(Node n) {
		this.LinkedListNode = n;
	}
	
	public Node removeDuplicates() {
		Node head = LinkedListNode;
		HashSet<Integer> set = new HashSet<Integer>();
		Node previous = null;
		while(LinkedListNode != null) {
			if(set.contains(LinkedListNode.data)) {
				previous.next = LinkedListNode.next;
			} else {
				set.add(LinkedListNode.data);
				previous = LinkedListNode;
			}
			
			LinkedListNode = LinkedListNode.next;
		}
		return head;
	}
}