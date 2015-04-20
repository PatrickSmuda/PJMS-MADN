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
	public void speichern(Object spiel){

		if(spiel != null && spiel instanceof Spiel){
			
		}else{
			throw new RuntimeException("Das zu speichernde Objekt ist nicht vom Typ Spiel!");
		}
		
		
		int count = 1;
		
		File dir = new File("C:\\Speicherstand");
		File[] files = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith("ser");
			}
		});
		for (File file : files) {
			count++;
		}
		dateiName = dateiName + count;
		
		try{
			oos = new ObjectOutputStream(new FileOutputStream(("C:\\Speicherstand\\" + dateiName + ".ser")));
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
				System.err.println("Fehler beim Schlieﬂen!");
			}
		}
	}
	/**
	 * Die Methode laden, um das Spiel zu de-serialisieren
	 */
	public Object laden(int zaehler) { 
		ObjectInputStream ois = null;
		String test = null;
		Spiel geladenesSpiel = null;
		File dir = new File("C:\\Speicherstand");
		File[] files = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith("ser");
			}
		});
		for (File file : files) {
			if(file.getName().equals((dateiName + zaehler + ".ser"))){
				try{
					ois=new ObjectInputStream(new FileInputStream(("C:\\Speicherstand\\" + dateiName + zaehler + ".ser")));
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
					System.err.println("Fehler beim Schlieﬂen!");
				}
			}
				return geladenesSpiel;
			}
		}
		throw new RuntimeException("Datei exsistiert nicht");
}
	
}
