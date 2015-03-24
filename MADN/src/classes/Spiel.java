package classes;

import java.util.ArrayList;

import javax.management.RuntimeErrorException;

public class Spiel implements iBediener {

	private Spielbrett spielbrett;
	private ArrayList<Spieler> spieler; 
	private Spieler spielerAmZug;
	private Spielfigur ausgewaehlteFigur;
	private boolean darfWuerfeln;
	private int bewegungsWert;
	private boolean hatGewuerfelt;
	private Spieler gewinner;
	private boolean spielHatBegonnen;

	public Spiel(){
		this.spielbrett = new Spielbrett();
		this.hatGewuerfelt = false;
		this.darfWuerfeln = true;
		this.spielHatBegonnen = false;
		this.spieler = new ArrayList<Spieler>();
	}

	public void spielerHinzufuegen(Spieler spieler){
		if(!spielHatBegonnen){
			if(spieler == null) throw new RuntimeException("Spieler existiert nicht!");
			for(int i = 0; i < this.spieler.size(); i++){
				if(this.spieler.get(i).getFarbe() == spieler.getFarbe()) throw new RuntimeException("Der Spieler mit dieser Farbe nimmt bereits am Spiel teil!");
			}
			this.spieler.add(spieler);
		}
		
	}

	public void beginneSpiel(){
		if(this.spieler.size() >= 2){
			this.spielHatBegonnen = true;
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
				if(!kannLaufen(sf)) ungueltigerZug();
				neuePosition = sf.getPosition().getId();
				neuePosition += bewegungsWert;
				if(userIstDumm(neuePosition, sf)) zugBeenden();
				sf.setPosition(spielbrett.getFeld(neuePosition));
				hatGewuerfelt = false;
			} else if(sf.getPosition().getTyp() != FeldTyp.Startfeld && bewegungsWert == 6){
				neuePosition = sf.getFreiPosition();
				if(userIstDumm(neuePosition, sf)) zugBeenden();
				sf.setPosition(spielbrett.getFeld(neuePosition));
				hatGewuerfelt = false;
			}
		}
		
	}
	
	private void ungueltigerZug(){
		
	}
	
	private boolean kannLaufen(Spielfigur sf){
		switch(sf.getFarbe())
		{
		case rot:
			if(sf.getPosition().getId() + bewegungsWert > 71) return false;
		case blau:
			if(sf.getPosition().getId() + bewegungsWert > 59) return false;
		case gruen: 
			if(sf.getPosition().getId() + bewegungsWert > 67) return false;
		case gelb:
			if(sf.getPosition().getId() + bewegungsWert > 63) return false;
		default: break;
		}
		return true;
		
	}
	
	private boolean userIstDumm(int neuePosition, Spielfigur sf){
		if((spielbrett.getFeld(neuePosition).getFigur() != null) && (spielbrett.getFeld(neuePosition).getFigur().getFarbe() == sf.getFarbe())) return true;
		return false;
	}

	private boolean hatFreieFigur(Spieler spieler){
		if(spieler.getFigur(0).getPosition().getTyp() == FeldTyp.Startfeld &&
				spieler.getFigur(1).getPosition().getTyp() == FeldTyp.Startfeld &&
				spieler.getFigur(2).getPosition().getTyp() == FeldTyp.Startfeld &&
				spieler.getFigur(3).getPosition().getTyp() == FeldTyp.Startfeld )return false;
		return true;
	}

	private void aufStartPositionSetzen(Spielfigur figur){
		switch(figur.getFarbe())
		{
		case rot: this.spielbrett.getFeld(0).setFigur(figur); break;
		case blau: this.spielbrett.getFeld(11).setFigur(figur); break;
		case gruen: this.spielbrett.getFeld(21).setFigur(figur); break;
		case gelb: this.spielbrett.getFeld(31).setFigur(figur); break;
		}
	}

	public void wuerfeln(){
		if(spielHatBegonnen){
			if(this.darfWuerfeln == true && this.hatGewuerfelt == false){
				this.bewegungsWert = this.spielerAmZug.getWuerfel().werfen();
				if(this.bewegungsWert == 6) this.darfWuerfeln = true;
				else this.darfWuerfeln = false;
				hatGewuerfelt = true;
			}
		}
		
	}


	private void spielGewonnen(Spieler gewinner){
		System.out.println("Der Gewinner ist: " + gewinner.getName());
	}
	
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
