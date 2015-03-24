package classes;
/**
 * Klasse Wuerfel
 * @author Sebastian Stumm, Johannes M�ndle
 * @version 1.0
 */
public class Wuerfel {
	
	/**
	 * Default-Konstruktor der Klasse Wuerfel
	 */
	public Wuerfel(){
		
	}
	
	/**
	 * Funktion werfen()
	 * @return Die Funktion liefert eine Ganzzahl zwischen 1 und 6 zurueck
	 */
	public int werfen(){
		int zahl = (int)((Math.random()*6)+1);
		System.out.println("W�rfel Zahl: "+ zahl);
		return zahl;
	}
	
	
//	public int werfen(){
//		return (int)6;
//	}
}
