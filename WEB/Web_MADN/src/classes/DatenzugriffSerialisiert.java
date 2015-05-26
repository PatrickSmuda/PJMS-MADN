package classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * 
 * @author 
 * Die Klasse DatenzugriffSerialisiert
 *
 */
public class DatenzugriffSerialisiert implements iDatenzugriff  {

	private ObjectOutputStream oos = null;
	private String dateiName = "Speicherstand_";
	
	
	/**
	 * Die Methode speichern, um das Spiel serialisiert zu speichern
	 */
	public void speichern(Object spiel, File fileAddressSave){

		if(spiel != null && spiel instanceof Spiel){
			
		}else{
			throw new RuntimeException("Das zu speichernde Objekt ist nicht vom Typ Spiel!");
		}
		
		try{
			oos = new ObjectOutputStream(new FileOutputStream(fileAddressSave));
			oos.writeObject(spiel);
		} catch(FileNotFoundException e){
			System.err.println("Datei konnte nicht erstellt werden!");
		} catch (IOException e) {
			System.err.println("Fehler bei Ein-/Ausgabe: " + e);
		}
		finally{
			try{
				oos.close();
			}catch(Exception e){
				System.err.println("Fehler beim Schlie�en!");
			}
		}
	}
	/**
	 * Die Methode laden, um das Spiel zu de-serialisieren
	 */


	@Override
	public Object laden(File fileAddressLoad) {
		ObjectInputStream ois = null;
		Spiel geladenesSpiel = null;
				try{
					ois=new ObjectInputStream(new FileInputStream((fileAddressLoad)));
					geladenesSpiel = (Spiel)ois.readObject();
				}catch(FileNotFoundException e){
					System.err.println("Datei konnte nicht geladen werden!");
				} catch (IOException e) {
					System.err.println("Fehler bei Ein-/Ausgabe: " + e);
			} catch (ClassNotFoundException e) {
					System.err.println("Datei enthaelt kein Objekt von Typ Spiel!");
				}finally{
				try{
					ois.close();
				}catch(Exception e){
					System.err.println("Fehler beim Schlie�en!");
				}
			}
			return geladenesSpiel;
		}
		
}
