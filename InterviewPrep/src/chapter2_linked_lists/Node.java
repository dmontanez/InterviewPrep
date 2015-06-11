package chapter2_linked_lists;

public class Node {
	public int data;
	public Node next = null;
	
	public Node(int d) {
		this.data = d;
	}
	
	public void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	
}
