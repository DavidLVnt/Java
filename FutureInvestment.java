package practice;

import java.util.Scanner;

public class FutureInvestment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter investment amount: ");
		double investmentAmount = input.nextDouble();
		System.out.print("Enter anual interest rate in percentage: ");
		double anualInterestRate = input.nextDouble();
		System.out.print("Enter number of years: ");
		double numberOfYears = input.nextDouble();
		
		double monthlyInterestRate = anualInterestRate / 1200;
		double futureInvestment = investmentAmount * (Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
		
		System.out.println("Future value is $" + futureInvestment);
		
		
	}

}
