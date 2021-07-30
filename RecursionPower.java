package Chapter11;
import java.util.Scanner;

/**  
 * @author Dung Luong
 * class RecursionPower will recursively calculate the result of
 * a user-entered base raised to user-entered exponent.
 */
public class RecursionPower 
{
  public static void main(String[] args)
	{
		int[] baseExp = new int[2]; // baseExp[0] will hold the base
									// baseExp[1] will hold the exponent
		try {
			getInput(baseExp);
			System.out.printf("%d^%d = %d", baseExp[0], baseExp[1],
							 computePower(baseExp[0], baseExp[1]));
		} catch (NumberFormatException exc) {
			System.out.println("Improper Integer: " + exc.getMessage());
		} catch (Exception exc) {
			System.out.println("Error occurred: " + exc.getMessage());
		}
	}

  /**
   * getInput prompts for and retrieves the base and exponent
   * from the user and stores the values into baseExp
   *   baseExp[0] --> holds the base
   *   baseExp[1] --> holds the exponent
   * @param baseExp[] The array that will eventually hold the base
   *                  and exponent */
  public static void getInput(int[] baseExp)
	{
		Scanner input = new Scanner(System.in);

		System.out.print("Enter the base: ");
		baseExp[0] = Integer.parseInt(input.nextLine());
		System.out.print("Enter the exponent: ");
		baseExp[1] = Integer.parseInt(input.nextLine());
		input.close();
	} // end getInput
  
  /**
   * computePower recursively computes base raised to the exponent.
   * @precondition exponent > 0.
   * @param base The base integer of the power calculation.
   * @param exponent The value to which the base is raised. 
   * @throws Exception if exponent <= 0. 
   * @return base raised to the exponent*/
	public static long computePower(int base, int exponent) throws Exception {
		if (exponent <= 0) {
			throw new Exception("Unaccepted exponent.");
		}
		if (exponent == 1)
			return base;
		else
			return base * computePower(base, exponent - 1);
	} // end computePower

}//end class

