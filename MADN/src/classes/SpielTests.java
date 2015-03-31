package classes;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpielTests {

	@Test
	public void spielerHinzufuegenSelbeFarbeTest() {
		Spiel s = new Spiel();
		Spielbrett sb = new Spielbrett();
		try{
			s.spielerHinzufuegen("a", 1);
			s.spielerHinzufuegen("a", 1);
		}catch(RuntimeException e){
			return;
		}
		fail("konnte 2 Spieler der selben Farbe dem Spiel hinzufuegen!");	
	}
	
	@Test
	public void spielerHinzufuegenNullTest() {
		Spiel s = new Spiel();
		Spielbrett sb = new Spielbrett();
		try{
			s.spielerHinzufuegen(null, 6);
		}catch(RuntimeException e){
			return;
		}
		fail("konnte leeren Spieler hinzufuegen!");	
	}
	
	@Test
	public void SpielStartenMitEinemSpielerTest() {
		Spiel s = new Spiel();
		Spielbrett sb = new Spielbrett();
		try{
			s.spielerHinzufuegen("a", 1);
			s.beginneSpiel();
		}catch(RuntimeException e){
			return;
		}
		fail("Konnte Spiel mit einem Spieler starten!");	
	}
	
	@Test
	public void spielerHinzufuegenNachSpielbeginTest() {
		Spiel s = new Spiel();
		Spielbrett sb = new Spielbrett();
		try{
			s.spielerHinzufuegen("a", 1);
			s.spielerHinzufuegen("a", 2);
			s.spielerHinzufuegen("a", 0);
			s.beginneSpiel();
			s.spielerHinzufuegen("a", 3);
		}catch(RuntimeException e){
			return;
		}
		fail("konnte nach Spielstart Spieler hinzufuegen!");	
	}
	
	@Test
	public void wuerfelTest() {
		Spiel s = new Spiel();
		Spielbrett sb = new Spielbrett();
		try{
			s.spielerHinzufuegen("a", 1);
			s.spielerHinzufuegen("a", 2);
			s.spielerHinzufuegen("a", 0);
			s.beginneSpiel();
			s.wuerfeln();
			s.wuerfeln();
		}catch(RuntimeException e){
			return;
		}
		fail("konnte mehrmals hintereinander wuerfeln!");	
	}
	
	@Test
	public void kleinerTest(){
		Spiel s = new Spiel();
		s.spielerHinzufuegen("Spieler 1", 3);
		s.spielerHinzufuegen("Spieler 2", 2);
		s.beginneSpiel();
		for(int i = 0; i < 40; i++){
			System.out.print(s.getSpielerAmZug()+"\t\tPosition: "+s.getPositionFigur(0));
			s.wuerfeln();
			System.out.println("\t\tWuerfel: "+s.getBewegungsWert());
			s.bewege(0);
		}
		
	}

}
