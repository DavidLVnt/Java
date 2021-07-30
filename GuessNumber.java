package Loop;

import java.util.Scanner;

public class GuessNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int number = (int)(Math.random() * 101);
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Guess a magic number between 0 and 100: ");
		
		int guessNumber = -1;
		while(guessNumber != number) {
			System.out.print("Enter your guess: ");
			guessNumber = input.nextInt();
			
			if (guessNumber > number) {
				System.out.println("Your guess is too high");
			}else if(guessNumber < number) {
				System.out.println("Your guess is too low");
			}else {
				System.out.println("Yes, the number is: " + guessNumber);
			}
		}
		

	}

}
