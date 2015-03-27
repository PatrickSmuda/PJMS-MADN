package classes;
/**
 * Die Klasse fuer die KI
 * @author Johannes Mändle
 *
 */

public abstract class KI {

	private Spieler spieler;
	private Spiel spiel;
	private boolean hatUeberlauf;
	/**
	 * Konstruktor
	 */
	public KI(Spieler spieler, Spiel spiel){
		if (spieler == null) throw new RuntimeException("Spieler muss vorhanden sein!");	
		this.spieler = spieler;
		
		if(spiel==null) throw new RuntimeException ("Spiel sollte vorhanden sein");
		this.spiel=spiel;
		
		hatUeberlauf=false;
	} 
	
	private void geheAufEndfeld(){
		int neueId;
		for(int i=0; i<4; i++){
		neueId = ueberlauf(spieler.getFigur(i).getPosition().getId() + spiel.getBewegungsWert());
		if(kannEndfeldErreichen(neueId)){
			if(zugGueltigEndfeld(neueId)){
				spiel.bewege(i); break;
			}
		}
		} 
	}
	
	private boolean zugGueltigEndfeld(int neueId){
		
			switch(spieler.getFarbe())
			{
			case rot: 
				if(neueId<44){
					for(int i=0; i<4; i++){
						if(spiel.figurAufFeld(68+i)&&(i<neueId-39)){
							return false;
						}return true;
					}
				}
			case blau:
				if(neueId<14 && hatUeberlauf){
					for(int i=0; i<4; i++){
						if(spiel.figurAufFeld(56+i)&&(i<neueId-9)){
							return false;
						}return true;
					}
				}
			case gruen:
				if(neueId<24 && hatUeberlauf){
					for(int i=0; i<4; i++){
						if(spiel.figurAufFeld(64+i)&&(i<neueId-19)){
							return false;
						}return true;
					}
				}
			case gelb:
				if(neueId<34 && hatUeberlauf){
					for(int i=0; i<4; i++){
						if(spiel.figurAufFeld(60+i)&&(i<neueId-29)){
							return false;
						}return true;
					}
				}
				default: return false;
			}
			
		
		
		}
	
	
	private boolean kannEndfeldErreichen(int neueId){
		switch(spieler.getFarbe())
		{
		case rot: if(neueId>39) return true; return false;
		case blau: neueId=ueberlauf(neueId); if(neueId>9&&hatUeberlauf) return true; return false;
		case gruen: neueId=ueberlauf(neueId); if(neueId>19&&hatUeberlauf) return true; return false;
		case gelb: neueId=ueberlauf(neueId); if(neueId>29&&hatUeberlauf) return true; return false;
		
		default: return false;
		}
	}
	
	private int ueberlauf(int neueId){
		if(neueId>39){ 
		hatUeberlauf=true;
		return	neueId-39;
		}hatUeberlauf=false;
		return neueId;
	}
	
	
	private boolean betreteSpielfeld(){
     
	}
	
	private boolean schlageGegner(){
		
	}
	
	private boolean laufEinfach(){ 
		
	}
	
	public void ausfuehren(){ 
		
	}
	
	public abstract void kalkuliereSpielzug();

}
