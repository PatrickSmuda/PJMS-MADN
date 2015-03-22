package classes;
/**
 * Die Klasse fuer die KI
 * @author Johannes Mändle
 *
 */

class KI {

	private Spieler spieler;
	/**
	 * Konstruktor
	 */
	public KI(Spieler spieler){
		if (spieler == null) throw new RuntimeException("Spieler muss vorhanden sein!");	
		this.spieler = spieler;
	} 

}
