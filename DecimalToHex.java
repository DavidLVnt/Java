package stringchar;

import java.util.Scanner;

public class DecimalToHex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter decimal value (0 to 15): ");
		int decimal = input.nextInt();
		
		if(decimal > 0 && decimal < 9) {
			System.out.println("The hex value is " + decimal);
		}
		else if(decimal > 9 && decimal < 15) {
			System.out.println("The hex value is " + (char)(decimal + 'A' - 10));
			
		}
		else {
			System.out.println(decimal + " is an invalid input");
		}
		

	}

}
