package practice;

import java.util.Scanner;

public class FindFutureDates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter today's day: ");
		int dayNumber = input.nextInt();
		
		System.out.print("Enter the number of days elapsed since today: ");
		int elapsed = input.nextInt();
		
		int futureDay = (dayNumber + elapsed) % 7;
		
		switch (dayNumber) {
        case 0:
            System.out.print("Today is Sunday and");
            break;
        case 1:
            System.out.print("Today is Monday and");
            break;
        case 2:
            System.out.print("Today is Tuesday and");
            break;
        case 3:
            System.out.print("Today is Wednesday and");
            break;
        case 4:
            System.out.print("Today is Thursday and");
            break;
        case 5:
            System.out.print("Today is Friday and");
            break;
        case 6:
            System.out.print("Today is Saturday and");
            break;

    }

    switch (futureDay) {
        case 0:
            System.out.print(" the future day is Sunday.");
            break;
        case 1:
            System.out.print(" the future day is Monday.");
            break;
        case 2:
            System.out.print(" the future day is Tuesday.");
            break;
        case 3:
            System.out.print(" the future day is Wednesday.");
            break;
        case 4:
            System.out.print(" the future day is Thursday.");
            break;
        case 5:
            System.out.print(" the future day is Friday.");
            break;
        case 6:
            System.out.print(" the future day is Saturday.");
            break;

    }	
				

	}

}
