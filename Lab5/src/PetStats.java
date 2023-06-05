import java.util.Scanner;
public class PetStats {
	private String name;
	private int hunger;
	private int cleanliness;
	private int happiness;
	private int health;
	private int age;
	Scanner inputDevice = new Scanner(System.in);

	// Constructor of the virtual pet
	PetStats()
	{
		// Randomize the following stats of the virtual pet,
		// but set the age to zero by default.
		hunger = (int)(Math.random() * 10) + 1;
		cleanliness = (int)(Math.random() * 10) + 1;
		happiness = (int)(Math.random() * 10) + 1;
		health = (int)(Math.random() * 10) + 1;
		age = 0;
	}
	// Setters and getters go below the constructor
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	public void setHunger(int hunger)
	{
		this.hunger = hunger;
	}
	public int getHunger()
	{
		return hunger;
	}
	public void setCleanliness(int cleanliness)
	{
		this.cleanliness = cleanliness;
	}
	public int getCleanliness()
	{
		return cleanliness;
	}
	public void setHappiness(int happiness)
	{
		this.happiness = happiness;
	}
	public int getHappiness()
	{
		return happiness;
	}
	public void setHealth(int health)
	{
		this.health = health;
	}
	public int getHealth()
	{
		return health;
	}
	// Display one of the two random messages by using
	// a random number generator along with modulus.
	// Then increment the corresponding stat and age.
	// Also, use randomDie to decrease a stat other than
	// the corresponding one.
	public void Feeding()
	{
		int randomDie = (int)(Math.random() * 3) + 1;
		if ((int)(Math.random() * 10) % 2 == 0)
		{
			System.out.println(name + " jumps with joy as you offer a banana (+1 Hunger).");
		}
		else
		{
			System.out.println(name + " dances with joy and devours pasta (+1 Hunger).");
		}
		hunger++;
		age++;
		if (randomDie == 1)
		{
			cleanliness--;
		}
		else if (randomDie == 2)
		{
			happiness--;
		}
		else if (randomDie == 3)
		{
			health--;
		}
	}
	public void Washing()
	{
		int randomDie = (int)(Math.random() * 3) + 1;
		if ((int)(Math.random() * 10) % 2 == 0)
		{
			System.out.println(name + " brushes his hair and becomes slightly upset"
					+ " due to excessive knots (+1 Cleanliness).");
		}
		else
		{
			System.out.println(name + " puts up a fight to resist, however"
					+ " he gives in and becomes squeaky clean (+1 Cleanliness).");
		}
		cleanliness++;
		age++;
		if (randomDie == 1)
		{
			hunger--;
		}
		else if (randomDie == 2)
		{
			happiness--;
		}
		else if (randomDie == 3)
		{
			health--;
		}
	}
	public void Playing()
	{
		int randomDie = (int)(Math.random() * 3) + 1;
		if ((int)(Math.random() * 10) % 2 == 0)
		{
			System.out.println("You pet " + name);
			System.out.println(name + " pets you back then suddenly"
					+ " eats a spider from out of your hair (+1 Happiness).");
		}
		else
		{
			System.out.println(name + " climbs the nearest tree (+1 Happiness).");
		}
		happiness++;
		age++;
		if (randomDie == 1)
		{
			hunger--;
		}
		else if (randomDie == 2)
		{
			cleanliness--;
		}
		else if (randomDie == 3)
		{
			health--;
		}
	}
	public void Health()
	{
		int randomDie = (int)(Math.random() * 3) + 1;
		if ((int)(Math.random() * 10) % 2 == 0)
		{
			System.out.println(name + " goes for a bike ride (+1 Health).");
		}
		else
		{
			System.out.println(name + " thrashes around the vet's office, "
					+ "breaking a window trying to escape from a shot  (+1 Health).");
		}
		health++;
		age++;
		if (randomDie == 1)
		{
			hunger--;
		}
		else if (randomDie == 2)
		{
			cleanliness--;
		}
		else if (randomDie == 3)
		{
			happiness--;
		}
	}
	// The boolean function checks if the pet's age
	// equals to 10. Set boolean to false if it is true.
	public boolean checkAge()
	{
		if (age < 10)
			return true;
		else
			return false;
	}
}
