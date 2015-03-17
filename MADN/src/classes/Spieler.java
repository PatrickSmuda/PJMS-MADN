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
	public Spieler(String name, FarbEnum farbe, KI ki, Spielbrett spielbrett)
	{
		if (zähler > 4) throw new RuntimeException("Zu viele Spieler");
		if(name == null) throw new RuntimeException("Ungültiger Name!");
		if (spielbrett == null) throw new RuntimeException("Kein Spielbrett");
		if (ki != null) this.ki = ki;
		this.spielbrett = spielbrett;
		this.name = name;
		würfel = new Würfel();
		spielfigur  = new Spielfigur[4];
		figurenInit(farbe);
		zähler++;
	}

	/**
	 * Gibt eine der vier Spielfiguren zurück
	 * @param n Figur 1, 2, 3 oder 4
	 * @return Spielfigur Gibt die Spielfigur zurück
	 */
	public Spielfigur getFigur(int n){
		if (n <0 || n>3) throw new RuntimeException("Ungültige Position");
		if(spielfigur == null || spielfigur.length == 0) throw new RuntimeException("Keine Spielfiguren vorhanden");
		return spielfigur[n];
	}
	
	/**
	 * Gibt den Würfel des Spielers zurück
	 * @return würfel 
	 */
	public Würfel getWürfel(){
		return this.würfel;
	}
	
	/**
	 * Die Methode initialisiert die Spielfiguren mit der übergebenen Farbe 
	 * und stellt sie auf ihre jeweilige Startposition.
	 * @param farbe Die Farbe der Spielfiguren
	 */
	private void figurenInit(FarbEnum farbe)
	{
		switch(farbe)
		{
		case rot: 
			this.farbe = FarbEnum.rot; 
			int z = 40;
			
			for(int i =0; i<spielfigur.length; i++){
				spielfigur[i] = new Spielfigur(farbe, spielbrett.getFeld(z));
				spielbrett.getFeld(z).setFigur(spielfigur[i]);
				z++;
			}
			break;
		case blau: 
			this.farbe = FarbEnum.blau; 
			int z1 = 44;
			for(int i =0; i<spielfigur.length; i++){
				spielfigur[i] = new Spielfigur(farbe, spielbrett.getFeld(z1));
				spielbrett.getFeld(z1).setFigur(spielfigur[i]);
				z1++;
			}
			break;
		case grün: 
			this.farbe = FarbEnum.grün;
			int z2=48;
			for(int i =0; i<spielfigur.length; i++){
				spielfigur[i] = new Spielfigur(farbe, spielbrett.getFeld(z2));
				spielbrett.getFeld(z2).setFigur(spielfigur[i]);
				z2++;
			}
			break;
		case gelb: 
			this.farbe = FarbEnum.gelb;
			int z3=52;
			for(int i =0; i<spielfigur.length; i++){
				spielfigur[i] = new Spielfigur(farbe, spielbrett.getFeld(z3));
				spielbrett.getFeld(z3).setFigur(spielfigur[i]);
				z3++;
			}
			break;
		default: throw new RuntimeException("Farbe nicht verfügbar");
		}
	}
}
