package practice;

import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a year: ");
		int year = input.nextInt();
		
		boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || ( year % 400 == 0);
		System.out.println(year + " is leap year? " + isLeapYear);	
		
		switch(year % 12) {
		case 0: System.out.println(year + " is the year of monkey"); break;
		case 1: System.out.println(year + " is the year of rooster"); break;
		case 2: System.out.println(year + " is the year of dog"); break;
		case 3: System.out.println(year + " is the year of pig"); break;
		case 4: System.out.println(year + " is the year of rat"); break;
		case 5: System.out.println(year + " is the year of ox"); break;
		case 6: System.out.println(year + " is the year of tiger"); break;
		case 7: System.out.println(year + " is the year of cat"); break;
		case 8: System.out.println(year + " is the year of dragon"); break;
		case 9: System.out.println(year + " is the year of snake"); break;
		case 10: System.out.println(year + " is the year of hourse"); break;
		case 11: System.out.println(year + " is the year of goat"); break;
		}

	}
	

}
