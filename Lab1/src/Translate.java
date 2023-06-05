/*
 * John Tu
 * Lab One: Input and Output
 */

// This program is about inputting year and checking if it is leap year.
import java.util.Scanner;
public class Translate {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Ask the user to enter a year
		System.out.println("Enter a year: ");
		int year = input.nextInt();
		
		// Use if/else statements to check
		// whether the inputed year is a leap year
		if (year % 4 == 0)	// Is the year modulus 4 equals 0?
		{
			if (year % 100 == 0)	// Is the year modulus 100 equals 0?
			{
				if (year % 400 == 0)	// Is the year modulus 400 equals 0?
					System.out.println(year + " is a leap year");
				else
					System.out.println(year + " is not a leap year");
			}
			else
				System.out.println(year + " is a leap year");
		}
		else
			System.out.println(year + " is not a leap year");
	}
}

/*
 Enter a year: 
 2018
 2018 is not a leap year
*/
