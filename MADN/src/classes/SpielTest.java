package classes;

public class SpielTest {
	
	Spielbrett sb = new Spielbrett();
	Spieler s1 = new Spieler("hans", FarbEnum.rot, null, sb);
	Spieler s2 = new Spieler("gretel", FarbEnum.blau, null, sb);
	Spieler s3 = new Spieler("blub", FarbEnum.gruen, null, sb);
	Spieler s4 = new Spieler("blaaa", FarbEnum.gelb, null, sb);
	
	public static void main(String[] args) {

		
		s.bewege(null);
		
	}
}
