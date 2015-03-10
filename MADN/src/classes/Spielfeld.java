package classes;

enum FeldTyp{
	Normalfeld,
	Startfeld,
	Endfeld
}

public class Spielfeld {
	
	private Spielfigur figur;
	private static int id;
	private FeldTyp typ;
	
	public Spielfeld(int typ){
		switch(typ)
		{
		case 0: this.typ = FeldTyp.Normalfeld; id++; break;
		case 1: this.typ = FeldTyp.Startfeld; break;
		case 2: this.typ = FeldTyp.Endfeld; break;
		default: throw new RuntimeException("Kein gültiges Feld konnte erstellt werden!");
		}
	}
	
}
