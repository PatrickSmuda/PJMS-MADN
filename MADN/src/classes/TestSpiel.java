package classes;
/**
 * Der JUnit Test zu Spiel
 * @author 
 * @version 1.0
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSpiel {
	
	@Before
	public void ausgabe(){ 
		System.out.println("Hier beginnt der Test.");
	}
	
	protected Spielbrett s;
	protected Wuerfel w;
	protected Spieler s1;
	protected Spieler s2;
	protected Spieler s3;
	protected Spieler s4;
	
	
	@Test
	public void test() {
		
	}
	
	public void assertEquals(){
		s1.equals(s2);
	}
	
	public void assertNotNull(){ 
		
	}
	
	

}
