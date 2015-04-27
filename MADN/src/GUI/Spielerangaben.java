package GUI;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

//import classes.Spiel;

public class Spielerangaben extends JFrame {
	//Plan B ist dass Plan A funktioniert
	
	private int width = 640;
	private int height = 480;
	private JFrame mainFrame;
	private JTextArea names[] = new JTextArea[4];
	private JRadioButton ki_a[] = new JRadioButton[4];
	private JRadioButton ki_d[] = new JRadioButton[4];
	private JRadioButton human[] = new JRadioButton[4];
	private JLabel[] playerNameLabel = new JLabel[4];
	private JLabel[] ki_a_label = new JLabel[4];
	private JLabel[] ki_d_label = new JLabel[4];
	private JLabel[] human_label = new JLabel[4];
	private JLabel instructions;
	private JComboBox amountPlayers;
	private JLabel playerSelectLabel;
	private ButtonGroup bg[] = new ButtonGroup[4];
	private JComboBox farbe[] = new JComboBox[4];
	private JButton accept; 
	private JButton cancel;
	
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
		
		int players = amountPlayers.getSelectedIndex()+1;
		System.out.println(players);
		mainFrame.validate();
		
		amountPlayers.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				paintSelection(amountPlayers.getSelectedIndex()+1);
				
			}
		});
		
		
		accept = new JButton();
		accept.setText("Annehmen");
		mainFrame.add(accept);
		accept.setBounds(15, 420, 100, 20);
		
		accept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		cancel = new JButton();
		cancel.setText("Abbrechen");
		mainFrame.add(cancel);
		cancel.setBounds(125, 420, 100, 20);
		
		mainFrame.setVisible(true);
	}
	
	
	private void paintSelection(int players){
		
		for(int i = 0; i < players; i++){
			human_label[i] = new JLabel();
			human_label[i].setText("Mensch");
			mainFrame.add(human_label[i]);
			human_label[i].setBounds(325, 100+(i*25), 100, 20);
			human[i] = new JRadioButton();
			mainFrame.add(human[i]);
			human[i].setBounds(375, 100+(i*25), 20, 20);
			
			ki_a_label[i] = new JLabel();
			ki_a_label[i].setText("KI aggressiv");
			mainFrame.add(ki_a_label[i]);
			ki_a_label[i].setBounds(400, 100+(i*25), 100, 20);
			ki_a[i] = new JRadioButton();
			mainFrame.add(ki_a[i]);
			ki_a[i].setBounds(475, 100+(i*25), 20, 20);
			
			ki_d_label[i] = new JLabel();
			ki_d_label[i].setText("KI defensiv");
			mainFrame.add(ki_d_label[i]);
			ki_d_label[i].setBounds(500, 100+(i*25), 100, 20);
			ki_d[i] = new JRadioButton();
			mainFrame.add(ki_d[i]);
			ki_d[i].setBounds(570, 100+(i*25), 20, 20);
			
			
			playerNameLabel[i] = new JLabel();
			playerNameLabel[i].setText("Name "+(i+1)+":");
			names[i] = new JTextArea();
			//names[i].setEnabled(false);
			mainFrame.add(playerNameLabel[i]);
			playerNameLabel[i].setBounds(15, 100+(i*25), 100, 20);
			mainFrame.add(names[i]);
			names[i].setBounds(100, 100+(i*25), 100, 20);
			
			bg[i] = new ButtonGroup();
			bg[i].add(human[i]);
			bg[i].add(ki_a[i]);
			bg[i].add(ki_d[i]);
			
			farbe[i] = new JComboBox();
			farbe[i].addItem("Rot");
			farbe[i].addItem("Blau");
			farbe[i].addItem("Gruen");
			farbe[i].addItem("Gelb");
			mainFrame.add(farbe[i]);
			farbe[i].setBounds(210,100+(i*25),100,20);
			final int x = i;
			farbe[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Object o = farbe[x].getSelectedItem();
					farbe[x].setEnabled(false);
					int y = 0;
					while(y < 4){
						System.out.println("a");
						if(y != x){
							farbe[y].removeItem(o);
						}
						y++;
					}
				}
			});
			
			
		}
		amountPlayers.setEnabled(false);
	}
	
}
