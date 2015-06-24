package chapter2_linked_lists;

import dataStructures.Node;

public class Question2_5 {
/*
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1s digit is in the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * 
 * Suppose the digits are in proper order, do the same thing.
 */
	
	Node n1;
	Node n2;
	
	public Question2_5(int[] num1, int[] num2) {
		n1 = new Node(num1[0]);
		n2 = new Node(num2[0]);
		
		for(int i = 1; i < num1.length; i++) {
			Node next = new Node(num1[i]);
			n1.appendToTail(next);
		}
		
		for(int i = 1; i < num2.length; i++) {
			Node next = new Node(num2[i]);
			n2.appendToTail(next);
		}
	}

	//Adding nums with ones digit in Linked List Head.
	public Node addListReverse() {
		//Optimization
		if(n1 == null && n2 != null) return n2;
		if(n1 != null && n2 == null) return n1;
		
		printList(n1);
		System.out.println();
		printList(n2);
		System.out.println();
		
		//Recursive helper function.
		Node sum = addListReverseHelper(n1, n2, 0);
		
		return sum;
	}
	
	public Node addListReverseHelper(Node l1, Node l2, int carry) {
		//Base case.
		if(l1 == null && l2 == null) return null;
		
		//Function work.
		int val = carry;
		if(l1 != null) val+= l1.data;
		if(l2 != null) val += l2.data;
		
		int keep = val % 10;
		carry = (val - keep) / 10;
		
		Node result = new Node();
		result.data = keep;
		
		//Recursive call;
		if(l1 != null || l2 != null) {
			Node more = addListReverseHelper(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry);
			result.appendToTail(more);
		}
		
		return result;
	}
	
	//Adding nums with ones digit in Linked List Tail.
	public class AddListPart {
		Node sum = null;
		int carry = 0;
	}
	
	public Node addListProper() {
		//Optimization
		if(n1 == null && n2 != null) return n2;
		if(n1 != null && n2 == null) return n1;
		
		printList(n1);
		System.out.println();
		printList(n2);
		System.out.println();
		
		//Pad the lists.
		if(length(n1) < length(n2)) {
			n1 = padList(n1,length(n2) - length(n1));
		} else {
			n2 = padList(n2,length(n1) - length(n2));
		}
		
		printList(n1);
		System.out.println();
		printList(n2);
		System.out.println();
		
		//Recursive helper function
		AddListPart sum = addListProperHelper(n1, n2);
		
		//Handle last carry and return.
		if(sum.carry == 0) {
			return sum.sum;
		} else {
			sum.sum.appendToHead(new Node(sum.carry));
			return sum.sum;
		}
	}
	
	//Get the length of a linked list.
	private int length(Node n) {
		int length = 0;
		while(n != null) {
			length += 1;
			n = n.next;
		}
		
		return length;
	}
	
	//Pad the linked list with zeros if its shorter than the other.
	private Node padList(Node n, int pad) {
		for(int i = 0; i < pad; i++) {
			Node nPad = new Node(0);
			n.appendToHead(nPad);
		}
		return n;
	}
	
	public AddListPart addListProperHelper(Node l1, Node l2) {
		
		//Base case.
		if(l1 == null && l2 == null) {
			System.out.println("HIT!");
			AddListPart sum = new AddListPart();
			return sum;
		}
		
		//Recursive call.
		AddListPart sum = addListProperHelper(l1.next, l2.next);
		
		//The work.
		int val = sum.carry + l1.data + l2.data;
		int keep = val % 10;
		int carry = (val - keep) / 10;
		
		Node n = new Node(keep);
		
		if(sum.sum == null) {
			sum.sum = n;
		} else {
			sum.sum.appendToHead(n);
		}
		
		sum.carry = carry;
		return sum;
	}
	
	public void printList(Node n) {
		while(n != null) {
			System.out.print(n.data);
			n = n.next;
		}
	}
}
