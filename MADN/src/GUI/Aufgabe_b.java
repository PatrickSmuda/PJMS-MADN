package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;


public class Aufgabe_b extends JFrame{
	JPanel jp = new JPanel();
	JButton jb = new JButton();
	
	public Aufgabe_b(){
		setTitle("DA");
		setVisible(true);
		setSize(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		jb.setIcon(new ImageIcon("C:\\Users\\Patrick\\Desktop\\Spielbrett.png"));
		jp.add(jb);
		add(jp);
		
		validate();	
	}
/*	
	private static final int SIZE = 900;
	private static final int SIZET = 650;
	
public void rahmen(){ 
	JFrame frame = new JFrame("Spiel");
	
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    frame.setSize(SIZE,SIZET);

	frame.setVisible(true);
//    frame.pack();
	
	frame.setResizable(false);
	frame.setLocationRelativeTo(null);  
			 

	
	
//	JButton south = new JButton("AUSGABE, STATUS");
//	JButton center = new JButton("SPIELBRETT");
//	JButton west = new JButton("WUERFEL");
//	JButton east = new JButton("SPIELFIGUREN, STEUERUNG");
	
	
	
//	frame.getContentPane().add(center, BorderLayout.CENTER);
//	frame.getContentPane().add(south, BorderLayout.SOUTH);
//	frame.getContentPane().add(west, BorderLayout.WEST);
//	frame.getContentPane().add(east, BorderLayout.EAST);
	
	
//	east.setPreferredSize(new Dimension(200, 100));
//	west.setPreferredSize(new Dimension(200, 100));
//	south.setPreferredSize(new Dimension(300, 150));
    
	
	
	}




      public void wuerfel(Graphics g){ 
    	  g.setColor (Color.CYAN);
          g.fillRect (10, 10, 50, 50);
      }
      
     
	
	
*/
}
