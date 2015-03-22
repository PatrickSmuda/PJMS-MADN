package classes;
/**
 * Die Klasse zum testen der Funktionalitaet des Wuerfels
 * @author Patrick Smuda
 * @version 1.0
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class WuerfelTest {
	protected Wuerfel w;
	/**
	 * Prueffall fuer das wuerfeln eines 6-Seitigen Wuerfels
	 */
	@Test
	public void test() {
		for (int i = 0; i < 1000; i++) {
			if (w.werfen() < 1 || w.werfen() > 6) {
				fail("Wuerfel soll nur 1-6 ausgeben");
			}
		}
	}
}
