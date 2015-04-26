package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;

import javax.swing.*;


public class Aufgabe_b extends JFrame{
	JPanel jp = new JPanel();
	JButton jb = new JButton();

	private static final int SIZEBreite = 1000;
	private static final int SIZEHoehe = 700;
	
public void rahmen(){ 
	JFrame frame = new JFrame("Spiel");
	
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    frame.setSize(SIZEBreite, SIZEHoehe);
    
	frame.setResizable(false);
	frame.setLocationRelativeTo(null);  
	 
	JButton south = new JButton("AUSGABE, STATUS");
	JLabel center = new JLabel();
	center.setIcon(new ImageIcon("Spielbrett.png"));
	JButton west = new JButton("WUERFEL");
	JButton east = new JButton("SPIELFIGUREN, STEUERUNG");
     
	frame.getContentPane().add(center, BorderLayout.CENTER);
	frame.getContentPane().add(south, BorderLayout.SOUTH);
	frame.getContentPane().add(west, BorderLayout.WEST);
	frame.getContentPane().add(east, BorderLayout.EAST);
	
	east.setPreferredSize(new Dimension(227, 100));
	west.setPreferredSize(new Dimension(227, 100));
	south.setPreferredSize(new Dimension(300, 125));
    
    frame.setVisible(true);
	
	}
      
}
