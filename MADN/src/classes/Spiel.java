package classes;

public class Spiel implements iBediener {

	private Spielbrett spielbrett;
	private Spieler[] spieler; 
	private Spieler spielerAmZug;
	private Spielfigur ausgewaehlteFigur;
	private boolean darfWuerfeln;
	private int bewegungsWert;
	
	public Spiel(Spieler s1, Spieler s2, Spieler s3, Spieler s4){
		if (s1 == null || s2 == null) throw new RuntimeException("Ungültige Eingabe");
		spieler = new Spieler[4];
		this.spielbrett = new Spielbrett();
		spieler[0] = s1;
		spieler[1] = s2;
		spieler[2] = s3;
		spieler[3] = s4;
		spielerAmZug = spieler[0];
	}
	
	/**
	 * Die Methode setzt die Spielfigur auf das Startfeld zurueck
	 */
	public void geschlagen(Spielfigur sf){
		sf.getStartPosition();
	}
	/**
	 * Methode zum bewegen der Spielfigur
	 * @param sf Spielfigur die bewegt wird
	 */
	public void bewege(Spielfigur sf){
		if(sf == null || sf.getFarbe() != this.spielerAmZug.getFarbe()) throw new RuntimeException("Figur existiert nicht oder hat die falsche Farbe!");
		int neuePosition = sf.getPosition().getId();
		neuePosition += bewegungsWert;
		sf.setPosition(spielbrett.getFeld(neuePosition));
	}
	
	public void figurRaus(Spielfigur sf){
		
	}
	
	private void figurRein(Spielfigur sf){
		
	}
	
	public boolean hatFreieFigur(Spieler spieler){
		if(spieler.getFigur(0).getPosition().getTyp() == FeldTyp.Startfeld &&
				spieler.getFigur(1).getPosition().getTyp() == FeldTyp.Startfeld &&
				spieler.getFigur(2).getPosition().getTyp() == FeldTyp.Startfeld &&
				spieler.getFigur(3).getPosition().getTyp() == FeldTyp.Startfeld )return false;
		return true;
	}
	
	public void figurAuswaehlen(Spielfigur figur){
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
		if(this.darfWuerfeln == true && hatFreieFigur(this.spielerAmZug) == true){
			this.bewegungsWert = this.spielerAmZug.getWuerfel().werfen();
			if(this.bewegungsWert == 6) this.darfWuerfeln = true;
			else this.darfWuerfeln = false;
		}
	}
	
	
	public void zugBeenden(){
		
	}
	
}
