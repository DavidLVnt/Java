package Chapter4;
import java.util.Scanner;
/**
 * @author Dung Luong
 * User enter number of gallons used, beginning odometer, ending odometer 
 * calculate number miles per gallons and kilometers per litters then
 * Display the result to the screen.
 */
public class MilesPerGallon {
  public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
    final double KMS_PER_MILE = 1.60934;
    final double LITTER_PER_GALLON = 3.78541;
    
    // Input number gallons used.
    System.out.print("Please enter number of gallons used: ");
    double gallon = Double.parseDouble(input.nextLine());
    input.close();
    
    // Compute and display to the screen.
    if (gallon > 0 ) {
      System.out.print("Please enter the beginning odometer reading: ");
      int beginOdometer = Integer.parseInt(input.nextLine());
      System.out.print("Please enter the ending odometer reading: ");
      int endingOdometer = Integer.parseInt(input.nextLine());
      
      if (endingOdometer > beginOdometer) {
    	double milePerGal = (endingOdometer - beginOdometer) / gallon;
    	double kmPerLit = (milePerGal * KMS_PER_MILE) / LITTER_PER_GALLON;     							
    	System.out.printf("The number of miles per gallons is: %.4f\n"
    			          , milePerGal);
        System.out.printf("The number of kilometers per liter is: %.4f\n"
        		          , kmPerLit);        		     
      }
      else {
    	System.out.println("I'm sorry, the ending odometer reading must be " 
    			          +  "greater than the starting odometer reading.");
      }
	}
    else {
      System.out.println("I'm sorry, gallons used must be greater than 0.");
    }
  }
}
