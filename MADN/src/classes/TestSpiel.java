package classes;
/**

 * Der JUnit Test zu Spiel
 * @author 
 * @version 1.0
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestSpiel {
	
	/**Ausgabe vor dem Test.
	  */
	@Before
	public void ausgabe(){ 
		System.out.println("Hier beginnt der Test.");
	}
	
	
	protected Spiel spiel;
	protected Spielbrett s;
	protected Wuerfel w;
	protected Spieler s1;
	protected Spieler s2;
	protected Spieler s3;
	protected Spieler s4;
	

	/**
	 * Testszenario erstellt Spielbrett und Spieler
	 */
	@Test
	public void test() {
		
		Spielbrett s = new Spielbrett();
		Spieler s1 = new Spieler ("MyNameIsJeff", FarbEnum.gruen, null, s);
		Spieler s2 = new Spieler ("Alex", FarbEnum.gelb, null, s);
		Spieler s3 = new Spieler ("ElPresidente", FarbEnum.rot, null, s);
		Spieler s4 = new Spieler ("Dumbledore", FarbEnum.blau, null, s);
		
		System.out.println(s1.getFigur(0).getFarbe());
		System.out.println(s2.getFigur(0).getFarbe());
		System.out.println(s3.getFigur(0).getFarbe());
		System.out.println(s4.getFigur(0).getFarbe());
		
	}
		
//	@Test 
//	public void negativeTest(){
//		try {
//		assertSame(s3.getFarbe(), s4.getFarbe());
//		assertEquals(s3.getName(), ("El Presidente"));
////		fail("wenn das nich funktioniert dann wein ich");
//		}
//		catch(IllegalArgumentException ex){	
//		}
//	}
	/**
	 * testet zwei Objekte, in dem Fall ob es der selbe Würfel ist mit Funktion werfen
	 */
	@Test
	public void guterTest(){ 
		assertEquals(w.werfen(), w.werfen());
//		assertNotSame(spiel.bewege(s1.getFigur(0)), spiel.bewege(s3.getFigur(2)));
	}
	
	/**
	 * Ausgabe nach dem Test
	 */
	@After 
	public void nachgabe(){
		System.out.println("Ende vom Test.");
	}
	

}
