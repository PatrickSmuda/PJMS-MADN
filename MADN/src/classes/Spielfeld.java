package classes;
/**
 * Die Klasse Spielfeld
 * @author ""
 * @version 1.0
 */
public class Spielfeld {
	
	private Spielfigur figur;
	private int id;
	private FeldTyp typ;
	private FarbEnum feldFarbe;
	
	public Spielfeld(FeldTyp typ, FarbEnum farbe, int id){
		switch(typ)
		{
		case Normalfeld: this.typ = FeldTyp.Normalfeld; this.id=id; figur = null; feldFarbe = null;  break;
		case Startfeld: this.typ = FeldTyp.Startfeld; this.id=id; figur = null; feldFarbe = figur.getFarbe();  break;
		case Endfeld: this.typ = FeldTyp.Endfeld; this.id=id;  figur = null; feldFarbe = farbe;  break;
		default: throw new RuntimeException("Kein gültiges Feld konnte erstellt werden!");
		}
	}
	
	public Spielfigur getFigur(){
		return this.figur;
	}
	
	public void setFigur(Spielfigur figur){
		if(figur!=null){
		this.figur=figur;
		} else throw new RuntimeException ("Andere Spielfigur ist schon drauf");
	}
	
	public int getId(){ 
		return this.id;
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
