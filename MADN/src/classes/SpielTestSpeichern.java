package classes;

public class SpielTestSpeichern {

	public static void main(String[] args) {
		iDatenzugriff d;
		d= new DatenzugriffSerialisiert();
		Spiel s = new Spiel();
		s.spielerHinzufuegen("Patrick", 0, 0);
		s.spielerHinzufuegen("Sebi", 1, 0);
		s.beginneSpiel();
		d.speichern(s);
	}
}
