package chapter2_linked_lists;

import dataStructures.LinkedListNode;
import dataStructures.Node;

public class Question2_5 {
/*
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1s digit is in the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * 
 * Suppose the digits are in proper order, do the same thing.
 */

	public LinkedListNode n1;
	public LinkedListNode n2;
	int keep;
	int carry;
	
	public Question2_5(int[] num1, int[] num2) {
		
		n1 = new LinkedListNode();
		n2 = new LinkedListNode();
		n1.data = num1[0];
		n2.data = num2[0];
		LinkedListNode temp = n1;
		
		for(int i = 1; i < num1.length; i++) {
			temp.setNext(new LinkedListNode());
			temp.next.data = num1[i];
			temp = temp.next;
		}
		temp = n2;
		for(int i = 1; i < num2.length; i++) {
			temp.setNext(new LinkedListNode());
			temp.next.data = num2[i];
			temp = temp.next;
		}
		
		carry = 0;
		keep = 0;
		
	}
	
	public LinkedListNode addListReverse() {
		LinkedListNode sum = new LinkedListNode();
		LinkedListNode sumHead = new LinkedListNode();
		
		if(n1 == null && n2 != null) return n2;
		if(n1 != null && n2 == null) return n1;
		
		while(n1 != null || n2 != null) {
			int val = n1.data + n2.data + carry;
			keep = val % 10;
			carry = (val - keep) / 10;
									
			sum.data = keep;
			sum.setNext(new LinkedListNode());
			
			if (sumHead == null) sumHead = sum;
			
			sum = sum.next;
			
			System.out.println("PASS");
			System.out.println(n1.data);
			System.out.println(n2.data);
			
			if(n1 != null) n1 = n1.next;
			if(n2 != null) n2 = n2.next;
		}
		
		if(carry > 0) {
			sum.data = carry;
		}
		
		return sumHead;
	}
	
	public LinkedListNode addListRecursive(LinkedListNode n1, LinkedListNode n2, int carryOver) {
		if(n1 == null && n2 == null && carryOver == 0) return null;
		
		int value = carryOver;
		LinkedListNode result = new LinkedListNode();
		
		if(n1 != null) value += n1.data;
		if(n2 != null) value += n2.data;
		
		result.data = value % 10;
		
		if(n1 != null || n2 != null) {
			LinkedListNode more = addListRecursive(n1 == null ? null : n1.next, n2 == null ? null : n2.next, carryOver >= 10 ? 1 : 0);
			result.setNext(more);
		}
		
		return result;
	}
	
	public void printList(LinkedListNode head) {
		System.out.println();
		while(head != null) {
			System.out.print(head.data);
			head = head.next;
		}
	}
	
}
