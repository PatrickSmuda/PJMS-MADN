package classes;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpielfigurTests {

	Spielfigur sf;
	Spielbrett sb;
	
	@Test
	public void test() {
		sb = new Spielbrett();
		sf = new Spielfigur(FarbEnum.rot,sb.getFeld(25));
		if(sf.getFarbe()==null)fail("Not yet implemented");
		if(sf.getPosition()==null)fail("Not yet implemented");
	}

}
