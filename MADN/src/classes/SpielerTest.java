package classes;
/**
 * Test-Klasse f�r die Klasse Spieler
 * @author Johannes M�ndle
 */
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SpielerTest {
	
	/**
	 * Ausgabe vor dem Test
	 */
	@Before
	public void ausgabe(){
		System.out.println("### Testanfang ###");
		System.out.println();
	}

	/**
	 * Testszenario erstellt ein Spielbrett und einen Spieler
	 */
	@Test
	public void test() {
		Spielbrett sb = new Spielbrett();
		Spieler s = new Spieler("Stefan", FarbEnum.rot, null, sb);
		Spieler s3 = new Spieler("Stefan", FarbEnum.gr�n, null, sb);
		Spieler s4 = new Spieler("Stefan", FarbEnum.blau, null, sb);
		Spieler s2 = new Spieler("Stefan", FarbEnum.gelb, null, sb);
		System.out.println(s.getFigur(0).getFarbe());
		System.out.println(s.getFigur(2).getPosition());
		System.out.println(s.getFigur(2).getPosition().getId());
		System.out.println(s2.getFigur(3));
		
	}
	
	/**
	 * Ausgabe nach dem Test
	 */
	@After 
	public void ausgabeDanach(){
		System.out.println();
		System.out.println("### Testende ###");
	}
	

}
