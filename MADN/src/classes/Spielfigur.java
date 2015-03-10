package classes;

//Test Kommentar

public class Spielfigur {
	private FarbEnum farbe;
	private int position;
	
	public Spielfigur(FarbEnum farbe){
		this.farbe = farbe;
	}
	
	public FarbEnum getFarbe(){
		return this.farbe;
	}

}

