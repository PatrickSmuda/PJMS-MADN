package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

public class AufgabeB extends JFrame {

	
	private static final long serialVersionUID = 1L;
	JPanel jp = new JPanel();
	JButton jb = new JButton();
	private static final int SIZE = 900;
	private static final int SIZET = 650;
	
public void rahmen(){ 
	JFrame frame = new JFrame("Spiel");
	
	
    frame.setSize(SIZE,SIZET);
    frame.setResizable(false);
	frame.setLocationRelativeTo(null); 
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

	
	JButton south = new JButton("AUSGABE, STATUS");
    JButton center = new JButton("CENTER");
    JButton west = new JButton("WUERFEL");
	JButton east = new JButton("SPIELFIGUREN, STEUERUNG");
	
	frame.getContentPane().add(center, BorderLayout.CENTER);
	frame.getContentPane().add(south, BorderLayout.SOUTH);
	frame.getContentPane().add(west, BorderLayout.WEST);
	frame.getContentPane().add(east, BorderLayout.EAST);
	
	east.setPreferredSize(new Dimension(200, 100));
	west.setPreferredSize(new Dimension(200, 100));
	south.setPreferredSize(new Dimension(300, 150));
	
    frame.setVisible(true);


}
}
