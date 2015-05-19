

package GUI;

import classes.Spiel;
import classes.iBediener;

public class TestB {

	public static void main (String [] args){ 
		iBediener ib = new Spiel();
		ib.spielerHinzufuegen("Rasanter Rudi", 1, 1);
		ib.spielerHinzufuegen("Fliegerbernd", 0, 1);
//		ib.spielerHinzufuegen("Glitzerndes Einhorn", 2, 0);
//		ib.spielerHinzufuegen("Amouroeser Alfred", 3, 2);
		ib.beginneSpiel();
		Aufgabe_b GUI = new Aufgabe_b();
		GUI.setBediener(ib);
		GUI.rahmen();
	}//Test
}
