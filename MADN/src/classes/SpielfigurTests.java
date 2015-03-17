package classes;
/**
 * Die Klasse zum testen der Funktionalität der Spielfigur
 * @author Sebastian Stumm
 * @version 1.0
 */
import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Prüffälle
 */
public class SpielfigurTests {

	private Spielfigur sf[];
	private Spielbrett sb;
	
	@Test
	public void anzTest() {
		sb = new Spielbrett();
		sf= new Spielfigur[10];
		try{
			for(int i = 0; i < sf.length; i++){
				sf[i] = new Spielfigur(FarbEnum.rot, sb.getFeld(i));
			}
		}catch(RuntimeException e){
			//Test erfolgreich
			return;
		}
		fail("Mehr als 4 Figuren einer Farbe wurden erstellt!");
	}
	
	
	@Test
	public void feldTest() {
		sb = new Spielbrett();
		sf= new Spielfigur[4];
		try{
			for(int i = 0; i < sf.length; i++){
				sf[i] = new Spielfigur(FarbEnum.rot, null);
			}
		}catch(RuntimeException e){
			//Test erfolgreich
			return;
		}
		fail("Figur konnte auf null gestellt werden!");
	}
	

}
