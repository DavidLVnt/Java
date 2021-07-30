package stringchar;

import java.util.Scanner;

public class Payroll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		  System.out.print("Enter employee's name: ");
		  String name = input.nextLine();
		 
		  System.out.print("Enter number of hours worked in a week: ");
		  double hours = input.nextDouble();
		 
		  System.out.print("Enter hourly pay rate: ");
		  double rate = input.nextDouble();
		 
		  System.out.print("Enter federal tax withholding rate: ");
		  double ftax = input.nextDouble();
		 
		  System.out.print("Enter state tax withholding rate: ");
		  double stax = input.nextDouble();
		 
		  System.out.println("Employee Name:" + name);
		  System.out.println("Hours Worked:" + hours);
		  System.out.println("Pay Rate: $" + rate);
		  System.out.println("Gross Pay: $" + rate * hours);
		  System.out.println("Deductions:");
		  System.out.printf("\tFederal Withholding (%.1f%%): $%.2f\n", ftax * 100,
		    ftax * rate * hours);
		  System.out.printf("\tState Withholding (%.1f%%): $%.2f\n", stax * 100,
		    stax * rate * hours);
		  System.out.printf("\tTotal Deduction: $%.2f\n", (stax + ftax) * rate
		    * hours);
		  System.out.printf("Net Pay: $%.2f\n", (1 - stax - ftax) * rate * hours);

	}

}
