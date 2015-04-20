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
		
		
	
	
	
	public Object laden(){ 
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
						
           ArrayList <String> zeug = new ArrayList <String>();
           String [][] anderesZeug;
           
           
            int i=0; //anzahl von Zeilen
            
            do{
            	zeug.add(reader.readLine());
            	i++;
            }while(zeug.get(i-1)!=null);
           
            anderesZeug = new String[5][];
            
//            anderesZeug [0] = new String [zeug.size()-1]; // name vom spieler
//            anderesZeug [1] = new String [zeug.size()-1]; // farbe vom spieler
//            anderesZeug [2] = new String [(zeug.size()-1)*4]; // positionen von den figuren
//            anderesZeug [3] = new String [(zeug.size()-1)*4]; // ueberlauf
//            anderesZeug [4] = new String [1]; // spieler am zug
            
            Spieler [] spieler = new Spieler [zeug.size()-1];
			Spiel s = new Spiel();
			Spielbrett sb = new Spielbrett();
			 int x=0;
			 String spielerAmZug;
			 int f; //farbe
     
			String [] neuerString;
            
           for(int k=0; k<zeug.size();k++){ 
 
              neuerString = zeug.get(k).split(";");
               
              switch (neuerString[1]){
              
               case "Rot": f=0;
               break; 
               
               case "Blau" : f=1;
               break;
               
               case "Gelb" : f=3;
               break; 
               
               case "Gruen" : f=2;
               break;
               
               default: throw new RuntimeException ("Farbe wurde nicht abgespeichert");
               
               }
              
              try{
            	x=Integer.parseInt(neuerString[3]); 
              }catch(NumberFormatException e){ 
            	  System.err.println("KI is kein int! man");
              }
              
              if(k<=zeug.size()-1){
               s.spielerHinzufuegen(neuerString[0], f, x);
              }else {
            	  spielerAmZug = neuerString[4];
              }
        	   }            
        	
            
		} catch (FileNotFoundException e) {
			System.err.println("Konnte Datei nicht �ffnen");
		} catch (IOException e) {
			System.err.println("Fehler bei der Ein-/Ausgabe: " + e);
		}
		finally{
			try {
				reader.close();
			} catch (Exception e) {
				System.err.println("Fehler beim schlie�en der Datei");
			}
		}
		
		return null;
	}

	
	
}
