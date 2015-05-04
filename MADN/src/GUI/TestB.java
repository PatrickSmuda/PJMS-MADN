

package GUI;

import classes.Spiel;
import classes.iBediener;

public class TestB {

	public static void main (String [] args){ 
		iBediener ib = new Spiel();
		ib.spielerHinzufuegen("Rasanter Rudi", 1, 0);
		ib.spielerHinzufuegen("Fliegerbernd", 0, 0);
		ib.beginneSpiel();
		Aufgabe_b GUI = new Aufgabe_b();
		GUI.setBediener(ib);
		GUI.rahmen();
	}//Test
}
