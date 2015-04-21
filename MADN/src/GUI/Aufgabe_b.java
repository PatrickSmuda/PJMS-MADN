package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Aufgabe_b extends JFrame{
	
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

    
    JButton north = new JButton("NORTH");
	JButton south = new JButton("SOUTH");
	JButton center = new JButton("CENTER");
	JButton west = new JButton("WEST");
	JButton east = new JButton("EAST");
	
	frame.getContentPane().add(north, BorderLayout.NORTH);
	frame.getContentPane().add(center, BorderLayout.CENTER);
	frame.getContentPane().add(south, BorderLayout.SOUTH);
	frame.getContentPane().add(west, BorderLayout.WEST);
	frame.getContentPane().add(east, BorderLayout.EAST);
	
	east.setPreferredSize(new Dimension(200, 100));
	west.setPreferredSize(new Dimension(200, 100));
	south.setPreferredSize(new Dimension(300, 150));
    
	
	
	}


	
	
	

}
