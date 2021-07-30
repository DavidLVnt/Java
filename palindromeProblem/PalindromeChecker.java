package palindromeProblem;

import java.util.Scanner;

import queues.LinkedQueue;
import stacks.ArrayStack;
import stacks.LinkedStack;

public final class PalindromeChecker {


	public static boolean isPalindrome(String phrase) {
		
		ArrayStack<Character> stack = new ArrayStack<>();
		
		String inputPhrase = removePunctuation(phrase);
		String reversePhrase = "";
		for (int i = 0; i < inputPhrase.length(); i++) {
			stack.push(inputPhrase.charAt(i));
		}
		
		while (!stack.isEmpty()) {
			reversePhrase += stack.pop();
		}
		
		if (inputPhrase.equals(reversePhrase))
			return true;

		return false;
	}

	public static String getPalindrome(String phrase) {
		 
		StringBuffer output = new StringBuffer(phrase);
		
		return output.reverse().toString();
	}
	
	public static String removePunctuation(String phrase) {
		int index = phrase.length() - 1;
		StringBuffer output = new StringBuffer(phrase);
		for(; index >= 0;) {
			String c = phrase.charAt(index) + "";
			if (c.equals(",") || c.equals(".") || c.equals(";") || c.equals(":") || c.equals("!") || c.equals("?"))
				output.replace(index, index + 1, "");
			index--;
		}
		return output.toString();
	}

}
