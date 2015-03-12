package classes;
/**
 * Die Klasse Spieler
 * @author Johannes M�ndle
 * @version 1.0
 */
import java.util.*;

public class Spieler {

	private String name;
	private FarbEnum farbe;
	private W�rfel w�rfel;
	private Spielfigur fig_1;
	private Spielfigur fig_2;
	private Spielfigur fig_3;
	private Spielfigur fig_4;
	private static int z�hler =1;

	/**
	 * Konstruktor
	 * @param name Name des Spielers
	 * @param farbe Farbe des Spielers
	 */
	public Spieler(String name, FarbEnum farbe)
	{
		if (z�hler > 4) throw new RuntimeException("Zu viele Spieler");
		if(name == null) throw new RuntimeException("Ung�ltiger Name!");
		this.name = name;
		w�rfel = new W�rfel();
		switch(farbe)
		{
		case rot: this.farbe = FarbEnum.rot; break;
		case blau: this.farbe = FarbEnum.blau; break;
		case gr�n: this.farbe = FarbEnum.gr�n; break;
		case gelb: this.farbe = FarbEnum.gelb; break;
		default: throw new RuntimeException("Farbe existiert nicht");
		}
		fig_1 = new Spielfigur(farbe, null);
		fig_2 = new Spielfigur(farbe, null);
		fig_3 = new Spielfigur(farbe, null);
		fig_4 = new Spielfigur(farbe, null);
		z�hler++;
	}
}
