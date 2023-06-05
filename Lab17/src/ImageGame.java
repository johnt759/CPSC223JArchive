/*
 * John Tu
 * Lab 17: GUI with Images
 * This program utilizes images and sprites
 * to simulate a game of Plants VS Zombies.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImageGame extends JFrame implements KeyListener {
	ImageIcon pic1 = new ImageIcon("E:/Eclipse/LabSeventeen/src/peaShooter.png");
	ImageIcon pic2 = new ImageIcon("E:/Eclipse/LabSeventeen/src/rock.png");
	ImageIcon pic3 = new ImageIcon("E:/Eclipse/LabSeventeen/src/sunflower.png");
	ImageIcon pic4 = new ImageIcon("E:/Eclipse/LabSeventeen/src/zombie.png");
	
	private final int ROWS = 8;
	private final int COLS = 8;
	private final int GAP = 2;
	
	private JPanel pane = new JPanel(new GridLayout(ROWS, COLS, GAP, GAP));
	private JLabel[][] label = new JLabel[ROWS][COLS];
	private JPanel[][] panel = new JPanel[ROWS][COLS];
	private Color[][] arrColor = new Color[ROWS][COLS];
	private Color color1 = Color.GREEN;
	private Color color2 = Color.GREEN.darker();
	private Color cursor = Color.YELLOW;
	private int positionX = 4;
	private int positionY = 4;
	private ImageIcon imageCursor;
	private ImageIcon spawnCursor;
	private ImageIcon[][] imagePane = new ImageIcon[ROWS][COLS];
	private int spawnMonster = 1;
	private Image sprite1;
	private Image sprite2;
	private Image sprite3;
	private Image sprite4;
	
	public ImageGame()
	{
		super("Plants VS Zombies");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(pane);
		
		for(int x = 0; x < ROWS; x++)
		{
			for (int y = 0; y < COLS; y++)
			{
				panel[x][y] = new JPanel();
				label[x][y] = new JLabel();
				imagePane[x][y] = new ImageIcon();
				
				// If x modulus 2 is zero, assign color1 to background.
				// Otherwise, assign color2 to the background.
				if (x % 2 == 0)
				{
					arrColor[x][y] = color1;
				}
				else
				{
					arrColor[x][y] = color2;
				}
				pane.add(panel[x][y]);
				panel[x][y].add(label[x][y]);
				panel[x][y].setBackground(arrColor[x][y]);
			}
		}
		panel[positionX][positionY].setBackground(cursor);
		
		sprite1 = pic1.getImage().getScaledInstance(50, 100, java.awt.Image.SCALE_SMOOTH);
		sprite2 = pic2.getImage().getScaledInstance(50, 100, java.awt.Image.SCALE_SMOOTH);
		sprite3 = pic3.getImage().getScaledInstance(50, 100, java.awt.Image.SCALE_SMOOTH);
		sprite4 = pic4.getImage().getScaledInstance(50, 100, java.awt.Image.SCALE_SMOOTH);
		
		addKeyListener(this);
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	// For every 4 arrow key movements pressed, place a zombie sprite anywhere
	// in a random grid panel at the two rightmost columns of the board.
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		int cursorPlant = (int)(Math.random() * 3 + 1);
		int monsterPlaceX = 0, monsterPlaceY = 0;
		
		// Assign spawnCursor to sprite4 by default.
		spawnCursor = new ImageIcon(sprite4);

		// For each of the three numbers, assign the cursor to
		// the new sprite image.
		if (cursorPlant == 1)
		{
			imageCursor = new ImageIcon(sprite1);
		}
		else if (cursorPlant == 2)
		{
			imageCursor = new ImageIcon(sprite2);
		}
		else if (cursorPlant == 3)
		{
			imageCursor = new ImageIcon(sprite3);
		}
		
		// If the user presses the arrow keys, move the
		// highlighted cursor to that direction.
		// Only move the cursor to that space if it is
		// within the boundaries of the program.
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
				panel[positionX][positionY].setBackground(cursor);
				spawnMonster++;
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
				panel[positionX][positionY].setBackground(cursor);
				spawnMonster++;
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
				panel[positionX][positionY].setBackground(cursor);
				spawnMonster++;
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
				panel[positionX][positionY].setBackground(cursor);
				spawnMonster++;
			}
		}
		
		// Spacebar will place the plant sprite to the
		// selected space on the grid. After that, cycle
		// through the 3 plant sprites for each instance
		// of the spacebar pressed.
		if (keyCode == KeyEvent.VK_SPACE)
		{
			imagePane[positionX][positionY] = imageCursor;
			label[positionX][positionY].setIcon(imageCursor);
			cursorPlant = (int)(Math.random() * 3 + 1);	// Reroll the random number for the cursorPlant.
			spawnMonster++;
		}
		
		// Check if spawnMonster modulus 4 is 0. If it is, then place a zombie sprite
		// somewhere at rows 0 to 7 and columns 6 to 7.
		if (spawnMonster % 4 == 0)
		{
			monsterPlaceX = (int)(Math.random() * ((7 - 0) + 1));
			monsterPlaceY = 6 + (int)(Math.random() * ((7 - 6) + 1));
			
			imagePane[monsterPlaceX][monsterPlaceY] = spawnCursor;
			label[monsterPlaceX][monsterPlaceY].setIcon(spawnCursor);
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		ImageGame program = new ImageGame();
		program.setVisible(true);
		program.setSize(600, 600);
	}
}