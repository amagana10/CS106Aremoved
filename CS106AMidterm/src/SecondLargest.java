import acm.program.*;

public class SecondLargest extends ConsoleProgram {
	private static final int SENTINEL = 0;
	
	public void run() {
		
		Println("This program finds the two largest integers in a");
		
		Println("List. Enter values, one per line, using a + SENTINEL +  " to" " );
		
		Println("signal the end of the list");
		
		int largest = -1;
		int secondLargest = -1;
		while(true) {
			int input = readInt(" ? ");
			if (input > largest) {
				
				secondLargest = largest;
				largest = input;
				
			}
			else if (input > secondLargest) {
				secondLargest = input;
				
			}
		}
		Println("The largest value is " + largest);
		Println(" The second largest is " + secondLargest);
	}

}
