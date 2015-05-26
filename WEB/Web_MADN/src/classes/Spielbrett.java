package classes;

import java.io.Serializable;

/**
 * Klasse Spielbrett
 * @author Patrick Smuda
 * @version 1.0
 */
public class Spielbrett implements Serializable{
	
	private Spielfeld[] spielbrett;
	
	/**
	 * Der Konstruktor setzt das Spielfeld fest
	 */
	public Spielbrett(){
		
		spielbrett = new Spielfeld[72];
		
		//Normale Spielfelder (ID´s 0 - 39)
		for (int n = 0; n < 40; n++) {
			spielbrett[n] = new Spielfeld(FeldTyp.Normalfeld, null, n);
		}
		
		//Die Startfelder der Spieler (ID´s 40 - 55)
		for (int n = 40; n < 44; n++) {
			spielbrett[n] = new Spielfeld(FeldTyp.Startfeld, FarbEnum.rot, n);
		}
		for (int n = 44; n < 48; n++) {
			spielbrett[n] = new Spielfeld(FeldTyp.Startfeld, FarbEnum.blau, n);
		}
		for (int n = 48; n < 52; n++) {
			spielbrett[n] = new Spielfeld(FeldTyp.Startfeld, FarbEnum.gruen, n);
		}
		for (int n = 52; n < 56; n++) {
			spielbrett[n] = new Spielfeld(FeldTyp.Startfeld, FarbEnum.gelb, n);
		}
		
		//Die Endfelder der Spieler (ID´s 56 - 71)
		for(int n = 56; n < 60; n++){
			spielbrett[n] = new Spielfeld(FeldTyp.Endfeld, FarbEnum.blau, n);
		}
		for(int n = 60; n < 64; n++){
			spielbrett[n] = new Spielfeld(FeldTyp.Endfeld, FarbEnum.gelb, n);
		}
		for(int n = 64; n < 68; n++){
			spielbrett[n] = new Spielfeld(FeldTyp.Endfeld, FarbEnum.gruen, n);
		}
		for(int n = 68; n < 72; n++){
			spielbrett[n] = new Spielfeld(FeldTyp.Endfeld, FarbEnum.rot, n);
		}
	}

	
	/**
	 * Gibt das Spielfeld mit der uebergebenen ID zurueck
	 * @param id Spielfeld-ID
	 * @return Spielfeld Das angefragte Spielfeld
	 */
	public Spielfeld getFeld(int id){
		if(id < 0 || id > 72) 
			throw new RuntimeException("Feld existiert nicht!");
		return this.spielbrett[id];
	}
	
}
