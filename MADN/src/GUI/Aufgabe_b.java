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
	
//	public Aufgabe_b(){
//		setTitle("DA");
//		setVisible(true);
//		setSize(400, 200);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		jb.setIcon(new ImageIcon("C:\\Users\\Patrick\\Desktop\\Spielbrett.png"));
//		jp.add(jb);
//		add(jp);
//		
//		validate();	
//	}
	
	private static final int SIZE = 1200;
	private static final int SIZET = 900;
	
public void rahmen(){ 
	JFrame frame = new JFrame("Spiel");
	
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    frame.setSize(SIZE,SIZET);

	
//    frame.pack();
	
	frame.setResizable(false);
	frame.setLocationRelativeTo(null);  
			 

	
	

//	JButton north = new JButton ("menue");
	
//	 ImageIcon myfile = new ImageIcon("C:\\Users\\Mersiha\\Desktop\\inf\\blatt2\\grafik"); 

	 validate();	
	 
//	 JFileChooser fc = new JFileChooser();
//	 fc.showOpenDialog(null);
//	 JLabel label = new JLabel(new ImageIcon(fc.getSelectedFile().getAbsolutePath()));
	 
	 JButton south = new JButton("AUSGABE, STATUS");
	 JButton center = new JButton("Center");
	 center.setIcon(new ImageIcon("C:\\Users\\Patrick\\Desktop\\Spielbrett.png"));
	 JButton west = new JButton("WUERFEL");
	 JButton east = new JButton("SPIELFIGUREN, STEUERUNG");
	 
//     frame.getContentPane().add(BorderLayout.CENTER, label);
//	
//        setTitle("DA");
//		setVisible(true);
//		label.setSize(400, 200);
//		
//		setResizable(false);
//		setLocationRelativeTo(null);  
	
	// das funktioniert alles nicht, ich fang gleich an zu weinen
     
	frame.getContentPane().add(center, BorderLayout.CENTER);
	frame.getContentPane().add(south, BorderLayout.SOUTH);
	frame.getContentPane().add(west, BorderLayout.WEST);
	frame.getContentPane().add(east, BorderLayout.EAST);

	System.out.println(new File("C:\\Users\\Mers\\Desktop\\Spielbrett.png").exists());
	
	east.setPreferredSize(new Dimension(200, 100));
	west.setPreferredSize(new Dimension(200, 100));
	south.setPreferredSize(new Dimension(300, 150));
	
//	jb.setIcon(new ImageIcon("C:\\Users\\Mers\\Desktop\\Spielbrett.png"));
//    jp.add(jb);
////    add(jp);
    
    frame.setVisible(true);
	
	}
      
}
