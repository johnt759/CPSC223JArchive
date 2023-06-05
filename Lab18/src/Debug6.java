import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Debug6 extends JFrame implements ActionListener{
	
		   private CardLayout cards = new CardLayout();
		   private JButton next = new JButton("Next");
		   private JButton prev = new JButton("Previous");
		   private JPanel buttonsPanel = new JPanel();
		   private JPanel buttonsPanel2 = new JPanel();
		   
		   public Debug6()
		   {
			  super("Debug");
			  setLayout(cards);
		      setSize(400, 150);
		      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      
		      next.addActionListener(this);
		      prev.addActionListener(this);
		      
		      buttonsPanel.setLayout(new FlowLayout());
		      buttonsPanel.add(new JButton("1"));
		      buttonsPanel.add(new JButton("2"));
		      buttonsPanel.add(new JButton("3"));
		      buttonsPanel.add(next);
		      add(buttonsPanel, "Panel1");
		      
		      buttonsPanel2.setLayout(new GridLayout(2, 2, 5, 5));
		      buttonsPanel2.add(new JButton("4"));
		      buttonsPanel2.add(new JButton("5"));
		      buttonsPanel2.add(new JButton("6"));
		      buttonsPanel2.add(prev);
		      add( buttonsPanel2, "Panel2");

		      setVisible(true); 
		   }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		
		if(source == next)
		{
			cards.show( getContentPane(), "Panel2");

		}else if (source == prev)
		{
			cards.show( getContentPane(), "Panel1");
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Debug6 frame = new Debug6();
	}

}

