// This is a helper class that checks the virtual pet's attributes.
public class AttributeTool {
	// Are the following stats at 5 or below?
	// If yes, display a negative message to user.
	public static void checkCleanliness(PetStats petName)
	{
		if (petName.getCleanliness() < 5)
		{
			if ((int)(Math.random() * 2) % 2 == 0)
			{
				System.out.println(petName.getName() + " starts to smell bad (-1 Health).");
				petName.setHealth(petName.getHealth() - 1);
			}
			else
			{
				System.out.println(petName.getName() + " is muddy from rolling around"
						+ " in the dirt (+1 Happiness).");
				petName.setHappiness(petName.getHappiness() - 1);
			}
		}
	}
	public static void checkHappiness(PetStats petName)
	{
		if (petName.getHappiness() < 5)
		{
			if ((int)(Math.random() * 2) % 2 == 0)
			{
				System.out.println(petName.getName() + " starts to feel bored (-1 Happiness).");
				petName.setHappiness(petName.getHappiness() + 1);
			}
			else
			{
				System.out.println(petName.getName() + " gobbled away your leftovers (+1 Hunger).");
				petName.setHunger(petName.getHunger() + 1);
			}
		}
	}
	public static void checkHealth(PetStats petName)
	{
		if (petName.getHealth() < 5)
		{
			if ((int)(Math.random() * 2) % 2 == 0)
			{
				System.out.println(petName.getName() + " has flu like symptoms (-1 Happiness).");
				petName.setHappiness(petName.getHappiness() - 1);
			}
			else
			{
				System.out.println(petName.getName() + " is about to vomit bananas (-1 Hunger).");
				petName.setHunger(petName.getHunger() - 1);
			}
		}
	}
	public static void checkHunger(PetStats petName)
	{
		if (petName.getHunger() < 5)
		{
			if ((int)(Math.random() * 2) % 2 == 0)
			{
				System.out.println(petName.getName() + " is about to gnaw his"
						+ " leg from hunger (-1 Health).");
				petName.setHealth(petName.getHealth() - 1);
			}
			else
			{
				System.out.println(petName.getName() + " is looking a bit thin (-1 Happiness).");
				petName.setHappiness(petName.getHappiness() - 1);
			}
		}
	}
	// Boolean function checks if one of the stats
	// is zero or lower. Return false if true.
	public static boolean statZero(PetStats petName)
	{
		if (petName.getCleanliness() <= 0 || petName.getHappiness() <= 0
				|| petName.getHealth() <= 0 || petName.getHunger() <= 0)
		{
			return false;
		}
		return true;
	}
}
