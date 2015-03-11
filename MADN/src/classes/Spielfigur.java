package classes;
/**
 * Die Klasse Spielfigur
 * @author Sebastian Stumm
 * @version 1.0
 */
public class Spielfigur {
	private FarbEnum farbe;
	private Spielfeld position;
	
	/**
	 * Der Konstruktor setzt die Farbe und Startposition der Figur
	 * @param farbe Farbe der Spielfigur
	 * @param position Spielfeld auf der die Spielfigur startet
	 */
	public Spielfigur(FarbEnum farbe, Spielfeld position){
		if(farbe == null || position == null || position.getFigur() != null) throw new RuntimeException("Ungültige Farbe oder Position der Spielfigur");
		this.farbe = farbe;
		this.position = position;
	}
	/**
	 * Die Methode gibt die Farbe der Figur zurück
	 * @return farbe, die Farbe der Figur 
	 */
	public FarbEnum getFarbe(){
		return this.farbe;
	}
	
	public void bewegeAuf(Spielfeld position){
		if(position == null || position.getFigur() != null) throw new RuntimeException("Spielfeld auf das die Spielfigur laufen soll existiert nicht");
		this.position = position;
	}

}

