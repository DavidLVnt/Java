package practice;

import java.util.Scanner;

public class FeetToMeter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a value for feet: ");
		double feet = input.nextDouble();
		
		double meter = feet * 0.305;
		System.out.println(feet + " feet is " + meter + " meters");
		

	}

}
