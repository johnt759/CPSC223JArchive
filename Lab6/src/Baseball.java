import javax.swing.JOptionPane;
public class Baseball {
	private int batterID;
	private double battingAverage;		// Assume the batting average between 0 and 1
	private static int numBatters = 0;	// Static int retains its previous value
	private String input;				// Reserved for message dialog and parsing
	private double totalAverage;		// Reserved for finding the collective average
	
	public Baseball()
	{
		batterID = 999;
		battingAverage = 0.5;
		totalAverage = 0.0;
	}
	
	public Baseball(int id, double avg)
	{
		batterID = id;
		battingAverage = avg;
		numBatters = numBatters + 1;
		totalAverage += totalAverage;
	}
	
	// Batting average default is 0.5 if only
	// the batter's ID is provided.
	public Baseball(int id)
	{
		this(id, 0.5);
	}
	
	// Batter's ID is 999 by default if only
	// the batting average is provided.
	public Baseball(double avg)
	{
		this(999, avg);
	}
	
	public void setCatcher(int id, double avg)
	{
		input = JOptionPane.showInputDialog(null, "What is the Catcher's id",
				"Catcher", JOptionPane.QUESTION_MESSAGE);
		id = Integer.parseInt(input);
		batterID = id;
		input = JOptionPane.showInputDialog(null, "What is the Catcher's Batting Average",
				"Catcher", JOptionPane.QUESTION_MESSAGE);
		avg = Double.parseDouble(input);
		battingAverage = avg;
		numBatters = numBatters + 1;
		totalAverage += avg;
	}
	
	public void setShortstop(int id, double avg)
	{
		input = JOptionPane.showInputDialog(null, "What is the Shortstop's id",
				"Shortstop", JOptionPane.QUESTION_MESSAGE);
		id = Integer.parseInt(input);
		batterID = id;
		input = JOptionPane.showInputDialog(null, "What is the Shortstop's Batting Average",
				"Shortstop", JOptionPane.QUESTION_MESSAGE);
		avg = Double.parseDouble(input);
		battingAverage = avg;
		numBatters = numBatters + 1;
		totalAverage += avg;
	}
	
	public void setOutfielder(double avg)
	{
		input = JOptionPane.showInputDialog(null, "What is the Outfielder's Batting Average",
				"Outfielder", JOptionPane.QUESTION_MESSAGE);
		avg = Double.parseDouble(input);
		battingAverage = avg;
		numBatters = numBatters + 1;
		totalAverage += avg;
	}
	
	public void setBatter(int id)
	{
		input = JOptionPane.showInputDialog(null, "What is the Batter's id",
				"Batter", JOptionPane.QUESTION_MESSAGE);
		id = Integer.parseInt(input);
		batterID = id;
		numBatters = numBatters + 1;
		totalAverage += 0.5;
	}
	
	public int getCount()
	{
		return numBatters;
	}
	
	public double getAverage()
	{
		return totalAverage;
	}
	
	public void getResult()
	{
		JOptionPane.showMessageDialog(null, "Player " + batterID + "'s batting average is "
				+ battingAverage + ". There are " + numBatters + " total on the team.",
				"Display Player", JOptionPane.INFORMATION_MESSAGE);
	}
}
