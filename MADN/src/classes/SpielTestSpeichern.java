package classes;
/**
 * Klasse SpielTestSpeichern
 * @author 
 * @version 1.0
 */

public class SpielTestSpeichern {

	/**Erstellung von Spiel, anschlieﬂend Speichern des Spieles in eine Datei
	*/
	public static void main(String[] args) {
		iDatenzugriff d;
		d= new DatenzugriffSerialisiert();
		Spiel s = new Spiel();
		s.spielerHinzufuegen("Patrick", 0, 0);
		s.spielerHinzufuegen("Sebi", 1, 1);
		s.beginneSpiel();
		d.speichern(s);
		
		d=new DatenzugriffCSV();
		d.speichern(s);
		
	}
}
