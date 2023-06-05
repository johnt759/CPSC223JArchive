/*
 * John Tu
 * Lab Two: Input and Output
 */


// This program asks the user to input the words.
// They will be used to display a short story with said words.

import java.util.Scanner;
import javax.swing.JOptionPane;	// Required for dialog boxes

public class MadLibs {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	// Needed for input
		
		String word1, word2, word3, word4;
		
		// Ask the user to enter the words when prompted
		word1 = JOptionPane.showInputDialog(null, "Enter a noun",
				"Mad Libs", JOptionPane.INFORMATION_MESSAGE);
		word2 = JOptionPane.showInputDialog(null, "Enter another noun",
				"Mad Libs", JOptionPane.INFORMATION_MESSAGE);
		word3 = JOptionPane.showInputDialog(null, "Enter an adjective",
				"Mad Libs", JOptionPane.INFORMATION_MESSAGE);
		word4 = JOptionPane.showInputDialog(null, "Enter a past-tense verb",
				"Mad Libs", JOptionPane.INFORMATION_MESSAGE);

		// Display the story to the user
		JOptionPane.showMessageDialog(null, "Mary had a little " + word1 + "\nIts "
				+ word2 + " was " + word3 + " as snow\n" + "And "
				+ "everywhere that Mary " + word4 + "\nThe "
				+ word1 + " was sure to go", "Mad Libs", JOptionPane.INFORMATION_MESSAGE);
	}

}
