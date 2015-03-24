package classes;

public class Spiel implements iBediener {

	private Spielbrett spielbrett;
	private Spieler[] spieler; 
	private Spieler spielerAmZug;
	private Spielfigur ausgewaehlteFigur;
	private boolean darfWuerfeln;
	private int bewegungsWert;
	private boolean hatGewuerfelt;
	
	public Spiel(Spieler s1, Spieler s2, Spieler s3, Spieler s4){
		if (s1 == null || s2 == null) throw new RuntimeException("Ungültige Eingabe");
		spieler = new Spieler[4];
		this.spielbrett = new Spielbrett();
		spieler[0] = s1;
		spieler[1] = s2;
		spieler[2] = s3;
		spieler[3] = s4;
		spielerAmZug = spieler[0];
		this.hatGewuerfelt = false;
		this.darfWuerfeln = true;
	}
	
	/**
	 * Die Methode setzt die Spielfigur auf das Startfeld zurueck
	 */
	private void geschlagen(Spielfigur sf){
		sf.getStartPosition();
	}
	/**
	 * Methode zum bewegen der Spielfigur
	 * @param sf Spielfigur die bewegt wird
	 */
	public void bewege(Spielfigur sf){
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
	
	private void figurRaus(Spielfigur sf){
	sf.setPosition(sf.getStartPosition());
	}
	
	private void figurRein(Spielfigur sf){
		
	}
	
	private boolean hatFreieFigur(Spieler spieler){
		if(spieler.getFigur(0).getPosition().getTyp() == FeldTyp.Startfeld &&
				spieler.getFigur(1).getPosition().getTyp() == FeldTyp.Startfeld &&
				spieler.getFigur(2).getPosition().getTyp() == FeldTyp.Startfeld &&
				spieler.getFigur(3).getPosition().getTyp() == FeldTyp.Startfeld )return false;
		return true;
	}
	
	private void figurAuswaehlen(Spielfigur figur){
		if(figur == null || figur.getFarbe() != this.spielerAmZug.getFarbe()) throw new RuntimeException("Figur existiert nicht oder hat die falsche Farbe!");
		this.ausgewaehlteFigur = figur;
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
		if(this.darfWuerfeln == true){
			this.bewegungsWert = this.spielerAmZug.getWuerfel().werfen();
			if(this.bewegungsWert == 6) this.darfWuerfeln = true;
			else this.darfWuerfeln = false;
			hatGewuerfelt = true;
		}
	}
	
	
	private void zugBeenden(){
	}
	
}
