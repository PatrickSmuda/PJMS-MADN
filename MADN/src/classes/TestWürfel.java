package classes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestW�rfel {
	protected W�rfel w;

	@Test
	public void test() {
		for (int i = 0; i < 1000; i++) {
			if (w.werfen() < 1 || w.werfen() > 6) {
				fail("W�rfel soll nur 1-6 ausgeben");
			}
		}
	}
}
