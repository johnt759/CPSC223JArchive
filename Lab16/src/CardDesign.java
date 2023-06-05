/*
 * John Tu
 * Lab 16: Menu Bar
 * Via the usage of CardLayout along with the JMenu, the user
 * will be entering a message to the applicant and then the name
 * will appear on either the congratulations or birthday card.
 * If home is selected, the program returns back to entering the
 * new recipient's name.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class CardDesign extends JFrame implements ActionListener {
	
	private JMenuBar mainBar = new JMenuBar();
	private JMenu menu1 = new JMenu("File");
	private JMenu menu2 = new JMenu("Select");
	private JMenu menu3 = new JMenu("Colors");
	private JMenu menu4 = new JMenu("Font");
	private JMenuItem exit = new JMenuItem("Exit");
	private JMenuItem home = new JMenuItem("Home");
	private JMenuItem congrats = new JMenuItem("Congratulations Card");
	private JMenuItem birthday = new JMenuItem("Birthday Card");
	private JMenuItem bright = new JMenu("Bright");
	private JMenuItem dark = new JMenu("Dark");
	private JMenuItem yellow = new JMenuItem("Yellow");
	private JMenuItem pink = new JMenuItem("Pink");
	private JMenuItem black = new JMenuItem("Black");
	private JMenuItem gray = new JMenuItem("Gray");
	private JMenuItem white = new JMenuItem("White");
	private JMenuItem arial = new JMenuItem("Arial");
	private JMenuItem lucida = new JMenuItem("Lucida Handwriting");
	private JMenuItem ink = new JMenuItem("Ink Free");
	private JTextField recipient = new JTextField("Please Enter the Recipient's Name");
	private CardLayout cards = new CardLayout();
	private JLabel title = new JLabel("Card Designer Application");
	private JLabel prompt = new JLabel("Then Get Started By Making Selections From the Menu");
	private JLabel displayMessage = new JLabel();
	private JLabel displayMessage2 = new JLabel();
	private JTextArea newMessage = new JTextArea("enter your message here");
	private JTextArea newMessage2 = new JTextArea("enter your message here");
	private JPanel Panel = new JPanel();
	private JPanel Panel2 = new JPanel();
	private JPanel Panel3 = new JPanel();

	public CardDesign()
	{
		super("Pimp My JFrame");
		setLayout(cards);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setJMenuBar(mainBar);
		mainBar.add(menu1);
		mainBar.add(menu2);
		mainBar.add(menu3);
		mainBar.add(menu4);
		menu1.add(exit);
		menu2.add(home);
		menu2.add(congrats);
		menu2.add(birthday);
		menu3.add(bright);
		menu3.add(dark);
		bright.add(yellow);
		bright.add(pink);
		dark.add(black);
		dark.add(gray);
		menu3.add(white);
		menu4.add(arial);
		menu4.add(lucida);
		menu4.add(ink);
		
		title.setFont(new Font("Georgia", Font.BOLD, 30));
		recipient.setFont(new Font("Georgia", Font.ITALIC, 30));
		prompt.setFont(new Font("Georgia", Font.BOLD, 15));
		
		// Card1 will be the home panel.
		Panel.setLayout(new GridLayout(3, 1));
		Panel.add(title, BorderLayout.NORTH);
		Panel.add(recipient, BorderLayout.CENTER);
		Panel.add(prompt, BorderLayout.SOUTH);
		add(Panel, "panel1");
		
		// Card2 will be the congratulations panel.
		Panel2.setLayout(new GridLayout(2, 1));
		Panel2.add(displayMessage, BorderLayout.NORTH);
		Panel2.add(newMessage, BorderLayout.SOUTH);
		add(Panel2, "panel2");
		
		// Card3 will be the birthday panel.
		Panel3.setLayout(new GridLayout(2, 1));
		Panel3.add(displayMessage2, BorderLayout.NORTH);
		Panel3.add(newMessage2, BorderLayout.SOUTH);
		add(Panel3, "panel3");
		
		exit.addActionListener(this);
		home.addActionListener(this);
		congrats.addActionListener(this);
		birthday.addActionListener(this);
		yellow.addActionListener(this);
		pink.addActionListener(this);
		black.addActionListener(this);
		gray.addActionListener(this);
		white.addActionListener(this);
		arial.addActionListener(this);
		lucida.addActionListener(this);
		ink.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		Container con = getContentPane();
		String recipientName;
		
		if (source == exit)
		{
			System.exit(0);
		}
		else if (source == home)
		{
			cards.show(getContentPane(), "panel1");
		}
		else if (source == congrats)
		{
			cards.show(getContentPane(), "panel2");
			recipientName = recipient.getText();
			displayMessage.setText("Congratulations " + recipientName);
			displayMessage.setFont(new Font("Georgia", Font.PLAIN, 30));
		}
		else if (source == birthday)
		{
			cards.show(getContentPane(), "panel3");
			recipientName = recipient.getText();
			displayMessage2.setText("Happy Birthday " + recipientName);
			displayMessage2.setFont(new Font("Georgia", Font.PLAIN, 30));
		}
		else if (source == yellow)
		{
			con.setBackground(Color.YELLOW);
		}
		else if (source == pink)
		{
			con.setBackground(Color.PINK);
		}
		else if (source == black)
		{
			con.setBackground(Color.BLACK);
		}
		else if (source == gray)
		{
			con.setBackground(Color.GRAY);
		}
		else if (source == white)
		{
			con.setBackground(Color.WHITE);
		}
		else if (source == arial)
		{
			newMessage.setFont(new Font("Arial", Font.PLAIN, 15));
			newMessage2.setFont(new Font("Arial", Font.PLAIN, 15));
		}
		else if (source == lucida)
		{
			newMessage.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
			newMessage2.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		}
		else if (source == ink)
		{
			newMessage.setFont(new Font("Ink Free", Font.PLAIN, 15));
			newMessage2.setFont(new Font("Ink Free", Font.PLAIN, 15));
		}
	}
	
	public static void main(String[] args) {
		CardDesign frame = new CardDesign();
		frame.setSize(500, 300);
		frame.setVisible(true);
	}
}
