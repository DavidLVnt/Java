package Chapter3;
import java.util.Scanner;
/**
 * @author Dung Luong
 * User prompt radius and use if else statements to calculate Circumference
 * and Area, display result to the screen.
 */
public class CircleCalculation {
  public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	//Get the radius and choices from keyboard.
	System.out.print("Please enter a radius (feet): ");
	double radius = Double.parseDouble(input.nextLine());
	System.out.print("Enter A(Area) or C(Circumference): ");
	String choice = input.nextLine();
	input.close();
	
	//Use if else statement to calculate circumference and area and display to output.
	if(choice.equalsIgnoreCase("c") && (radius > 0)) {
	  double circumference = 2 * radius * Math.PI;
	  System.out.printf("Circumference: %.4f feet", circumference);
	}
	else if (choice.equalsIgnoreCase("a") && (radius > 0)) {
	  double area = radius * radius * Math.PI;
	  System.out.printf("Area: %.4f square feet", area);
	}
	else {
	  System.out.println("I'm sorry, I did not understand your choice.");
	}	
	}
}
