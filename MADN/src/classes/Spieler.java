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
	private Spielfigur[] spielfigur;
	private Spielbrett spielbrett;
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
		spielfigur  = new Spielfigur[3];
		spielbrett = new Spielbrett();
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
			for(int i =0; i<spielfigur.length; i++){
				//spielfigur[i] = new Spielfigur(farbe, r1);
			}
			break;
		case blau: 
			this.farbe = FarbEnum.blau; 
			for(int i =0; i<spielfigur.length; i++){
				//spielfigur[i] = new Spielfigur(farbe, r1);
			}
			break;
		case grün: 
			this.farbe = FarbEnum.grün;
			for(int i =0; i<spielfigur.length; i++){
				//spielfigur[i] = new Spielfigur(farbe, r1);
			}
			break;
		case gelb: 
			this.farbe = FarbEnum.gelb;
			for(int i =0; i<spielfigur.length; i++){
				//spielfigur[i] = new Spielfigur(farbe, r1);
			}
			break;
		default: throw new RuntimeException("Farbe existiert nicht");
		}
	}
}
