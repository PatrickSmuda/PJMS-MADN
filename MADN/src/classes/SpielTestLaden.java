package classes;

public class SpielTestLaden {

	public static void main(String[] args) {
		iDatenzugriff d;
		d= new DatenzugriffSerialisiert();
		iBediener p = (Spiel) d.laden(1);
		
		System.out.println(p.getSpielerAmZug() + "  ist auf dem Feld mit der ID  " + p.getPosition(1));
	}
}
