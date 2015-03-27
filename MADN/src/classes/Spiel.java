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
	

	/**
	 * Der Konstruktor für die Klasse Spiel erstellt ein Spielbrett und setzt die Anfangswerte
	 */
	public Spiel(){
		this.spielbrett = new Spielbrett();
		this.hatGewuerfelt = false;
		this.darfWuerfeln = true;
		this.spielHatBegonnen = false;
		this.spieler = new ArrayList<Spieler>();
	}

	/**
	 * Fuegt dem Spiel einen Spieler hinzu.
	 * @param spieler Der Spieler, der hinzugefuegt werden soll.
	 */
	public void spielerHinzufuegen(Spieler spieler){
		if(!spielHatBegonnen){
			if(spieler == null) 
				throw new RuntimeException("Spieler existiert nicht!");
			for(int i = 0; i < this.spieler.size(); i++){
				if(this.spieler.get(i).getFarbe() == spieler.getFarbe()) throw new RuntimeException("Der Spieler mit dieser Farbe nimmt bereits am Spiel teil!");
			}
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
	public void bewege(Spielfigur sf){
		if(spielHatBegonnen){
			if(sf == null || sf.getFarbe() != this.spielerAmZug.getFarbe()) throw new RuntimeException("Figur existiert nicht oder hat die falsche Farbe!");
			if(hatGewuerfelt == false) throw new RuntimeException("Erst wuerfeln!");
			
			int neuePosition;
			
			if(sf.getPosition().getTyp() != FeldTyp.Startfeld){
				//if(!kannLaufen(sf)) ungueltigerZug();
				neuePosition = sf.getPosition().getId();
				neuePosition += bewegungsWert;
				neuePosition = ueberlauf(neuePosition);
				if(userIstDumm(neuePosition, sf)) zugBeenden();
				if(kannLaufen(neuePosition, sf))
				spielbrett.getFeld(neuePosition).setFigur(sf);
				sf.setPosition(spielbrett.getFeld(neuePosition));
				hatGewuerfelt = false;
				if(bewegungsWert != 6) zugBeenden();
			} else if(sf.getPosition().getTyp() == FeldTyp.Startfeld && bewegungsWert == 6){
				neuePosition = sf.getFreiPosition();
				if(userIstDumm(neuePosition, sf)) zugBeenden();
				spielbrett.getFeld(neuePosition).setFigur(sf);
				sf.setPosition(spielbrett.getFeld(neuePosition));
				hatGewuerfelt = false;
			} else if(sf.getPosition().getTyp() == FeldTyp.Startfeld && bewegungsWert != 6){
				hatGewuerfelt = false;
				zugBeenden();
			}
		}
		
	}
	
	private int ueberlauf(int neuePosition){
		if(neuePosition > 39){
			return (neuePosition-39);
		}
		return neuePosition;
	}
	
	/**
	 * Die Methode wird ausgefuehrt, wenn ein Zug ungueltig ist.
	 */
	private void ungueltigerZug(){
		zugBeenden();
	}
	
	private boolean figurAufEndfeld(int id){
		for(int i = 0; i < 3; i++){
			if(spielbrett.getFeld(id+i).getFigur() != null) return true;
		}
		return false;
	}
	
	public int getBewegungsWert(){
		if(hatGewuerfelt){
			return this.bewegungsWert;
		}else throw new RuntimeException ("Hat noch nicht nicht gewürfelt.");
	}
	
	
	
	public boolean figurAufFeld(int id){
		if(id<0 || id>72){ 
			throw new RuntimeException ("Feld existiert nicht.");
		}
		if(spielbrett.getFeld(id).getFigur()!=null) return true;
		return false;
	}
	
	
	/**
	 * Ueberprueft ob eine Spielfigur laufen darf.
	 * @param sf Die zu ueberprüfende Spielfigur.
	 * @return boolean Gibt einen boolschen Wert zurueck.
	 */
	private boolean kannLaufen(int neuePosition, Spielfigur sf){
		switch(sf.getFarbe())
		{
		case rot:
			if(neuePosition > 1){
				if(figurAufEndfeld(68)) return false;
			}return true;
		case blau:
			if(neuePosition > 11){
				if(figurAufEndfeld(56)) return false;
			}return true;
		case gruen:
			if(neuePosition > 21){
				if(figurAufEndfeld(64)) return false;
			}return true;
		case gelb:
			if(neuePosition > 31){
				if(figurAufEndfeld(60)) return false;
			}return true;
		default: return false;
		}
		
		
	}
	
	/**
	 * Gibt den Spieler der am Zug ist zurueck
	 * @return spielerAmZug
	 */
	public String getSpielerAmZug(){
		return this.spielerAmZug.getName();
	}
	
	
	/**
	 * Wird aufgerufen, wenn der User versucht seine eigene Figur zu schlagen.
	 * @param neuePosition Die neue Position der Figur.
	 * @param sf Die Spielfigur 
	 * @return boolean Boolscher Rueckgabewert
	 */ 
	private boolean userIstDumm(int neuePosition, Spielfigur sf){
		if((spielbrett.getFeld(neuePosition).getFigur() != null) && (spielbrett.getFeld(neuePosition).getFigur().getFarbe() == sf.getFarbe())) return true;
		return false;
	}

	/**
	 * Ueberprueft ob ein Spieler eine freie Figur hat
	 * @param spieler Der zu ueberpruefende Spieler
	 * @return Gibt einen boolschen wert zurueck, ob der Spieler eine freie Figur hat.
	 */
	private boolean hatFreieFigur(Spieler spieler){
		if(spieler.getFigur(0).getPosition().getTyp() == FeldTyp.Startfeld &&
				spieler.getFigur(1).getPosition().getTyp() == FeldTyp.Startfeld &&
				spieler.getFigur(2).getPosition().getTyp() == FeldTyp.Startfeld &&
				spieler.getFigur(3).getPosition().getTyp() == FeldTyp.Startfeld )return false;
		return true;
	}

	/**
	 * Setzt eine Spielfigur auf die Startposition zurueck.
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
	 * Die Methode wuerfelt.
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
	 * Gibt zurueck, welcher Spieler gewonnen hat.
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
		for(int i =0; i< spieler.size(); i++){
			if(spieler.get(i) == spielerAmZug){
				if(i == 3){
					spielerAmZug = spieler.get(0);
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

}
