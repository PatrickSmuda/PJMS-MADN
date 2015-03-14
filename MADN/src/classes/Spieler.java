package classes;
/**
 * Die Klasse Spieler
 * @author Johannes Mändle
 * @version 1.0
 */

public class Spieler {

	private String name;
	private FarbEnum farbe;
	private Würfel würfel;
	private Spielfigur fig_1;
	private Spielfigur fig_2;
	private Spielfigur fig_3;
	private Spielfigur fig_4;
	private KI ki;
	private static int zähler =1;

	/**
	 * Konstruktor setzt den Spielernamen, die Farbe der Spielfiguren des Spielers und ggf. eine KI
	 * @param name Name des Spielers
	 * @param farbe Farbe des Spielers
	 */
	public Spieler(String name, FarbEnum farbe, KI ki)
	{
		if (zähler > 4) throw new RuntimeException("Zu viele Spieler");
		if(name == null) throw new RuntimeException("Ungültiger Name!");
		if (ki != null) this.ki = ki;
		this.name = name;
		würfel = new Würfel();
		figurenInit(farbe);
		zähler++;
	}

	/**
	 * Die Methode initialisiert die Spielfiguren mit der übergebenen Farbe 
	 * und stellt sie auf ihre jeweilige Startposition
	 * @param farbe Die Farbe der Spielfiguren
	 */
	public void figurenInit(FarbEnum farbe)
	{
		switch(farbe)
		{
		case rot: 
			this.farbe = FarbEnum.rot; 
			Spielfeld r1 = new Spielfeld(FeldTyp.Startfeld, farbe, 52);
			Spielfeld r2 = new Spielfeld(FeldTyp.Startfeld, farbe, 53);
			Spielfeld r3 = new Spielfeld(FeldTyp.Startfeld, farbe, 54);
			Spielfeld r4 = new Spielfeld(FeldTyp.Startfeld, farbe, 55);
			fig_1 = new Spielfigur(farbe, r1);
			fig_2 = new Spielfigur(farbe, r2);
			fig_3 = new Spielfigur(farbe, r3);
			fig_4 = new Spielfigur(farbe, r4);
			break;
		case blau: 
			this.farbe = FarbEnum.blau; 
			Spielfeld b1 = new Spielfeld(FeldTyp.Startfeld, farbe, 40);
			Spielfeld b2 = new Spielfeld(FeldTyp.Startfeld, farbe, 41);
			Spielfeld b3 = new Spielfeld(FeldTyp.Startfeld, farbe, 42);
			Spielfeld b4 = new Spielfeld(FeldTyp.Startfeld, farbe, 43);
			fig_1 = new Spielfigur(farbe, b1);
			fig_2 = new Spielfigur(farbe, b2);
			fig_3 = new Spielfigur(farbe, b3);
			fig_4 = new Spielfigur(farbe, b4);
			break;
		case grün: 
			this.farbe = FarbEnum.grün;
			Spielfeld g1 = new Spielfeld(FeldTyp.Startfeld, farbe, 44);
			Spielfeld g2 = new Spielfeld(FeldTyp.Startfeld, farbe, 45);
			Spielfeld g3 = new Spielfeld(FeldTyp.Startfeld, farbe, 46);
			Spielfeld g4 = new Spielfeld(FeldTyp.Startfeld, farbe, 47);
			fig_1 = new Spielfigur(farbe, g1);
			fig_2 = new Spielfigur(farbe, g2);
			fig_3 = new Spielfigur(farbe, g3);
			fig_4 = new Spielfigur(farbe, g4);
			break;
		case gelb: 
			this.farbe = FarbEnum.gelb;
			Spielfeld y1 = new Spielfeld(FeldTyp.Startfeld, farbe, 48);
			Spielfeld y2 = new Spielfeld(FeldTyp.Startfeld, farbe, 49);
			Spielfeld y3 = new Spielfeld(FeldTyp.Startfeld, farbe, 50);
			Spielfeld y4 = new Spielfeld(FeldTyp.Startfeld, farbe, 51);
			fig_1 = new Spielfigur(farbe, y1);
			fig_2 = new Spielfigur(farbe, y2);
			fig_3 = new Spielfigur(farbe, y3);
			fig_4 = new Spielfigur(farbe, y4);
			break;
		default: throw new RuntimeException("Farbe existiert nicht");
		}
	}
}
