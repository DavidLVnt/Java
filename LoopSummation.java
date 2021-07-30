package Chapter5;
import java.util.Scanner;
/**
 * @author Dung Luong
 * User input two integer values upper and lower, lower less than or equal
 * upper, then sum all values from lower to upper.
 */
public class LoopSummation {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int upperLimit;
		int lowerLimit;
		int sum = 0;
		do {
			// User in put two integer values until 
			// lower limit less than or equal upper limit.
			System.out.print("Lower Limit: ");
			lowerLimit = input.nextInt();
			System.out.print("Upper Limit: ");
			upperLimit = input.nextInt();
			System.out.println("");
			
			// Sum all values from lower limit to upper limit.
			for (int i = lowerLimit; i <= upperLimit; ++i) {
				sum += i;
			}
		} while (lowerLimit > upperLimit);
		// Display sum to the screen.
		System.out.println("The sum from " + lowerLimit + " through " 
		                   + upperLimit + " is " + sum);
		input.close();
	}
}
