package classes;
/**
 * Das Interface iBediener
 * @author 
 * @version 1.0
 */

public interface iBediener{
	
	public void wuerfeln();
	
	public void bewege(int id);
	
	public void spielerHinzufuegen(String name, int f, int KI);
	
	public void beginneSpiel();
	
	public String getSpielerAmZug();
	
	public int getBewegungsWert();
	
	public boolean figurAufFeld(int id);
	
	public String getPosition(int n);
	
	public String getGewinner();
	
	public boolean grenzUeberschreitung(int neuePosition);
	
	public int ueberlauf(int neuePosition, int figurId);
	
	public int endfeld(int neuePosition);
	
	public boolean zugGueltigEndfeld(int neuePosition);
	
	public boolean zugGueltigAufEndfeld(int neuePosition, int n);
	
	public boolean kannEndfeldErreichen(int neuePosition);
	
	public boolean userIstDumm(int neuePosition, int figurId);
	
	
	//Für die TestKlasse
	
		public void benutzeKI();
	
		public void wuerfeln2();

		public void wuerfeln6();
		
		public void wuerfeln42();
		
		public void setTestPosition(int figurId, int id);
		
		public void zugBeenden();
	}
