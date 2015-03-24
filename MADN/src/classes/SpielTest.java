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
		Spiel s = new Spiel(s1, s2, s3, s4);
		
		iBediener p;
		
		p = s;
		
		
		
		p.wuerfeln();
		p.bewege(s1.getFigur(1));
		System.out.println(s1.getFigur(1).getPosition());
		
		
	}
}
