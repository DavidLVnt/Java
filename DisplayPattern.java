package Loop;

import java.util.Scanner;

public class DisplayPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter number of n: ");
		int n = input.nextInt();
		
		System.out.println("Pattern A\n");
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
		System.out.println("Pattern B\n");
		for (int i = n; i > 0; i--) {
			for(int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();

		}
		
		System.out.println("Pattern C\n");
		for(int i = 1; i <= n; i++) {
			for(int j = (n - i); j >= 1; j--) {
				System.out.print(" ");
			}
			for(int k = i; k >= 1; k--) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
		
		System.out.println("Pattern D\n");
		for (int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < (n - i); k++) {
				System.out.print((k + 1) + " ");
			}
			System.out.println();

	}
	}
}
