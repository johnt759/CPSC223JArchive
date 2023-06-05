import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
	final int FRAME_WIDTH = 300;
	final int FRAME_HEIGHT = 150;
	JLabel heading;
	JTextField number1;
	JTextField number2;
	JLabel spacing1;
	JLabel spacing2;
	JLabel spacing3;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	
	public Calculator()
	{
		super("Calculator");
		heading = new JLabel(" Calculator Application");
		number1 = new JTextField(6);
		number2 = new JTextField(6);
		spacing1 = new JLabel("             ");
		spacing2 = new JLabel("            ");
		button1 = new JButton("x");
		button2 = new JButton("-");
		button3 = new JButton("/");
		button4 = new JButton("+");
		number1.setToolTipText("Press Enter for pow 2");
		number2.setToolTipText("Press Enter for sqrt");
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		heading.setFont(new Font("Arial", Font.BOLD, 16));
		number1.setFont(new Font("Arial", Font.BOLD, 20));
		number2.setFont(new Font("Arial", Font.BOLD, 20));
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		number1.addActionListener(this);
		number2.addActionListener(this);
		
		setLayout(new FlowLayout());
		add(heading);
		add(spacing1);
		add(number1);
		add(spacing2);
		add(number2);
		add(button1);
		add(button2);
		add(button3);
		add(button4);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		String input1, input2;
		double first = 0, second = 0, result;
		
		// These try-catch methods must be used
		// to ensure the user doesn't input any
		// invalid text when running the program.
		try
		{
			input1 = number1.getText();
			first = Double.parseDouble(input1);
		}
		catch(Exception ex)
		{
			number1.setText("0");
		}
		try
		{
			input2 = number2.getText();
			second = Double.parseDouble(input2);
		}
		catch(Exception ex)
		{
			number2.setText("0");
		}
		
		if (source == button1)
		{
			result = first * second;
			heading.setText("Result: " + result);
		}
		else if (source == button2)
		{
			result = first - second;
			heading.setText("Result: " + result);
		}
		else if (source == button3)
		{
			result = first / second;
			heading.setText("Result: " + result);
		}
		else if (source == button4)
		{
			result = first + second;
			heading.setText("Result: " + result);
		}
		else if (source == number1)
		{
			result = first * first;
			heading.setText("Result: " + result);
		}
		else if (source == number2)
		{
			result = Math.sqrt(second);
			heading.setText("Result: " + result);
		}
	}
}
