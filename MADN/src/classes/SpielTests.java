package classes;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpielTests {

	@Test
	public void spielerHinzufuegenSelbeFarbeTest() {
		Spiel s = new Spiel();
		Spielbrett sb = new Spielbrett();
		try{
			s.spielerHinzufuegen("a", FarbEnum.blau);
			s.spielerHinzufuegen("a", FarbEnum.blau);
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
			s.spielerHinzufuegen(null, null);
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
			s.spielerHinzufuegen("a", FarbEnum.blau);
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
			s.spielerHinzufuegen("a", FarbEnum.blau);
			s.spielerHinzufuegen("a", FarbEnum.gruen);
			s.spielerHinzufuegen("a", FarbEnum.rot);
			s.beginneSpiel();
			s.spielerHinzufuegen("a", FarbEnum.gelb);
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
			s.spielerHinzufuegen("a", FarbEnum.blau);
			s.spielerHinzufuegen("a", FarbEnum.gruen);
			s.spielerHinzufuegen("a", FarbEnum.rot);
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
		s.spielerHinzufuegen("Spieler 1", FarbEnum.gelb);
		s.spielerHinzufuegen("Spieler 2", FarbEnum.gruen);
		s.beginneSpiel();
		for(int i = 0; i < 30; i++){
			System.out.print(s.getSpielerAmZug()+"\t\tPosition: "+s.getPositionFigur(0));
			s.wuerfeln();
			System.out.println("\t\tWuerfel: "+s.getBewegungsWert());
			s.bewege(0);
		}
		
	}

}
