package chapter2_linked_lists;

import dataStructures.Node;

public class Question2_4 {
/*
 * Write code to partition a linked list around a value x, such that all nodes less than x
 * come before all nodes greater than r equal to x.
 */
	
	Node n;
	int x;
	
	public Question2_4(int len, int x) {
		n = new Node(1);
		for(int i = 1; i < len; i++) {
			n.appendToTail(i%4);
		}
		this.x = x;
	}
	
	public void partitionList() {
		Node p1 = null;
		Node p2 = null;
		Node p1Head = null;
		Node p2Head = null;
		while(n != null) {
			Node currNode = n.next;
			n.next = null;
			if(n.data < x) {
				if(p1 == null) {
					p1 = n;
					p1Head = p1;
				} else {
					p1.next = n;
					p1 = n;
				}
			} else {
				if(p2 == null) {
					p2 = n;
					p2Head = p2;
				} else {
					p2.next = n;
					p2 = n;
				}
			}
			//printList(p1Head);
			//printList(p2Head);
			n = currNode;
		}
		
		if(p1 == null){
			n = p2Head;
			return;
		}
		p1.next = p2Head;
		n = p1Head;
	}
	
	public void printList() {
		System.out.println();
		Node head = n;
		while(head != null) {
			System.out.print(head.data);
			head = head.next;
		}
	}
	
	private void printList(Node head) {
		System.out.println();
		while(head != null) {
			System.out.print(head.data);
			head = head.next;
		}
	}
	
}
