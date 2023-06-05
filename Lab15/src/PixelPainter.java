/*
 * John Tu
 * Lab 15: KeyListener in GUI
 * This program will follow the similar procedure like
 * the Run Kitty Run, except that when the keyboard is
 * pressed, each listener will perform the corresponding action.
 * In that case, the keyboard will simulate a pixel paint program.
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PixelPainter extends JFrame implements KeyListener {
	private final int ROWS = 16;
	private final int COLS = 16;
	private final int GAP = 2;
	
	private JPanel pane = new JPanel(new GridLayout(ROWS, COLS, GAP, GAP));

	private JPanel[][] panel = new JPanel[ROWS][COLS];
	private Color[][] arrColor = new Color[ROWS][COLS];
	private Color color1 = Color.WHITE;
	private Color color2 = Color.YELLOW;
	private Color color3 = Color.BLACK;
	private int positionX = 0;
	private int positionY = 0;
	
	public PixelPainter()
	{
		super("Pixel Painter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(pane);
		
		for(int x = 0; x < ROWS; x++)
		{
			for (int y = 0; y < COLS; y++)
			{
				panel[x][y] = new JPanel();
				arrColor[x][y] = color1;
				pane.add(panel[x][y]);
				panel[x][y].setBackground(arrColor[x][y]);
			}
		}
		addKeyListener(this);
		panel[positionX][positionY].setBackground(color2);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		// If the user presses the arrow keys, move the
		// highlighted cursor to that direction.
		// Only move the cursor to that space if it is
		// within the boundaries of the program.
		// In addition, be sure to save the newly changed
		// color inside the Color array.
		if (keyCode == KeyEvent.VK_UP)
		{
			if (positionX - 1 < 0)
			{
				return;
			}
			else
			{
				panel[positionX][positionY].setBackground(arrColor[positionX][positionY]);
				positionX--;
				panel[positionX][positionY].setBackground(color2);
			}
		}
		if (keyCode == KeyEvent.VK_DOWN)
		{
			if (positionX + 1 > ROWS)
			{
				return;
			}
			else
			{
				panel[positionX][positionY].setBackground(arrColor[positionX][positionY]);
				positionX++;
				panel[positionX][positionY].setBackground(color2);
			}
		}
		if (keyCode == KeyEvent.VK_LEFT)
		{
			if (positionY - 1 < 0)
			{
				return;
			}
			else
			{
				panel[positionX][positionY].setBackground(arrColor[positionX][positionY]);
				positionY--;
				panel[positionX][positionY].setBackground(color2);
			}
		}
		if (keyCode == KeyEvent.VK_RIGHT)
		{
			if (positionY + 1 > COLS)
			{
				return;
			}
			else
			{
				panel[positionX][positionY].setBackground(arrColor[positionX][positionY]);
				positionY++;
				panel[positionX][positionY].setBackground(color2);
			}
		}
		
		// Spacebar will change the pixel color.
		if (keyCode == KeyEvent.VK_SPACE)
		{
			// If the highlighted space is white, then the panel is
			// set to black. If the highlighted space is black, then
			// change it back to white.
			if (arrColor[positionX][positionY] == color1)
			{
				arrColor[positionX][positionY] = color3;
				panel[positionX][positionY].setBackground(color3);
				
			}
			else if (arrColor[positionX][positionY] == color3)
			{
				arrColor[positionX][positionY] = color1;
				panel[positionX][positionY].setBackground(color1);
				
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		PixelPainter program = new PixelPainter();
		program.setSize(400, 400);
		program.setVisible(true);
	}
}
