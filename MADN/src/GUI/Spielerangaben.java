package GUI;
import javax.swing.*;

public class Spielerangaben {
	//Plan B ist dass Plan A funktioniert
	public void anzahlSpieler(){
		Object[] options = {"2", "3", "4"};
	    int selected = 	JOptionPane.showOptionDialog(null, "Anzahl der Spieler", "Alternativen",JOptionPane.DEFAULT_OPTION, 
	    				JOptionPane.INFORMATION_MESSAGE, 
					    null, options, options[0]);
	    setNamen(selected);
	}
	
	public void setNamen(int anzSpieler){
		int anz;
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
        meinJFrame.setSize(150,100);
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
