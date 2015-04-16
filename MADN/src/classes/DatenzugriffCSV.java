package classes;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;

public class DatenzugriffCSV implements iDatenzugriff {

	private String dateiName = "SpeicherstandCSV_";
	
	public void speichern(Object spiel){ 
		
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
		
		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileWriter("C:\\Speicherstand\\" + dateiName + ".ser"));
		} catch (IOException e) {
			System.err.println("Datei konnte nicht geladen werden!");
		}
		
		
	}
	
	
	public Object laden(int zaehler){ 
		
	}

	
	
}
