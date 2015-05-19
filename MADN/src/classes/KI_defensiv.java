package classes;

/**
 * Die Defensive KI-Klasse
 * @author Sebastian Stumm, Patrick Smuda, Mersiha Dervisevic
 * @version 1.0
 */

public class KI_defensiv extends KI{
	
	private static final long serialVersionUID = 1L;
	private iBediener p;
	private boolean repeat = false;
	private boolean bewegt = false;
	
	/**
	 * Der Konstruktor der Defensiven KI
	 * @param spieler der Spieler mit der KI
	 * @param spiel das Spiel an der die KI teil nimmt
	 */
	
	public KI_defensiv(Spieler spieler, Spiel spiel){
		super(spieler, spiel);
		p = spiel;
	}
	
	/**
	 * Die Methode die den eigentlichen Spielzug der KI durchf�hrt
	 */
	@Override
	public String kalkuliereSpielzug() {
		String s = "";
		do{
			/*p.wuerfeln();
			System.out.println("Spieler: " + spieler.getName());
			System.out.println("W�rfelwert: " + p.getBewegungsWert());
			System.out.println("Figur 1: "+ spieler.getFigur(0).getPosition()+"\tFigur 2: "
			+ spieler.getFigur(1).getPosition()+"\tFigur 3: "
					+ spieler.getFigur(2).getPosition()+"\tFigur 4: "
			+ spieler.getFigur(3).getPosition());*/
			s = s + "KI "+spieler.getName() +" wuerfelt eine "+ p.getBewegungsWert()+"\n";
			if(bewegt == false && geheAufEndfeld()){
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
			}else if(bewegt == false &&schlageGegner()){
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
			s = s + "Figur 1: "+ (spieler.getFigur(0).getPosition().getId()+1)+"\tFigur 2: "
					+ (spieler.getFigur(1).getPosition().getId()+1)+"\tFigur 3: "
					+ (spieler.getFigur(2).getPosition().getId()+1)+"\tFigur 4: "
			+ (spieler.getFigur(3).getPosition().getId()+1)+"\n";
			/*System.out.println("Figur 1: "+ spieler.getFigur(0).getPosition()+"\tFigur 2: "
					+ spieler.getFigur(1).getPosition()+"\tFigur 3: "
							+ spieler.getFigur(2).getPosition()+"\tFigur 4: "
					+ spieler.getFigur(3).getPosition());
			System.out.println("--------------------------------------------------------------");*/
			
			bewegt = false;
		}while(repeat);
		return s;
		
	}
	
}
