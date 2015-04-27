package GUI;
import java.awt.TextArea;
import java.util.*;

import javax.swing.*;

//import classes.Spiel;

public class Spielerangaben extends JFrame {
	//Plan B ist dass Plan A funktioniert
	
	private int width = 640;
	private int height = 480;
	private JFrame mainFrame;
	private JTextArea names[] = new JTextArea[4];
	private JCheckBox ki_a[] = new JCheckBox[4];
	private JCheckBox ki_d[] = new JCheckBox[4];
	private JCheckBox human[] = new JCheckBox[4];
	private JLabel instructions;
	private JComboBox amountPlayers;
	private JLabel playerSelectLabel;
	
	public void init(){
		mainFrame = new JFrame("Spielererstellung");
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainFrame.setSize(width, height);
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);  
		mainFrame.setLayout(null);
		
		instructions = new JLabel();
		instructions.setText("Geben Sie die Anzahl der Spieler und deren Beschaffenheit an:");
		mainFrame.add(instructions);
		instructions.setBounds(15, 15, 640, 20);
		
		playerSelectLabel = new JLabel();
		playerSelectLabel.setText("Anzahl der Spieler:");
		mainFrame.add(playerSelectLabel);
		playerSelectLabel.setBounds(15, 50, 150, 20);
		amountPlayers = new JComboBox();
		amountPlayers.addItem("1");
		amountPlayers.addItem("2");
		amountPlayers.addItem("3");
		amountPlayers.addItem("4");
		mainFrame.add(amountPlayers);
		amountPlayers.setBounds(200, 50, 100, 20);
		
		mainFrame.setVisible(true);
	}
	
	
}
