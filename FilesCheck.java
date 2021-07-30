package Chapter8;
import java.util.Scanner;
import java.io.*;
public class FilesCheck {	
		public static void main(String[] args) throws IOException
		  {
		    File inFile = new File("capitals.txt");
		    // If the file does not exist, then exit with an error message.
		    if (!inFile.exists())
		    {
		      System.out.println(inFile.getName() + " does not exist.");
		      System.exit(1);
		    }

		    // Retrieve and display the capitals
		    String[] capitals = getData(inFile);
		    for (String capital: capitals)
		    {
		      System.out.println(capital);
		    }
		  } // end main
		  
		  public static String[] getData(File inFile) throws IOException
		  {
		    String[] capitals;
		    try (Scanner input = new Scanner(inFile))
		    {
		      int numRecords = Integer.parseInt(input.nextLine());
		      capitals = new String[numRecords];
		      for (int i = 0; i < numRecords; ++i)
		      {
		        capitals[i] = input.nextLine();
		      } // end for
		    } // end try
		    
		    return capitals;
		  } // end getData
		} 
