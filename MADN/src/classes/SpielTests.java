package classes;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpielTests {

	@Test
	public void spielerHinzufuegenSelbeFarbeTest() {
		Spiel s = new Spiel();
		Spielbrett sb = new Spielbrett();
		try{
			s.spielerHinzufuegen(new Spieler("a", FarbEnum.blau, null, sb));
			s.spielerHinzufuegen(new Spieler("a", FarbEnum.blau, null, sb));
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
			s.spielerHinzufuegen(null);
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
			s.spielerHinzufuegen(new Spieler("a", FarbEnum.blau, null, sb));
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
			s.spielerHinzufuegen(new Spieler("a", FarbEnum.blau, null, sb));
			s.spielerHinzufuegen(new Spieler("a", FarbEnum.gruen, null, sb));
			s.spielerHinzufuegen(new Spieler("a", FarbEnum.rot, null, sb));
			s.beginneSpiel();
			s.spielerHinzufuegen(new Spieler("a", FarbEnum.gelb, null, sb));
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
			s.spielerHinzufuegen(new Spieler("a", FarbEnum.blau, null, sb));
			s.spielerHinzufuegen(new Spieler("a", FarbEnum.gruen, null, sb));
			s.spielerHinzufuegen(new Spieler("a", FarbEnum.rot, null, sb));
			s.beginneSpiel();
			s.wuerfeln();
			s.wuerfeln();
		}catch(RuntimeException e){
			return;
		}
		fail("konnte mehrmals hintereinander wuerfeln!");	
	}
	
	

}
