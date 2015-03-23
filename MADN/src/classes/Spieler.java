package classes;
/**
 * Die Klasse Spieler
 * @author Johannes Mändle
 * @version 1.0
 */

public class Spieler {

	private String name;
	private FarbEnum farbe;
	private Wuerfel wuerfel;
	private Spielfigur[] spielfigur;
	private Spielbrett spielbrett;
	private KI ki;
	private static int zaehler =1;

	/**
	 * Konstruktor setzt den Spielernamen, die Farbe der Spielfiguren des Spielers und ggf. eine KI
	 * @param name Name des Spielers
	 * @param farbe Farbe des Spielers
	 */
	public Spieler(String name, FarbEnum farbe, KI ki, Spielbrett spielbrett)
	{
		if (zaehler > 4) throw new RuntimeException("Zu viele Spieler");
		if(name == null) throw new RuntimeException("Ungueltiger Name!");
		if (spielbrett == null) throw new RuntimeException("Kein Spielbrett");
		if (ki != null) this.ki = ki;
		this.spielbrett = spielbrett;
		this.name = name;
		wuerfel = new Wuerfel();
		spielfigur  = new Spielfigur[4];
		figurenInit(farbe);
		zaehler++;
	}

	/**
	 * Gibt eine der vier Spielfiguren zurueck
	 * @param n Figur 1, 2, 3 oder 4
	 * @return Spielfigur Gibt die Spielfigur zurueck
	 */
	public Spielfigur getFigur(int n){
		if (n <0 || n>3) throw new RuntimeException("Ungueltige Position");
		if(spielfigur == null || spielfigur.length == 0) throw new RuntimeException("Keine Spielfiguren vorhanden");
		return spielfigur[n];
	}
	
	/**
	 * Gibt den Wuerfel des Spielers zurueck
	 * @return wuerfel 
	 */
	public Wuerfel getWuerfel(){
		return this.wuerfel;
	}
	/**
	 * Gibt die Farbe des Spielers zurück
	 * @return farbe
	 */
	public FarbEnum getFarbe(){
		return this.farbe;
	}
	
	public String getName(){ 
		return name;
	}
	
	/**
	 * Die Methode initialisiert die Spielfiguren mit der uebergebenen Farbe 
	 * und stellt sie auf ihre jeweilige Startposition.
	 * @param farbe Die Farbe der Spielfiguren
	 */
	private void figurenInit(FarbEnum farbe)
	{
		switch(farbe)
		{
		case rot: 
			this.farbe = FarbEnum.rot; 
			int z = 40;
			
			for(int i =0; i<spielfigur.length; i++){
				spielfigur[i] = new Spielfigur(farbe, spielbrett.getFeld(z), this);
				spielbrett.getFeld(z).setFigur(spielfigur[i]);
				z++;
			}
			break;
		case blau: 
			this.farbe = FarbEnum.blau; 
			int z1 = 44;
			for(int i =0; i<spielfigur.length; i++){
				spielfigur[i] = new Spielfigur(farbe, spielbrett.getFeld(z1), this);
				spielbrett.getFeld(z1).setFigur(spielfigur[i]);
				z1++;
			}
			break;
		case gruen: 
			this.farbe = FarbEnum.gruen;
			int z2=48;
			for(int i =0; i<spielfigur.length; i++){
				spielfigur[i] = new Spielfigur(farbe, spielbrett.getFeld(z2), this);
				spielbrett.getFeld(z2).setFigur(spielfigur[i]);
				z2++;
			}
			break;
		case gelb: 
			this.farbe = FarbEnum.gelb;
			int z3=52;
			for(int i =0; i<spielfigur.length; i++){
				spielfigur[i] = new Spielfigur(farbe, spielbrett.getFeld(z3), this);
				spielbrett.getFeld(z3).setFigur(spielfigur[i]);
				z3++;
			}
			break;
		default: throw new RuntimeException("Farbe nicht verfuegbar.");
		}
	}
}
