package classes;
/**
 * Die Klasse fuer die KI
 * @author Johannes Mändle
 *
 */

public abstract class KI {

	private Spieler spieler;
	private Spiel spiel;
	/**
	 * Konstruktor
	 */
	public KI(Spieler spieler, Spiel spiel){
		if (spieler == null) throw new RuntimeException("Spieler muss vorhanden sein!");	
		this.spieler = spieler;
		if(spiel==null) throw new RuntimeException ("Spiel sollte vorhanden sein");
		this.spiel=spiel;
	} 
	
	private void geheAufEndfeld(){
		int neueId;
		for(int i=0; i<4; i++){
		neueId = ueberlauf(spieler.getFigur(i).getPosition().getId() + spiel.getBewegungsWert());
		} 
		
		
	}
	
	private boolean zugGueltig(int zugtyp, int neueId){
		switch(zugtyp)
		{
		case 1: 
			switch(spieler.getFarbe())
			{
			case rot: 
				if(neueId<43){
					for(int i=0; i<4; i++){
						if(spiel.figurAufFeld(68+i)){
							
						}
					}
				}
			
			}
		
		
		}
	}
	
	private boolean kannEndfeldErreichen(int neueId){
		switch(spieler.getFarbe())
		{
		case rot: if(neueId>39) return true; return false;
		case blau: neueId=ueberlauf(neueId); if(neueId>9) return true; return false;
		case gruen: neueId=ueberlauf(neueId); if(neueId>19) return true; return false;
		case gelb: neueId=ueberlauf(neueId); if(neueId>29) return true; return false;
		
		default: return false;
		}
	}
	
	private int ueberlauf(int neueId){
		if(neueId>39){ 
		return	neueId-39;
		}return neueId;
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
