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
		

		p.spielerHinzufuegen("ROT", 0, 0);
		p.spielerHinzufuegen("BLAU", 1, 1);
		
		p.beginneSpiel();
		
		p.setTestPosition(1, 12);
		System.out.println(p.getSpielerAmZug() + "    " + p.getPosition(1));
		p.zugBeenden();
		
		p.setTestPosition(1, 14);
		System.out.println(p.getSpielerAmZug() + "    " + p.getPosition(1));
		p.zugBeenden();
		
		System.out.println("------------");
		
		p.wuerfeln2();
		System.out.println(p.getSpielerAmZug() + "  Würfelt eine:   " + p.getBewegungsWert());
		p.bewege(1);
		
		System.out.println(p.getSpielerAmZug() + "    " + p.getPosition(1));
		p.zugBeenden();
		System.out.println(p.getSpielerAmZug() + "    " + p.getPosition(1));
		
//		for (int i = 0; i < 100; i++) {
//			p.wuerfeln();
//			int x = (int)((Math.random()*4));
//			System.out.println(p.getSpielerAmZug() + " ist auf dem Feld " + p.getPosition(x) + " und würfelt eine " + p.getBewegungsWert());
//			p.bewege(x);		
//		}
		
	}
}