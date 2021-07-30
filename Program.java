package Chapter7;
import java.util.Scanner;
/**
 * @author Dung Luong
 * User insert a new name into array and count total name 
 * User input the name need to delete in array and delete it
 * if name not exist display not found.
 */
public class Program {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	    
	    // Partially fill an array with names in alphabetic order
		final int NAMES_SIZE = 10;
		String[] names = new String[NAMES_SIZE];
		names[0] = "Allison";
		names[1] = "Desmond";
		names[2] = "Gary";
		names[3] = "Kimberly";
		names[4] = "Olivia";
		names[5] = "Tyson";
		int numNames = 6;
		int index = 0;

		// Display the names
		for (int i = 0; i < numNames; ++i)
			System.out.print(names[i] + " ");
		System.out.printf("%nThere are %d names.%n%n", numNames);

		// Enter a name to insert.
		System.out.print("Enter a name to insert: ");
		String name = input.nextLine();

		for (int i = 0; i < numNames; i++) {
			if (name.compareToIgnoreCase(names[i]) < 0) {
				break;
			}
			index = i + 1;
		}
		for (int i = numNames; i > index; --i) {
			names[i] = names[i - 1];
		}
		names[index] = name;
		numNames++;

		// Display the names
		for (int i = 0; i < numNames; ++i)
			System.out.print(names[i] + " ");
		System.out.printf("%nThere are %d names.%n%n", numNames);

		// Enter a name to delete.
		System.out.print("Enter a name to delete: ");
		name = input.nextLine();
		input.close();

		String key = name;
		int keyIndex = -1;
		for (int i = 0; i < numNames; ++i) {
			if (name.equalsIgnoreCase(names[i]) == true) {
				keyIndex = i;
			}
		}
		if (keyIndex != -1) {
			for (int i = keyIndex; i < numNames; ++i) {
				names[i] = names[i + 1];
			}
		} else {
			System.out.println(name + " not found.");
		}
		numNames--;

		// Display the names
		for (int i = 0; i < numNames; ++i)
			System.out.print(names[i] + " ");
		System.out.printf("%nThere are %d names.%n", numNames);

	}
}
	