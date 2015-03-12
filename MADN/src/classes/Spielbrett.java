package classes;
/**
 * Klasse Spielbrett
 * @author Patrick Smuda
 * @version 0.1
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
			spielbrett[n] = new Spielfeld(FeldTyp.Normalfeld, null);
		}
		
		//Die Startfelder der Spieler
		for (int n = 40; n < 44; n++) {
			spielbrett[n] = new Spielfeld(FeldTyp.Startfeld, FarbEnum.blau);
		}
		for (int n = 44; n < 48; n++) {
			spielbrett[n] = new Spielfeld(FeldTyp.Startfeld, FarbEnum.grün);
		}
		for (int n = 48; n < 52; n++) {
			spielbrett[n] = new Spielfeld(FeldTyp.Startfeld, FarbEnum.gelb);
		}
		for (int n = 52; n < 56; n++) {
			spielbrett[n] = new Spielfeld(FeldTyp.Startfeld, FarbEnum.rot);
		}
		
		//Die Endfelder der Spieler
		for(int n = 56; n < 60; n++){
			spielbrett[n] = new Spielfeld(FeldTyp.Endfeld, FarbEnum.blau);
		}
		for(int n = 60; n < 64; n++){
			spielbrett[n] = new Spielfeld(FeldTyp.Endfeld, FarbEnum.gelb);
		}
		for(int n = 64; n < 68; n++){
			spielbrett[n] = new Spielfeld(FeldTyp.Endfeld, FarbEnum.grün);
		}
		for(int n = 68; n < 72; n++){
			spielbrett[n] = new Spielfeld(FeldTyp.Endfeld, FarbEnum.rot);
		}
	}
	
	
	public Spielfeld[] getSpielbrett(){
		return this.spielbrett;
	}
	
	private void setSpielbrett(Spielfeld[] spielbrett) {
		this.spielbrett = spielbrett;
	}
	
}

