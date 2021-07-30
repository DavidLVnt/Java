package Chapter1;
import java.util.Scanner;
/**
 * @author Dung Luong
 * Get the height and weight from the user, calculate BMI and display result to the window. 
 *
 */
public class CalculateBMI {
  public static void main(String[] args)
  {
	Scanner input = new Scanner(System.in);
	
	// Get the weight and height
	System.out.print("Enter weight in pounds: ");
	double weight = input.nextDouble();
	System.out.print("Enter height in inches: ");
	double height = input.nextDouble();
	input.close();
	
	//Compute and display BMI
	final int BMI_METRIC_CONVERTER = 703;
	double bmi = (weight / (height * height) * BMI_METRIC_CONVERTER );
	System.out.printf("BMI is %.1f", bmi);
	
	}

}
