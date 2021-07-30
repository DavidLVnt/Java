package Chapter1;
/**
 * @author Dung Luong
 * User input two integer numbers, calculations and display the results to the window. 
 *
 */
import java.util.Scanner;
public class OperatorCalculation {
  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);  
    
    // Get integers from user
    System.out.print("Please enter the first positive integer: ");
    int firstNums = input.nextInt();
    System.out.print("Please enter the second positive integer: ");
    int secondNums = input.nextInt();
    input.close();
    
    // Display resulting calculations
    System.out.println("Sum: " + (firstNums + secondNums));
    System.out.println("Product: " + (firstNums * secondNums));
    System.out.println("Difference: " + (firstNums - secondNums));
    System.out.println("Quotient: " + ((double)firstNums / secondNums));
    System.out.println("Remainder: " + (firstNums % secondNums));
  }

}
