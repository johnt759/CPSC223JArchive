/*
 * John Tu
 * Lab 5: More Classes
 * 
 * This program simulates a virtual pet
 * simulator via class methods and functions.
 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		// Declare a new object called newPet
		int number;
		String petName;
		boolean endProgram = false;	// Reserved for exiting the switch statement
		PetStats newPet = new PetStats();
		
		// Ask user to input the new pet's name
		System.out.println("Please enter a name for your pet");
		petName = userInput.nextLine();
		newPet.setName(petName);
		while (endProgram != true)
		{
			printStats(newPet);
			checkAttributes(newPet);
			// Check if the pet's age is 10. Exit if it is true.
			if (!newPet.checkAge())
			{
				System.out.println(newPet.getName() + " has died of old age");
				System.out.println("Quitting program...");
				System.exit(0);
			}
			// Exit program if the pet's stat becomes zero.
			if (!AttributeTool.statZero(newPet))
			{
				System.out.println("Insufficient stat: " + newPet.getName() + " has died");
				System.out.println("Quitting program...");
				System.exit(0);
			}
			number = printMenu();
			// Use a switch statement to validate the choices.
			switch(number)
			{
			case 1:
				newPet.Feeding();
				break;
			case 2:
				newPet.Washing();
				break;
			case 3:
				newPet.Playing();
				break;
			case 4:
				newPet.Health();
				break;
			case 5:
				endProgram = true;
				break;
			default:
				System.out.println("Invalid choice.");
			}
			checkAttributes(newPet);
		}
		System.out.println("Quitting program...");
	}
	
	public static void printStats(PetStats aPet)
	{
		System.out.println("-" + aPet.getName() + "'s Stats-");
		System.out.println("Hunger: " + aPet.getHunger());
		System.out.println("Cleanliness: " + aPet.getCleanliness());
		System.out.println("Happiness: " + aPet.getHappiness());
		System.out.println("Health: " + aPet.getHealth());
	}
	
	public static int printMenu()
	{
		Scanner userInput = new Scanner(System.in);
		int choice;
		System.out.println("Main Menu:");
		System.out.println("1. Feed");
		System.out.println("2. Wash");
		System.out.println("3. Play");
		System.out.println("4. Health");
		System.out.println("5. -Quit-");
		choice = userInput.nextInt();
		return choice;
	}
	// This function calls the helper class's functions.
	// It checks if something isn't right with the
	// virtual pet's attributes.
	public static void checkAttributes(PetStats aPet)
	{
		AttributeTool.checkCleanliness(aPet);
		AttributeTool.checkHappiness(aPet);
		AttributeTool.checkHealth(aPet);
		AttributeTool.checkHunger(aPet);
	}
}

/*
Please enter a name for your pet
Benny
-Benny's Stats-
Hunger: 6
Cleanliness: 3
Happiness: 3
Health: 9
Benny is muddy from rolling around in the dirt (+1 Happiness).
Benny starts to feel bored (-1 Happiness).
Main Menu:
1. Feed
2. Wash
3. Play
4. Health
5. -Quit-
2
Benny puts up a fight to resist, however he gives in and becomes squeaky clean (+1 Cleanliness).
Benny starts to smell bad (-1 Health).
Benny starts to feel bored (-1 Happiness).
-Benny's Stats-
Hunger: 6
Cleanliness: 4
Happiness: 4
Health: 7
Benny starts to smell bad (-1 Health).
Benny gobbled away your leftovers (+1 Hunger).
Main Menu:
1. Feed
2. Wash
3. Play
4. Health
5. -Quit-
2
Benny brushes his hair and becomes slightly upset due to excessive knots (+1 Cleanliness).
Benny starts to feel bored (-1 Happiness).
-Benny's Stats-
Hunger: 6
Cleanliness: 5
Happiness: 5
Health: 6
Main Menu:
1. Feed
2. Wash
3. Play
4. Health
5. -Quit-
3
Benny climbs the nearest tree (+1 Happiness).
-Benny's Stats-
Hunger: 6
Cleanliness: 5
Happiness: 6
Health: 5
Main Menu:
1. Feed
2. Wash
3. Play
4. Health
5. -Quit-
2
Benny puts up a fight to resist, however he gives in and becomes squeaky clean (+1 Cleanliness).
-Benny's Stats-
Hunger: 5
Cleanliness: 6
Happiness: 6
Health: 5
Main Menu:
1. Feed
2. Wash
3. Play
4. Health
5. -Quit-
1
Benny dances with joy and devours pasta (+1 Hunger).
Benny has flu like symptoms (-1 Happiness).
-Benny's Stats-
Hunger: 6
Cleanliness: 6
Happiness: 5
Health: 4
Benny is about to vomit bananas (-1 Hunger).
Main Menu:
1. Feed
2. Wash
3. Play
4. Health
5. -Quit-
4
Benny goes for a bike ride (+1 Health).
-Benny's Stats-
Hunger: 5
Cleanliness: 5
Happiness: 5
Health: 5
Main Menu:
1. Feed
2. Wash
3. Play
4. Health
5. -Quit-
4
Benny thrashes around the vet's office, breaking a window trying to escape from a shot  (+1 Health).
Benny starts to feel bored (-1 Happiness).
-Benny's Stats-
Hunger: 5
Cleanliness: 5
Happiness: 5
Health: 6
Main Menu:
1. Feed
2. Wash
3. Play
4. Health
5. -Quit-
1
Benny dances with joy and devours pasta (+1 Hunger).
Benny gobbled away your leftovers (+1 Hunger).
-Benny's Stats-
Hunger: 7
Cleanliness: 5
Happiness: 4
Health: 6
Benny starts to feel bored (-1 Happiness).
Main Menu:
1. Feed
2. Wash
3. Play
4. Health
5. -Quit-
3
You pet Benny
Benny pets you back then suddenly eats a spider from out of your hair (+1 Happiness).
Benny is muddy from rolling around in the dirt (+1 Happiness).
-Benny's Stats-
Hunger: 7
Cleanliness: 4
Happiness: 5
Health: 6
Benny is muddy from rolling around in the dirt (+1 Happiness).
Benny gobbled away your leftovers (+1 Hunger).
Main Menu:
1. Feed
2. Wash
3. Play
4. Health
5. -Quit-
2
Benny brushes his hair and becomes slightly upset due to excessive knots (+1 Cleanliness).
Benny starts to feel bored (-1 Happiness).
-Benny's Stats-
Hunger: 8
Cleanliness: 5
Happiness: 4
Health: 6
Benny gobbled away your leftovers (+1 Hunger).
Benny has died of old age
Quitting program...
*/
