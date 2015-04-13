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
		
		//Test fürs rausgehn
		System.out.println("Test fürs rausgehn");
		System.out.println();
		System.out.println(p.getSpielerAmZug() + "  ist auf dem Feld mit der ID  " + p.getPosition(1));
		p.wuerfeln6();
		System.out.println(p.getSpielerAmZug() + "  Würfelt eine:   " + p.getBewegungsWert());
		p.bewege(1);
		System.out.println(p.getSpielerAmZug() + "  ist auf dem Feld mit der ID  " + p.getPosition(1));
		
		p.zugBeenden();
		System.out.println();
		
		System.out.println(p.getSpielerAmZug() + "  ist auf dem Feld mit der ID  " + p.getPosition(1));
		p.wuerfeln6();
		System.out.println(p.getSpielerAmZug() + "  Würfelt eine:   " + p.getBewegungsWert());
		p.bewege(1);
		System.out.println(p.getSpielerAmZug() + "  ist auf dem Feld mit der ID  " + p.getPosition(1));
		p.zugBeenden();
		
		System.out.println();
		System.out.println("--------------------------");
		System.out.println();
		
		//Test fürs schlagen
		System.out.println("Test fürs schlagen");
		System.out.println();
		p.setTestPosition(1, 12);
		System.out.println(p.getSpielerAmZug() + "  ist auf dem Feld mit der ID  " + p.getPosition(1));
		p.zugBeenden();
		
		p.setTestPosition(1, 14);
		System.out.println(p.getSpielerAmZug() + "  ist auf dem Feld mit der ID  " + p.getPosition(1));
		p.zugBeenden();
		
		System.out.println();
		
		p.wuerfeln2();
		System.out.println(p.getSpielerAmZug() + "  Würfelt eine:   " + p.getBewegungsWert());
		p.bewege(1);
		p.zugBeenden();
		System.out.println(p.getSpielerAmZug() + "  ist auf dem Feld mit der ID  " + p.getPosition(1));
		p.zugBeenden();
		System.out.println(p.getSpielerAmZug() + "  ist auf dem Feld mit der ID  " + p.getPosition(1));
		p.zugBeenden();
		
		System.out.println();
		System.out.println("--------------------------");
		System.out.println();
		
		//Test fürs auf Endfeld gehn
		System.out.println("Test fürs auf Endfeld gehn");
		System.out.println();
		
		p.setTestPosition(1, 39);
		System.out.println(p.getSpielerAmZug() + "  ist auf dem Feld mit der ID  " + p.getPosition(1));
		p.wuerfeln2();
		System.out.println(p.getSpielerAmZug() + "  Würfelt eine:   " + p.getBewegungsWert());
		p.bewege(1);
		p.zugBeenden();
		System.out.println(p.getSpielerAmZug() + "  ist auf dem Feld mit der ID  " + p.getPosition(1));
		p.zugBeenden();
		
		p.setTestPosition(1, 9);
		System.out.println(p.getSpielerAmZug() + "  ist auf dem Feld mit der ID  " + p.getPosition(1));
		p.wuerfeln2();
		System.out.println(p.getSpielerAmZug() + "  Würfelt eine:   " + p.getBewegungsWert());
		p.bewege(1);
		p.zugBeenden();
		System.out.println(p.getSpielerAmZug() + "  ist auf dem Feld mit der ID  " + p.getPosition(1));
		p.zugBeenden();
		
		System.out.println();
		System.out.println("--------------------------");
		System.out.println();
		
		//Test fürs aufm Endfeld überspringen
		System.out.println("Test fürs aufm Endfeld überspringen");
		System.out.println();
		
		p.setTestPosition(1, 68);
		System.out.println(p.getSpielerAmZug() + "  ist auf dem Feld mit der ID  " + p.getPosition(1));
		p.setTestPosition(2, 69);
		System.out.println(p.getSpielerAmZug() + "  ist auf dem Feld mit der ID  " + p.getPosition(2));
		System.out.println();
		p.wuerfeln2();
		System.out.println(p.getSpielerAmZug() + "  Würfelt eine:   " + p.getBewegungsWert());
		System.out.println("Rot zeiht mit seiner ersten Figur von Feld ID 68 auf 70");
		p.bewege(1);
		p.zugBeenden();
		System.out.println(p.getSpielerAmZug() + "  ist auf dem Feld mit der ID  " + p.getPosition(1));
		System.out.println(p.getSpielerAmZug() + "  ist auf dem Feld mit der ID  " + p.getPosition(2));
		System.out.println();
		p.wuerfeln2();
		System.out.println(p.getSpielerAmZug() + "  Würfelt eine:   " + p.getBewegungsWert());
		System.out.println("Rot zeiht mit seiner ersten Figur von Feld ID 69 auf 71");
		p.bewege(2);
		p.zugBeenden();
		System.out.println(p.getSpielerAmZug() + "  ist auf dem Feld mit der ID  " + p.getPosition(1));
		System.out.println(p.getSpielerAmZug() + "  ist auf dem Feld mit der ID  " + p.getPosition(2));
		
		
		
//		for (int i = 0; i < 100; i++) {
//			p.wuerfeln();
//			int x = (int)((Math.random()*4));
//			System.out.println(p.getSpielerAmZug() + " ist auf dem Feld " + p.getPosition(x) + " und würfelt eine " + p.getBewegungsWert());
//			p.bewege(x);		
//		}
		
	}
}