package classes;

public class Spielfeld {
	
	private Spielfigur figur;
	private static int id;
	private FeldTyp typ;
	//private Spieler spielerFeld;
	private FarbEnum feldFarbe;
	
	public Spielfeld(FeldTyp typ, FarbEnum farbe){
		switch(typ)
		{
		case Normalfeld: this.typ = FeldTyp.Normalfeld; figur = null; feldFarbe = null; break;
		case Startfeld: this.typ = FeldTyp.Startfeld; figur = null; feldFarbe = figur.getFarbe(); break;
		case Endfeld: this.typ = FeldTyp.Endfeld;  figur = null; feldFarbe = farbe; break;
		default: throw new RuntimeException("Kein gültiges Feld konnte erstellt werden!");
		}
	}
	
	public String toString(){
		return this.feldFarbe+" "+this.typ;
	}
	
}
