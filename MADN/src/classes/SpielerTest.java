package classes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SpielerTest {
	
	@Before
	public void ausgabe(){
		System.out.println("### Testanfang ###");
		System.out.println();
	}

	@Test
	public void test() {
		Spielbrett sb = new Spielbrett();
		Spieler s = new Spieler("Stefan", FarbEnum.rot, null, sb);
		System.out.println(s.getFigur(0).getFarbe());
		System.out.println(s.getFigur(2).getPosition());
		System.out.println(s.getFigur(2).getPosition().getId());
		
	}
	
	@After 
	public void ausgabeDanach(){
		System.out.println();
		System.out.println("### Testende ###");
	}
	

}
