package classes;
/**
 * Klasse W�rfel
 * @author Sebastian Stumm, Johannes M�ndle
 * @version 1.0
 */
public class W�rfel {

	public W�rfel(){
		
	}
	
	/**
	 * Funktion werfen()
	 * @return Die Funktion liefert eine Ganzzahl zwischen 1 und 6 zur�ck
	 */
	public static int werfen(){
		return (int)((Math.random()*6)+1);
	}
	
}
