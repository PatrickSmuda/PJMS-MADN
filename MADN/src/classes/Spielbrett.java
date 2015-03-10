package classes;

public class Spielbrett {
	
	private Spielfeld[] brett;
	
	public Spielbrett(){
		brett = new Spielfeld[76];
		
		for(int i = 0; i < 4; i++){
			brett[i] = new Spielfeld(FeldTyp.Startfeld,FarbEnum.rot);
		}
		for(int i = 4; i < 8; i++){
			brett[i] = new Spielfeld(FeldTyp.Startfeld, FarbEnum.blau);
		}
		for(int i = 8; i < 12; i++){
			brett[i] = new Spielfeld(FeldTyp.Startfeld, FarbEnum.grün);
		}
		for(int i = 12; i < 16; i++){
			brett[i] = new Spielfeld(FeldTyp.Startfeld, FarbEnum.gelb);
		}
		for(int i = 16; i < 20; i++){
			brett[i] = new Spielfeld(FeldTyp.Endfeld, FarbEnum.rot);
		}
		for(int i = 20; i < 24; i++){
			brett[i] = new Spielfeld(FeldTyp.Endfeld, FarbEnum.blau);
		}
		for(int i = 24; i < 28; i++){
			brett[i] = new Spielfeld(FeldTyp.Endfeld, FarbEnum.gelb);
		}
		for(int i = 28; i < 32; i++){
			brett[i] = new Spielfeld(FeldTyp.Endfeld, FarbEnum.grün);
		}
		for(int i = 28; i < brett.length; i++){
			brett[i] = new Spielfeld(FeldTyp.Normalfeld, null);
		}
		 
		 
		

			
		
	}
	public Spielfeld[] getBrett(){
		return this.brett;
	}

	
}
