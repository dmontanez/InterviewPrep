import chapter1_arrays_and_strings.*;
import chapter2_linked_lists.*;
import dataStructures.Node;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] num1 = new int[4];
		int[] num2 = new int[3];
		
		num1[0] = 1;
		num1[1] = 2;
		num1[2] = 3;
		num1[3] = 4;
		num2[0] = 5;
		num2[1] = 6;
		num2[2] = 7;
		
		Question2_5_2 myList = new Question2_5_2(num1, num2);
		
		myList.printList(myList.n1);
		myList.printList(myList.n2);
		
		System.out.println();
		
		myList.printList(myList.addListProper());
		System.out.println();
	}

}
