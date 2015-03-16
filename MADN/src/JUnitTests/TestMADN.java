package JUnitTests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import classes.Würfel;

public class TestMADN {
	protected classes.Würfel w;
	
	
	@Test
	public void test() {
		for (int i = 0; i < 100; i++) {
			if (Würfel.werfen() < 1 || Würfel.werfen() > 6) {
				fail();
			}
			
		}
	
	}
	
	
}
