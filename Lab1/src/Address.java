/*
 * John Tu
 * Lab One: Input and Output
 */

// This program asks the user to input the address.
// This is done via the usage of new line for each input.

import java.util.Scanner;
public class Address {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Ask the user to input each prompt
		System.out.println("Enter your street: ");
		String street = input.next();
		input.nextLine(); // Needed to avoid input mismatch
		System.out.println("Enter the house or apartment number: ");
		int number = input.nextInt();
		input.nextLine(); // Needed to avoid input mismatch
		System.out.println("Enter the city: ");
		String city = input.next();
		input.nextLine(); // Needed to avoid input mismatch
		System.out.println("Enter the zip code: ");
		int zip = input.nextInt();
		input.nextLine(); // Needed to avoid input mismatch
		System.out.println("Enter the State: ");
		String state = input.next();
		input.nextLine(); // Needed to avoid input mismatch
		
		// Display the statement
		System.out.println(number + " " + street + ", " + city + ", " + state + " " + zip);
	}
}

/*
 * Output:
Enter your street: 
Andirons
Enter the house or apartment number: 
101
Enter the city: 
Irvine
Enter the zip code: 
92602
Enter the State: 
CA
101 Andirons, Irvine, CA 92602
*/