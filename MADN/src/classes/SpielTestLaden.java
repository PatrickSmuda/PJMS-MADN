package classes;

public class SpielTestLaden {

	public static void main(String[] args) {
		iDatenzugriff d;
//		d= new DatenzugriffSerialisiert();
//		iBediener p = (Spiel) d.laden(1);
		Spiel s = new Spiel();
		s.spielerHinzufuegen("penis", 2, 0);
		s.spielerHinzufuegen("bla", 1, 0);
		s.beginneSpiel();
//		System.out.println(p.getSpielerAmZug() + "  ist auf dem Feld mit der ID  " + p.getPosition(1));
		
		d = new DatenzugriffCSV();
		s = (Spiel)d.laden(1);
        System.out.println(s.getSpielerAmZug()); 
        System.out.println(s.getPosition(0));
	}
	
}
