/*
 * John Tu
 * Lab 14: Arrays with JObjects
 * There will be a grid of arrays to simulate a checkerboard.
 * Along with the JPanels and JLabel, the program will be about
 * a user letting the kitten run around the board.*/
import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class KittyGrid extends JFrame implements ActionListener{
	private final int ROWS = 8;
	private final int COLS = 8;
	private final int GAP = 2;
	private JButton up = new JButton("UP");
	private JButton left = new JButton("LEFT");
	private JButton right = new JButton("RIGHT");
	private JButton down = new JButton("DOWN");
	
	private JPanel pane = new JPanel(new GridLayout(ROWS, COLS, GAP, GAP));

	private JPanel[][] panel = new JPanel[ROWS][COLS];
	private JLabel[][] label = new JLabel[ROWS][COLS];
	private Color color1 = Color.WHITE;
	private Color color2 = Color.BLUE;
	private Color tempColor;
	private int positionX = 4;
	private int positionY = 4;
	public KittyGrid()
	{
		super("Run Kitty Run");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(pane);
		add(up, BorderLayout.NORTH);
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.EAST);
		add(down, BorderLayout.SOUTH);
		
		for(int x = 0; x < ROWS; x++)
		{
			for (int y = 0; y < COLS; y++)
			{
				panel[x][y] = new JPanel();
				label[x][y] = new JLabel();
				pane.add(panel[x][y]);
				panel[x][y].add(label[x][y]);
				label[x][y].setText(" ");
				
				// Swap the colors if x modulus column numbers is zero.
				if (y % COLS == 0)
				{
					tempColor = color1;
					color1 = color2;
					color2 = tempColor;
				}
				// If x modulus 2 is zero, assign color1 to background.
				// Otherwise, assign color2 to the background.
				if (y % 2 == 0)
				{
					panel[x][y].setBackground(color1);
				}
				else
				{
					panel[x][y].setBackground(color2);
				}
			}
		}
		label[positionX][positionY].setText("=^.^=");
		
		up.addActionListener(this);
		left.addActionListener(this);
		right.addActionListener(this);
		down.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		String kitten = "=^.^=";
		
		// Each time the user wants to move the kitten over,
		// check if the kitten tries to move outside the board.
		// If that happens, then do nothing.
		if (source == up)
		{
			if (positionX - 1 < 0)
			{
				return;
			}
			else
			{
				label[positionX][positionY].setText(" ");
				positionX--;
				label[positionX][positionY].setText(kitten);
			}
		}
		
		if (source == left)
		{
			if (positionY - 1 < 0)
			{
				return;
			}
			else
			{
				label[positionX][positionY].setText(" ");
				positionY--;
				label[positionX][positionY].setText(kitten);
			}
		}
		
		if (source == right)
		{
			if (positionY + 1 > COLS)
			{
				return;
			}
			else
			{
				label[positionX][positionY].setText(" ");
				positionY++;
				label[positionX][positionY].setText(kitten);
			}
		}
		
		if (source == down)
		{
			if (positionX + 1 > ROWS)
			{
				return;
			}
			else
			{
				label[positionX][positionY].setText(" ");
				positionX++;
				label[positionX][positionY].setText(kitten);
			}
		}
	}
	
	public static void main(String[] args) {
		KittyGrid window = new KittyGrid();
		window.setSize(500, 350);
		window.setVisible(true);
	}
}
