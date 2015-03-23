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
	
	
	
	protected Spielbrett s;
	protected Wuerfel w;
	protected Spieler s1;
	protected Spieler s2;
	protected Spieler s3;
	protected Spieler s4;
	
	
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
	
		assertTrue(Spieler.getName().equals("MyNameIsJeff"));
		
	}
		
	@After 
	public void nachgabe(){
		System.out.println("Ende vom Test.");
	}
	

}
