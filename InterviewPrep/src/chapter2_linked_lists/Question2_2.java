package chapter2_linked_lists;

import dataStructures.Node;

public class Question2_2 {
/*
 * Implement a function to find the kth to last element of a singly linked list.
 */
	Node n;
	
	public Question2_2(int len) {
		n = new Node(0);
		for(int i = 1; i < len; i++) {
			n.appendToTail(i);
		}
	}
	
	public Node getKthNode (int k) {
		Node frontRunner, tailRunner;
		frontRunner = n;
		tailRunner = n;
		
		for(int i = 1; i < k; i++) {
			frontRunner = frontRunner.next;
		}
		
		while(frontRunner.next != null) {
			frontRunner = frontRunner.next;
			tailRunner = tailRunner.next;
		}
		
		return tailRunner;
	}
	
}
