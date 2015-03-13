package classes;
/**
 * Klasse Spielbrett
 * @author Patrick Smuda
 * @version 0.2
 */
public class Spielbrett{
	
	private Spielfeld[] spielbrett;
	
	/**
	 * Der Konstruktor setzt das Spielfeld fest
	 * @param typ Typ des Feldes
	 * @param farbe Farbe des Feldes
	 */
	public Spielbrett(FeldTyp typ, FarbEnum farbe){
		
		spielbrett = new Spielfeld[72];
		
		//Normale Spielfelder
		for (int n = 0; n < 40; n++) {
			spielbrett[n] = new Spielfeld(FeldTyp.Normalfeld, null, n);
		}
		
		//Die Startfelder der Spieler
		for (int n = 40; n < 44; n++) {
			spielbrett[n] = new Spielfeld(FeldTyp.Startfeld, FarbEnum.blau, n);
		}
		for (int n = 44; n < 48; n++) {
			spielbrett[n] = new Spielfeld(FeldTyp.Startfeld, FarbEnum.grün, n);
		}
		for (int n = 48; n < 52; n++) {
			spielbrett[n] = new Spielfeld(FeldTyp.Startfeld, FarbEnum.gelb, n);
		}
		for (int n = 52; n < 56; n++) {
			spielbrett[n] = new Spielfeld(FeldTyp.Startfeld, FarbEnum.rot, n);
		}
		
		//Die Endfelder der Spieler
		for(int n = 56; n < 60; n++){
			spielbrett[n] = new Spielfeld(FeldTyp.Endfeld, FarbEnum.blau, n);
		}
		for(int n = 60; n < 64; n++){
			spielbrett[n] = new Spielfeld(FeldTyp.Endfeld, FarbEnum.gelb, n);
		}
		for(int n = 64; n < 68; n++){
			spielbrett[n] = new Spielfeld(FeldTyp.Endfeld, FarbEnum.grün, n);
		}
		for(int n = 68; n < 72; n++){
			spielbrett[n] = new Spielfeld(FeldTyp.Endfeld, FarbEnum.rot, n);
		}
	}
	
	public Spielfeld[] getSpielbrett(){
		return this.spielbrett;
	}
	
}

