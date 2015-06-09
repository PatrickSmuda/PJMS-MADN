package backEnd;

import java.awt.Image;
import java.io.File;

/**
 * 
 * @author 
 * @version 1.0
 * Das Interface iDatenzugriff
 * 
 */
public interface iDatenzugriff {

	public void speichern(Object spiel, File fileAddressSave);
		
	public Object laden(File fileAddressLoad);
	
}