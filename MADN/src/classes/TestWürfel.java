package classes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestW�rfel {
	protected classes.W�rfel w;

	@Test
	public void test() {
		for (int i = 0; i < 1000; i++) {
			if (W�rfel.werfen() < 1 || W�rfel.werfen() > 6) {
				fail("W�rfel soll nur 1-6 ausgeben");
			}
		}
	}
}
