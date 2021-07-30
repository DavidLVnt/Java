package Chapter8;
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
/**
 * @author
 * User check file from input, if exist calculate GPA and out put new file,
 * if not exit program.
 * 
 */

public class GPACalculation {
	public static void main(String[] args) throws IOException {
		Scanner inFile = openFile();
		String[] gradeSummary = processGrades(inFile);
		inFile.close();
		storeGpa(gradeSummary);
		System.out.println("Data processing complete.");
	}
	
	/**
	 * method to prompt the user for a file name and check if the file exists,
     * and return a reference to the opened input file.
	 * @return a scanner created from a file 
	 * @throws IOException
	 */
	public static Scanner openFile() throws IOException {
		Scanner input = new Scanner(System.in);
		
		//User input and check file name
		System.out.print("Enter grade input file in the form filename.txt: ");
		String fileName = input.nextLine();
		input.close();
		File file = new File(fileName);
		if (!file.getAbsoluteFile().exists()) {
			System.out.println("File open error: " + file.getName());
			System.exit(1);
		}
		Scanner fileScanner = new Scanner(file);
		return fileScanner;
	}
	
	/**
	 * processGrades get the student name and grades from file 
	 * and calculate GPA 
	 * @param inFile opened grades file.
	 * @return student name and GPA
	 * @throws IOException
	 */
	public static String[] processGrades(Scanner inFile) throws IOException {
		
		//Create array holds name and GPA
		String[] studentsGpa = new String[2];
		if (inFile.hasNext()) {
			String name = inFile.nextLine();
			studentsGpa[0] = name;
		}
		
		int letterPoints = 0;
		int totalPoints = 0;
		double gpa = 0;
		while (inFile.hasNext()) {
			
			// Get the next line of data
			String courseInfoLine = inFile.nextLine(); 
			String[] courseInfoArray = courseInfoLine.split(",");
			int hoursAttempt = Integer.parseInt(courseInfoArray[1]);
			
			//conversion letter to grade
			switch (courseInfoArray[0]) {
			case "A":
				letterPoints += 4 * hoursAttempt;
				break;
			case "B":
				letterPoints += 3 * hoursAttempt;
				break;
			case "C":
				letterPoints += 2 * hoursAttempt;
				break;
			case "D":
				letterPoints += 1 * hoursAttempt;
				break;
			}
			totalPoints += hoursAttempt;
		}
		
		//Calculate GPA and return
		gpa = (double) letterPoints / totalPoints;
		studentsGpa[1] = String.format("%.2f", gpa);
		return studentsGpa;
	}
	/**
	 * storeGpa created new file with student name and store name and Gpa
	 * @param gradeSummary included name and gpa
	 * @throws IOException
	 */
	public static void storeGpa(String[] gradeSummary) throws IOException {

		//Create new file with student name
		File outFile = new File(gradeSummary[0]);
		PrintWriter writer = new PrintWriter(outFile);

		// printing data to the file
		writer.append(gradeSummary[0] + "," + gradeSummary[1]);
		writer.close();
	}
}
