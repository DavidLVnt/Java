package Recursion;


public class RecursionLabProblems {
	
	/**
	 * This function returns a string of numbers from [start] to [end] (inclusive)
	 * as a string. For simplicity reason, it is expected that there will be a space as the last character.
	 * 
	 * Base case:		If start > end, then we're done; return an empty string.
	 * Recursive case:	Return start (as a string), plus a space, plus countUp( start+1, end )
	 * 
	 * @param start		Which number to start at
	 * @param end		Which number to end at
	 * @return			A string of each number from [start] to [end] (inclusive),
	 * 					separated with spaces and with a trailing space at the end.
	 */
	public String countUp( int start, int end ) {
		if (start > end) 
			return "";
		else 
			return start + " " + countUp(start+1, end);
		
		}

	/**
	 * Finds the result of n!, where n! = n * (n-1) * (n-2) * ... * 1
	 * 
	 * Base case: 		When n is 0, return 1. (0! = 1)
	 * Recursive case:	n! = n * (n-1)!
	 * 
	 * @param n		The value of n, where the multiplication begins at
	 * @return		Returns the result for n!
	 */
	public int factorial( int n ) {
		
		if (n == 0) {
			return 1;
		} else {
			return n * factorial(n -1);
		}
		
	}

	/**
	 * Returns the nth fibonacci term, starting with 1 as the 0th term, and 1 as the 1st term.
	 * Fibonacci numbers are 1, 1, 2, 3, 5, 8, 13, ... (each next number is the sum of the previous two.)
	 * 
	 * Base case:		If n = 0, return 1
	 * Base case:		If n = 1, return 1
	 * Recursive case:	Return fib(n-1) + fib(n-2)
	 * 
	 * @param n			The nth fibonacci term to find
	 * @return			The value of the nth fibonacci term
	 */
	public int fibonacci( int n ) {
		if (n == 0) {
			return 0;
		}else if (n ==1) {
			return 1;
		}else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
		 
	}
	
	/**
	 * A function that counts the amount of spaces in a string of text.
	 * 
	 * Base case:		pos is at the end of the string (text.length()), return 0 since there are no spaces here.
	 * Recursive case:	Check if the character at [pos] in the [text] string is a space ' '. 
	 * 					If so, 1 will be added to the result of countSpaces( text, pos+1 ).
	 * 					If not a space, it will be 0 plus the result of countSpaces( text, pos+1 ).
	 * 
	 * @param text		The text to search through
	 * @param pos		The current position in the string we're looking at
	 * @return			The count of spaces found
	 */
	public int countSpaces( String text, int pos ) {
		
		if (text == null || text.length() == pos) {
			return 0;
		}
		
		if (' ' != text.charAt(pos)) {
			
			return countSpaces(text, pos + 1);
		} else {
			
			return countSpaces(text, pos + 1) + 1;
		}
				
	}
    

}
