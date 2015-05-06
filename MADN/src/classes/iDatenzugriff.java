package classes;

import java.io.File;

/**
 * 
 * @author 
 * @version 1.0
 * Das Interface iDatenzugriff
 * 
 */
public interface iDatenzugriff {

	public void speichern(Object spiel, File filefileAddressSave);
	
	public Object laden(int zaehler);
	
}