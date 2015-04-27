package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
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
	
	final JTextArea logging = new JTextArea();
	//south.add(logging);
	//logging.setBounds(0, 0, 1000, 125);
	logging.setEditable(false);
	JScrollPane sp = new JScrollPane();
	sp.setViewportView(logging);
	south.add(sp);
	sp.setBounds(0,0,995,125);
	
	
	JButton wuerfel = new JButton();
	west.add(wuerfel);
	wuerfel.setBounds(90, 200, 50, 50);;
	
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
					eh.buttonClicked(x, logging);
			}
		});
	}
	//Immer +48
	felder[0].setBounds(10, 207, 35, 35);
	felder[1].setBounds(58, 207, 35, 35);
	felder[2].setBounds(107, 207, 35, 35);
	felder[3].setBounds(156, 207, 35, 35);
	felder[4].setBounds(205, 207, 35, 35);
	felder[5].setBounds(205, 159, 35, 35);
	felder[6].setBounds(205, 111, 35, 35);
	
	felder[59].setBounds(254, 207, 35, 35);
	
	felder[14].setBounds(302, 207, 35, 35);
	felder[15].setBounds(350, 207, 35, 35);
	felder[16].setBounds(398, 207, 35, 35);
	felder[17].setBounds(446, 207, 35, 35);
	felder[18].setBounds(494, 207, 35, 35);
	
	
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
