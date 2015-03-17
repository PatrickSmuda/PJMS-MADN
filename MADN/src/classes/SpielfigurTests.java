package classes;
/**
 * Die Klasse zum testen der Funktionalität der Spielfigur
 * @author Sebastian Stumm
 * @version 1.0
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class SpielfigurTests {

	private Spielfigur sf[];
	private Spielbrett sb;
	private Spieler s;
	/**
	 * Prüffall für anzahl der Figuren
	 */
	@Test
	public void anzTest() {
		sb = new Spielbrett();
		sf= new Spielfigur[10];
		s = new Spieler("Hugo", FarbEnum.rot, null, sb);
		try{
			for(int i = 0; i < sf.length; i++){
				sf[i] = new Spielfigur(FarbEnum.rot, sb.getFeld(i),s);
			}
		}catch(RuntimeException e){
			//Test erfolgreich
			return;
		}
		fail("Mehr als 4 Figuren einer Farbe wurden erstellt!");
	}
	
	/**
	 * Prüffall ob Figur auf null steht
	 */
	@Test
	public void feldTest() {
		sb = new Spielbrett();
		sf= new Spielfigur[4];
		try{
			for(int i = 0; i < sf.length; i++){
				sf[i] = new Spielfigur(FarbEnum.rot, null,s);
			}
		}catch(RuntimeException e){
			//Test erfolgreich
			return;
		}
		fail("Figur konnte auf null gestellt werden!");
	}
	
	/**
	 * Prüffall ob Figur eine Farbe besitzt
	 */
	@Test
	public void farbTest() {
		sb = new Spielbrett();
		sf= new Spielfigur[4];
		try{
			for(int i = 0; i < sf.length; i++){
				sf[i] = new Spielfigur(null, sb.getFeld(i),s);
			}
		}catch(RuntimeException e){
			//Test erfolgreich
			return;
		}
		fail("Figur besitzt keine Farbe!");
	}
	

}
