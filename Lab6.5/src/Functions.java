
public class Functions {
	private int batterID;
	private double battingAverage;		// Assume the batting average between 0 and 1
	private static int numBatters = 0;	// Static int retains its previous value
	
	public Functions()
	{
		batterID = 999;
		battingAverage = 0.5;
	}
	
	public Functions(int id, double avg)
	{
		batterID = id;
		battingAverage = avg;
		numBatters = numBatters + 1;
	}
	
	// Batting average default is 0.5 if only
	// the batter's ID is provided.
	public Functions(int id)
	{
		this(id, 0.5);
	}
	
	// Batter's ID is 999 by default if only
	// the batting average is provided.
	public Functions(double avg)
	{
		this(999, avg);
	}
	
	public int getCount()
	{
		return numBatters;
	}
	
	public double getAverage()
	{
		return battingAverage;
	}
	
	public int getID()
	{
		return batterID;
	}

}
