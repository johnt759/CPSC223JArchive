/*
 * John Tu
 * Lab 6: Overloading Constructors
 * This program uses constructors that are
 * overloaded with parameters in order to read
 * the information about baseball score.
 */
import javax.swing.JOptionPane;
public class Main {
	public static void main(String[] args) {
		double average;
		int players;
		Baseball Catcher = new Baseball();
		Catcher.setCatcher(999, 0.5);
		Catcher.getResult();
		Baseball Shortstop = new Baseball();
		Shortstop.setShortstop(999, 0.5);
		Shortstop.getResult();
		Baseball Outfielder = new Baseball(999);
		Outfielder.setOutfielder(0.5);
		Outfielder.getResult();
		Baseball Batter = new Baseball(0.5);
		Batter.setBatter(999);
		Batter.getResult();
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