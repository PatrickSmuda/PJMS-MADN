package GUI;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

import classes.FarbEnum;
import classes.Spiel;
import classes.iBediener;

//import classes.Spiel;
/**
 * Klasse fuer Spielererstellung
 * @author Mersiha, Sebastian, Patrick
 *
 */
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
	private JLabel bgLabel;
	private JLabel mainLabel;
	private iBediener ib;
	private Aufgabe_b b;
	
	/**
	 * initalisiert die GUI
	 */
	public void init(){
		mainFrame = new JFrame("Spielererstellung");
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainFrame.setSize(width, height);
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);  
		mainFrame.setLayout(null);
		
		bgLabel = new JLabel();
		bgLabel.setIcon(new ImageIcon("bg1.png"));
		mainFrame.add(bgLabel);
		bgLabel.setBounds(0, 0, 640, 480);
		
		
		
		instructions = new JLabel();
		instructions.setText("Geben Sie die Anzahl der Spieler und deren Beschaffenheit an:");
		bgLabel.add(instructions);
		instructions.setBounds(15, 15, 640, 20);
		
		playerSelectLabel = new JLabel();
		playerSelectLabel.setText("Anzahl der Spieler:");
		bgLabel.add(playerSelectLabel);
		playerSelectLabel.setBounds(15, 50, 150, 20);
		amountPlayers = new JComboBox();
		amountPlayers.addItem("1");
		amountPlayers.addItem("2");
		amountPlayers.addItem("3");
		amountPlayers.addItem("4");
		bgLabel.add(amountPlayers);
		amountPlayers.setBounds(200, 50, 100, 20);
		
		int players = amountPlayers.getSelectedIndex()+1;
		mainFrame.validate();
		
		amountPlayers.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				paintSelection(amountPlayers.getSelectedIndex()+1);
				
			}
		});
		
		
		accept = new JButton();
		accept.setText("Annehmen");
		bgLabel.add(accept);
		accept.setBounds(15, 420, 100, 20);
		accept.setEnabled(false);
		accept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean passed = true;
				int f = 10;
				int a_players = amountPlayers.getSelectedIndex()+1;
				for(int i = 0; i < a_players; i++){
					if(names[i].getText().equals("")){
						final JFrame alert = new JFrame();
						JLabel alertMessage = new JLabel();
						JButton alertOk = new JButton("Ok");
						
						mainFrame.setEnabled(false);
						alert.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
						alert.setSize(300, 100);
						alert.setResizable(false);
						alert.setLocationRelativeTo(null);  
						alert.setLayout(null);
						alertMessage.setText("Ein oder mehrere Namen sind leer!");
						alert.add(alertMessage);
						//mainFrame.add(alert);
						alertMessage.setBounds(50, 0, 300, 50);
						alert.add(alertOk);
						alertOk.setBounds(125, 40, 50, 20);
						passed = false;
						alertOk.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								alert.dispose();
								mainFrame.setEnabled(true);
								
							}
						});
						alert.setVisible(true);
						break;
					}
					
					boolean hit = false;
					f = farbe[i].getSelectedIndex();
					for(int j = 0; j < farbe.length; j++){
						if(farbe[j] != null && j != i && farbe[j].getSelectedIndex() == f){
							hit = true;
						}
					}
					
					if(hit){
						final JFrame alert = new JFrame();
						JLabel alertMessage = new JLabel();
						JButton alertOk = new JButton("Ok");
						
						mainFrame.setEnabled(false);
						alert.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
						alert.setSize(300, 100);
						alert.setResizable(false);
						alert.setLocationRelativeTo(null);  
						alert.setLayout(null);
						alertMessage.setText("Pro Farbe nur ein Spieler!");
						alert.add(alertMessage);
						//mainFrame.add(alert);
						alertMessage.setBounds(75, 0, 300, 50);
						alert.add(alertOk);
						alertOk.setBounds(125, 40, 50, 20);
						passed = false;
						alertOk.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								alert.dispose();
								mainFrame.setEnabled(true);
								
							}
						});
						alert.setVisible(true);
						break;
					}
					
					
						
					
					
				}
				if(passed){
					ib = new Spiel();
					
					
					
					for(int j = 0; j < a_players; j++){
						int ki = 0;
						if(human[j].isSelected()){
							ki = 0;
						}
						if(ki_a[j].isSelected()){
							ki = 1;
						}
						if(ki_d[j].isSelected()){
							ki = 2;
						}
						ib.spielerHinzufuegen(names[j].getText(), farbe[j].getSelectedIndex(), ki);	
					}
					ib.beginneSpiel();
					b = new Aufgabe_b(ib);
					//mainFrame.dispose();
				}
			}
		});
		
		cancel = new JButton();
		cancel.setText("Abbrechen");
		bgLabel.add(cancel);
		cancel.setBounds(125, 420, 100, 20);
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.dispose();
				
			}
		});
		
		mainFrame.setVisible(true);
	}
	
	/**
	 * Zeichnet die Spielerauswahl
	 * @param players anzahl der Spieler
	 */
	private void paintSelection(int players){
		
		for(int i = 0; i < players; i++){
			human_label[i] = new JLabel();
			human_label[i].setText("Mensch");
			bgLabel.add(human_label[i]);
			human_label[i].setBounds(325, 100+(i*25), 100, 20);
			human[i] = new JRadioButton("human");
			bgLabel.add(human[i]);
			human[i].setBounds(375, 100+(i*25), 20, 20);
			human[i].setOpaque(false);
			human[i].setSelected(true);
			
			ki_a_label[i] = new JLabel();
			ki_a_label[i].setText("KI aggressiv");
			bgLabel.add(ki_a_label[i]);
			ki_a_label[i].setBounds(400, 100+(i*25), 100, 20);
			ki_a[i] = new JRadioButton("ki_a");
			bgLabel.add(ki_a[i]);
			ki_a[i].setBounds(475, 100+(i*25), 20, 20);
			ki_a[i].setOpaque(false);
			
			ki_d_label[i] = new JLabel();
			ki_d_label[i].setText("KI defensiv");
			bgLabel.add(ki_d_label[i]);
			ki_d_label[i].setBounds(500, 100+(i*25), 100, 20);
			ki_d[i] = new JRadioButton("ki_d");
			bgLabel.add(ki_d[i]);
			ki_d[i].setBounds(570, 100+(i*25), 20, 20);
			ki_d[i].setOpaque(false);
			
			playerNameLabel[i] = new JLabel();
			playerNameLabel[i].setText("Name "+(i+1)+":");
			names[i] = new JTextArea();
			//names[i].setEnabled(false);
			bgLabel.add(playerNameLabel[i]);
			playerNameLabel[i].setBounds(15, 100+(i*25), 100, 20);
			bgLabel.add(names[i]);
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
			bgLabel.add(farbe[i]);
			farbe[i].setBounds(210,100+(i*25),100,20);
			final int x = i;
			farbe[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			
			
		}
		amountPlayers.setEnabled(false);
		accept.setEnabled(true);
	}
	
}
