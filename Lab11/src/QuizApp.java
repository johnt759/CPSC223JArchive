import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class QuizApp extends JFrame implements ActionListener, ItemListener  {
	final int FRAME_WIDTH = 300;
	final int FRAME_HEIGHT = 280;
	JLabel label;
	JLabel question1;
	JCheckBox ans1a;
	JCheckBox ans1b;
	JCheckBox ans1c;
	JCheckBox ans1d;
	JLabel question2;
	JCheckBox ans2a;
	JCheckBox ans2b;
	JCheckBox ans2c;
	JCheckBox ans2d;
	JLabel question3;
	JLabel question4;
	JCheckBox ans4a;
	JCheckBox ans4b;
	JCheckBox ans4c;
	JCheckBox ans4d;
	JLabel results;
	int score = 0;
	ButtonGroup aGroup1 = new ButtonGroup();	// mutually exclusive
	ButtonGroup aGroup2 = new ButtonGroup();
	ButtonGroup aGroup3 = new ButtonGroup();
	JButton button;
	
	String[] comboArray = {"False", "True"};
	JComboBox comboSize = new JComboBox(comboArray);
	
	public QuizApp()
	{
		super("JAVA QUIZ");
		label = new JLabel("223J Quiz Application");
		question1 = new JLabel("1) A variable can be reference from its");
		ans1a = new JCheckBox("Range");
		ans1b = new JCheckBox("Space");
		ans1c = new JCheckBox("Domain");
		ans1d = new JCheckBox("Scope");
		question2 = new JLabel("2) Methods referenced with individual objects are");
		ans2a = new JCheckBox("Private");
		ans2b = new JCheckBox("Public");
		ans2c = new JCheckBox("Static");
		ans2d = new JCheckBox("NonStatic");
		question3 = new JLabel("3) Most Class Data Fields are Private");
		question4 = new JLabel("4) Java classes are stored in a folder or");
		ans4a = new JCheckBox("Packet");
		ans4b = new JCheckBox("Package");
		ans4c = new JCheckBox("Bundle");
		ans4d = new JCheckBox("Gaggle");
		button = new JButton("Submit");
		results = new JLabel("Score:  /20");
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ans1a.addItemListener(this);
		ans1b.addItemListener(this);
		ans1c.addItemListener(this);
		ans1d.addItemListener(this);
		ans2a.addItemListener(this);
		ans2b.addItemListener(this);
		ans2c.addItemListener(this);
		ans2d.addItemListener(this);
		comboSize.addItemListener(this);
		ans4a.addItemListener(this);
		ans4b.addItemListener(this);
		ans4c.addItemListener(this);
		ans4d.addItemListener(this);
		button.addActionListener(this);
		
		// Make sure the user never selects more than one answer.
		aGroup1.add(ans1a);
		aGroup1.add(ans1b);
		aGroup1.add(ans1c);
		aGroup1.add(ans1d);
		aGroup2.add(ans2a);
		aGroup2.add(ans2b);
		aGroup2.add(ans2c);
		aGroup2.add(ans2d);
		aGroup3.add(ans4a);
		aGroup3.add(ans4b);
		aGroup3.add(ans4c);
		aGroup3.add(ans4d);
		
		// Now add everything else to the main frame.
		setLayout(new FlowLayout());
		add(label);
		add(question1);
		add(ans1a);
		add(ans1b);
		add(ans1c);
		add(ans1d);
		add(question2);
		add(ans2a);
		add(ans2b);
		add(ans2c);
		add(ans2d);
		add(question3);
		add(comboSize);
		add(question4);
		add(ans4a);
		add(ans4b);
		add(ans4c);
		add(ans4d);
		add(button);
		add(results);
	}
	
	@Override
	public void itemStateChanged(ItemEvent e)
	{
		Object source = e.getItem();
		Object source2 = e.getSource();
		int select = e.getStateChange();
		// Check through each answer if it is correct.
		// If it is, then add 5 points to the score.
		
		if (source == ans1d)
		{
			if (select == ItemEvent.SELECTED)
			{
				score += 5;
			}
			else if (select == ItemEvent.DESELECTED)
			{
				score -= 5;
			}
		}
		if (source == ans2d)
		{
			if (select == ItemEvent.SELECTED)
			{
				score += 5;
			}
			else if (select == ItemEvent.DESELECTED)
			{
				score -= 5;
			}
		}
		if (source2 == comboSize)
		{
			if (select == ItemEvent.SELECTED)
			{
				int positionOfSelection = comboSize.getSelectedIndex();
				if (positionOfSelection == 0)
				{
					score -= 5;
				}
				else if (positionOfSelection == 1)
				{
					score += 5;
				}
			}
		}
		if (source == ans4b)
		{
			if (select == ItemEvent.SELECTED)
			{
				score += 5;
			}
			else if (select == ItemEvent.DESELECTED)
			{
				score -= 5;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		results.setText("Score: " + score + "/20");
	}
}
