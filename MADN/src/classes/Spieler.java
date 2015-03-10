package classes;
/**
 * Die Klasse Spieler
 * @author Johannes M�ndle
 * @version 1.0
 */

public class Spieler {

	private String name;
	private FarbEnum farbe;
	private W�rfel w�rfel;
	private Spielfigur fig_1;
	private Spielfigur fig_2;
	private Spielfigur fig_3;
	private Spielfigur fig_4;

	/**
	 * Konstruktor
	 * @param Name des Spielers
	 * @param Farbe des Spielers
	 */
	public Spieler(String name, int farbe)
	{
		this.name = name;
		switch(farbe)
		{
		case 0: this.farbe = FarbEnum.rot; break;
		case 1: this.farbe = FarbEnum.blau; break;
		case 2: this.farbe = FarbEnum.gr�n; break;
		case 3: this.farbe = FarbEnum.gelb; break;
		default: throw new RuntimeException("Farbe existiert nicht");
		}
		fig_1 = new Spielfigur(farbe);
		fig_2 = new Spielfigur(farbe);
		fig_3 = new Spielfigur(farbe);
		fig_4 = new Spielfigur(farbe);
	}
}