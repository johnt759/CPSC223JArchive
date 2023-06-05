/*
 * John Tu
 * Lab One: Input and Output
 */

// This program asks the user to input the name and age.
// After that, it checks which age group the person belongs to.

import java.util.Scanner;
public class AgeChart {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Ask the user to enter a year
		System.out.println("Please enter a person's name: ");
		String name = input.nextLine();
		System.out.println("Please enter the person's age: ");
		int year = input.nextInt();
		
		// Use if/else statements to check the age.
		// Return the statement if any of the conditions below
		// are true. Otherwise, assume else as true.
		if (year < 1)					// Person is less than 1 year old
			System.out.println(name + " is an infant");
		else if (year >= 1 && year <= 3) // Person is between 1 and 3 years old
			System.out.println(name + " is a toddler");
		else if (year >= 4 && year <= 5) // Person is between 4 and 5 years old
			System.out.println(name + " is a preschooler");
		else if (year >= 6 && year <= 12) // Person is between 6 and 12 years old
			System.out.println(name + " is a grade schooler");
		else if (year >= 13 && year <= 18) // Person is between 13 and 18 years old
			System.out.println(name + " is a teenager");
		else if (year >= 19 && year <= 21) // Person is between 19 and 22 years old
			System.out.println(name + " is a young adult");
		else							   // Person is greater than 21 years old
			System.out.println(name + " is an adult");
	}
}

/*
 * Output 1:
   Please enter a person's name: 
   Bobby
   Please enter the person's age: 
   15
   Bobby is a teenager
   
   Output 2:
   Please enter a person's name: 
   Tiny Tim
   Please enter the person's age: 
   4
   Tiny Tim is a preschooler
*/