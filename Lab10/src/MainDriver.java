/*
 * John Tu 
 * Lab 10: Actionlistener Events & Try Catch
 * This program simulates a simple calculator.
 * It is similar to Lab 9 except that a try-catch
 * method is included to test the user input for any
 * unknown integers entered. If that's true, then the
 * values will be set to zero by default.
 */
public class MainDriver {

	public static void main(String[] args) {
		Calculator program = new Calculator();
		
		program.setVisible(true);
	}

}
