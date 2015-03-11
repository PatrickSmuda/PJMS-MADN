package classes;
/**
 * Klasse Würfel
 * @author Sebastian Stumm, Johannes Mändle
 * @version 1.0
 */
public class Würfel {

	public Würfel(){
		
	}
	
	/**
	 * Funktion werfen()
	 * @return Die Funktion liefert eine Ganzzahl zwischen 1 und 6 zurück
	 */
	public static int werfen(){
		return (int)((Math.random()*6)+1);
	}
	
}
