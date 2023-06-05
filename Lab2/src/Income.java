/*
 * John Tu
 * Lab Two: Input and Output
 */

// The user inputs their taxable income.
// Then, the program computes the tax owed.

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Income {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String income;
		double incomeTax, total;
		
		// Ask the user to input the income tax
		income = JOptionPane.showInputDialog(null, "Please provide your taxable income:",
				"Taxable Income", JOptionPane.INFORMATION_MESSAGE);
		incomeTax = Double.parseDouble(income);
		
		// Compute the tax owed using the conditional statements
		if (incomeTax >= 0 && incomeTax < 9325)
		{
			total = 0.1 * incomeTax;
		}
		else if (incomeTax > 9325 && incomeTax < 37950)
		{
			total = 932.5 + (0.15 * (incomeTax - 9325));
		}
		else if (incomeTax > 37950 && incomeTax < 91900)
		{
			total = 5226.25 + (0.25 * (incomeTax - 37950));
		}
		else if (incomeTax > 91900 && incomeTax < 191650)
		{
			total = 18713.75 + (0.28 * (incomeTax - 91900));
		}
		else if (incomeTax > 191650 && incomeTax < 416700)
		{
			total = 46643.75 + (0.33 * (incomeTax - 191650));
		}
		else if (incomeTax > 416700 && incomeTax < 418400)
		{
			total = 120910.25 + (0.35 * (incomeTax - 416700));
		}
		else
		{
			total = 121505.25 + (0.396 * (incomeTax - 418400));
		}
		
		JOptionPane.showMessageDialog(null, "Your federal income tax is " + total,
				"Taxable income", JOptionPane.INFORMATION_MESSAGE);
	}

}
