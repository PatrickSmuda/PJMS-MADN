package classes;

/**
 * Die Defensive KI-Klasse
 * @author Sebastian Stumm, Patrick Smuda, Mersiha Dervisevic
 * @version 1.0
 */

public class KI_aggressiv extends KI{
	
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
			//System.out.println(p.getBewegungsWert());
			if(bewegt == false && schlageGegner()){
				if(p.getBewegungsWert() == 6){
					bewegt = true;
					repeat = true;
				}else{
					bewegt = false;
					repeat = false;
					break;
				}
			}else if(bewegt == false && betreteSpielfeld()){
				if(p.getBewegungsWert() == 6){
					bewegt = true;
					repeat = true;
				}else{
					bewegt = false;
					repeat = false;
					break;
				}
			}else if(bewegt == false &&geheAufEndfeld()){
				if(p.getBewegungsWert() == 6){
					bewegt = true;
					repeat = true;
				}else{
					bewegt = false;
					repeat = false;
					break;
				}
			}else if(bewegt == false && laufEinfach()){
				if(p.getBewegungsWert() == 6){
					bewegt = true;
					repeat = true;
				}else{
					bewegt = false;
					repeat = false;
					break;
				}
			}
			System.out.println(p.getPosition(1));
			bewegt = false;
		}while(repeat);
		
	}
	
}
