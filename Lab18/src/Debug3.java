import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Debug3 extends JFrame
{
   private final int ROWS = 8;
   private final int COLS = 8;
   private final int GAP = 2;
   private final int NUM = ROWS * COLS;
   private JPanel panel[][] = new JPanel[ROWS][COLS];
   private Color color1 = Color.WHITE;

   
   public Debug3()
   {
	   super("White Grid");
	   setLayout(new GridLayout(ROWS, COLS, GAP, GAP));
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      for(int x = 0; x < ROWS; ++x)
      {
          for(int y = 0; y < COLS; ++y)
          {
        	 panel[x][y] = new JPanel();
	         add(panel[x][y]);
	         panel[x][y].setBackground(color1);
	      
          }
      }

   }
   
  
   
   public static void main(String[] args)
   {
      Debug3 frame = new Debug3();
      final int SIZE = 300;
      frame.setSize(400, 300);
      frame.setVisible(true);
   }

}
