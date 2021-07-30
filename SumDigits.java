package practice;

import java.util.Scanner;

public class SumDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a number between 0 and 1000: ");
		int number = input.nextInt();
		
		int lastDigit = number % 10;
		int middleDigit = number / 10;
		int remaindMiddleDigit = middleDigit % 10;
		int firstDigit = number / 100;
		
		int sum = lastDigit + remaindMiddleDigit + firstDigit;
		
		System.out.println(firstDigit);
		System.out.println(remaindMiddleDigit);
		System.out.println(lastDigit);

		System.out.println("The sum of the digits is " + sum);		

	}

}
