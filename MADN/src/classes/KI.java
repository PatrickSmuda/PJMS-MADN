package classes;

import java.util.ArrayList;

/**
 * Die Klasse fuer die KI
 * @author 
 *
 */

public abstract class KI {

	/**
	 * Attribute der Klasse KI
	 */

	protected Spieler spieler;
	protected iBediener spiel;
	private boolean hatUeberlauf;
	private ArrayList<Spielfigur> figurenUeberlauf;
	
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
	protected boolean geheAufEndfeld(){
		int neueId;
		for(int i=0; i<4; i++)
		{
			if(spieler.getFigur(i).getPosition().getTyp() == FeldTyp.Normalfeld){
			neueId = spieler.getFigur(i).getPosition().getId() + spiel.getBewegungsWert();
			neueId = spiel.ueberlauf(neueId, i);
			if(spiel.kannEndfeldErreichen(neueId) && spiel.userIstDumm(neueId, i) == false){
				if(spiel.zugGueltigEndfeld(neueId)){
					if(spiel.endfeld(neueId) == neueId){
						
					}else{
						spiel.bewege(i);
						return true;
					}
				}
			}
			}
		} 
		return false;
	}
	
	/**
	 * Methode, die die Spielfiguren raus bewegt
	 */
	protected boolean betreteSpielfeld(){
		
		int neueId;
		
		if(spiel.getBewegungsWert()==6)
		{
			for(int i=0; i<4; i++){
				if(spieler.getFigur(i).getPosition().getTyp() == FeldTyp.Startfeld){
					neueId = spieler.getFigur(i).getFreiPosition();
					if(spiel.userIstDumm(neueId, i)){
						
					}else{
						spiel.bewege(i);
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 *Die Methode schlägt die gegnerische Figur
	 */
	protected boolean schlageGegner(){

		int neueId;
		
		for(int i=0; i<4; i++){
			if(spieler.getFigur(i).getPosition().getTyp() == FeldTyp.Startfeld){
				neueId = spieler.getFigur(i).getFreiPosition();
				if(!spiel.userIstDumm(neueId, i)){
					spiel.bewege(i);
					return true;
				}
			}
			
			if(spiel.figurAufFeld(spiel.ueberlauf(spiel.getBewegungsWert()+spieler.getFigur(i).getPosition().getId(), i)) && spieler.getFigur(i).getPosition().getTyp() != FeldTyp.Startfeld){
				for(int j=0; j<4; i++){
					if(spieler.getFigur(j).getPosition().getId()==spiel.ueberlauf(spiel.getBewegungsWert()+spieler.getFigur(i).getPosition().getId(), j)){
						
					}else{
						spiel.bewege(i); 
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Die Methode die die Spielfiguren zum Laufen bringt
	 */
	protected boolean laufEinfach(){ 

		int groessteId=spieler.getFigur(0).getPosition().getId();
		int figurId=0; // Figur mit der größten ID
		
		
		for(int i=1; i<4; i++)
		{ 
			if(spieler.getFigur(i).getPosition().getTyp() == FeldTyp.Normalfeld && groessteId<spieler.getFigur(i).getPosition().getId()){
				groessteId=spieler.getFigur(i).getPosition().getId();
				figurId=i;
			}
		}
		spiel.bewege(figurId);
		return true;
	}

	/**
	 * Führt den eigentlichen Spielzeug der KI aus
	 */
	public abstract void kalkuliereSpielzug();

}
