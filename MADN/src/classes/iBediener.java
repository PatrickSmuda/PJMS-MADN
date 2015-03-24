package classes;
/**
 * Das Interface iBediener
 * @author 
 * @version 1.0
 */

public interface iBediener {
	
	public void wuerfeln();
	
	public void bewege(Spielfigur figur);
	
	public void spielerHinzufuegen(Spieler spieler);
	
	public void beginneSpiel();
	
	public Spieler getSpielerAmZug();
	
	}
