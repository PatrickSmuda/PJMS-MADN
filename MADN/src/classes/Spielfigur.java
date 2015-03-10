package classes;
/**
 * Die Klasse Spielfigur
 * @author Sebastian Stumm
 * @version 1.0
 */
public class Spielfigur {
	private FarbEnum farbe;
	private int position;
	
	/**
	 * Der Konstruktor setzt die Farbe der Figur
	 * @param farbe Farbe der Figut
	 */
	public Spielfigur(FarbEnum farbe){
		this.farbe = farbe;
	}
	/**
	 * Die Methode gibt die Farbe der Figur zurück
	 * @return farbe, die Farbe der Figur 
	 */
	public FarbEnum getFarbe(){
		return this.farbe;
	}

}

