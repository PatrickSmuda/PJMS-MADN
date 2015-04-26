package GUI;
import java.util.Locale;

import javax.swing.*;

//import classes.Spiel;

public class Spielerangaben {
	//Plan B ist dass Plan A funktioniert
	
	
	public void anzahlSpieler(){
	
		JFrame meinJFrame = new JFrame();
        meinJFrame.setSize(400,400);
        meinJFrame.setTitle("Spieler oder KI?");
 
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
 
        panel.add(label);
        
        JButton spielerAnz1 = new JButton("test1");
        JButton spielerAnz2 = new JButton("test2");
        JButton spielerAnz3 = new JButton("test3");
        JButton spielerAnz4 = new JButton("test4");
        
        panel.add(spielerAnz1);
        panel.add(spielerAnz2);
        panel.add(spielerAnz3);
        panel.add(spielerAnz4);
        
        meinJFrame.add(panel);
 
        meinJFrame.setVisible(true);
		Object[] options = {"2", "3", "4"};
	    int selected = 	JOptionPane.showOptionDialog(null, "Anzahl der Spieler", "Alternativen",JOptionPane.DEFAULT_OPTION, 
	    				JOptionPane.INFORMATION_MESSAGE, 
					    null, options, options[0]);
	    setNamen();
	}
	
	
	
	public void setNamen(){
		
		JFrame meinJFrame = new JFrame();
        meinJFrame.setSize(400,400);
        meinJFrame.setTitle("Spieler oder KI?");
 
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
 
        panel.add(label);
        
        JButton spielerAnz1 = new JButton("test1");
        JButton spielerAnz2 = new JButton("test2");
        JButton spielerAnz3 = new JButton("test3");
        JButton spielerAnz4 = new JButton("test4");
        
        panel.add(spielerAnz1);
        panel.add(spielerAnz2);
        panel.add(spielerAnz3);
        panel.add(spielerAnz4);
        
        meinJFrame.add(panel);
 
        meinJFrame.setVisible(true);
		
		
		
		int anz;
		int anzSpieler = 3;
		switch(anzSpieler)
		{
		case 0: anz = 2; break;
		case 1: anz = 3; break;
		case 2: anz = 4; break;
		default: anz = 4; break;
		}
		int ki = 0;
		String eingabe[] = new String[anz];
		for(int i = 0; i < anz; i++){
			eingabe[i] = JOptionPane.showInputDialog(null,"Geben Sie Ihren Namen ein",
	                "Namensgebung",
	                JOptionPane.PLAIN_MESSAGE);
		}
		for(int i = 0; i< anz; i++){
			System.out.println(eingabe[i]);
		}
		setKI();
	}
	public void setKI(){
		JFrame meinJFrame = new JFrame();
        meinJFrame.setSize(400,400);
        meinJFrame.setTitle("Spieler oder KI?");
 
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
 
        panel.add(label);

        //JCheckBoxen werden erstellt
        JCheckBox checkSpieler = new JCheckBox("Spieler");
        JCheckBox checkKI = new JCheckBox("KI");
 
        //JCheckBoxen werden Panel hinzugefügt
        panel.add(checkSpieler);
        panel.add(checkKI);
 
        meinJFrame.add(panel);
 
        meinJFrame.setVisible(true);
	}
	
}
