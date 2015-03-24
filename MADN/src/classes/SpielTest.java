package classes;
/**
 * Die Testklasse SpielTest
 * @author Patrick Smuda
 * @version 1.0
 */
public class SpielTest {
	
	
	/**Erstellung vom Spielbrett, Spieler erzeugen
	*/
	public static void main(String[] args) {
		Spielbrett sb = new Spielbrett();
		Spieler s1 = new Spieler("hans", FarbEnum.rot, null, sb);
		Spieler s2 = new Spieler("gretel", FarbEnum.blau, null, sb);
		Spieler s3 = new Spieler("hanni", FarbEnum.gruen, null, sb);
		Spieler s4 = new Spieler("nanni", FarbEnum.gelb, null, sb);
		Spiel s = new Spiel();
		iBediener p = s;
		
		p.spielerHinzufuegen(s1);
		p.spielerHinzufuegen(s2);
		p.spielerHinzufuegen(s3);
		p.spielerHinzufuegen(s4);
		
		p.beginneSpiel();
		
		for (int i = 0; i < 9; i++) {
			
		p.wuerfeln();
		switch (p.getSpielerAmZug().getFarbe()) {
		case rot:
			System.out.println("Alte Position von " + p.getSpielerAmZug().getFarbe() + ": " + s1.getFigur(1).getPosition().getId());
			p.bewege(s1.getFigur(1));
			System.out.println("Neue Position: " + s1.getFigur(1).getPosition().getId());
			break;

		case blau:
			System.out.println("Alte Position von " + p.getSpielerAmZug().getFarbe() + ": " + s2.getFigur(1).getPosition().getId());
			p.bewege(s2.getFigur(1));
			System.out.println("Neue Position: " + s2.getFigur(1).getPosition().getId());
			break;
	
		case gruen:
			System.out.println("Alte Position von " + p.getSpielerAmZug().getFarbe() + ": " + s3.getFigur(1).getPosition().getId());
			p.bewege(s3.getFigur(1));
			System.out.println("Neue Position: " + s3.getFigur(1).getPosition().getId());
			break;
	
		case gelb:
			System.out.println("Alte Position von " + p.getSpielerAmZug().getFarbe() + ": " + s4.getFigur(1).getPosition().getId());
			p.bewege(s4.getFigur(1));
			System.out.println("Neue Position: " + s4.getFigur(1).getPosition().getId());
			break;
		}
		}
	}
}
