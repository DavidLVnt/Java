package Chapter8;
import java.util.Random;
import java.text.DecimalFormat;
/**
 * @author Dung Luong
 * User generate random temperature and wind speed, display to screen.
 * use method calculate wind chill and display to window.
 */
public class WindChillCalculation {
	public static void main(String[] args) {
		final int LOW_TEMP = 0;
		final int HIGH_TEMP = 50;
		final int LOW_WIND_SPEED = 4;
		final int HIGH_WIND_SPEED = 30;
		Random randomNumbers = new Random();
		DecimalFormat number = new DecimalFormat("##.#");

		// Generate random temperatures and wind speeds.
		int temperature = randomNumbers.nextInt(HIGH_TEMP - LOW_TEMP + 1);															  
		int windSpeed = randomNumbers.nextInt(HIGH_WIND_SPEED 
				                  - LOW_WIND_SPEED + 1) + LOW_WIND_SPEED;
		System.out.println("Temperature: " + temperature 
				                                + " degrees Fahrenheit");
		System.out.println("Wind speed: " + windSpeed + " MPH");
		System.out.println("Temperature (including wind chill): "
				+ number.format(computeWindChill(temperature, windSpeed))
				                                + " degrees Fahrenheit");
	}

	/**
	 * computeWindChill calculate wind chill base on temperature and wind speed
	 * @param newTemp temperature
	 * @param newWindSpeed wind speed
	 * @return windChill
	 */
	public static double computeWindChill(int newTemp, int newWindSpeed){
		final double WIND_SPEED = Math.pow(newWindSpeed, 0.16);
		final double VELOCITY1 = 35.74;
		final double VELOCITY2 = 35.75;
		final double CONST1 = 0.6215;
		final double CONST2 = 0.4275;
		double windChill = VELOCITY1 + CONST1 * newTemp - VELOCITY2 
				            * WIND_SPEED + CONST2 * newTemp * WIND_SPEED;
		return windChill;
	}
}