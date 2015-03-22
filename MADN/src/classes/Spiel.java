package classes;

public class Spiel {

	private Spielbrett spielbrett;
	private Spieler s1;
	private Spieler s2;
	private Spieler s3;
	private Spieler s4;
	private Spieler istAmZug;
	
	public Spiel(Spieler s1, Spieler s2, Spieler s3, Spieler s4){
		if (s1 == null) throw new RuntimeException("Ungültige Eingabe");
		this.s1 = s1;
		this.s2=s2;
		this.s3=s3;
		this.s4=s4;
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
	
	public void spielStarten(){
		this.spielbrett = new Spielbrett();
		
	}
	
	public void zugBeenden(){
		
	}
	
}
