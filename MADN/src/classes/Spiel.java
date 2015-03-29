package classes;

/**
 * Die Klasse Spiel 
 * @author Sebastian Stumm, Johannes Mändle
 * @version 1.0
 */


import java.util.ArrayList;

import javax.management.RuntimeErrorException;

public class Spiel implements iBediener {

	/**
	 * Die Attribute der Klasse Spiel.
	 */
	private Spielbrett spielbrett;
	private ArrayList<Spieler> spieler; 
	private Spieler spielerAmZug;
	private Spielfigur ausgewaehlteFigur;
	private boolean darfWuerfeln;
	private int bewegungsWert;
	private boolean hatGewuerfelt;
	private Spieler gewinner;
	private boolean spielHatBegonnen;
	private boolean hatUeberlauf;
	

	/**
	 * Der Konstruktor für die Klasse Spiel erstellt ein Spielbrett und setzt die Anfangswerte
	 */
	public Spiel(){
		this.spielbrett = new Spielbrett();
		this.hatGewuerfelt = false;
		this.darfWuerfeln = true;
		this.spielHatBegonnen = false;
		this.spieler = new ArrayList<Spieler>();
		this.hatUeberlauf = false;
	}

	public int getBewegungsWert(){
		return this.bewegungsWert;
	}
	
	/**
	 * Fügt dem Spiel einen Spieler hinzu.
	 * @param spieler Der Spieler, der hinzugefügt werden soll.
	 */
public void spielerHinzufuegen(String name, FarbEnum farbe){
		
		boolean rotvorhanden = false;
		boolean blauvorhanden = false;
		boolean gelbvorhanden = false;
		boolean gruenvorhanden = false;
		
		if(!spielHatBegonnen){
			if(spieler == null){
				throw new RuntimeException("Spieler existiert nicht!");
			}
			if (rotvorhanden == true || blauvorhanden == true || gelbvorhanden == true || gruenvorhanden == true) {
				throw new RuntimeException("Farbe bereits belegt");
			}
			
			switch (farbe) {
			case rot:
				rotvorhanden = true;
				break;
			case blau:
				rotvorhanden = true;
				break;
			case gelb:
				rotvorhanden = true;
				break;
			case gruen:
				rotvorhanden = true;
				break;				
			}
			
			Spieler spieler = new Spieler(name, farbe, null, spielbrett);
			this.spieler.add(spieler);
		}
		
	}
	/**
	 * Die Methode beginnt das Spiel.
	 */
	public void beginneSpiel(){
		if(this.spieler.size() >= 2){
			this.spielHatBegonnen = true;
			this.spielerAmZug = this.spieler.get(0);
		} else throw new RuntimeException("Spiel muss mindestens 2 Spieler haben!");
		
	}
	
	/**
	 * Methode zum bewegen der Spielfigur
	 * @param sf Spielfigur die bewegt wird
	 */
	public void bewege(int figurId){
		if(this.spielHatBegonnen){
			if(figurId > 4 || figurId < 0) throw new RuntimeException("Figur existiert nicht!");
			
			int neuePosition = this.spielerAmZug.getFigur(figurId).getPosition().getId() + this.bewegungsWert;
			
			if(this.bewegungsWert == 6 && this.spielerAmZug.getFigur(figurId).getPosition().getTyp() == FeldTyp.Startfeld){
				neuePosition = this.spielerAmZug.getFigur(figurId).getFreiPosition();
				if(userIstDumm(neuePosition, this.spielerAmZug.getFigur(figurId))){
					zugBeenden();
				}else{
					this.spielerAmZug.getFigur(figurId).setPosition(this.spielbrett.getFeld(neuePosition));
					this.spielerAmZug.getFigur(figurId).getPosition().setFigur(this.spielerAmZug.getFigur(figurId));
				}
			}
			
			else if(this.bewegungsWert != 6 && this.spielerAmZug.getFigur(figurId).getPosition().getTyp() == FeldTyp.Startfeld){
				zugBeenden();
			}
			
			else if(this.spielerAmZug.getFigur(figurId).getPosition().getTyp() != FeldTyp.Startfeld){
				neuePosition = ueberlauf(this.spielerAmZug.getFigur(figurId).getPosition().getId() + this.bewegungsWert);
				if(userIstDumm(neuePosition, this.spielerAmZug.getFigur(figurId))){
					zugBeenden();
				}else{
					if(kannEndfeldErreichen(neuePosition)){
						if(zugGueltigEndfeld(neuePosition)){
							this.spielerAmZug.getFigur(figurId).setPosition(this.spielbrett.getFeld(neuePosition));
							this.spielerAmZug.getFigur(figurId).getPosition().setFigur(this.spielerAmZug.getFigur(figurId));
						}
					}else{
						this.spielerAmZug.getFigur(figurId).setPosition(this.spielbrett.getFeld(neuePosition));
						this.spielerAmZug.getFigur(figurId).getPosition().setFigur(this.spielerAmZug.getFigur(figurId));
					}
					if(this.bewegungsWert != 6){
						zugBeenden();
					}
				}
			}
			
			hatGewuerfelt = false;
			
		}	
	}
	
	private int ueberlauf(int neuePosition){
		if(neuePosition > 39){
			hatUeberlauf = true;
			return (neuePosition-40);
		}
		hatUeberlauf = false;
		return neuePosition;
	}
	
	
	private boolean zugGueltigEndfeld(int neuePosition){
		switch(spielerAmZug.getFarbe())
		{
		case rot:
			if(neuePosition < 4 && hatUeberlauf){
				for(int i = 0; i < 4; i++){
					if(figurAufFeld(68+i) && i < neuePosition){
						return false;
					}return true;
				}
			}
			
		case blau:
			if(neuePosition < 14 && hatUeberlauf){
				for(int i = 0; i < 4; i++){
					if(figurAufFeld(56+i) && i < neuePosition-9){
						return false;
					}return true;
				}
			}
			
		case gruen:
			if(neuePosition < 24 && hatUeberlauf){
				for(int i = 0; i < 4; i++){
					if(figurAufFeld(64+i) && i < neuePosition-19){
						return false;
					}return true;
				}
			}
			
		case gelb:
			if(neuePosition < 34 && hatUeberlauf){
				for(int i = 0; i < 4; i++){
					if(figurAufFeld(60+i) && i < neuePosition-29){
						return false;
					}return true;
				}
			}
			
		default: return false;
			
		}
		

	}
	
	
	private boolean kannEndfeldErreichen(int neuePosition){
		switch(spielerAmZug.getFarbe())
		{
		case rot: 	if(neuePosition>=0&&hatUeberlauf) return true; return false;
		case blau:	if(neuePosition>9&&hatUeberlauf) return true; return false;
		case gruen:	if(neuePosition>19&&hatUeberlauf) return true; return false;
		case gelb:	if(neuePosition>29&&hatUeberlauf) return true; return false;
		default: return false;
		}
		}
	
	
	/**
	 * Die Methode wird ausgeführt, wenn ein Zug ungültig ist.
	 */
	private void ungueltigerZug(){
		zugBeenden();
	}
	
	public boolean figurAufFeld(int id){
		if(spielbrett.getFeld(id).getFigur() != null) 
			return true;
		return false;
	}
	
	/**
	 * Überprüft ob eine Spielfigur laufen darf.
	 * @param sf Die zu überprüfende Spielfigur.
	 * @return boolean Gibt einen boolschen Wert zurück.
	 */
	private boolean kannLaufen(int neuePosition, Spielfigur sf){
		switch(sf.getFarbe())
		{
		case rot:
			if(neuePosition > 1){
				if(figurAufFeld(68)) return false;
				return false;
			}return true;
		case blau:
			if(neuePosition > 11){
				if(figurAufFeld(56)) return false;
				return false;
			}return true;
		case gruen:
			if(neuePosition > 21){
				if(figurAufFeld(64)) return false;
				return false;
			}return true;
		case gelb:
			if(neuePosition > 31){
				if(figurAufFeld(60)) return false;
				return false;
			}return true;
		default: return false;
		}
		
		
	}
	
	/**
	 * Gibt den Spieler der am Zug ist zurück
	 * @return spielerAmZug
	 */
	public String getSpielerAmZug(){
		return this.spielerAmZug.getName();
	}
	
	
	/**
	 * Wird aufgerufen, wenn der User versucht seine eigene Figur zu schlagen.
	 * @param neuePosition Die neue Position der Figur.
	 * @param sf Die Spielfigur 
	 * @return boolean Boolscher Rückgabewert
	 */ 
	private boolean userIstDumm(int neuePosition, Spielfigur sf){
		if((spielbrett.getFeld(neuePosition).getFigur() != null) && (spielbrett.getFeld(neuePosition).getFigur().getFarbe() == sf.getFarbe())) return true;
		return false;
	}

	/**
	 * Überprüft ob ein Spieler eine freie Figur hat
	 * @param spieler Der zu überprüfende Spieler
	 * @return Gibt einen boolschen wert zurück, ob der Spieler eine freie Figur hat.
	 */
	private boolean hatFreieFigur(Spieler spieler){
		if(spieler.getFigur(0).getPosition().getTyp() == FeldTyp.Startfeld &&
				spieler.getFigur(1).getPosition().getTyp() == FeldTyp.Startfeld &&
				spieler.getFigur(2).getPosition().getTyp() == FeldTyp.Startfeld &&
				spieler.getFigur(3).getPosition().getTyp() == FeldTyp.Startfeld )return false;
		return true;
	}

	/**
	 * Setzt eine Spielfigur auf die Startposition zurück.
	 * @param figur Die Spielfigur
	 */
	private void aufStartPositionSetzen(Spielfigur figur){
		switch(figur.getFarbe())
		{
		case rot: this.spielbrett.getFeld(0).setFigur(figur); break;
		case blau: this.spielbrett.getFeld(11).setFigur(figur); break;
		case gruen: this.spielbrett.getFeld(21).setFigur(figur); break;
		case gelb: this.spielbrett.getFeld(31).setFigur(figur); break;
		}
	}

	/**
	 * Die Methode würfelt.
	 */
	public void wuerfeln(){
		if(spielHatBegonnen){
			if(this.darfWuerfeln == true && this.hatGewuerfelt == false){
				this.bewegungsWert = this.spielerAmZug.getWuerfel().werfen();
				if(this.bewegungsWert == 6) this.darfWuerfeln = true;
				else this.darfWuerfeln = false;
				hatGewuerfelt = true;
			}else throw new RuntimeException("Darf nicht 2 mal Wuerfeln!");
		}
		
	}

	/**
	 * Gibt zurück, welcher Spieler gewonnen hat.
	 * @param gewinner Der Spieler der gewonnen hat.
	 */
	private void spielGewonnen(Spieler gewinner){
		System.out.println("Der Gewinner ist: " + gewinner.getName());
	}
	
	/**
	 * Die Methode beendet einen Zug.
	 */
	private void zugBeenden(){
		int zaehler=0;
		for(int i =0; i<4; i++){
			if (spielerAmZug.getFigur(i).getPosition().getTyp() == FeldTyp.Endfeld){
				zaehler++;
			}
		}
		if (zaehler == 3) {
			spielGewonnen(spielerAmZug);
			return;
		}
		for(int i = 0; i< spieler.size(); i++){
			if(i+1 > spieler.size()){
				spielerAmZug = spieler.get(i-spieler.size());
				darfWuerfeln = true;
				break;
			}else{
				spielerAmZug = spieler.get(i+1);
				darfWuerfeln = true;
				break;
			}
			
			
		}
	}

}
