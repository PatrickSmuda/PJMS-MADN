package classes;
/**
 * Die Klasse zum testen der Funktionalit�t des W�rfels
 * @author Patrick Smuda
 * @version 1.0
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class TestW�rfel {
	protected W�rfel w;
	/**
	 * Pr�ffall f�r das w�rfeln eines 6-Seitigen W�rfels
	 */
	@Test
	public void test() {
		for (int i = 0; i < 1000; i++) {
			if (w.werfen() < 1 || w.werfen() > 6) {
				fail("W�rfel soll nur 1-6 ausgeben");
			}
		}
	}
}
