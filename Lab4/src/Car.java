/*
 * John Tu
 * Lab Four: Classes
 * 
 * This program simulates a car. Via the usage
 * of public and private members in a separate class,
 * create an object with the parameters.
 */

public class Car {

	public static void main(String[] args) {
		// First, create a new object named lola.
		Object lola = new Object();
		
		// Set the default values for speed and distance.
		lola.setSpeed(0);
		lola.setDistance(0.0);
		print(lola);
		print(lola.getSpeed(), lola.getDistance());
				
		// Accelerate by 50 mph.
		lola.Accelerate(50);
		lola.Travel(1.5);
		print(lola);
		print(lola.getSpeed(), lola.getDistance());
		
		// Decelerate by 15 mph.
		lola.Decelerate(15);
		lola.Travel(1);
		print(lola);
		print(lola.getSpeed(), lola.getDistance());
	}
	
	public static void print(Object car1)
	{
		System.out.println("Lola has a current speed of " + car1.getSpeed()
		+ " and has gone a distance of " + car1.getDistance());
	}
	
	public static void print(int speed, double distance)
	{
		System.out.println("Lola has a current speed of " + speed
		+ " and has gone a distance of " + distance);
	}
}
