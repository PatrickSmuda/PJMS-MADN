package classes;

public class KI_offensiv extends KI{


	public KI_offensiv(Spieler spieler, iBediener spiel) {
		super(spieler, spiel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void kalkuliereSpielzug(){
		int k =0;
		
		do{
			spiel.wuerfeln();
			k = spiel.getBewegungsWert();
			if (schlageGegner() == true){
				break;
			}else
			{
				if (spiel.getSpielerAmZug().equals(spieler.getName()) && betreteSpielfeld() == true){
					break;
				}
				else{
					if (spiel.getSpielerAmZug().equals(spieler.getName()) && geheAufEndfeld() == true){
						break;
					}else{
						laufEinfach();
					}
				}
			}
		}while(k == 6);
		
	}
	
	/*
	@Override
	public void kalkuliereSpielzug() {
		int k;
		
		do{
			
			spiel.wuerfeln();
			k= spiel.getBewegungsWert();
			schlageGegner();
			
			if (spiel.getSpielerAmZug().equals(spieler.getName()))
			{
				betreteSpielfeld();
				if (spiel.getSpielerAmZug().equals(spieler.getName()))
				{
					geheAufEndfeld();

					if(spiel.getSpielerAmZug().equals(spieler.getName()))
					{
						laufEinfach();
					}
					else{

					}
				}
				else{
					return;
				}
			}
			else{
				return;
			}
		}while(k==6);
	
	}
*/
}
