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
	final JLabel wrfl = new JLabel();
	west.add(wrfl);
	wrfl.setBounds(0, 0, 221, 216);
	
	
	
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
	wuerfel.setBounds(90, 200, 50, 50);
	wuerfel.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			eh.wrflAnzeigen(wrfl);
		}
		
	});
	
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
	//Immer +-48
	felder[0].setBounds(10, 207, 35, 35);
	felder[1].setBounds(58, 207, 35, 35);
	felder[2].setBounds(107, 207, 35, 35);
	felder[3].setBounds(156, 207, 35, 35);
	felder[4].setBounds(205, 207, 35, 35);
	felder[5].setBounds(205, 159, 35, 35);
	felder[6].setBounds(205, 111, 35, 35);
	felder[7].setBounds(205, 63, 35, 35);
	felder[8].setBounds(205, 15, 35, 35);
	felder[9].setBounds(253, 15, 35, 35);
	felder[10].setBounds(301, 15, 35, 35);
	felder[11].setBounds(301, 63, 35, 35);
	felder[12].setBounds(301, 111, 35, 35);
	felder[13].setBounds(301, 159, 35, 35);
	felder[14].setBounds(302, 207, 35, 35);
	felder[15].setBounds(350, 207, 35, 35);
	felder[16].setBounds(398, 207, 35, 35);
	felder[17].setBounds(446, 207, 35, 35);
	felder[18].setBounds(494, 207, 35, 35);
	felder[19].setBounds(494, 255, 35, 35);
	felder[20].setBounds(494, 303, 35, 35);
	felder[21].setBounds(446, 303, 35, 35);
	felder[22].setBounds(398, 303, 35, 35);
	felder[23].setBounds(350, 303, 35, 35);
	felder[24].setBounds(302, 303, 35, 35);
	felder[25].setBounds(302, 352, 35, 35);
	felder[26].setBounds(302, 401, 35, 35);
	felder[27].setBounds(302, 449, 35, 35);
	felder[28].setBounds(302, 497, 35, 35);
	felder[29].setBounds(254, 498, 35, 35);
	felder[30].setBounds(204, 498, 35, 35);
	felder[31].setBounds(204, 450, 35, 35);
	felder[32].setBounds(204, 402, 35, 35);
	felder[33].setBounds(204, 353, 35, 35);
	felder[34].setBounds(204, 304, 35, 35);
	felder[35].setBounds(156, 304, 35, 35);
	felder[36].setBounds(108, 304, 35, 35);
	felder[37].setBounds(59, 304, 35, 35);
	felder[38].setBounds(10, 304, 35, 35);
	felder[39].setBounds(10, 256, 35, 35);
	//Endfelder Blau
	felder[56].setBounds(253, 62, 35, 35);
	felder[57].setBounds(253, 110, 35, 35);
	felder[58].setBounds(253, 158, 35, 35);
	felder[59].setBounds(253, 207, 35, 35);
	//Endfelder Gelb
	felder[60].setBounds(253, 450, 35, 35);
	felder[61].setBounds(253, 402, 35, 35);
	felder[62].setBounds(253, 353, 35, 35);
	felder[63].setBounds(253, 304, 35, 35);
	
	
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
