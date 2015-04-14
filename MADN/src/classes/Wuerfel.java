package classes;

import java.io.Serializable;

/**
 * Klasse Wuerfel
 * @author Sebastian Stumm, Johannes M�ndle
 * @version 1.0
 */
public class Wuerfel implements Serializable{
	
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
		return zahl;
	}
	public int werfen2(){
		int zahl = 2;
		return zahl;
	}
	public int werfen6(){
		int zahl = 6;
		return zahl;
	}
	public int werfen42(){
		int zahl = 42;
		return zahl;
	}
	
//	public int werfen(){
//		return (int)6;
//	}
}
