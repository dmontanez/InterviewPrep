import chapter1_arrays_and_strings.*;
import chapter2_linked_lists.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n = new Node(0);
		for(int i = 1; i < 10; i++) {
			n.appendToTail(i%2);
		}
		
		Node printNode = n;
		
		while(printNode!=null) {
			System.out.print(printNode.data);
			printNode = printNode.next;
		}
		
		System.out.println();
		System.out.println("Running Function...");
		
		Question2_1 checkQuestion = new Question2_1(n);
		printNode = checkQuestion.removeDuplicates();
		
		System.out.println("Function done running!");
		
		while(printNode!=null) {
			System.out.print(printNode.data);
			printNode = printNode.next;
		}
	}

}
