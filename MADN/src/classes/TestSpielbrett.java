package classes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSpielbrett {
	protected Spielbrett s;

	@Test
	public void test() {
		s = new Spielbrett();
		try {
			s.getFeld(-1);
		} catch (RuntimeException e) {
			return;
		}
		fail();
	}

}
