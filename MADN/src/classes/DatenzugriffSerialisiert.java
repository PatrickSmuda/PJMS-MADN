package classes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DatenzugriffSerialisiert implements iDatenzugriff  {

	
	//Test
	ObjectOutputStream oos = null;
	
	public void speichern(Spiel spiel){
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
	
	public void laden(){ 
		
	}
	
}
