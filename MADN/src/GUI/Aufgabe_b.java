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
import java.lang.reflect.Array;
import java.util.ArrayList;
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
	
	
	JButton felder[] = new JButton[72];
	for (int i = 0; i < felder.length; i++) {
		felder[i] = new JButton();
		center.add(felder[i]);
		felder[i].setOpaque(false);
		felder[i].setContentAreaFilled(false);
		//Feld1.setBorderPainted(false);
		final int x = i+1;
		felder[i].addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
					eh.buttonClicked(x);
			}
		});
	}
	felder[0].setBounds(13, 204, 35, 35);
	felder[1].setBounds(54, 204, 35, 35);
	felder[2].setBounds(100, 204, 35, 35);
	felder[3].setBounds(146, 204, 35, 35);
	felder[4].setBounds(202, 202, 35, 35);
	felder[5].setBounds(202, 153, 35, 35);
	felder[6].setBounds(202, 105, 35, 35);
	felder[7].setBounds(202, 55, 35, 35);
	felder[8].setBounds(202, 12, 35, 35);
	felder[9].setBounds(252, 12, 35, 35);
	felder[10].setBounds(300, 11, 35, 35);
	felder[11].setBounds(300, 50, 35, 35);
	felder[12].setBounds(100, 204, 35, 35);
	felder[13].setBounds(100, 204, 35, 35);
	felder[14].setBounds(100, 204, 35, 35);
	felder[15].setBounds(100, 204, 35, 35);
	felder[16].setBounds(100, 204, 35, 35);
	
	
	
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
