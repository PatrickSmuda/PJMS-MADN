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
		Spiel s = new Spiel();
		iBediener p = s;
		
		p.spielerHinzufuegen("alpha", FarbEnum.rot);
		p.spielerHinzufuegen("beta", FarbEnum.blau);
		p.spielerHinzufuegen("gamma", FarbEnum.gelb);
		p.spielerHinzufuegen("omega", FarbEnum.gruen);
		
		p.beginneSpiel();
		
<<<<<<< HEAD
		for (int i = 0; i < 20; i++) {
			System.out.print(p.getSpielerAmZug() + " würfelt eine ");
=======
		for (int i = 0; i < 60; i++) {
>>>>>>> branch 'master' of https://github.com/SebastianStumm/PJMS-MADN
			p.wuerfeln();
<<<<<<< HEAD
			System.out.println(p.getBewegungsWert());
			p.bewege((int)((Math.random()*3)));	
=======
			int x = (int)((Math.random()*4));
			System.out.println(p.getSpielerAmZug() + " ist auf dem Feld " + p.getPosition(x) + " und würfelt eine " + p.getBewegungsWert());
			p.bewege(x);	
>>>>>>> branch 'master' of https://github.com/SebastianStumm/PJMS-MADN
		}
		
		
		
//		Funktioniert mit den neuen Änderungen nichtmehr		
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

