package stringchar;

import java.util.Scanner;

public class AsciiToChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter an ASCII code: ");
		int asCode = input.nextInt();
				
		System.out.println("The character for ASCII code " + asCode  
				+ " is " + ((char)asCode));
		
			}

}
