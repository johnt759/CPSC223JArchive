/*
 * John Tu
 * Lab Three: Flow Control
 * 
 * This program simulates a dice rolling game.
 * It will check whether the user had 2 or 3 matching dice.
 * Afterwards, ask if the user wants to play again.
 */

import javax.swing.JOptionPane;	// Needed to use confirmation dialog
public class Dice {

	public static void main(String[] args) {
		// The first 2 variables are for yes/no dialog boxes.
		int selection;
		boolean isYes;
		
		// Ask the player whether to play the dice game
		selection = JOptionPane.showConfirmDialog(null, "Do you want to play the dice game?",
				"Dice Game Begin 1", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		isYes = (selection == JOptionPane.YES_OPTION);

		// If the user selected no, ignore the while loop and exit program.
		while (isYes)
		{
			// Generate 3 random numbers
			// Also use boolean allMatch and twoMatch as well
			boolean allMatch = false;
			boolean twoMatch = false;
			int random1 = (int) (Math.random() * 6) + 1;
			int random2 = (int) (Math.random() * 6) + 1;
			int random3 = (int) (Math.random() * 6) + 1;
			
			// Roll the dice and display the results.
			JOptionPane.showMessageDialog(null, "Die 1: " + random1 + "\nDie 2: " + random2 + "\nDie 3: " + random3,
					"Roll results", JOptionPane.INFORMATION_MESSAGE);
			
			// Run a boolean check if any of the numbers match.
			if (random1 == random3 && random1 == random2 && random2 == random3)
			{
				allMatch = true;
			}
			else if (random1 == random3 || random1 == random2 || random2 == random3)
			{
				twoMatch = true;
			}
			// All three numbers match, so very lucky!
			if (allMatch)
			{
				JOptionPane.showMessageDialog(null, "All three of your dice are a match!",
						"WINNER", JOptionPane.WARNING_MESSAGE);
			}
			// There is a match in these 2 numbers.
			else if (twoMatch)
			{
				JOptionPane.showMessageDialog(null, "Two of your dice are a match!",
						"WINNER", JOptionPane.WARNING_MESSAGE);
			}
			// Oh dear, none of the numbers match...
			else
			{
				JOptionPane.showMessageDialog(null, "Better luck next time",
						"Loser", JOptionPane.ERROR_MESSAGE);
			}
			
			// Ask the user whether to play again or not.
			// If yes, be sure to restore default settings for all variables.
			selection = JOptionPane.showConfirmDialog(null,  "Would you like to play the dice game again?",
					"Dice Game Begin 2", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			isYes = (selection == JOptionPane.YES_OPTION);
		}
	}

}
