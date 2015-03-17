package classes;
/**
 * Die Klasse zum testen der Funktionalit�t des Spielbretts
 * @author Patrick Smuda
 * @version 1.0
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSpielbrett {
	protected Spielbrett s;

	
	@Before
	public void init() {
		s = new Spielbrett();
	}
	
	/**
	 * Pr�ffall f�r die Anzahl der Spielfelder auf dem Spielbrett
	 */
	@Test
	public void test() {
		try {
			s.getFeld(-1);
		} catch (RuntimeException e) {
			return;
		}
		
		try {
			s.getFeld(71);
		} catch (RuntimeException e) {
			return;
		}
		fail("Fehler beim Spielbrett");
	}
}
