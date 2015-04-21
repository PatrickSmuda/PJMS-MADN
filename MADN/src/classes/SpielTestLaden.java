package classes;
/**
 * Klasse SpielTestLaden
 * @author 
 * @version 1.0
 */

public class SpielTestLaden {
	
	/**Erstellung von einem Spiel, anschlieﬂend Laden des Spieles aus einer Datei
	*/
	public static void main(String[] args) {
		iDatenzugriff d;
		d= new DatenzugriffSerialisiert();
		iBediener p = (Spiel) d.laden(1);
		System.out.println("Geladenes Spiel:");
		System.out.println("Spieler am Zug: "+p.getSpielerAmZug());
		p.wuerfeln();
		System.out.println("Wuerfelwert: " +p.getBewegungsWert());
		p.bewege(0);
		System.out.println("Spieler am Zug: "+p.getSpielerAmZug());
		System.out.println("\n");
		d = new DatenzugriffCSV();
		p = (Spiel)d.laden(1);
		System.out.println("Geladenes Spiel:");
		System.out.println("Spieler am Zug: "+p.getSpielerAmZug());
		p.wuerfeln();
		p.bewege(0);
		System.out.println("Wuerfelwert: " +p.getBewegungsWert());
		System.out.println("Spieler am Zug: "+p.getSpielerAmZug());
	}
	
}
