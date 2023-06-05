
public class Object {

	private int speed;
	private double distance;
	private double hours;
	
	// Below are the getters and setters functions.
	// Also include the accelerate, decelerate, and travel.
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	public int getSpeed()
	{
		return this.speed;
	}
	public void setDistance(double distance)
	{
		this.distance = distance;
	}
	public double getDistance()
	{
		return this.distance;
	}
	public void Accelerate(int speed)
	{
		// Check if the speed is greater or equal to 0.
		if (this.speed >= 0)
		{
			this.speed = this.speed + speed;
		}
		else
		{
			System.out.println("Cannot accelerate the vehicle");
		}
	}
	public void Decelerate(int speed)
	{
		// Check if the speed is greater than 0.
		if (this.speed > 0)
		{
			this.speed = this.speed - speed;
		}
		else
		{
			System.out.println("Cannot delecerate the vehicle");
		}
	}
	public void Travel(double hours)
	{
		distance = distance + (hours * speed);
	}
	
}
