/*
 * John Tu
 * Lab 8: GUI JFrame
 * This program uses a GUI JFrame to display the
 * advertisement billboard on a new window. It is
 * done only after the user enters the following
 * information: name, message, and contact info.
 */
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Scanner;
public class GUIFrame {
	public static void main(String[] args) {
		final int FRAME_WIDTH = 800;
		final int FRAME_HEIGHT = 600;
		String name, message, contact;
		Scanner input = new Scanner(System.in);
		
		// Greet the user first, and then ask them to
		// input the corresponding strings in the console.
		System.out.println("=== Welcome to the Billboard Advertisement CO. ===");
		System.out.println("Please enter your Company Name");
		name = input.nextLine();
		System.out.println("Please enter your Message");
		message = input.nextLine();
		System.out.println("Please enter your Contact info");
		contact = input.nextLine();
		
		// Now display the window with the user inputs.
		// Assume company name and message as bold font,
		// and have contact be in italics.
		JFrame frame = new JFrame("Bill Board");
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JLabel text1 = new JLabel(name);
		text1.setFont(new Font("Georgia", Font.BOLD, 60));
		frame.add(text1);
		
		JLabel text2 = new JLabel(message);
		text2.setFont(new Font("Georgia", Font.BOLD, 40));
		frame.add(text2);
		
		JLabel text3 = new JLabel(contact);
		text3.setFont(new Font("Georgia", Font.ITALIC, 40));
		frame.add(text3);
		
		frame.setLayout(new FlowLayout(FlowLayout.LEFT));
	}
}