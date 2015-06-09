package classes;

/**
 * Die Klasse Spiel 
 * @author Sebastian Stumm, Johannes M�ndle
 * @version 1.0
 */


import java.io.Serializable;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;

public class SpielBean implements iBedienerBean, Serializable {

	/**
	 * Die Attribute der Klasse Spiel.
	 */
	private static final long serialVersionUID = 1L;
	public Spielbrett getSpielbrett() {
		return spielbrett;
	}
	public void setSpielbrett(Spielbrett spielbrett) {
		this.spielbrett = spielbrett;
	}
	public ArrayList<Spieler> getSpieler() {
		return spieler;
	}
	public void setSpieler(ArrayList<Spieler> spieler) {
		this.spieler = spieler;
	}
	public Spielfigur getAusgewaehlteFigur() {
		return ausgewaehlteFigur;
	}
	public void setAusgewaehlteFigur(Spielfigur ausgewaehlteFigur) {
		this.ausgewaehlteFigur = ausgewaehlteFigur;
	}
	public boolean isDarfWuerfeln() {
		return darfWuerfeln;
	}
	public void setDarfWuerfeln(boolean darfWuerfeln) {
		this.darfWuerfeln = darfWuerfeln;
	}
	public boolean isHatGewuerfelt() {
		return hatGewuerfelt;
	}
	public void setHatGewuerfelt(boolean hatGewuerfelt) {
		this.hatGewuerfelt = hatGewuerfelt;
	}
	public boolean isSpielHatBegonnen() {
		return spielHatBegonnen;
	}
	public void setSpielHatBegonnen(boolean spielHatBegonnen) {
		this.spielHatBegonnen = spielHatBegonnen;
	}
	public boolean isHatUeberlauf() {
		return hatUeberlauf;
	}
	public void setHatUeberlauf(boolean hatUeberlauf) {
		this.hatUeberlauf = hatUeberlauf;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public ArrayList<Spielfigur> getFigurenUeberlauf() {
		return figurenUeberlauf;
	}
	public void setFigurenUeberlauf(ArrayList<Spielfigur> figurenUeberlauf) {
		this.figurenUeberlauf = figurenUeberlauf;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setSpielerAmZug(Spieler spielerAmZug) {
		this.spielerAmZug = spielerAmZug;
	}
	public void setBewegungsWert(int bewegungsWert) {
		this.bewegungsWert = bewegungsWert;
	}
	public void setGewinner(Spieler gewinner) {
		this.gewinner = gewinner;
	}


	private Spielbrett spielbrett;
	private ArrayList<Spieler> spieler; 
	private Spieler spielerAmZug;
	private Spielfigur ausgewaehlteFigur;
	private boolean darfWuerfeln;
	private int bewegungsWert;
	private boolean hatGewuerfelt;
	private Spieler gewinner;
	private boolean spielHatBegonnen;
	private boolean hatUeberlauf;
	private int count=1;
	private ArrayList<Spielfigur> figurenUeberlauf;
	

	/**
	 * Der Konstruktor f�r die Klasse Spiel erstellt ein Spielbrett und setzt die Anfangswerte
	 */
	public SpielBean(){
		this.spielbrett = new Spielbrett();
		this.hatGewuerfelt = false;
		this.darfWuerfeln = true;
		this.spielHatBegonnen = false;
		this.spieler = new ArrayList<Spieler>();
		this.hatUeberlauf = false;
		this.figurenUeberlauf = new ArrayList<Spielfigur>();
	}
	/**
	 * Gibt den Bewegungwert eines Spielzug zurueck
	 * @return bewegungsWert
	 */

	@Override
	public int getBewegungsWert(){
		return this.bewegungsWert;
	}
	
	/**
	 * F�gt dem Spiel einen Spieler hinzu.
	 * @param spieler Der Spieler, der hinzugef�gt werden soll.
	 */
	
	@Override
public void spielerHinzufuegen(String name, int f, int KI){
		
		if(!spielHatBegonnen){
			if(spieler == null){
				throw new RuntimeException("Spieler existiert nicht!");
			}
			Spieler spieler;
			FarbEnum farbe = null;
		
			switch (f) {
			case 0: farbe = FarbEnum.rot; break;
			case 1: farbe = FarbEnum.blau; break;
			case 2: farbe = FarbEnum.gruen; break;
			case 3: farbe = FarbEnum.gelb; break;
			default: throw new RuntimeException("Farbe existiert nicht!");
			}
			
			switch(KI)
			{
			case 0: spieler = new Spieler(name, farbe, null, spielbrett); break;
			case 1: 
				spieler = new Spieler(name, farbe, null, spielbrett);
				KI_aggressiv ofKI = new KI_aggressiv(spieler, this); 
				spieler.setKI(ofKI); break;
			case 2: 
				spieler = new Spieler(name, farbe, null, spielbrett);
				KI_defensiv defKI = new KI_defensiv(spieler, this); 
				spieler.setKI(defKI); break;
			default: throw new RuntimeException("Spieler konnte nicht erstellt werden!");
			}
			
			
			
			this.spieler.add(spieler);
		}
		
	}
	/**
	 * Die Methode beginnt das Spiel.
	 */
	
	@Override
	public void beginneSpiel(){
		if(this.spieler.size() >= 2){
			this.spielHatBegonnen = true;
			this.spielerAmZug = this.spieler.get(0);
		} else throw new RuntimeException("Spiel muss mindestens 2 Spieler haben!");
		
	}
	
	/**
	 * Hilfsmethode fuer CSV
	 *
	 * @return String s, vorgefertigter String
	 */
	
	public String csvString(){ 
		String s= "";
		
		for(int i=0;i<spieler.size();i++){
			s+=spieler.get(i).getName()+";"+spieler.get(i).getFarbe()+";"+spieler.get(i).getKIWert()+";"
					+spieler.get(i).getFigur(0).getPosition().getId()+";"+figurenUeberlauf.contains(spieler.get(i))+";"
					+spieler.get(i).getFigur(1).getPosition().getId()+";"+figurenUeberlauf.contains(spieler.get(i))+";"
					+spieler.get(i).getFigur(2).getPosition().getId()+";"+figurenUeberlauf.contains(spieler.get(i))+";"
					+spieler.get(i).getFigur(3).getPosition().getId()+";"+figurenUeberlauf.contains(spieler.get(i))+";\n";
		}
		s+=spielerAmZug.getName();
		return s;
	}
	
	/**
	 * Diese Methode gibt die Farbe und die ID der Figur zurueck
	 * @param feldId
	 * @return int [] temp
	 */
	
	public int [] figurInfos(int feldId){ 
		
		
		if(figurAufFeld(feldId)){
			for(int i=0; i<spieler.size(); i++){
				for(int j=0; j<4; j++){
					if(spieler.get(i).getFigur(j)==spielbrett.getFeld(feldId).getFigur()){
						int [] temp = new int[2];
						
						switch (spieler.get(i).getFarbe()){
						case rot: temp[0]=0; break;
						case blau: temp[0]=1; break;
						case gelb: temp[0]=3; break;
						case gruen: temp[0]=2; break;
						}
						
						temp[1]=j;
						
						return temp;
						
					}
					
				}
			}
		} throw new RuntimeException ("Auf dem Feld ist keine Figur");
	}
	
	/**
	 * Methode zum bewegen der Spielfigur
	 * @param sf Spielfigur die bewegt wird
	 */
	@Override
	public void bewege(int figurId){
		if(this.spielHatBegonnen){
			if(figurId > 4 || figurId < 0) throw new RuntimeException("Figur existiert nicht!");
			
			int neuePosition = this.spielerAmZug.getFigur(figurId).getPosition().getId() + this.bewegungsWert;
			
			if(this.bewegungsWert == 6 && this.spielerAmZug.getFigur(figurId).getPosition().getTyp() == FeldTyp.Startfeld){
				neuePosition = this.spielerAmZug.getFigur(figurId).getFreiPosition();
				if(userIstDumm(neuePosition, figurId)){
					zugBeenden();
				}else{
					this.spielerAmZug.getFigur(figurId).setPosition(this.spielbrett.getFeld(neuePosition));
					this.spielerAmZug.getFigur(figurId).getPosition().setFigur(this.spielerAmZug.getFigur(figurId));
					
				}
			}
			
			else if(this.bewegungsWert != 6 && this.spielerAmZug.getFigur(figurId).getPosition().getTyp() == FeldTyp.Startfeld){
				zugBeenden();
			}
			
			else if(this.spielerAmZug.getFigur(figurId).getPosition().getTyp() == FeldTyp.Endfeld){
				if (zugGueltigAufEndfeld(neuePosition, figurId)) {
					this.spielbrett.getFeld(this.spielerAmZug.getFigur(figurId).getPosition().getId()).setFigur(null);
					this.spielerAmZug.getFigur(figurId).setPosition(this.spielbrett.getFeld(neuePosition));
					this.spielerAmZug.getFigur(figurId).getPosition().setFigur(this.spielerAmZug.getFigur(figurId));
					if(bewegungsWert != 6){
						zugBeenden();
					}
				}else {
					zugBeenden();
				}
			}
			
			else if(this.spielerAmZug.getFigur(figurId).getPosition().getTyp() == FeldTyp.Normalfeld){
				neuePosition = ueberlauf((this.spielerAmZug.getFigur(figurId).getPosition().getId() + this.bewegungsWert), figurId);
				
				
					if(kannEndfeldErreichen(neuePosition)){
						if(zugGueltigEndfeld(neuePosition)){
							if(endfeld(neuePosition) == neuePosition){
								zugBeenden();
							}
							else if(userIstDumm(neuePosition, figurId)){
								zugBeenden();
							}
							else{
								this.spielbrett.getFeld(this.spielerAmZug.getFigur(figurId).getPosition().getId()).setFigur(null);
								this.spielerAmZug.getFigur(figurId).setPosition(this.spielbrett.getFeld(endfeld(neuePosition)));
								this.spielerAmZug.getFigur(figurId).getPosition().setFigur(this.spielerAmZug.getFigur(figurId));
							}
							
							
						}
					}else{
						if(!grenzUeberschreitung(neuePosition)){
							int test = this.spielerAmZug.getFigur(figurId).getPosition().getId();
							this.spielbrett.getFeld(test).setFigur(null);
							this.spielerAmZug.getFigur(figurId).setPosition(this.spielbrett.getFeld(neuePosition));
							this.spielerAmZug.getFigur(figurId).getPosition().setFigur(this.spielerAmZug.getFigur(figurId));
						}else{
							zugBeenden();
						}
						
					}
					if(this.bewegungsWert != 6){
						zugBeenden();
					}
				}
			}
			
			hatGewuerfelt = false;
			
		
	}
	
	
	public ArrayList<String> getAllFigures(){
		ArrayList<String> temp = new ArrayList<String>();
		for(int i = 0; i < spieler.size(); i++){
			for(int j = 0; j < 4; j++){
				temp.add(spieler.get(i).getFarbe()+"_"+spieler.get(i).getFigur(j).getPosition().getId()+"_"+j);
			}
			
		}
		return temp;
	}
	
	/**
	 * Die Methode beschreibt ob die Figuren die Grenze ueberschreiten
	 * @param neuePosition
	 * @return boolean
	 */
	@Override
	public boolean grenzUeberschreitung(int neuePosition){
		switch(spielerAmZug.getFarbe())
		{
		case rot: 
			if(neuePosition > 39) return true;
			return false;
		case blau: 
			if(neuePosition > 9 && hatUeberlauf) return true;
			return false;
		case gruen: 
			if(neuePosition > 19 && hatUeberlauf) return true;
			return false;
		case gelb: 
			if(neuePosition > 29 && hatUeberlauf) return true;
			return false;
		default: throw new RuntimeException("Spieler hat keine Farbe!");
		}
	}
	/**
	 * Die Methode beschreibt den �berlauf
	 * @param neuePosition
	 * @param figurId
	 * @return neuePosition, figurId
	 */
	@Override
	public int ueberlauf(int neuePosition, int figurId){
		int hit = 0;
		if(neuePosition > 39){
			for(int i = 0; i < figurenUeberlauf.size(); i++){
				if(spielerAmZug.getFigur(figurId) == figurenUeberlauf.get(i) && spielerAmZug.getFigur(figurId).getPosition().getTyp() != FeldTyp.Endfeld){
					//throw new RuntimeException("Figur will 2 mal ueber 0 laufen!");
				}
			}
			figurenUeberlauf.add(spielerAmZug.getFigur(figurId));
			hatUeberlauf = true;
			return (neuePosition-40);
		}
		
		for(int i = 0; i < figurenUeberlauf.size(); i++){
			if(spielerAmZug.getFigur(figurId) == figurenUeberlauf.get(i) && spielerAmZug.getFigur(figurId).getPosition().getTyp() != FeldTyp.Endfeld){
				hit++;
			}
		}
		
		if(hit != 0){
			hatUeberlauf = true;
		}else{
			hatUeberlauf = false;
		}
		
		return neuePosition;
	}
	
	/**
	 * Die Methode setzt die geladenen Wert
	 * @param positionen
	 * @param farbe
	 * @param ueberlaeufe
	 * @param spielerAmZug
	 */
	public void csvLadenSetter(int[] positionen, int farbe, boolean[] ueberlaeufe, String spielerAmZug){
		FarbEnum f;
		switch(farbe)
		{
		case 0: f = FarbEnum.rot; break;
		case 1: f = FarbEnum.blau; break;
		case 2: f = FarbEnum.gruen; break;
		case 3: f = FarbEnum.gelb; break;
		default: throw new RuntimeException("Keine Farbe wurde uebergeben!");
		}
		for(int i = 0; i < spieler.size(); i++){
			if(spieler.get(i).getFarbe() == f){
				for(int j = 0; j < 4; j++){
					spieler.get(i).getFigur(j).setPosition(this.spielbrett.getFeld(positionen[j]));
					spieler.get(i).getFigur(j).getPosition().setFigur(spieler.get(i).getFigur(j));
					if(ueberlaeufe[j] == true){
						figurenUeberlauf.add(spieler.get(i).getFigur(j));
					}
				}
				
			}
			if(spieler.get(i).getName() == spielerAmZug){
				this.spielerAmZug = spieler.get(i);
			}
		}
		
	}
	
	/**
	 * Die Methode weist die Endfelder zu
	 * @param neuePosition
	 * @return neue Position
	 */
	
	@Override
	public int endfeld(int neuePosition){
		switch(spielerAmZug.getFarbe())
		{
		case rot: 
			if(68+neuePosition <= 71)
				return (68+neuePosition);
			return neuePosition;
		case blau:
			if(56+neuePosition-10 <= 59)
				return (56+(neuePosition-10));
			return neuePosition;
		case gruen:
			if(64+neuePosition-20 <= 67)
				return (64+(neuePosition-20));
			return neuePosition;
		case gelb:
			if(60+neuePosition-30 <= 63)
				return (60+(neuePosition-30));
			return neuePosition;
		default: throw new RuntimeException("Fehler beim betreten des Endfeldes!");
		}
	}
	
	/**
	 * Diese Methode ueberprueft ob der Zug auf das Endfeld gueltig ist
	 * @param neuePosition
	 * @return boolean
	 */
	
	@Override
	public boolean zugGueltigEndfeld(int neuePosition){
		switch(spielerAmZug.getFarbe())
		{
		case rot:
			if(neuePosition < 4 && hatUeberlauf){
				for(int i = 0; i < 4; i++){
					if(figurAufFeld(68+i) && i < neuePosition){
						return false;
					}
				}return true;
			}
			
		case blau:
			if(neuePosition < 14 && hatUeberlauf){
				for(int i = 0; i < 4; i++){
					if(figurAufFeld(56+i) && i < neuePosition-9){
						return false;
					}
				}return true;
			}
			
		case gruen:
			if(neuePosition < 24 && hatUeberlauf){
				for(int i = 0; i < 4; i++){
					if(figurAufFeld(64+i) && i < neuePosition-19){
						return false;
					}
				}return true;
			}
			
		case gelb:
			if(neuePosition < 34 && hatUeberlauf){
				for(int i = 0; i < 4; i++){
					if(figurAufFeld(60+i) && i < neuePosition-29){
						return false;
					}
				}return true;
			}
			
		default: return false;
			
		}
		

	}
	/**
	 * Die Methode ueberpreuft ob der Spieler sich auf dem Endfeld bewegen darf
	 */
	@Override
	public boolean zugGueltigAufEndfeld(int neuePosition, int n){
		int x = 0;
		switch(spielerAmZug.getFarbe())
		{
		case rot:
			x = 71 - spielerAmZug.getFigur(n).getPosition().getId();
			if(spielerAmZug.getFigur(n).getPosition().getId()+getBewegungsWert() > 71){
				return false;
			}else{
				for (int i = spielerAmZug.getFigur(n).getPosition().getId(); i < spielerAmZug.getFigur(n).getPosition().getId()+getBewegungsWert(); i++) {
					if (figurAufFeld(i+1)) {
						return false;
					}
				}
				return true;
			}
			
		case blau:
			x = 59 - spielerAmZug.getFigur(n).getPosition().getId();
			if(spielerAmZug.getFigur(n).getPosition().getId()+getBewegungsWert() > 59){
				return false;
			}else{
				for (int i = spielerAmZug.getFigur(n).getPosition().getId(); i < spielerAmZug.getFigur(n).getPosition().getId()+getBewegungsWert(); i++) {
					if (figurAufFeld(i+1)) {
						return false;
					}
				}
				return true;
			}
			
		case gruen:
			x = 67 - spielerAmZug.getFigur(n).getPosition().getId();
			if(spielerAmZug.getFigur(n).getPosition().getId()+getBewegungsWert() > 67){
				return false;
			}else{
				for (int i = spielerAmZug.getFigur(n).getPosition().getId(); i < spielerAmZug.getFigur(n).getPosition().getId()+getBewegungsWert(); i++) {
					if (figurAufFeld(i+1)) {
						return false;
					}
				}
				return true;
			}
			
		case gelb:
			x = 63 - spielerAmZug.getFigur(n).getPosition().getId();
			if(spielerAmZug.getFigur(n).getPosition().getId()+getBewegungsWert() > 63){
				return false;
			}else{
				for (int i = spielerAmZug.getFigur(n).getPosition().getId(); i < spielerAmZug.getFigur(n).getPosition().getId()+getBewegungsWert(); i++) {
					if (figurAufFeld(i+1)) {
						return false;
					}
				}
				return true;
			}
			
		default: return false;
			
		}
		

	}
	/**
	 * Diese Methode ueberprueft ob der Spieler mit dem Zug das Endfeld erreichen kann
	 * @param neuePosition
	 * @return boolean
	 */
	
	@Override
	public boolean kannEndfeldErreichen(int neuePosition){
		switch(spielerAmZug.getFarbe())
		{
		case rot: 	if(neuePosition>=0&&hatUeberlauf) return true; return false;
		case blau:	if(neuePosition>9&&hatUeberlauf) return true; return false;
		case gruen:	if(neuePosition>19&&hatUeberlauf) return true; return false;
		case gelb:	if(neuePosition>29&&hatUeberlauf) return true; return false;
		default: return false;
		}
		}
	
	
	/**
	 * Die Methode wird ausgef�hrt, wenn ein Zug ung�ltig ist.
	 */
	private void ungueltigerZug(){
		zugBeenden();
	}
	/**
	 * �berpr�ft ob sich eine Figur auf dem Feld befindet
	 * @param id Die Feld ID
	 * @return boolean Gibt boolschen Wert zurueck
	 */
	@Override
	public boolean figurAufFeld(int id){
		if(spielbrett.getFeld(id).getFigur() != null) 
			return true;
		return false;
	}
	
	/**
	 * �berpr�ft ob eine Spielfigur laufen darf.
	 * @param sf Die zu �berpr�fende Spielfigur.
	 * @return boolean Gibt einen boolschen Wert zur�ck.
	 */
	private boolean kannLaufen(int neuePosition, Spielfigur sf){
		switch(sf.getFarbe())
		{
		case rot:
			if(neuePosition > 1){
				if(figurAufFeld(68)) return false;
				return false;
			}return true;
		case blau:
			if(neuePosition > 11){
				if(figurAufFeld(56)) return false;
				return false;
			}return true;
		case gruen:
			if(neuePosition > 21){
				if(figurAufFeld(64)) return false;
				return false;
			}return true;
		case gelb:
			if(neuePosition > 31){
				if(figurAufFeld(60)) return false;
				return false;
			}return true;
		default: return false;
		}
		
		
	}
	
	/**
	 * Gibt den Spieler der am Zug ist zur�ck
	 * @return spielerAmZug
	 */
	
	@Override
	public String getSpielerAmZug(){
		return this.spielerAmZug.getName()+"("+this.spielerAmZug.getFarbe()+")";
	}
	
	/**
	 * Gibt die Position der Spielfigur zurueck
	 */
	@Override
	public String getPosition(int n){
		return this.spielerAmZug.getFigur(n).getPosition().toString();
	}
	
	/**
	 * Wird aufgerufen, wenn der User versucht seine eigene Figur zu schlagen.
	 * @param neuePosition Die neue Position der Figur.
	 * @param sf Die Spielfigur 
	 * @return boolean Boolscher R�ckgabewert
	 */ 
	
	@Override
	public boolean userIstDumm(int neuePosition, int figurId){
		if((spielbrett.getFeld(neuePosition).getFigur() != null) && (spielbrett.getFeld(neuePosition).getFigur().getFarbe() == spielerAmZug.getFarbe())) return true;
		return false;
	}

	/**
	 * Methode gibt die ID des Spielers zurueck
	 * @return i ID des Spielers
	 */
	public int getCurrentPlayerId(){
		for(int i = 0; i < spieler.size(); i++){
			if(spieler.get(i).equals(spielerAmZug)){
				return i;
			}
		}
		return 0;
	}
	
	/**
	 * �berpr�ft ob ein Spieler eine freie Figur hat
	 * @param spieler Der zu �berpr�fende Spieler
	 * @return Gibt einen boolschen wert zur�ck, ob der Spieler eine freie Figur hat.
	 */
	public boolean hatFreieFigur(int id){
		if(spieler.get(id).getFigur(0).getPosition().getTyp() == FeldTyp.Startfeld &&
				spieler.get(id).getFigur(1).getPosition().getTyp() == FeldTyp.Startfeld &&
				spieler.get(id).getFigur(2).getPosition().getTyp() == FeldTyp.Startfeld &&
				spieler.get(id).getFigur(3).getPosition().getTyp() == FeldTyp.Startfeld )return false;
		return true;
	}
	/**
	 * Die Methode gibt die Position einer Spielfigur zurueck, von dem Spieler der gerade dran ist
	 * @param figurId
	 * @return figurId
	 */
	public int getPositionFigur(int figurId){
		return this.spielerAmZug.getFigur(figurId).getPosition().getId();
	}

	/**
	 * Setzt eine Spielfigur auf die Startposition zur�ck.
	 * @param figur Die Spielfigur
	 */
	private void aufStartPositionSetzen(Spielfigur figur){
		switch(figur.getFarbe())
		{
		case rot: this.spielbrett.getFeld(0).setFigur(figur); break;
		case blau: this.spielbrett.getFeld(11).setFigur(figur); break;
		case gruen: this.spielbrett.getFeld(21).setFigur(figur); break;
		case gelb: this.spielbrett.getFeld(31).setFigur(figur); break;
		}
	}
	
	/**
	 * Methode gibt die ID der Figur zurueck auf einem feld
	 * @param int feld feld das ueberprueft wird
	 * @return int i id der Figur
	 */
	public int figurIdAufFeld(int feld){
		if(spielbrett.getFeld(feld).getFigur() != null){
			for(int i = 0; i < 4; i++){
				if(spielerAmZug.getFigur(i) == spielbrett.getFeld(feld).getFigur()){
					return i;
				}
			}
		}
		throw new RuntimeException("Keine Figur ausgewaehlt!");
	}

	/**
	 * Die Methode w�rfelt.
	 */
	
	@Override
	public void wuerfeln(){
		if(spielHatBegonnen){
			/*System.out.println("Spiel darfWuerfeln: "+darfWuerfeln+"\nSpiel hatGewuerfelt: "+hatGewuerfelt+"\nSpiel spielerAmZug: "+spielerAmZug.getName()+"\nSpiel Bewegungswert: "+bewegungsWert+"\n"
		+spielerAmZug.getFigur(0).getPosition().getId()+"\\"
		+spielerAmZug.getFigur(1).getPosition().getId()+"\\"
		+spielerAmZug.getFigur(2).getPosition().getId()+"\\"
		+spielerAmZug.getFigur(3).getPosition().getId());*/
			if(this.darfWuerfeln == true && this.hatGewuerfelt == false){
				this.bewegungsWert = this.spielerAmZug.getWuerfel().werfen();
				if(this.bewegungsWert == 6) this.darfWuerfeln = true;
				else this.darfWuerfeln = false;
				hatGewuerfelt = true;
			}else{
				//zugBeenden();
				throw new RuntimeException("Darf nicht 2 mal Wuerfeln!");
			}
		}
	}
	
	/**
	 * TestMethode f�r die KI
	 * @return 
	 */

	//F�r die TestKlasse. Sp�ter l�schen!
	public String benutzeKI(){
		if(spielerAmZug.getKI() == null) throw new RuntimeException("Spieler hat keine KI!");
		return spielerAmZug.getKI().kalkuliereSpielzug();
	}
	
		public void wuerfeln2(){
			if(spielHatBegonnen){
				if(this.darfWuerfeln == true && this.hatGewuerfelt == false){
					this.bewegungsWert = this.spielerAmZug.getWuerfel().werfen2();
					if(this.bewegungsWert == 6) this.darfWuerfeln = true;
					else this.darfWuerfeln = false;
					hatGewuerfelt = true;
				}else throw new RuntimeException("Darf nicht 2 mal Wuerfeln!");
			}
		}
		public void wuerfeln6(){
			if(spielHatBegonnen){
				if(this.darfWuerfeln == true && this.hatGewuerfelt == false){
					this.bewegungsWert = this.spielerAmZug.getWuerfel().werfen6();
					if(this.bewegungsWert == 6) this.darfWuerfeln = true;
					else this.darfWuerfeln = false;
					hatGewuerfelt = true;
				}else throw new RuntimeException("Darf nicht 2 mal Wuerfeln!");
			}
		}
		public void wuerfeln42(){
			if(spielHatBegonnen){
				if(this.darfWuerfeln == true && this.hatGewuerfelt == false){
					this.bewegungsWert = this.spielerAmZug.getWuerfel().werfen42();
					if(this.bewegungsWert == 6) this.darfWuerfeln = true;
					else this.darfWuerfeln = false;
					hatGewuerfelt = true;
				}else throw new RuntimeException("Darf nicht 2 mal Wuerfeln!");
			}
		}
		public void setTestPosition(int figurId, int id) {
			this.spielerAmZug.getFigur(figurId).setPosition(this.spielbrett.getFeld(id));
			this.spielerAmZug.getFigur(figurId).getPosition().setFigur(this.spielerAmZug.getFigur(figurId));
		}
	
	/**
	 * Gibt zur�ck, welcher Spieler gewonnen hat.
	 * @param gewinner Der Spieler der gewonnen hat.
	 */
	private void spielGewonnen(Spieler gewinner){
        if(gewinner!=null){ 
		this.gewinner=gewinner;
        }else throw new RuntimeException ("Gewinner existiert nicht!");
	}
	
	/**
	 * Hier wird der Gewinner zur�ckgegeben
	 * @return String gewinner
	 */
	public String getGewinner(){
		if(gewinner==null){
			return null;
		}else return gewinner.getName();
	}
	
	
	/**
	 * Die Methode beendet einen Zug.
	 */
	public void zugBeenden(){
		int zaehler=0;
		for(int i =0; i<4; i++){
			if (spielerAmZug.getFigur(i).getPosition().getTyp() == FeldTyp.Endfeld){
				zaehler++;
			}
		}
		if (zaehler == 4) {
			spielGewonnen(spielerAmZug);
		}
		for(int i = 0; i< spieler.size(); i++){
			if(count == spieler.size()){
				spielerAmZug = spieler.get(count-spieler.size());
				darfWuerfeln = true;
				count = 1;
				break;
			}else{
				spielerAmZug = spieler.get(count);
				darfWuerfeln = true;
				count = count+1;
				break;
			}
			
			
		}
	}

}
