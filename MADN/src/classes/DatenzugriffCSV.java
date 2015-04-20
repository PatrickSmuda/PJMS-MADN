package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DatenzugriffCSV implements iDatenzugriff {

	private String dateiName = "SpeicherstandCSV_";
	
	public void speichern(Object spiel){ 
		
		
        if(spiel != null && spiel instanceof Spiel){
			
        	Spiel s=(Spiel)spiel;
        	
        	int count=1;
        	
        	File dir = new File("C:\\Speicherstand\\");
    		File[] files = dir.listFiles(new FilenameFilter() {
    			public boolean accept(File dir, String name) {
    				return name.endsWith("csv");
    			}
    		});
    		for (File file : files) {
    			count++;
    		}
    		dateiName = dateiName + count + ".csv";
    		String text = s.csvString(); 
    		dir = new File("C:\\Speicherstand\\"+dateiName);
    		
    		
    		try{
    			FileWriter writer = new FileWriter(dir);
    			
    			writer.write(text);
    	
    			writer.flush();
    			writer.close();
    			
    		}catch(IOException e){
    			e.printStackTrace();
    		}
        	
		}else{
			throw new RuntimeException("Das zu speichernde Objekt ist nicht vom Typ Spiel!");
		}
		
		
	}
		
//		int count = 1;	
//		
//		File dir = new File("C:\\Speicherstand");
//		File[] files = dir.listFiles(new FilenameFilter() {
//			public boolean accept(File dir, String name) {
//				return name.endsWith("ser");
//			}
//		});
//		for (File file : files) {
//			count++;
//		}
//		dateiName = dateiName + count;
//		
//		PrintWriter pw;
//		try {
//			pw = new PrintWriter(new FileWriter("C:\\Speicherstand\\" + dateiName + ".ser"));
//		} catch (IOException e) {
//			System.err.println("Datei konnte nicht geladen werden!");
//		}
		
		
	
	
	
	public Object laden(int zaehler){ 
		BufferedReader reader = null;
		
		try {
			
             int count=0;
        	
        	File dir = new File("C:\\Speicherstand\\");
    		File[] files = dir.listFiles(new FilenameFilter() {
    			public boolean accept(File dir, String name) {
    				return name.endsWith("csv");
    			}
    		});
    		for (File file : files) {
    			count++;
    		}
    		
    		dateiName = dateiName + zaehler + ".csv";
			System.out.println(dateiName);
			reader = new BufferedReader(new FileReader("C:\\Speicherstand\\" + dateiName ));
						
           ArrayList <String> inhaltStrings = new ArrayList <String>();
           String[] inhalt = null;
           Spiel s = new Spiel();
           
           
            String currentLine = reader.readLine();
            
            while(currentLine != null){
    			inhaltStrings.add(currentLine);
    			currentLine = reader.readLine();
    		}
            
           ArrayList<String> namen = new ArrayList<String>();
           ArrayList<String> farben = new ArrayList<String>();
           ArrayList<String> kiTyp = new ArrayList<String>();
           ArrayList<String> positionen = new ArrayList<String>();
           ArrayList<String> ueberlaeufe = new ArrayList<String>();
           
           for(int i = 0; i < inhaltStrings.size(); i++){
        	   inhalt = inhaltStrings.get(i).split(";");
        	   for(int j = 0; j < inhalt.length; j++){
        		   if(i < inhaltStrings.size()-1){
        			   switch(j)
            		   {
            		   case 0:	namen.add(inhalt[0]); break;
            		   case 1:	farben.add(inhalt[1]); break;
            		   case 2:	kiTyp.add(inhalt[2]); break;
            		   case 3:	positionen.add(inhalt[3]); break;
            		   case 4:	ueberlaeufe.add(inhalt[4]); break;
            		   case 5:	positionen.add(inhalt[5]); break;
            		   case 6:	ueberlaeufe.add(inhalt[6]); break;
            		   case 7:	positionen.add(inhalt[7]); break;
            		   case 8:	ueberlaeufe.add(inhalt[8]); break;
            		   case 9:	positionen.add(inhalt[9]); break;
            		   case 10:	ueberlaeufe.add(inhalt[10]); break;
            		   }
        		   }
        		   
        	   }
        	   
        	   
           }
           
           for(int i = 0; i < namen.size(); i++){
        	   int f = Integer.parseInt(farben.get(i));
        	   int ki = Integer.parseInt(kiTyp.get(i));
        	   s.spielerHinzufuegen(namen.get(i), f, ki);
           }
           
           
            
           for(int i = 0; i < namen.size(); i++){
        	   System.out.println(namen.get(i));
           }System.out.println("-------");
            
           for(int i = 0; i < farben.size(); i++){
        	   System.out.println(farben.get(i));
           }System.out.println("-------");
           
           for(int i = 0; i < kiTyp.size(); i++){
        	   System.out.println(kiTyp.get(i));
           }System.out.println("-------");
           
           for(int i = 0; i < positionen.size(); i++){
        	   System.out.println(positionen.get(i));
           }System.out.println("-------");
           
           for(int i = 0; i < ueberlaeufe.size(); i++){
        	   System.out.println(ueberlaeufe.get(i));
           }System.out.println("-------");
           
           
           
		} catch (FileNotFoundException e) {
			System.err.println("Konnte Datei nicht öffnen");
		} catch (IOException e) {
			System.err.println("Fehler bei der Ein-/Ausgabe: " + e);
		}
		finally{
			try {
				reader.close();
			} catch (Exception e) {
				System.err.println("Fehler beim schließen der Datei");
			}
		}
		
		return null;
	}

	
	
}
