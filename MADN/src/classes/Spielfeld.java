package classes;

import java.io.Serializable;

/**
 * Die Klasse Spielfeld
 * @author ""
 * @version 1.0
 **/
public class Spielfeld implements Serializable {
	
	private Spielfigur figur;
	private int id;
	private FeldTyp typ;
	private FarbEnum feldFarbe;
	
	
	/**Konstruktor uebergibt den Feldtyp, die Farbe und die ID vom Feld
	 * 
	 * @param typ Typ des Feldes
	 * @param farbe Farbe des Feldes
	 * @param id Id des Feldes
	 */
	public Spielfeld(FeldTyp typ, FarbEnum farbe, int id){
		switch(typ)
		{
		case Normalfeld: this.typ = FeldTyp.Normalfeld; this.id=id;  feldFarbe = farbe;  break;
		case Startfeld: this.typ = FeldTyp.Startfeld; this.id=id;  feldFarbe = farbe;  break;
		case Endfeld: this.typ = FeldTyp.Endfeld; this.id=id;  feldFarbe = farbe;  break;
		default: throw new RuntimeException("Kein gueltiges Feld konnte erstellt werden!");
		}
	}
	
	/**Gibt die Spielfigur zurueck
	 * @return figur Gibt die Spielfigur zurueck
	 */
	public Spielfigur getFigur(){
		return this.figur;
	}
	
	/**
	 * Die Methode setzt die Figur auf die Startposition
	 * @param figur 
	 */
	public void setFigur(Spielfigur figur){
		if(figur == null) this.figur = null;
		if(this.figur == null) this.figur = figur;
		else{
			this.figur.setPosition(figur.getStartPosition());
			this.figur = figur;
		}
	}
	
	/**Gibt die ID fuer das Feld zurueck
	 *@return id Die ID fuer ein Feld
	 */ 
	
	public int getId(){ 
		return this.id;
	}
	
	/**Gibt den Feldtypen zurueck
	 * 
	 * @return typ Gibt den Typ des Feldes zurueck
	 */
	public FeldTyp getTyp(){ 
		return this.typ;
	}
	
	/**Die Methode gibt die Farbe vom Feld zurueck
	 * @return feldfarbe Gibt die Farbe des Feldes zurueck
	 */
	public FarbEnum getFeldFarbe(){ 
		return this.feldFarbe;
	}
	/**
	 * Die Methode toString wird überschrieben
	 * @return id,typ 
	 */
	@Override
	public String toString(){
	return this.id+" "+this.typ;
}
	
}
