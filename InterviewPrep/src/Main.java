import chapter1_arrays_and_strings.*;
import chapter2_linked_lists.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] num1 = new int[3];
		int[] num2 = new int[7];
		
		num1[0] = 5;
		num1[1] = 0;
		num1[2] = 1;
		
		num2[0] = 0;
		num2[1] = 1;
		num2[2] = 2;
		num2[3] = 3;
		num2[4] = 4;
		num2[5] = 5;
		num2[6] = 6;
		
		Question2_3 myList = new Question2_3(num2);
		myList.removeMid(myList.getMid()).print();
		
	}

}
