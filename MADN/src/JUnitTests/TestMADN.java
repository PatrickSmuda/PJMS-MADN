package JUnitTests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import classes.W�rfel;

public class TestMADN {
	protected classes.W�rfel w;
	
	
	@Test
	public void test() {
		for (int i = 0; i < 100; i++) {
			if (W�rfel.werfen() < 1 || W�rfel.werfen() > 6) {
				fail();
			}
			
		}
	
	}
	
	
}
