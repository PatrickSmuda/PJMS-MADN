package classes;
/**
 * Die Klasse Spielfeld
 * @author ""
 * @version 1.0
 */
public class Spielfeld {
	
	private Spielfigur figur;
	private static int id;
	private FeldTyp typ;
	private Spieler spielerFeld; 
	private FarbEnum feldFarbe;
	
	public Spielfeld(FeldTyp typ, FarbEnum farbe, int id){
		switch(typ)
		{
		case Normalfeld: this.typ = FeldTyp.Normalfeld; figur = null; feldFarbe = null;  break;
		case Startfeld: this.typ = FeldTyp.Startfeld; figur = null; feldFarbe = figur.getFarbe();  break;
		case Endfeld: this.typ = FeldTyp.Endfeld;  figur = null; feldFarbe = farbe;  break;
		default: throw new RuntimeException("Kein gültiges Feld konnte erstellt werden!");
		}
	}
	
	public Spielfigur getFigur(){
		return this.figur;
	}
	
	public static int getId(){ 
		return id;
	}
	
	public FeldTyp getTyp(){ 
		return this.typ;
	}
	
	public FarbEnum getFeldFarbe(){ 
		return this.feldFarbe;
	}
	
	public String toString(){
		return this.feldFarbe+" "+this.typ;
	}
	
}
