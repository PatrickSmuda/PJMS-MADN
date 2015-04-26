package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SpielerAngaben_a {
	
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
	    //setNamen();
	}
	

}
