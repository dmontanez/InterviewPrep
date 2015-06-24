package dataStructures;

public class Node {
	public int data;
	public Node next = null;
	
	public Node(int d) {
		this.data = d;
	}
	
	public Node() {};
	
	public void appendToTail(Node end) {
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	
	public void appendToHead(Node start) {
		Node node = new Node(this.data);
		node.next = this.next;
		this.data = start.data;
		this.next = node;
	}
	
	public void print() {
		Node n = this;
		while(n != null) {
			System.out.print(n.data);
			n = n.next;
		}
	}
}