package backEnd;
/**
 * Die Testklasse SpielTest
 * @author Patrick Smuda
 * @version 1.0
 */
public class KiTest {
	
	
	/**Erstellung vom Spielbrett, Spieler erzeugen
	*/
	public static void main(String[] args) {
		Spielbrett sb = new Spielbrett();
		SpielBean s = new SpielBean();
		iBedienerBean p = s;
		

		p.spielerHinzufuegen("ROTAggressiv", 0, 1);
		p.spielerHinzufuegen("BLAUDefensiv", 1, 2);
		
		
		p.beginneSpiel();
		
		
		for(int i = 0; i < 80; i++){
			p.benutzeKI();
		}
		
		
		
		
		
//		System.out.println(p.getSpielerAmZug());
//		p.wuerfeln();
//		System.out.println(p.getBewegungsWert());
//		p.bewege(0);
//		if(p.getBewegungsWert() != 6){
//			System.out.println(p.getSpielerAmZug());
//			p.benutzeKI();
//		}
//		
		
		
		//Test f�rs rausgehn
//				System.out.println("Test f�rs rausgehn");
//				System.out.println();
//				System.out.println(p.getSpielerAmZug() + "  ist auf dem Feld mit der ID  " + p.getPosition(1));
//				p.benutzeKI();
//				System.out.println(p.getSpielerAmZug() + "  ist auf dem Feld mit der ID  " + p.getPosition(1));
//		
		
		
		
//		Funktioniert mit den neuen �nderungen nichtmehr		
//		for (int i = 0; i < 40; i++) {
//		p.wuerfeln();
//
//		switch (p.getSpielerAmZug()) {
//		case rot:
//			System.out.println("Alte Position von " + p.getSpielerAmZug().getFarbe() + ": " + s1.getFigur(1).getPosition().getId());
//			p.bewege(s1.getFigur(1));
//			System.out.println("Neue Position: " + s1..getFigur(1).getPosition().getId());
//			break;
//
//		case blau:
//			System.out.println("Alte Position von " + p.getSpielerAmZug().getFarbe() + ": " + s2.getFigur(1).getPosition().getId());
//			p.bewege(s2.getFigur(1));
//			System.out.println("Neue Position: " + s2.getFigur(1).getPosition().getId());
//			break;
//	
//		case gruen:
//			System.out.println("Alte Position von " + p.getSpielerAmZug().getFarbe() + ": " + s3.getFigur(1).getPosition().getId());
//			p.bewege(s3.getFigur(1));
//			System.out.println("Neue Position: " + s3.getFigur(1).getPosition().getId());
//			break;
//	
//		case gelb:
//			System.out.println("Alte Position von " + p.getSpielerAmZug().getFarbe() + ": " + s4.getFigur(1).getPosition().getId());
//			p.bewege(s4.getFigur(1));
//			System.out.println("Neue Position: " + s4.getFigur(1).getPosition().getId());
//			break;
//		}
	}
}

