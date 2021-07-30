package Chapter4;
import java.util.Scanner;
/**
 * @author Dung Luong
 * Get the month from input and display the season.
 * 
 */
public class SeasonSwitch {
  public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	// Get the month from input.
	System.out.print("Enter a numeric month i will display the season: ");
	int month = Integer.parseInt(input.nextLine());
	input.close();
	
	// Display season to the screen.
	switch (month)
	{
	  case 12:
	  case 1:
	  case 2:
	    System.out.println("Month: " + month);
	    System.out.println("winter");
	    break;
	  case 3:
	  case 4:
	  case 5:
	    System.out.println("Month: " + month);
	    System.out.println("spring");
	    break;
	  case 6:
	  case 7:
	  case 8:
	    System.out.println("Month: " + month);
	    System.out.println("summer");
	    break;
	  case 9:
	  case 10:
	  case 11:
	    System.out.println("Month: " + month);
	    System.out.println("fall");
	    break;
	  default:
		System.out.println("Month: " + month);
		System.out.println("I'm sorry, an invalid month was entered.");
		break;
	  }
	}
}
