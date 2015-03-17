package classes;
/**
 * Die Klasse zum testen der Funktionalität des Würfels
 * @author Patrick Smuda
 * @version 1.0
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class TestWürfel {
	protected Würfel w;
	/**
	 * Prüffall für das würfeln eines 6-Seitigen Würfels
	 */
	@Test
	public void test() {
		for (int i = 0; i < 1000; i++) {
			if (w.werfen() < 1 || w.werfen() > 6) {
				fail("Würfel soll nur 1-6 ausgeben");
			}
		}
	}
}
