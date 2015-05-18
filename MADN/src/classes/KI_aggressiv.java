package classes;

/**
 * Die Defensive KI-Klasse
 * @author Sebastian Stumm, Patrick Smuda, Mersiha Dervisevic
 * @version 1.0
 */

public class KI_aggressiv extends KI{
	
	private static final long serialVersionUID = 1L;
	private iBediener p;
	private boolean repeat = false;
	private boolean bewegt = false;
	
	/**
	 * Der Konstruktor der Defensiven KI
	 * @param spieler der Spieler mit der KI
	 * @param spiel das Spiel an der die KI teil nimmt
	 */
	
	public KI_aggressiv(Spieler spieler, Spiel spiel){
		super(spieler, spiel);
		p = spiel;
	}
	
	/**
	 * Die Methode die den eigentlichen Spielzug der KI durchführt
	 */
	@Override
	public void kalkuliereSpielzug() {
		
		do{
			p.wuerfeln();
			//ASDF
			System.out.println("Spieler: " + spieler.getName());
			System.out.println("Würfelwert: " + p.getBewegungsWert());
			System.out.println("Figur 1: "+ spieler.getFigur(0).getPosition()+"\tFigur 2: "
			+ spieler.getFigur(1).getPosition()+"\tFigur 3: "
					+ spieler.getFigur(2).getPosition()+"\tFigur 4: "
			+ spieler.getFigur(3).getPosition());
			if(bewegt == false && schlageGegner()){
				if(p.getBewegungsWert() == 6){
					bewegt = true;
					repeat = true;
				}else{
					bewegt = false;
					repeat = false;
					//break;
				}
			}else if(bewegt == false && betreteSpielfeld()){
				if(p.getBewegungsWert() == 6){
					bewegt = true;
					repeat = true;
				}else{
					bewegt = false;
					repeat = false;
					//break;
				}
			}else if(bewegt == false &&geheAufEndfeld()){
				if(p.getBewegungsWert() == 6){
					bewegt = true;
					repeat = true;
				}else{
					bewegt = false;
					repeat = false;
					//break;
				}
			}else if(bewegt == false && laufEinfach()){
				if(p.getBewegungsWert() == 6){
					bewegt = true;
					repeat = true;
				}else{
					bewegt = false;
					repeat = false;
					//break;
				}
			}else{
				p.zugBeenden();
				repeat = false;
				bewegt = true;
			}
			
			System.out.println("Figur 1: "+ spieler.getFigur(0).getPosition()+"\tFigur 2: "
					+ spieler.getFigur(1).getPosition()+"\tFigur 3: "
							+ spieler.getFigur(2).getPosition()+"\tFigur 4: "
					+ spieler.getFigur(3).getPosition());
			System.out.println("--------------------------------------------------------------");
			bewegt = false;
		}while(repeat);
		
	}
	
}
