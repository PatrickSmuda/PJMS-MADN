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
		JCheckBox box = new JCheckBox("KI");
		String eingabe[] = new String[anz];
		for(int i = 0; i < anz; i++){
			box.setSelected(false);
			eingabe[i] = JOptionPane.showInputDialog(null,"Geben Sie Ihren Namen ein",
	                "Namensgebung",
	                JOptionPane.PLAIN_MESSAGE);
		}
		for(int i = 0; i< anz; i++){
			System.out.println(eingabe[i]);
		}
		
	}
	
	
}
