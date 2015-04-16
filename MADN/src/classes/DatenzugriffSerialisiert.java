package classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
	private static int zaehler;
	
	/**
	 * Die Methode speichern, um das Spiel serialisiert zu speichern
	 */
	public void speichern(Object spiel){
		dateiName = dateiName+zaehler;
		this.zaehler++;
		System.out.println(zaehler);
		try{
			oos = new ObjectOutputStream(new FileOutputStream((dateiName + ".ser")));
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
	public void laden(int zaehler) { 
		ObjectInputStream ois = null;
		try{
			ois=new ObjectInputStream(new FileInputStream("out.ser"));
			Spiel geladenesSpiel = (Spiel)ois.readObject();
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
	
}

	
	
}
