package Chapter6;
import java.util.Scanner;
import java.text.DecimalFormat;
/**
 * @author Dung Luong
 * User generate salaries, input raise, calculate
 * salaries after add raise and display final salaries.
 */
public class SalaryArray {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		DecimalFormat currencyFormat = new DecimalFormat("$,###.00");
		DecimalFormat moneyFormat = new DecimalFormat("#");
		double[] salaries = { 42500, 54100, 60000, 39125, 43500 };
		int i;
		double raise;
		
		// Display salaries array to the screen.
		System.out.print("Original salaries array initialized to : ");
		for (i = 0; i < salaries.length; ++i) {
			if (i == (salaries.length - 1)) {
				System.out.print(moneyFormat.format(salaries[i]));
			} else {
				System.out.print(moneyFormat.format(salaries[i]) + ", ");
			}
		}

		// User input the raise.
		System.out.println("");
		System.out.print("Enter the percent raise: ");
		raise = Double.parseDouble(input.nextLine());
		// Calculate raise and display final salaries to screen.
		for (i = 0; i < salaries.length; ++i) {
			salaries[i] += salaries[i] * (raise / 100);
		}
		for (double value : salaries) {
			System.out.println(currencyFormat.format(value));
		}
	}
}
