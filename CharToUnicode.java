package stringchar;

import java.util.Scanner;

public class CharToUnicode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a character: ");
		String s = input.nextLine();
		char c = s.charAt(0);
		
		System.out.println("The Unicode for the character " + s + " is " 
		+ ((int)c));
		

	}

}
