package Chapter7;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * @author Dung Luong
 * User check to see if file exist then find the total population and 
 * largest city, smallest city... If file not exist, show file does not exist.
 */
public class KansasPopulationStatistics {
	public static void main(String[] args) throws IOException {
		File inFile = new File("KansasSortedCities.csv");
		
		// Check if file exist or not.
		if (!inFile.exists()) {
			System.out.println(inFile.getName() + " does not exist");
			System.exit(1);
		} else {
			Scanner input = new Scanner(inFile);			
			int totalPopulation = 0;
			int largestCityPop = 0;
			int smallestCityPop = 0;
			int totalCities = 0;
			String largestCity = null;
			String smallestCity = null;
			
			//Calculate and find largest city and total population
			while (input.hasNextLine()) {
				String cityInfo = input.nextLine();
				String[] cityInfoArray = cityInfo.split(",");
				int population = Integer.parseInt(cityInfoArray[1]);
				totalPopulation += population;
				totalCities += 1;
				if (population > largestCityPop) {
					largestCityPop = population;
					largestCity = cityInfoArray[0];
				}
				if ((smallestCity == null) || (population < smallestCityPop)) {
					smallestCityPop = population;
					smallestCity = cityInfoArray[0];
				}
			}
			input.close();
			
			//Display largest city, smallest city, total population, total city 
			DecimalFormat decimal = new DecimalFormat("#,###");
			System.out.println("\nTotal Population: " + 
						        	       decimal.format(totalPopulation));
			System.out.println("Total Cities: " + decimal.format(totalCities));
			System.out.println("Average population: " + 
					  decimal.format((totalPopulation * 1.0) / totalCities));
			System.out.println("Largest City: " + largestCity + 
								" (" + decimal.format(largestCityPop) + ")");
			System.out.println("Smallest City: " + smallestCity + 
								" (" + decimal.format(smallestCityPop) + ")");
		}
	}
}
