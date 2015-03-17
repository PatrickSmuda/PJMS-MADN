package classes;
/**
 * Die Klasse zum testen der Funktionalität der Spielfigur
 * @author Sebastian Stumm
 * @version 1.0
 */
import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Prüffälle
 */
public class SpielfigurTests {

	private Spielfigur sf;
	private Spielbrett sb;
	
	@Test
	public void test() {
		sb = new Spielbrett();
		sf = new Spielfigur(FarbEnum.rot,sb.getFeld(25));
		//if(sf.getFarbe()==null)fail("Farbe der Figur ist null");
		if(sf.getPosition()==null)fail("Figur steht auf keinem Feld");
	}

}
