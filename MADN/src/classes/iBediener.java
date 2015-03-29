package classes;
/**
 * Das Interface iBediener
 * @author 
 * @version 1.0
 */

public interface iBediener {
	
	public void wuerfeln();
	
	public void bewege(int id);
	
	public void spielerHinzufuegen(String name, FarbEnum farbe);
	
	public void beginneSpiel();
	
	public String getSpielerAmZug();
	
	public int getBewegungsWert();
	
	public boolean figurAufFeld(int id);
	
	}
