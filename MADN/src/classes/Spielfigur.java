package classes;
/**
 * Die Klasse Spielfigur
 * @author Sebastian Stumm
 * @version 1.0
 */
public class Spielfigur {
	private FarbEnum farbe;
	private Spielfeld position;
	
	private static int anz_rot;
	private static int anz_blau;
	private static int anz_grün;
	private static int anz_gelb;
	
	/**
	 * Der Konstruktor setzt die Farbe und Startposition der Figur
	 * @param farbe Farbe der Spielfigur
	 * @param position Spielfeld auf der die Spielfigur startet
	 */
	public Spielfigur(FarbEnum farbe, Spielfeld position){
		if(farbe == null || position == null || position.getFigur() != null) throw new RuntimeException("Ungültige Farbe oder Position der Spielfigur");
		this.farbe = farbe;
		this.position = position;
		switch(this.farbe)
		{
		case rot: if(this.anz_rot >= 4)throw new RuntimeException("Mehr als 4 Figuren sind nicht erlaubt!"); this.anz_rot++; break;
		case blau: if(this.anz_blau >= 4)throw new RuntimeException("Mehr als 4 Figuren sind nicht erlaubt!"); this.anz_blau++; break;
		case grün: if(this.anz_grün >= 4)throw new RuntimeException("Mehr als 4 Figuren sind nicht erlaubt!"); this.anz_grün++; break;
		case gelb: if(this.anz_gelb >= 4)throw new RuntimeException("Mehr als 4 Figuren sind nicht erlaubt!"); this.anz_gelb++; break;
		}
	}
	/**
	 * Die Methode gibt die Farbe der Figur zurück
	 * @return farbe, die Farbe der Figur 
	 */
	public FarbEnum getFarbe(){
		return this.farbe;
	}
	/**
	 * Die Methode setzt die Spielfigur auf das Startfeld zurück
	 */
	public void geschlagen(Spielfeld position){
		/*(position.getFigur().getFarbe())
		{
		case rot: position.getFigur().position = startfeld wenn frei;break;
		case blau: break;
		case grün: break;
		case gelb: break;
		default: throw new RuntimeException("Farbe der Figur nicht vorhanden");
		}
		*/
	}
	/**
	 * Methode zum bewegen der Spielfigur
	 * @param position Position auf welche die Spielfigur zieht
	 */
	public void bewegeAuf(Spielfeld position){
		if(position == null) throw new RuntimeException("Spielfeld auf das die Spielfigur laufen soll existiert");
		if(position.getFigur() != null) position.getFigur().geschlagen(position);
		this.position = position;
	}

}

