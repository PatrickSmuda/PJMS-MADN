

package GUI;

import classes.Spiel;
import classes.iBediener;

public class TestB {

	public static void main (String [] args){ 
		iBediener ib = new Spiel();
		Aufgabe_b GUI = new Aufgabe_b(ib);
		GUI.rahmen();
	}//Test
}
