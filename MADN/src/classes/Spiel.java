package classes;

public class Spiel {

	private Spielbrett spielbrett;
	private Spieler[] spieler;
	private Spieler istAmZug;
	
	public Spiel(Spieler s1, Spieler s2, Spieler s3, Spieler s4){
		if (s1 == null || s2 == null) throw new RuntimeException("Ungültige Eingabe");
		spieler = new Spieler[4];
		spieler[0] = s1;
		spieler[1] = s2;
		spieler[2] = s3;
		spieler[3] = s4;
	}
	
	/**
	 * Die Methode setzt die Spielfigur auf das Startfeld zurueck
	 */
	public void geschlagen(Spielfigur sf){
		sf.getStartPosition();
	}
	/**
	 * Methode zum bewegen der Spielfigur
	 * @param position Position auf welche die Spielfigur zieht
	 */
	public void bewegeAuf(Spielfeld position, Spielfigur sf){
		if(position == null) throw new RuntimeException("Spielfeld auf das die Spielfigur laufen soll existiert nicht");
		if(position.getFigur() != null){
			if (position.getFigur().getFarbe().equals(sf.getFarbe())){
				zugBeenden();
			}else{
				geschlagen(position.getFigur());
			}
		}
		sf.setPosition(position);
	}
	
	public void figurRaus(Spieler s){
		s.getFigur(0).getFarbe();
	}
	
	public void spielStarten(){
		this.spielbrett = new Spielbrett();
		
	}
	
	public void zugBeenden(){
		
	}
	
}
