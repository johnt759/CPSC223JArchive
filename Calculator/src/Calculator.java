/*
 * This program uses the JFrame and the ActionListener
 * components in order to simulate a simple calculator
 * similar to the ones in iOS and Android phones.
 * In addition, implement a stack and a array of
 * character elements when performing calculations
 * for each expression in the equation, as well as
 * converting the infix equation to postfix.
 */

/*
 * Title: Set 2 (Infix to Postfix)
 * Author(s): N/A
 * Website: GeeksForGeeks
 * Date: October 26, 2018
 * Availability: https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
 */

/*
 * Title: Set 4 (Evaluation of Postfix Expression)
 * Author(s): Sumit Ghosh & Arnab Kundu
 * Website: GeeksForGeeks
 * Date: October 8, 2018
 * Availability: https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/
 */

/*
 * Title: Make a Backspace Button
 * Author(s): Nestor Jr. Ratilla
 * Website: Java Development Tools - Help Blog
 * Date: May 2, 2013
 * Availability:
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Stack;

public class Calculator extends JFrame implements ActionListener {
	JButton clear = new JButton("C");
	JButton zero = new JButton("0");
	JButton one = new JButton("1");
	JButton two = new JButton("2");
	JButton three = new JButton("3");
	JButton four = new JButton("4");
	JButton five = new JButton("5");
	JButton six = new JButton("6");
	JButton seven = new JButton("7");
	JButton eight = new JButton("8");
	JButton nine = new JButton("9");
	JButton plus = new JButton("+");
	JButton minus = new JButton("-");
	JButton times = new JButton("*");
	JButton divide = new JButton("/");
	JButton point = new JButton(".");
	JButton equals = new JButton("=");
	JButton leftParen = new JButton("(");
	JButton rightParen = new JButton(")");
	JButton backspace = new JButton("BACK");
	JTextField equation = new JTextField();
	JTextField result = new JTextField();
	
	JPanel monitor = new JPanel();
	JPanel buttons = new JPanel();
	
	public Calculator()
	{
		super("Simple Calculator");
		setSize(350, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		equation.setFont(new Font("Georgia", Font.PLAIN, 20));
		result.setFont(new Font("Georgia", Font.PLAIN, 20));
		
		add(monitor, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);
		
		clear.addActionListener(this);
		leftParen.addActionListener(this);
		rightParen.addActionListener(this);
		zero.addActionListener(this);
		one.addActionListener(this);
		two.addActionListener(this);
		three.addActionListener(this);
		four.addActionListener(this);
		five.addActionListener(this);
		six.addActionListener(this);
		seven.addActionListener(this);
		eight.addActionListener(this);
		nine.addActionListener(this);
		plus.addActionListener(this);
		minus.addActionListener(this);
		times.addActionListener(this);
		divide.addActionListener(this);
		point.addActionListener(this);
		equals.addActionListener(this);
		backspace.addActionListener(this);
		
		// Set the GridLayout to span 2 rows and 1 column,
		// then add the equation and result monitor to it.
		monitor.setLayout(new GridLayout(2, 1));
		monitor.add(equation);
		monitor.add(result);
		
		// Set the GridLayout to span 5 rows and 4 columns,
		// then assign each button to the corresponding spot.
		buttons.setLayout(new GridLayout(5, 4));
		buttons.add(clear);
		buttons.add(leftParen);
		buttons.add(rightParen);
		buttons.add(divide);
		buttons.add(seven);
		buttons.add(eight);
		buttons.add(nine);
		buttons.add(times);
		buttons.add(four);
		buttons.add(five);
		buttons.add(six);
		buttons.add(minus);
		buttons.add(one);
		buttons.add(two);
		buttons.add(three);
		buttons.add(plus);
		buttons.add(backspace);
		buttons.add(zero);
		buttons.add(point);
		buttons.add(equals);
		
		// Don't let the user enter anything in the text box.
		equation.setEditable(false);
		result.setEditable(false);
	}
	
	// There will be 2 functions in processing the equation in
	// the calculator: one that converts infix to postfix and
	// the other that will return the result of postfix.
	// In addition, implement a helper function that will
	// determine the precendence of the operators.
    static int Prec(char ch) 
    { 
        switch (ch) 
        { 
        case '+': 
        case '-': 
            return 1; 
       
        case '*': 
        case '/': 
            return 2; 
        } 
        return -1; 
    }
    
	public String InfixToPostfix(String infixExp)
	{
		// First, create and initialize an empty string.
		String postfixExp = new String("");
		
		// Also create and initialize an empty stack.
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < infixExp.length(); i++)
		{
			char c = infixExp.charAt(i);
			
			// If the scanned character is an operand
			// or a decimal, add to postfixExp.
			if ((Character.isDigit(c)) || c == '.')
			{
				postfixExp += c;
			}
			
			// If the scanned character is left parentheses, push to stack.
			else if (c == '(')
			{
				stack.push(c);
				postfixExp += ' ';
			}
			
			// If the scanned character is right parentheses, pop from stack
			// and append into postfixExp until a left parentheses is reached.
			else if (c == ')')
			{
				while (!stack.isEmpty() && stack.peek() != '(')
				{
					postfixExp += stack.pop();
				}
				if (!stack.isEmpty() && stack.peek() != '(')
				{
					return null;
				}
				else
				{
					stack.pop();
				}
				postfixExp += ' ';
			}
			
			// The operator is reached, so the precedence will be determined
			// via a helper function.
			else
			{
				while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek()))
				{
					postfixExp += stack.pop();
				}
				stack.push(c);
				postfixExp += ' ';
			}
		}
		
		// Now pop all the operators from the stack.
		while (!stack.isEmpty())
		{
			postfixExp += stack.pop();
		}
		
		return postfixExp;
	}
	
	public double calculatePostfix(String postfixExp)
	{
		// Create a new stack just like in the previous function.
		Stack<Double> stack = new Stack<>();
				
		// Look through all the character one at a time until
		// int i reaches the end of the expression string.
		for (int i = 0; i < postfixExp.length(); i++)
		{
			// Be sure to use the scanner variable to look
			// through each character if it is an operand
			// or an operator!
			char c = postfixExp.charAt(i);
			
			if (c == ' ')
			{
				continue;
			}
			
			// If the scanner character is an operand,
			// extract the numbers and push them to stack.
			// Not only that, if the isDecimal is true, then
			// multiply variable n by the power of decimals.
			// Otherwise, simply multiply n by 10 and add
			// the character input to it.
			else if (Character.isDigit(c) || c == '.')
			{
				double n = 0;
				double p = 0.1;	// This is for the decimal digits.
				
				// The boolean variable checks whether the scanner
				// character is a decimal.
				boolean isDecimal = false;
				
				while ((Character.isDigit(c)) || c == '.')
				{
					if (c == '.')
					{
						isDecimal = true;
						i++;
						c = postfixExp.charAt(i);
					}
					else if (isDecimal)
					{
						// Whenever a decimal value is calculated,
						// multiply p by 0.1.
						n = n + p * (double)(c - '0');
						i++;
						p = p * 0.1;
						c = postfixExp.charAt(i);
					}
					else
					{
						n = n * 10 + (double)(c - '0');
						i++;
						c = postfixExp.charAt(i);
					}
				}
				i--;

				stack.push(n);
			}
			
			// If the scanned character is an operator, pop the
			// two elements from the stack and apply the operation.
			else
			{
				double num1 = stack.pop();
				double num2 = stack.pop();
				
				switch(c)
				{
				case '+':
					stack.push(num2 + num1);
					break;
				case '-':
					stack.push(num2 - num1);
					break;
				case '*':
					stack.push(num2 * num1);
					break;
				case '/':
					stack.push(num2 / num1);
					break;
				}
			}
		}
		
		// Return the final result of the postfix expression.
		return stack.pop();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// For the actionPerformed, store all the entered characters
		// into the equation as a string. Once the user presses enter,
		// implement a stack and perform each appropriate calculations.
		// After that, return the final answer in the result screen.
		Object source = e.getSource();
		
		// Set every text fields to empty if clear is pressed.
		if (source == clear)
		{
			equation.setText("");
			result.setText("");
		}
		// For all the corresponding buttons below, simply insert them
		// into the text field of the equation.
		if (source == zero)
		{
			equation.setText(equation.getText() + "0");
		}
		if (source == one)
		{
			equation.setText(equation.getText() + "1");
		}
		if (source == two)
		{
			equation.setText(equation.getText() + "2");
		}
		if (source == three)
		{
			equation.setText(equation.getText() + "3");
		}
		if (source == four)
		{
			equation.setText(equation.getText() + "4");
		}
		if (source == five)
		{
			equation.setText(equation.getText() + "5");
		}
		if (source == six)
		{
			equation.setText(equation.getText() + "6");
		}
		if (source == seven)
		{
			equation.setText(equation.getText() + "7");
		}
		if (source == eight)
		{
			equation.setText(equation.getText() + "8");
		}
		if (source == nine)
		{
			equation.setText(equation.getText() + "9");
		}
		if (source == plus)
		{
			equation.setText(equation.getText() + "+");
		}
		if (source == minus)
		{
			equation.setText(equation.getText() + "-");
		}
		if (source == times)
		{
			equation.setText(equation.getText() + "*");
		}
		if (source == divide)
		{
			equation.setText(equation.getText() + "/");
		}
		if (source == point)
		{
			equation.setText(equation.getText() + ".");
		}
		// Insert the left parentheses to the beginning of the expression
		// and the right parentheses to the end of the expression.
		if (source == leftParen)
		{
			equation.setText(equation.getText() + "(");
		}
		if (source == rightParen)
		{
			equation.setText(equation.getText() + ")");
		}
		// If the user presses backspace, delete a character from
		// the equation only if it is not empty.
		if (source == backspace)
		{
			if (equation.getText().length() > 0)
			{
				// First, declare a StringBuilder variable and a temporary string.
				String newEquation = null;
				StringBuilder strRemove = new StringBuilder(equation.getText());
				strRemove.deleteCharAt(equation.getText().length() - 1);
				newEquation = strRemove.toString();
				equation.setText(newEquation);
			}
		}
		// Equal button will perform an appropriate operation of
		// the equation via stack push and pop methods.
		if (source == equals)
		{
			// Declare a double variable called tempPostfix.
			// Then user it to convert the infix equation to postfix.
			String tempPostfix = InfixToPostfix(equation.getText());
			// Now declare another variable called tempFinal.
			// Use it to calculate the final result.
			double tempFinal = calculatePostfix(tempPostfix);
			String finalAnswer = Double.toString(tempFinal);
			result.setText(finalAnswer);
		}
	}
	
	public static void main(String[] args) {
		Calculator.setDefaultLookAndFeelDecorated(true);
		Calculator frame = new Calculator();
		frame.setVisible(true);
	}
}
