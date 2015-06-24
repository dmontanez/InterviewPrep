package chapter2_linked_lists;

import dataStructures.Node;

public class Question2_2 {
/*
 * Implement a function to find the kth to last element of a singly linked list.
 */
	
	Node n;
	
	public Question2_2(int[] num) {
		n = new Node(num[0]);
		for(int i = 1; i < num.length; i++) {
			Node aNode = new Node(num[i]);
			n.appendToTail(aNode);
		}
	}
	
	public int kthToLast(int k) {
		if(n == null || n.next == null) return n.data;
		Node frontRunner = n;
		Node tailRunner = n;
		
		for(int i = 0; i < k; i++) {
			frontRunner = frontRunner.next;
		}
		
		while(frontRunner != null) {
			tailRunner = tailRunner.next;
			frontRunner =frontRunner.next;
		}
		return tailRunner.data;
	}
	
}
