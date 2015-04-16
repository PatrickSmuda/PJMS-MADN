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

	//Test
	ObjectOutputStream oos = null;
	
	/**
	 * Die Methode speichern, um das Spiel serialisiert zu speichern
	 */
	public void speichern(Object spiel){
		try{
			oos = new ObjectOutputStream(new FileOutputStream("out.ser"));
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
	public void laden() { 
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
