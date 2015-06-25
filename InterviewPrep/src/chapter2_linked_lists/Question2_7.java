package chapter2_linked_lists;

import dataStructures.Node;

public class Question2_7 {
/*
 * Implement a function to determine if a linked list is a palindrome.
 */
	
	// RACECAR
	// reverse list, compare nodes.
	
	public Node n;
	
	public Question2_7(int[] list) {
		n = new Node(list[0]);
		for(int i = 1; i <list.length; i++) {
			Node node = new Node(list[i]);
			n.appendToTail(node);
		}
	}
	
	public boolean isPalendrome() {
		Node reverse = reverseList();
		while(n != null) {
			if(n.data != reverse.data) return false;
			n = n.next;
			reverse = reverse.next;
		}
		return true;
	}

	public Node reverseList() {
		Node flipped = new Node(n.data);
		n = n.next;
		while(n != null) {
			flipped.appendToHead(n);
			n = n.next;
		}
		
		return flipped;
	}
	
}
