/*
 * John Tu
 * Lab 6: Overloading Constructors
 * This program uses constructors that are
 * overloaded with parameters in order to read
 * the information about baseball score.
 */
import javax.swing.JOptionPane;
public class Interface {

	public static void main(String[] args) {
		String input;
		int playerID;
		double average;
		int players;
		
		// For each player, ask the user to input the player ID and the batting average.
		// Only ask for batting average for outfielder and player ID for batter.
		input = JOptionPane.showInputDialog(null, "What is the Catcher's id",
				"Catcher", JOptionPane.QUESTION_MESSAGE);
		playerID = Integer.parseInt(input);
		input = JOptionPane.showInputDialog(null, "What is the Catcher's Batting Average",
				"Catcher", JOptionPane.QUESTION_MESSAGE);
		average = Double.parseDouble(input);
		Functions Catcher = new Functions(playerID, average);
		JOptionPane.showMessageDialog(null, "Player " + Catcher.getID() + "'s batting average is "
				+ Catcher.getAverage() + ". There are " + Catcher.getCount() + " total on the team.",
				"Display Player", JOptionPane.INFORMATION_MESSAGE);
		
		input = JOptionPane.showInputDialog(null, "What is the Shortstop's id",
				"Shortstop", JOptionPane.QUESTION_MESSAGE);
		playerID = Integer.parseInt(input);
		input = JOptionPane.showInputDialog(null, "What is the Shortstop's Batting Average",
				"Shortstop", JOptionPane.QUESTION_MESSAGE);
		average = Double.parseDouble(input);
		Functions Shortstop = new Functions(playerID, average);
		JOptionPane.showMessageDialog(null, "Player " + Shortstop.getID() + "'s batting average is "
				+ Shortstop.getAverage() + ". There are " + Shortstop.getCount() + " total on the team.",
				"Display Player", JOptionPane.INFORMATION_MESSAGE);
		
		input = JOptionPane.showInputDialog(null, "What is the Outfielder's Batting Average",
				"Outfielder", JOptionPane.QUESTION_MESSAGE);
		average = Double.parseDouble(input);
		Functions Outfielder = new Functions(average);
		JOptionPane.showMessageDialog(null, "Player " + Outfielder.getID() + "'s batting average is "
				+ Outfielder.getAverage() + ". There are " + Outfielder.getCount() + " total on the team.",
				"Display Player", JOptionPane.INFORMATION_MESSAGE);

		input = JOptionPane.showInputDialog(null, "What is the Batter's id",
				"Batter", JOptionPane.QUESTION_MESSAGE);
		playerID = Integer.parseInt(input);
		Functions Batter = new Functions(playerID);
		JOptionPane.showMessageDialog(null, "Player " + Batter.getID() + "'s batting average is "
				+ Batter.getAverage() + ". There are " + Batter.getCount() + " total on the team.",
				"Display Player", JOptionPane.INFORMATION_MESSAGE);
		
		// Assume getCount as shared and average as separate from each player
		average = Catcher.getAverage() + Shortstop.getAverage()
		+ Outfielder.getAverage() + Batter.getAverage();
		players = Catcher.getCount();
		totalAverage(average, players);
	}
	
	public static void totalAverage(double totalAverage, int numBatters)
	{
		totalAverage = totalAverage / numBatters;
		JOptionPane.showMessageDialog(null, "There are " + numBatters +
		" players and the team's " + "collective batting average is " + totalAverage,
		"Collective Batting Average", JOptionPane.INFORMATION_MESSAGE);
	}

}
