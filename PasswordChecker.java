package Chapter8;
import java.util.Scanner;
/**
 * @author Dung Luong
 * User entered the password, then create a method check password 
 * invalid or valid.
 */
public class PasswordChecker {
	public static void main(String[] args) {
		  Scanner input = new Scanner(System.in); 
		  
		  // Get the password
		  System.out.print("Password: "); 
		  String password = input.nextLine(); 
		 
		  // Check for validity
		  if (isValidPassword(password)) {
			  System.out.println("Valid Password"); 
		  } else {
			  System.out.println("Invalid Password"); 
		  }
		  input.close();
	} // end method 
	
	/**
	 * method isValidPassword checks if a password meets the 
	 * following criteria: 
	 * 1) >= 8 characters  
	 * 2) At least 2 digits 
	 * 3) Consists only of letters and digits
	 * @param newPassword the password to check 
	 * @return true or false depending if the password is valid 
	 */
	public static boolean isValidPassword(String newPassword) {
		int i;
		if (newPassword.length() < 8) {
			return false;
		} else {
			char ch;
			int count = 0;
			for (i = 0; i < newPassword.length(); ++i) {
				ch = newPassword.charAt(i);
				if (!Character.isLetter(ch) && !Character.isDigit(ch)) {
					return false;
				} else if (Character.isDigit(ch)) {
					count++;
				}
			}
			if (count < 2) {
				return false;
			}
		}
		return true;
	}
}
