package chapter2_linked_lists;

import java.util.HashSet;

import dataStructures.Node;

public class Question2_1 {
/*
 * Write code to remove duplicates from an unsorted linked list.
 * How would you do this if a temporary buffer is not allowed?
 */

	Node n;
	
	public Question2_1(int len, int k) {
		n = new Node(0);
		for(int i = 1; i < len; i++) {
			n.appendToTail(i%k);
		}
	}
	
	public void removeDuplicates() {
		Node head = n;
		HashSet<Integer> set = new HashSet<Integer>();
		Node previous = null;
		while(head != null) {
			if(set.contains(head.data)) {
				previous.next = head.next;
			} else {
				set.add(head.data);
				previous = head;
			}
			
			head = head.next;
		}
	}
	
	public void removeDupNoBuff() {
		Node head = n;
		
		while(n.next != null) {
			Node runner = n;
			while(runner != null) {
				if(runner.next.data == head.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			head = head.next;
		}
	}
	
	public void printList() {
		System.out.println();
		Node head = n;
		while(head != null) {
			System.out.print(head.data);
			head = head.next;
		}
	}
	
	public Node getHead() {
		return n;
	}
	
}