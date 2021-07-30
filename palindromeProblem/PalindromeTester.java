package palindromeProblem;

import java.util.Scanner;

public class PalindromeTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner (System.in);
		
		while (true) {
		System.out.print("Enter a phrase: ");
		String phrase = input.nextLine();
		
		System.out.println("Phrase: " + phrase);
		System.out.println("Is palindrome?: " + PalindromeChecker.isPalindrome(phrase));
		System.out.println("Reversed palindrome phrase: " + PalindromeChecker.getPalindrome(phrase));
		
		System.out.println("Continue checking another phrase, or quit (Y/N)? ");
		if (input.nextLine().equalsIgnoreCase("y"))
			continue;
		else
			break;
	}
	input.close();
	}
}
