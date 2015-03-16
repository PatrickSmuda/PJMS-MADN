package classes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestWürfel {
	protected classes.Würfel w;

	@Test
	public void test() {
		for (int i = 0; i < 1000; i++) {
			if (Würfel.werfen() < 1 || Würfel.werfen() > 6) {
				fail("Würfel soll nur 1-6 ausgeben");
			}
		}
	}
}
