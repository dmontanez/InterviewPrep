package chapter2_linked_lists;

import java.util.Random;

import dataStructures.Node;

public class Question2_3 {
/*
 * Implement an algorithm to delete the node in the middle of a singly linked list,
 * given access to only that node.
 */
	
	Node n;
	
	public Question2_3(int[] num) {
		n = new Node(num[0]);
		for(int i = 1; i < num.length; i++) {
			Node aNode = new Node(num[i]);
			n.appendToTail(aNode);
		}
	}
	
	public Node getMid() {
		Node node = n;
		int ran = (int)(Math.random() * (length(n) - 1));
		System.out.println(ran);
		for(int i = 0; i < ran; i++) {
			node = node.next;
		}
		return node;
	}
	
	private int length(Node node) {
		int length = 0;
		while(node != null) {
			length += 1;
			node = node.next;
		}
		
		return length;
	}
	
	public Node removeMid(Node mid) {
		if(mid.next == null) {
			mid = null;
		} else {
			mid.data = mid.next.data;
			mid.next = mid.next.next;
		}
		return n;
	}
	
}
