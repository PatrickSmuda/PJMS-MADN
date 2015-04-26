package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.EventListener;

import javax.swing.*;


public class Aufgabe_b extends JFrame{
	JPanel jp = new JPanel();
	JButton jb = new JButton();

	private static final int SIZEBreite = 1000;
	private static final int SIZEHoehe = 700;
	private EventHandler eh = new EventHandler();
	
public void rahmen(){ 
	JFrame frame = new JFrame("Spiel");
	
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    frame.setSize(SIZEBreite, SIZEHoehe);
    
	frame.setResizable(false);
	frame.setLocationRelativeTo(null);  
	 
	JLabel south = new JLabel();
	JLabel center = new JLabel();
	center.setIcon(new ImageIcon("Spielbrett.png"));
	JLabel west = new JLabel();
	JLabel east = new JLabel();
	
	JButton Feld1 = new JButton();
	center.add(Feld1);
	Feld1.setBounds(13, 204, 35, 35);
	Feld1.setOpaque(false);
	Feld1.setContentAreaFilled(false);
	//Feld1.setBorderPainted(false);
	Feld1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
				eh.buttonClicked(1);
		}
	});
	
	JButton Feld2 = new JButton();
	center.add(Feld2);
	Feld2.setBounds(54, 204, 35, 35);
	Feld2.setOpaque(false);
	Feld2.setContentAreaFilled(false);
	//Feld1.setBorderPainted(false);
	Feld2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
				eh.buttonClicked(2);
		}
	});		
	
	
	JButton Feld3 = new JButton();
	center.add(Feld3);
	Feld3.setBounds(100, 204, 35, 35);
	Feld3.setOpaque(false);
	Feld3.setContentAreaFilled(false);
	//Feld1.setBorderPainted(false);
	Feld3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
				eh.buttonClicked(3);
		}
	});		
	
	
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
