package classes;

enum FarbEnum{
	rot,
	blau,
	grün,
	gelb
}

public class Spielfigur {
	private FarbEnum farbe; // testtestblabla
	private int position;
	
	public Spielfigur(int farbe){
		switch(farbe){
		case 0: this.farbe = FarbEnum.rot; break;
		case 1: this.farbe = FarbEnum.blau; break;
		case 2: this.farbe = FarbEnum.grün; break;
		case 3: this.farbe = FarbEnum.gelb; break;
		default: throw new RuntimeException("Farbe existiert nicht");
		}
	}
	
	

}

