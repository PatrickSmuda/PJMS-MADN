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
	private EventHandler eh = new EventHandler(this);
	
	private JLabel [] figurGruen = new JLabel[4];
	private JLabel [] figurRot = new JLabel[4];
	private JLabel [] figurGelb = new JLabel[4];
	private JLabel [] figurBlau = new JLabel[4];
	
	
	
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
	wrfl.setName("wuerfelLabel");
	west.add(wrfl);
	wrfl.setBounds(0, 0, 221, 216);
	
	
	for(int i=0;i<4;i++){
		figurRot[i]=new JLabel();
		figurBlau[i]=new JLabel();
		figurGelb[i]=new JLabel();
		figurGruen[i]=new JLabel();
		
		center.add(figurRot[i]);
		center.add(figurBlau[i]);
		center.add(figurGelb[i]);
		center.add(figurGruen[i]);
		
		figurRot[i].setIcon(new ImageIcon("SpielfigurRot.jpg"));
		figurBlau[i].setIcon(new ImageIcon("SpielfigurBlau.jpg"));
		figurGelb[i].setIcon(new ImageIcon("SpielfigurGelb.jpg"));
		figurGruen[i].setIcon(new ImageIcon("SpielfigurGruen.jpg"));
	
	}
	
	figurRot[0].setBounds(8, 11, 30, 30);
	figurRot[1].setBounds(56, 11, 30, 30);
	figurRot[2].setBounds(8, 59, 30, 30);
	figurRot[3].setBounds(56, 59, 30, 30);
	
	figurBlau[0].setBounds(444, 11, 30, 30);
	figurBlau[1].setBounds(492, 11, 30, 30);
	figurBlau[2].setBounds(444, 59, 30, 30);
	figurBlau[3].setBounds(492, 59, 30, 30);
	
	figurGelb[0].setBounds(8, 447, 30, 30);
	figurGelb[1].setBounds(56, 447, 30, 30 );
	figurGelb[2].setBounds(8, 496, 30, 30 );
	figurGelb[3].setBounds(56, 496, 30, 30);
	
	figurGruen[0].setBounds(444, 447, 30, 30);
	figurGruen[1].setBounds(492, 447, 30, 30);
	figurGruen[2].setBounds(444, 496, 30, 30);
	figurGruen[3].setBounds(492, 496, 30, 30);



	
	
	final JTextArea logging = new JTextArea();
	//south.add(logging);
	//logging.setBounds(0, 0, 1000, 125);
	logging.setEditable(false);
	JScrollPane sp = new JScrollPane();
	sp.setViewportView(logging);
	south.add(sp);
	sp.setBounds(0,0,995,125);
	
	
	JButton wuerfel = new JButton("Wuerfeln");
	wuerfel.setName("wuerfel");
	west.add(wuerfel);
	wuerfel.setBounds(60, 300, 100, 30);
	wuerfel.addActionListener(eh);

	JButton bewege[] = new JButton[4];
	for (int i = 0; i < bewege.length; i++) {
		bewege[i] = new JButton("Bewege Firgur "+(i+1));
		bewege[i].setName("Bewege_"+i);
		east.add(bewege[i]);
		bewege[i].setBounds(10, ((i*100)+60), 200, 50);
		bewege[i].addActionListener(eh);
	}
	
	JButton felder[] = new JButton[72];
	for (int i = 0; i < felder.length; i++) {
		felder[i] = new JButton();
		felder[i].setName("Feld_"+i);
		center.add(felder[i]);
		felder[i].setOpaque(false);
		felder[i].setContentAreaFilled(false);
		felder[i].setBorderPainted(false);
		felder[i].addActionListener(eh);
//		final int x = i+1;
//		felder[i].addActionListener(new ActionListener() {	
//			@Override
//			public void actionPerformed(ActionEvent e) {
//					eh.buttonClicked(x, logging);
//			}
//		});
	}
	//Circa +-48 Abstand der Felder
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
	//Startfelder Rot
	felder[40].setBounds(8, 11, 40, 40);
	felder[41].setBounds(56, 11, 40, 40);
	felder[42].setBounds(8, 59, 40, 40);
	felder[43].setBounds(56, 59, 40, 40);
	//Startfelder Blau
	felder[44].setBounds(444, 11, 40, 40);
	felder[45].setBounds(492, 11, 40, 40);
	felder[46].setBounds(444, 59, 40, 40);
	felder[47].setBounds(492, 59, 40, 40);
	//Startfelder Gruen
	felder[48].setBounds(444, 447, 40, 40);
	felder[49].setBounds(492, 447, 40, 40);
	felder[50].setBounds(444, 496, 40, 40);
	felder[51].setBounds(492, 496, 40, 40);
	//Startfelder Gelb
	felder[52].setBounds(8, 447, 40, 40);
	felder[53].setBounds(56, 447, 40, 40);
	felder[54].setBounds(8, 496, 40, 40);
	felder[55].setBounds(56, 496, 40, 40);
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
	//Endfelder Gruen
	felder[64].setBounds(302, 255, 35, 35);
	felder[65].setBounds(350, 255, 35, 35);
	felder[66].setBounds(398, 255, 35, 35);
	felder[67].setBounds(446, 255, 35, 35);
	//Endfelder Rot
	felder[68].setBounds(58, 256, 35, 35);
	felder[69].setBounds(107, 256, 35, 35);
	felder[70].setBounds(156, 256, 35, 35);
	felder[71].setBounds(205, 256, 35, 35);
	
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
