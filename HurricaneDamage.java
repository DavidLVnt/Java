package Chapter3;
import java.util.Random;
/**
 * @author Dung Luong
 * User generate random wind speed, then display alert of wind speed 
 * to the screen using if else statements.
 */
public class HurricaneDamage {
  public static void main(String[] args) {
	final int LOW_WIND = 20;
	final int HIGH_WIND = 180;
	Random randomNumbers = new Random();
	
	//Generate random wind speed and display alert to the out put.
	int windLevel = HIGH_WIND - LOW_WIND + 1;
	int windSpeed = randomNumbers.nextInt(windLevel) + 20;
	if(windSpeed >= 157) {
	  System.out.println("Wind speed: " + windSpeed + " MPH");
	  System.out.println("Catastrophic damage will occur. "
	  		         + "A high percentage of framed homes will be destroyed.");
	}
	else if (windSpeed >= 130) {
      System.out.println("Wind speed: " + windSpeed + " MPH");
	  System.out.println("Catastrophic damage will occur.");	  
	}
	else if (windSpeed >= 111) {
	  System.out.println("Wind speed: " + windSpeed + " MPH");
	  System.out.println("Devastating damage will occur.");	
	}
	else if (windSpeed >= 96) {
	  System.out.println("Wind speed: " + windSpeed + " MPH");
	  System.out.println("Extremely dangerous winds will cause extensive damage.");
	}
	else if (windSpeed >= 74) {
	  System.out.println("Wind speed: " + windSpeed + " MPH");		
	  System.out.println("Very dangerous winds will produce some damage.");
	}
    else { 
      System.out.println("");
    }
    }
}
