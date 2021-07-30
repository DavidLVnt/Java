package Chapter7;
import java.util.Scanner;
import java.util.Random;
/**
 * @author Dung Luong
 * User generate table 10 x 10, find the largest number in the table 
 * and find locate of that number.
 */
public class TwoDimensionalArray {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random randomNumbers = new Random();
		final int LIMIT = 100;
		final int NUM_SIZE = 10;
		int[][] table = new int[NUM_SIZE][NUM_SIZE];
		int maxNumber = table[0][0];
		int i = 0;
		int j = 0;
		int x = 0;
		int y = 0;
		
		//Generate random number of table and find max number
		for (i = 0; i < table.length; ++i) {
			for (j = 0; j < table[i].length; ++j) {
				table[i][j] = randomNumbers.nextInt(LIMIT);
			}
		}
		for (i = 0; i < table.length; ++i) {			
			for (j = 0; j < table[i].length; ++j) {
				if (table[i][j] > maxNumber) {
					maxNumber = table[i][j];
					y = j;
					x = i;
				}								
			}			
		}
		
		//Display table and locate max number.
		for (int numRows[] : table) {
			for (int numCols : numRows) {
				System.out.printf("%3d", numCols);
			}
			System.out.println();
		}
		System.out.println();
		System.out.print(" The highest value located at [" + x + "]" + "["
		 + y +"]" + " is " + maxNumber);
	}
}
