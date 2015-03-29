package classes;
/**
 * Die Klasse fuer die KI
 * @author 
 *
 */

public abstract class KI {

	/**
	 * Attribute der Klasse KI
	 */
	
	private Spieler spieler;
	private Spiel spiel;
	private boolean hatUeberlauf;
//	private Spielfigur sf;
	/**
	 * Konstruktor, uebergibt Spieler und Spiel
	 */
	public KI(Spieler spieler, Spiel spiel){
		if (spieler == null) throw new RuntimeException("Spieler muss vorhanden sein!");	
		this.spieler = spieler;
		
		if(spiel==null) throw new RuntimeException ("Spiel sollte vorhanden sein");
		this.spiel=spiel;
		
		hatUeberlauf=false;
	} 
	
	/**
	 * Methode bewegt die Figur zum Endfeld
	 * */
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
	/**
	 * Hilfsmethode fuer die geheAufEndfeld, vermeidet dass die Spielfigur ueberspringen
	 * 
	 * @return neueId
	 */
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
	
	/**
	 * Methode um zu verhindern damit die Figur nicht ueber die Felder geht, ueber die sie nicht soll
	 * (kommentar sollte man evtl aendern)
	 * @param neueId
	 * @return neueId
	 */
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
	/**
	 * Hilfsmethode die einen ueberlauf erzeugt
	 * @param neueId
	 * @return die neueId
	 */
	private int ueberlauf(int neueId){
		if(neueId>39){ 
		hatUeberlauf=true;
		return	neueId-39;
		}hatUeberlauf=false;
		return neueId;
	}
	
	
	private void betreteSpielfeld(){
		
		if(spiel.getBewegungsWert()==6){
		for(int i=0; i<4; i++){
    	 if(spieler.getFigur(i).getPosition().getTyp()==FeldTyp.Startfeld){
    	 spiel.bewege(i);
    	 break;
     }
	}
	}
	}
	
	
	private void schlageGegner(){
		
		for(int i=0; i<4; i++){
			if(spiel.figurAufFeld(ueberlauf(spiel.getBewegungsWert()+spieler.getFigur(i).getPosition().getId()))){
				for(int j=0; j<4; i++){
					if(spieler.getFigur(j).getPosition().getId()==ueberlauf(spiel.getBewegungsWert()+spieler.getFigur(i).getPosition().getId())){
						
					}else{
						spiel.bewege(i); break;
					}
				}
			}
		}
	}
	
	private void laufEinfach(){ 
		
		int groessteId=spieler.getFigur(0).getPosition().getId();
		int figurId=0; // Figur mit der größten ID
		
		for(int i=1; i<4; i++){ 
			if(groessteId<spieler.getFigur(i).getPosition().getId()){
				groessteId=spieler.getFigur(i).getPosition().getId();
				figurId=i;
			}
		}
		spiel.bewege(figurId);
	}
	
	
	
	public abstract void kalkuliereSpielzug();

}
