import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dice extends JFrame implements ActionListener, ItemListener  {
	JTextField bet = new JTextField(10);
	int cashAvailable = 1000;
	JTextField cashleft = new JTextField("$" + cashAvailable);
	JButton roll = new JButton("Roll Dice");
	JButton cashEnd = new JButton("Cash Out");
	JButton gameEnd = new JButton("Exit");
	JButton dice1 = new JButton("D1");
	JButton dice2 = new JButton("D2");
	JButton dice3 = new JButton("D3");
	JLabel title = new JLabel ("Welcome To the High Rollers Game");
	JLabel howmuch = new JLabel ("Cash Available");
	JLabel result = new JLabel("     ");
	JLabel whichPair = new JLabel("     ");
	JLabel gameOver = new JLabel("     ");
	
	String[] comboArray = {"Quick Bet", "$100", "$350", "$500"};
	JComboBox quickCash = new JComboBox(comboArray);

	JPanel buttonsPanel = new JPanel();

	public Dice()
	{
		super("Casino Simulator");
		setLayout(new BorderLayout());
		
		setSize(450, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		dice1.addActionListener(this);
		dice2.addActionListener(this);
		dice3.addActionListener(this);
		cashEnd.addActionListener(this);
		gameEnd.addActionListener(this);
		quickCash.addItemListener(this);
		
		add(title, BorderLayout.NORTH);
		add(buttonsPanel, BorderLayout.CENTER);
		
		buttonsPanel.setLayout(new FlowLayout());
		buttonsPanel.add(title);
		buttonsPanel.add(howmuch);
		buttonsPanel.add(dice1);
		buttonsPanel.add(dice2);
		buttonsPanel.add(dice3);
		buttonsPanel.add(cashEnd);
		buttonsPanel.add(cashleft);
		buttonsPanel.add(gameOver);
		buttonsPanel.add(bet);
		buttonsPanel.add(quickCash);
		buttonsPanel.add(result);
		buttonsPanel.add(roll);
		buttonsPanel.add(whichPair);
		
		cashleft.setEditable(false);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e)
	{
		Object source2 = e.getSource();
		int select = e.getStateChange();
		
		// If the user wants to quick bet, then set the
		// betCash to the entered amount.
		if (source2 == quickCash)
		{
			if (select == ItemEvent.SELECTED)
			{
				int positionOfSelection = quickCash.getSelectedIndex();
				if (positionOfSelection == 1)
				{
					bet.setText("" + 100);
				}
				else if (positionOfSelection == 2)
				{
					bet.setText("" + 350);
				}
				else if (positionOfSelection == 3)
				{
					bet.setText("" + 500);
				}
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		boolean threeMatch = false, twoMatch = false;
		String input;
		int betCash = 0;
		int howMuchLeft;
		
		// Let the user input how much cash he wants to bet.
		// If the bet is greater than the amount left, then
		// display an error message.
		try
		{
			input = bet.getText();
			betCash = Integer.parseInt(input);
		}
		catch(Exception ex)
		{
			result.setText("Insufficient Funds");
		}
		
		if (source == roll)
		{
			howMuchLeft = cashAvailable;
			// Roll the 3 dice to acquire the random numbers
			int random1 = (int) (Math.random() * 6) + 1;
			int random2 = (int) (Math.random() * 6) + 1;
			int random3 = (int) (Math.random() * 6) + 1;
			dice1.setText("" + random1);
			dice2.setText("" + random2);
			dice3.setText("" + random3);
			
			if (random1 == random2 && random2 == random3 && random1 == random3)
			{
				threeMatch = true;
			}
			else if (random1 == random2 || random2 == random3 || random1 == random3)
			{
				twoMatch = true;
			}
			
			// If all 3 dices match, then add 4 times the bet to the cash.
			if (threeMatch)
			{
				result.setText("WINNER");
				whichPair.setText("Three of a Kind!");
				howMuchLeft += (4 * betCash);
				cashAvailable = howMuchLeft;
			}
			// If at least 2 dices match, then add the bet to the cash.
			else if (twoMatch)
			{
				result.setText("WINNER");
				whichPair.setText("Two Pair!");
				howMuchLeft += betCash;
				cashAvailable = howMuchLeft;
			}
			// If none of the dice match, then subtract the bet from the cash.
			else
			{
				result.setText("LOSER");
				whichPair.setText("Better luck next time.");
				howMuchLeft -= betCash;
				cashAvailable = howMuchLeft;
			}
			
			cashleft.setText("$" + cashAvailable);
			
			// If the amount of cash becomes zero or less, then it's game over.
			// In that case, set the amount to zero and apologize to the player
			// that he has no more cash left to play.
			if (howMuchLeft <= 0)
			{
				gameOver.setText("Game Over");
				cashleft.setText("$0");
			}
		}
		
		// Exit the program if the user wants to cash out
		if (source == cashEnd)
		{
			super.dispose();
		}
		
		if (source == gameEnd)
		{
			super.dispose();
		}
	}
}
