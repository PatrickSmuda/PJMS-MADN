package classes;
/**
 * Die Klasse Spielfeld
 * @author ""
 * @version 1.0
 **/
public class Spielfeld {
	
	private Spielfigur figur;
	private int id;
	private FeldTyp typ;
	private FarbEnum feldFarbe;
	
	
	/**Konstruktor übergibt den Feldtyp, die Farbe und die ID vom Feld
	 * 
	 * @param typ
	 * @param farbe
	 * @param id
	 */
	public Spielfeld(FeldTyp typ, FarbEnum farbe, int id){
		switch(typ)
		{
		case Normalfeld: this.typ = FeldTyp.Normalfeld; this.id=id;  feldFarbe = farbe;  break;
		case Startfeld: this.typ = FeldTyp.Startfeld; this.id=id;  feldFarbe = farbe;  break;
		case Endfeld: this.typ = FeldTyp.Endfeld; this.id=id;  feldFarbe = farbe;  break;
		default: throw new RuntimeException("Kein gültiges Feld konnte erstellt werden!");
		}
	}
	
	/**Gibt die Spielfigur zurück
	 * @return
	 */
	public Spielfigur getFigur(){
		return this.figur;
	}
	
	//
	public void setFigur(Spielfigur figur){
		if(figur!=null){
		this.figur=figur;
		} else throw new RuntimeException ("Andere Spielfigur ist schon drauf");
	}
	
	/**Gibt die ID für das Feld zurück
	 * */
	
	public int getId(){ 
		return this.id;
	}
	
	/**Gibt den Feldtypen zurück
	 * 
	 * @return
	 */
	public FeldTyp getTyp(){ 
		return this.typ;
	}
	
	/**Die Methode gibt die Farbe vom Feld zurück
	 * @return
	 */
	public FarbEnum getFeldFarbe(){ 
		return this.feldFarbe;
	}
	
	
	public String toString(){
		return this.feldFarbe+" "+this.typ;
	}
	
}
