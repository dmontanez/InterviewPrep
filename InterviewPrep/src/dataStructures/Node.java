package dataStructures;

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
	
	public void appendToHead(int d) {
		Node node = new Node(this.data);
		node.next = this.next;
		this.data = d;
		this.next = node;
	}
}
