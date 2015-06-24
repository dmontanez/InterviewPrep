package chapter2_linked_lists;

import java.util.HashSet;

import dataStructures.Node;

public class Question2_1 {
/*
 * Write code to remove duplicates from an unsorted linked list.
 * How would you do this if a temporary buffer is not allowed?
 */
	Node n;
	
	public Question2_1 (int[] nums){
		n = new Node(nums[0]);
		for(int i = 1; i < nums.length; i++) {
			Node newNode = new Node(nums[i]);
			n.appendToTail(newNode);
		}
	}
	
	public Node removeDups() {
		//Optimization.
		if(n == null || n.next == null) return n;
		
		HashSet<Integer> myList = new HashSet<Integer>();
		Node start = n;
		Node prev = n;
		
		myList.add(n.data);
		n = n.next;
		while(n != null) {
			if(myList.contains(n.data)){
				prev.next = n.next;
				n = n.next;
			} else {
				myList.add(n.data);
			}
			prev = prev.next;
			if(n != null) n = n.next;
		}
		
		return start;
	}
	
	public void printList(Node n) {
		while(n != null) {
			System.out.print(n.data);
			n = n.next;
		}
	}
}
