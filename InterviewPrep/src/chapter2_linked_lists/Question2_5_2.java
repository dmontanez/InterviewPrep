package chapter2_linked_lists;

import dataStructures.Node;

public class Question2_5_2 {
/*
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1s digit is in the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * 
 * Suppose the digits are in proper order, do the same thing.
 */

	public Node n1;
	public Node n2;
	
	public Question2_5_2(int[] num1, int[] num2) {
		n1 = new Node(num1[0]);
		n2 = new Node(num2[0]);
		for(int i = 1; i < num1.length; i++) {
			n1.appendToTail(num1[i]);
		}
		for(int i = 1; i < num2.length; i++) {
			n2.appendToTail(num2[i]);
		}
	}
	
	public Node addListReverse() {
		Node sum = null;
		int keep;
		int carry = 0;
		if(n1 == null && n2 != null) return n2;
		if(n1 != null && n2 == null) return n1;
		
		while(n1 != null || n2 != null) {
			int val = carry;
			if(n1 != null) val += n1.data;
			if(n2 != null) val += n2.data;
			
			keep = val % 10;
			carry = (val - keep) / 10;
			
			if(sum == null) {
				sum = new Node(keep);
			} else {
				sum.appendToTail(keep);
			}
			
			if(n1 != null) n1 = n1.next;
			if(n2 != null) n2 = n2.next;
		}
		if(carry > 0) sum.appendToTail(carry);
		return sum;
	}
	
	public Node addListProper() {
		if(length(n1) < length(n2)) {
			padList(n1, length(n2) - length(n1));
		} else {
			padList(n2, length(n1) - length(n2));
		}
		n1 = reverse(n1);
		n2 = reverse(n2);
		System.out.println("REVERSED");
		printList(n1);
		printList(n2);
		if(n1 == null && n2 != null) return n2;
		if(n1 != null && n2 == null) return n1;
		Node sum = null;
		int keep;
		int carry = 0;
		while(n1 != null || n2 != null) {
			int val = carry;
			if(n1 != null) val += n1.data;
			if(n2 != null) val += n2.data;
			keep = val % 10;
			carry = (val - keep) / 10;
			if(sum == null) {
				sum = new Node(keep);
			} else {
				sum.appendToHead(keep);
			}
			System.out.println("PASS");
			if(n1 != null) n1 = n1.next;
			if(n2 != null) n2 = n2.next;
		}
		if(carry > 0) sum.appendToHead(carry);
		return sum;
	}
	
	public int length(Node n) {
		int count = 0;
		while(n != null) {
			count += 1;
			n = n.next;
		}
		return count;
	}
	
	public void padList(Node n, int len) {
		for(int i = 0; i < len; i++) {
			n.appendToHead(0);
		}
	}
	
	public Node reverse(Node n) {
		int temp = n.data;
		Node newNode = new Node(temp);
		n = n.next;
		while(n != null) {
			newNode.appendToHead(n.data);
			n = n.next;
		}
		return newNode;
	}
	
	public void printList(Node head) {
		System.out.println();
		while(head != null) {
			System.out.print(head.data);
			head = head.next;
		}
	}
	
}
