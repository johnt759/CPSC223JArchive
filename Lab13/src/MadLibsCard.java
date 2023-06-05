/*
 * John Tu
 * Lab 13: Card Layout
 * This program is similar to the Mad Libs from the previous
 * labs, except that a card layout will be implemented.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MadLibsCard extends JFrame implements ActionListener{
	private CardLayout cards = new CardLayout();
	private JButton b1 = new JButton("Next");
	private JButton b2 = new JButton("Prev");
	private JButton b3 = new JButton("Exit");
	private JLabel title = new JLabel("                                      Welcome to Mad Libs");
	private JTextArea story = new JTextArea("STORY\'\n INSERT");
	private JLabel prompt1 = new JLabel("Please Enter Your Name");
	private JLabel prompt2 = new JLabel("Please Enter a Verb ending in 'ing'");
	private JLabel prompt3 = new JLabel("Please Enter a Plural Noun");
	private JLabel prompt4 = new JLabel("Please Enter an Adjective");
	private JTextField name = new JTextField(10);
	private JTextField verb = new JTextField(10);
	private JTextField noun = new JTextField(10);
	private JTextField adj = new JTextField(10);
	private JPanel buttonsPanel = new JPanel();
	private JPanel buttonsPanel2 = new JPanel();
	
	public MadLibsCard()
	{
		super("Mad Libs");
		setLayout(cards);
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel card1 = new JPanel();
		card1.add(title, BorderLayout.NORTH);
		card1.add(buttonsPanel, BorderLayout.CENTER);
		buttonsPanel.add(prompt1);
		buttonsPanel.add(name);
		buttonsPanel.add(prompt2);
		buttonsPanel.add(verb);
		buttonsPanel.add(prompt3);
		buttonsPanel.add(noun);
		buttonsPanel.add(prompt4);
		buttonsPanel.add(adj);
		buttonsPanel.add(b1, BorderLayout.EAST);
		b1.addActionListener(this);
		add(buttonsPanel, "panel1");
		
		JPanel card2 = new JPanel();
		card2.add(title, BorderLayout.NORTH);
		card2.add(buttonsPanel2, BorderLayout.CENTER);
		buttonsPanel2.add(story);
		buttonsPanel2.add(b2, BorderLayout.WEST);
		b2.addActionListener(this);
		buttonsPanel2.add(b3, BorderLayout.EAST);
		b3.addActionListener(this);
		add(buttonsPanel2, "panel2");
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		int randomNum = (int)(Math.random() * 10);
		String input1, input2, input3, input4;
		
		input1 = name.getText();
		input2 = verb.getText();
		input3 = noun.getText();
		input4 = adj.getText();
		// If user presses next, move on to next card.
		if (source == b1)
		{
			cards.show(getContentPane(), "panel2");
			
			// Generate one of the two random mad libs story via random number.
			if (randomNum % 2 == 0)
			{
				story.setText("Hi there, all you Boring little boys and girls!" + 
				"\nThis is your old TV buddy, " + input1 + "!\n" + "With another "
				+ input4 + "-hour program of\n" + input3 + " " + input2 + " for all of you");
				story.setFont(new Font("Arial", Font.PLAIN, 10));
			}
			else
			{
				story.setText("Driving a car can be fun...\n" + "If you follow "
				+ input1 + "'s "+ input4 + " advice:\n" + "Before " + input2
				+ ", always stick your " + input3 + "\nout of the window.");
				story.setFont(new Font("Arial", Font.PLAIN, 10));
			}
		}
		// If user presses prev, move back to previous card.
		if (source == b2)
		{
			cards.show(getContentPane(), "panel1");
			randomNum = (int)(Math.random());
		}
		// if user presses exit, close the program.
		if (source == b3)
		{
			super.dispose();
		}
	}
	
	public static void main(String[] args) {
		MadLibsCard panel = new MadLibsCard();
		panel.setVisible(true);
	}
}