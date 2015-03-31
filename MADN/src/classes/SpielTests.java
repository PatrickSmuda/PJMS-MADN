package classes;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpielTests {

	@Test
	public void rauskommen() {
		Spiel s = new Spiel();
		Spielbrett sb = new Spielbrett();
		s.spielerHinzufuegen("Spieler 1",FarbEnum.gelb);
		s.spielerHinzufuegen("Spieler 2",FarbEnum.blau);
		s.beginneSpiel();
		for(int i = 0; i < 40; i++){
			System.out.print(s.getSpielerAmZug()+" Position: "+s.getPositionFigur(0)+"\t\tWuerfel: ");
			//System.out.println(i);
			s.wuerfeln();
			s.bewege(0);
			System.out.println(s.getBewegungsWert()+ "\t\tZug: "+i+"\n");
		}
		
		
	}
}
