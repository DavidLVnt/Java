package Chapter5;
import java.util.Scanner;
import java.text.DecimalFormat;
/**
 * @author Dung Luong
 * USer input positive account balance, continue input check amount, 
 * calculate remaining balance. Stop iteration if input less than or equal 0.
 */
public class DepositCheck {
    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
		DecimalFormat currencyFormat = new DecimalFormat("$#,##0.00");

		// User input initial account balance and check deposit.
		System.out.print("Please enter a balance: $");
		double balance = Double.parseDouble(input.nextLine());
		System.out.println();
		System.out.print("Please enter check amount "
							+ "(0 or negative value to end): $");
		double checkAmount = Double.parseDouble(input.nextLine());

		// Calculate check amount and remaining balance, 
		// then display final balance.
		while (checkAmount > 0) {
			// Stop iteration if check amount less than or equal 0.
			if (checkAmount <= 0) {
				break;				
			} else if (balance - checkAmount < 0) {
				System.out.println("Warning: Check will bounce. "
						           + "No transaction occurred.");
			} else {
				balance = balance - checkAmount;
				System.out.println("Remaining balance: " 
				               + currencyFormat.format(balance));
			}
			System.out.println();
			System.out.print("Please enter check amount"
					           + " (0 or negative value to end): $");
			checkAmount = Double.parseDouble(input.nextLine());
		}
		System.out.println("Final balance: " + currencyFormat.format(balance));
		input.close();
	}
}
