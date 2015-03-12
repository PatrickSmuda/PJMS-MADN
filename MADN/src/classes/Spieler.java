package classes;
/**
 * Die Klasse Spieler
 * @author Johannes Mändle
 * @version 1.0
 */
import java.util.*;

public class Spieler {

	private String name;
	private FarbEnum farbe;
	private Würfel würfel;
	private Spielfigur fig_1;
	private Spielfigur fig_2;
	private Spielfigur fig_3;
	private Spielfigur fig_4;
	private static int zähler =1;

	/**
	 * Konstruktor
	 * @param name Name des Spielers
	 * @param farbe Farbe des Spielers
	 */
	public Spieler(String name, FarbEnum farbe)
	{
		if (zähler > 4) throw new RuntimeException("Zu viele Spieler");
		if(name == null) throw new RuntimeException("Ungültiger Name!");
		this.name = name;
		würfel = new Würfel();
		switch(farbe)
		{
		case rot: this.farbe = FarbEnum.rot; break;
		case blau: this.farbe = FarbEnum.blau; break;
		case grün: this.farbe = FarbEnum.grün; break;
		case gelb: this.farbe = FarbEnum.gelb; break;
		default: throw new RuntimeException("Farbe existiert nicht");
		}
		fig_1 = new Spielfigur(farbe, null);
		fig_2 = new Spielfigur(farbe, null);
		fig_3 = new Spielfigur(farbe, null);
		fig_4 = new Spielfigur(farbe, null);
		zähler++;
	}
}
