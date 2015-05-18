package GUI;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.filechooser.FileFilter;

//import com.sun.deploy.uitoolkit.impl.fx.Utils;







import classes.DatenzugriffCSV;
import classes.DatenzugriffSerialisiert;
import classes.Spiel;
import classes.Wuerfel;
import classes.iBediener;
import classes.iDatenzugriff;
/**
 * Die Klasse EventHandler
 * @author 
 *
 */


public class EventHandler extends JFrame implements ActionListener {

	
	
	
	/**
	 * Attribute von der Klasse EventHandler
	 */
	
	private Aufgabe_b gui = null;
	private iBediener ib;
	private iDatenzugriff id;
	private boolean nextBewege = false;
	private boolean gewuerfelt = false;
	private Mail mail;
	
	public EventHandler(Aufgabe_b gui){
		if(gui != null){
			this.gui = gui;
		}
	}
	
	/**
	 * Die Methode faengt das Event ab und fuehrt die jeweilige Aktion aus 
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Component c = (Component) e.getSource();
		String cases = c.getName();
		
		JRootPane ebene1 = (JRootPane) gui.getFrames()[2].getComponent(0);
		JLayeredPane ebene2 = (JLayeredPane) ebene1.getComponent(1);
		JPanel ebene3 = (JPanel) ebene2.getComponent(0);
		JLabel southEbene1 = null;
		for(int i = 0; i < ebene3.getComponentCount(); i++){
			if(ebene3.getComponent(i).getName().equals("south")){
				southEbene1 = (JLabel) ebene3.getComponent(i);
				break;
			}
		}
		JScrollPane logsp = (JScrollPane) southEbene1.getComponent(0);
		JViewport ebene4 = (JViewport) logsp.getComponent(0);
		final JTextArea logta = (JTextArea) ebene4.getComponent(0);
		final String s = logta.getText();
		
		switch (cases) {
		case "wuerfel":
			JLabel jlb=null;
			JLabel jf = (JLabel) c.getParent();
			for(int i = 0; i < jf.getComponentCount(); i++){
				if(jf.getComponent(i).getName().equals("wuerfelLabel")){
					jlb=(JLabel) jf.getComponent(i);
					break;
				}
			}
			try{
				ib.wuerfeln();
				int wrflWrt = ib.getBewegungsWert();
				switch (wrflWrt){
					case 1:jlb.setIcon(new ImageIcon ("Augenzahl1.jpg")); break;
					case 2:jlb.setIcon(new ImageIcon ("Augenzahl2.jpg")); break;
					case 3:jlb.setIcon(new ImageIcon ("Augenzahl3.jpg")); break;
					case 4:jlb.setIcon(new ImageIcon ("Augenzahl4.jpg")); break;
					case 5:jlb.setIcon(new ImageIcon ("Augenzahl5.jpg")); break;
					case 6:jlb.setIcon(new ImageIcon ("Augenzahl6.jpg")); break;
				}
				logta.setText(s+ib.getSpielerAmZug()+" hat eine " + wrflWrt + " gewuerfelt.\n");
				int currentPlayer = ib.getCurrentPlayerId();
				if(ib.getBewegungsWert() != 6 && ib.hatFreieFigur(currentPlayer) == false){
					ib.bewege(0);
					logta.setText(s+"Spieler am Zug: " + ib.getSpielerAmZug()+"\n");
					gewuerfelt = false;
				}else{
					gewuerfelt = true;
				}
				
			}catch(RuntimeException h){
				logta.setText(s+"Du darfst nicht 2 mal wuerfeln innerhalb eines Zuges!\n");
			}
			
			break;
			
		case "Feld_0":
		case "Feld_1":
		case "Feld_2":
		case "Feld_3":
		case "Feld_4":
		case "Feld_5":
		case "Feld_6":
		case "Feld_7":
		case "Feld_8":
		case "Feld_9":
		case "Feld_10":
		case "Feld_11":
		case "Feld_12":
		case "Feld_13":
		case "Feld_14":
		case "Feld_15":
		case "Feld_16":
		case "Feld_17":
		case "Feld_18":
		case "Feld_19":
		case "Feld_20":
		case "Feld_21":
		case "Feld_22":
		case "Feld_23":
		case "Feld_24":
		case "Feld_25":
		case "Feld_26":
		case "Feld_27":
		case "Feld_28":
		case "Feld_29":
		case "Feld_30":
		case "Feld_31":
		case "Feld_32":
		case "Feld_33":
		case "Feld_34":
		case "Feld_35":
		case "Feld_36":
		case "Feld_37":
		case "Feld_38":
		case "Feld_39":
		case "Feld_40":
		case "Feld_41":
		case "Feld_42":
		case "Feld_43":
		case "Feld_44":
		case "Feld_45":
		case "Feld_46":
		case "Feld_47":
		case "Feld_48":
		case "Feld_49":
		case "Feld_50":
		case "Feld_51":
		case "Feld_52":
		case "Feld_53":
		case "Feld_54":
		case "Feld_55":
		case "Feld_56":
		case "Feld_57":
		case "Feld_58":
		case "Feld_59":
		case "Feld_60":
		case "Feld_61":
		case "Feld_62":
		case "Feld_63":
		case "Feld_64":
		case "Feld_65":
		case "Feld_66":
		case "Feld_67":
		case "Feld_68":
		case "Feld_69":
		case "Feld_70":
		case "Feld_71":
			System.out.println("Eventhandler Gewuerfelt:" + gewuerfelt);
			String split[] = cases.split("_");
			int x = Integer.parseInt(split[1]);
			logta.setText(s+"Das Feld " + (x+1) + " wurde angewaehlt. \n");
			if (nextBewege == true) {
				try {
					int fig = ib.figurIdAufFeld(x);
					ib.bewege(fig);
					bitchBetterHaveMyMoney((JLabel)c.getParent());
					logta.setText(s+"Spieler am Zug: " + ib.getSpielerAmZug()+"\n");
					nextBewege = false;
					gewuerfelt = false;
				} catch (Exception e2) {
					logta.setText(s+"Keine Figur ausgewaehlt!\n");
				}
			}
			break;
		case "Bewege":	
			nextBewege = true;
			logta.setText(s+ib.getSpielerAmZug()+" ist bereit seinen Zug zu vollfuehren\n");
			break;
		
			
		
		case "ki":
			logta.setText(s+ib.getSpielerAmZug()+" kalkuliert seinen Spielzug\n");
			ib.benutzeKI();
			bitchBetterHaveMyMoney((JLabel)ebene3.getComponent(0));
			
			
			break;
			
		case "mail":
			String address = null;
			for(int i = 0; i < c.getParent().getComponentCount(); i++){
				if(c.getParent().getComponent(i).getName().equals("address")){
					JTextArea jt = (JTextArea)c.getParent().getComponent(i);
					address = jt.getText();
				}
			}
			final JFrame anhang = new JFrame();
			anhang.setVisible(true);
			anhang.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			anhang.setSize(300, 300);
			anhang.setResizable(false);
			anhang.setLocationRelativeTo(null);  
			anhang.setLayout(null);
			
			final JComboBox<String> anhangeList = new JComboBox<String>();
			anhangeList.addItem("Ohne Anhang");
			anhangeList.addItem("Mit Ser");
			anhangeList.addItem("Mit PDF");
			anhangeList.setBounds(75, 10, 150, 50);
			anhang.add(anhangeList);
			
			JButton ok = new JButton("OK");
			ok.setName("ok");
			ok.setBounds(120, 150, 60, 40);
			anhang.add(ok);
			final String address_f = address;
			final BufferedImage image=getScreenShot((JLabel)ebene3.getComponent(0));
			ok.addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					
					int x = anhangeList.getSelectedIndex();
					switch (x) {
					case 0:
						new Mail(address_f, "Ich moechte ein Spiel spielen", "Hallo Adam, \n "
								+ "du kennst mich nicht, aber ich kenne dich. "
								+ "Das passiert wenn du verlierst: \n"
								+ " ",
								null, null, null, null);
						logta.setText(s+"E-Mail wurde gesendet\n");
						break;

					case 1:
						id = new DatenzugriffSerialisiert();
						id.speichern(ib, new File("Anhang"));
						new Mail(address_f, "Ich moechte ein Spiel spielen", "Hallo Adam, \n "
								+ "du kennst mich nicht, aber ich kenne dich. "
								+ "Das passiert wenn du verlierst: \n"
								+ " ",
								"Anhang.ser", "Spiel.ser", null, null);
						logta.setText(s+"E-Mail wurde gesendet\n");
						break;
						
					case 2:
						
						iDatenzugriff daten = new DatenzugriffPDF();
						daten.speichern(image, new File("AnhangPdf.pdf"));
						new Mail(address_f, "Ich moechte ein Spiel spielen", "Hallo Adam, \n "
								+ "du kennst mich nicht, aber ich kenne dich. "
								+ "Das passiert wenn du verlierst: \n"
								+ " ",
								"AnhangPdf.pdf", "Spiel.pdf", null, null);
						logta.setText(s + "Mail mit PDF verschickt!\n");
						break;
						
					default:
						break;
					}
					anhang.dispose();
				}
			});
			
			break;
			
		case "speichern":
			JFileChooser chooseAddressSave = new JFileChooser();
			chooseAddressSave.setName("chooseAddressSave");
			chooseAddressSave.showOpenDialog(null);
			
			File fileAddressSave = chooseAddressSave.getSelectedFile();
			String fileNameSave = chooseAddressSave.getSelectedFile().getName();
		
			String splitFileSave[] = fileNameSave.split("\\.");
			try {
				if (splitFileSave[1].equals("ser")) {
					id = new DatenzugriffSerialisiert();
				}
				if (splitFileSave[1].equals("csv")) {
					id = new DatenzugriffCSV();
				}
				id.speichern(ib, fileAddressSave);
			} catch (Exception e2) {
				try {
					id = new DatenzugriffSerialisiert();
					id.speichern(ib, fileAddressSave);
				} catch (Exception e3) {
					logta.setText(s + "Fehler beim Speichern!\n");
				}
				
			}
			break;
			
		case "laden":
			JFileChooser chooseAddressLoad = new JFileChooser();
			chooseAddressLoad.setName("chooseAddressSave");
			chooseAddressLoad.showOpenDialog(null);
			
			File fileAddressLoad = chooseAddressLoad.getSelectedFile();
			String fileNameLoad = chooseAddressLoad.getSelectedFile().getName();
			
			String splitFileLoad[] = fileNameLoad.split("\\.");
	
			try {
				if (splitFileLoad[1].equals("ser") || splitFileLoad[1].equals("csv")) {
					if (splitFileLoad[1].equals("ser")) {
						id = new DatenzugriffSerialisiert();
					}
					if (splitFileLoad[1].equals("csv")) {
						id = new DatenzugriffCSV();
					}	
				}
				ib = (Spiel) id.laden(fileAddressLoad);
				bitchBetterHaveMyMoney((JLabel)ebene3.getComponent(0));
			} catch (Exception e2) {
				try {
					id = new DatenzugriffSerialisiert();
					ib = (Spiel) id.laden(fileAddressLoad);
					bitchBetterHaveMyMoney((JLabel)ebene3.getComponent(0));
				} catch (Exception e3) {
					logta.setText(s + "Fehler beim Laden!\n");
				}
			}
		
			
		/*	try{
				ib.wuerfeln();
			}catch(Exception e2){
				gewuerfelt = true;
			}
			*/
			break;
			
		case "pdfSpeichern":
			JFileChooser jfc=new JFileChooser();
			jfc.showOpenDialog(null);
			File f=jfc.getSelectedFile();
			String fName=f.getName();
			String [] bla;
			try{
				bla=fName.split("\\.");
				if(bla[1].equals("pdf")){
					BufferedImage bImage=getScreenShot((JLabel)ebene3.getComponent(0));
					iDatenzugriff daten = new DatenzugriffPDF();
					daten.speichern(bImage, f);
				}else{
					logta.setText(s+"Keine PDF Datei!!!\n");
				}
			}catch(Exception ex){
			 logta.setText(s+"Keine PDF Datei!!!\n");
			}
			
			break;
			
		default:
			throw new RuntimeException("Hups, "+ cases + " wurde nicht richtig gemacht!");
		}

	}
	
	/**
	 * Die Update Funktion
	 * @param center
	 */
	public void bitchBetterHaveMyMoney(JLabel center){
		String split[];
		ArrayList<String> farben = new ArrayList<String>();
		ArrayList<String> figuren = ib.getAllFigures();
		int[] positionen = new int[figuren.size()];
		int[] ids = new int[figuren.size()];
		for(int i = 0; i < figuren.size(); i++){
			split = figuren.get(i).split("_");
			farben.add(split[0]);
			positionen[i] = Integer.parseInt(split[1]);
			ids[i] = Integer.parseInt(split[2]);
		}
		
		for(int i = 0; i < farben.size(); i++){
			
			switch(farben.get(i))
			{
			case "rot":
				for(int j = 0; j < center.getComponentCount(); j++){
					String splitg[];
					splitg = center.getComponent(j).getName().split("_");
					int id = Integer.parseInt(splitg[1]);
					if(splitg[0].equals("r") && id == ids[i]){
						feldInfo(positionen[i], (JLabel)center.getComponent(j));
					}
				}
				break;
			case "blau":
				for(int j = 0; j < center.getComponentCount(); j++){
					String splitg[];
					splitg = center.getComponent(j).getName().split("_");
					int id = Integer.parseInt(splitg[1]);
					if(splitg[0].equals("b") && id == ids[i]){
						feldInfo(positionen[i], (JLabel)center.getComponent(j));
					}
				}
				break;
			case "gruen":
				for(int j = 0; j < center.getComponentCount(); j++){
					String splitg[];
					splitg = center.getComponent(j).getName().split("_");
					int id = Integer.parseInt(splitg[1]);
					if(splitg[0].equals("gr") && id == ids[i]){
						feldInfo(positionen[i], (JLabel)center.getComponent(j));
					}
				}
				break;
			case "gelb":
				for(int j = 0; j < center.getComponentCount(); j++){
					String splitg[];
					splitg = center.getComponent(j).getName().split("_");
					int id = Integer.parseInt(splitg[1]);
					if(splitg[0].equals("ge") && id == ids[i]){
						feldInfo(positionen[i], (JLabel)center.getComponent(j));
					}
				}
				break;
			}
		}
		
	}
	
	/**
	 * enth�lt die Positionen der Felder und setzt die Figuren dem entsprechend
	 * @param id
	 * @param fig
	 */
	private void feldInfo(int id, JLabel fig){
		switch(id){
		case 0: fig.setBounds(10, 207, 35, 35); break;
		case 1: fig.setBounds(58, 207, 35, 35); break;
		case 2: fig.setBounds(107, 207, 35, 35); break;
		case 3: fig.setBounds(156, 207, 35, 35); break;
		case 4: fig.setBounds(205, 207, 35, 35); break;
		case 5: fig.setBounds(205, 159, 35, 35); break;
		case 6: fig.setBounds(205, 111, 35, 35); break;
		case 7: fig.setBounds(205, 63, 35, 35); break;
		case 8: fig.setBounds(205, 15, 35, 35); break;
		case 9: fig.setBounds(253, 15, 35, 35); break;
		case 10: fig.setBounds(301, 15, 35, 35); break;
		case 11: fig.setBounds(301, 63, 35, 35); break;
		case 12: fig.setBounds(301, 111, 35, 35); break;
		case 13: fig.setBounds(301, 159, 35, 35); break;
		case 14: fig.setBounds(302, 207, 35, 35); break;
		case 15: fig.setBounds(350, 207, 35, 35); break;
		case 16: fig.setBounds(398, 207, 35, 35); break;
		case 17: fig.setBounds(446, 207, 35, 35); break;
		case 18: fig.setBounds(494, 207, 35, 35); break;
		case 19: fig.setBounds(494, 255, 35, 35); break;
		case 20: fig.setBounds(494, 303, 35, 35); break;
		case 21: fig.setBounds(446, 303, 35, 35); break;
		case 22: fig.setBounds(398, 303, 35, 35); break;
		case 23: fig.setBounds(350, 303, 35, 35); break;
		case 24: fig.setBounds(302, 303, 35, 35); break;
		case 25: fig.setBounds(302, 352, 35, 35); break;
		case 26: fig.setBounds(302, 401, 35, 35); break;
		case 27: fig.setBounds(302, 449, 35, 35); break;
		case 28: fig.setBounds(302, 497, 35, 35); break;
		case 29: fig.setBounds(254, 498, 35, 35); break;
		case 30: fig.setBounds(204, 498, 35, 35); break;
		case 31: fig.setBounds(204, 450, 35, 35); break;
		case 32: fig.setBounds(204, 402, 35, 35); break;
		case 33: fig.setBounds(204, 353, 35, 35); break;
		case 34: fig.setBounds(204, 304, 35, 35); break;
		case 35: fig.setBounds(156, 304, 35, 35); break;
		case 36: fig.setBounds(108, 304, 35, 35); break;
		case 37: fig.setBounds(59, 304, 35, 35); break;
		case 38: fig.setBounds(10, 304, 35, 35); break;
		case 39: fig.setBounds(10, 256, 35, 35); break;
		case 40: fig.setBounds(8, 11, 35, 35); break;
		case 41: fig.setBounds(56, 11, 35, 35); break;
		case 42: fig.setBounds(8, 59, 35, 35); break;
		case 43: fig.setBounds(56, 59, 35, 35); break;
		case 44: fig.setBounds(444, 11, 35, 35); break;
		case 45: fig.setBounds(492, 11, 35, 35); break;
		case 46: fig.setBounds(444, 59, 35, 35); break;
		case 47: fig.setBounds(492, 59, 35, 35); break;
		case 48: fig.setBounds(444, 447, 35, 35); break;
		case 49: fig.setBounds(492, 447, 35, 35); break;
		case 50: fig.setBounds(444, 496, 35, 35); break;
		case 51: fig.setBounds(492, 496, 35, 35); break;
		case 52: fig.setBounds(8, 447, 35, 35); break;
		case 53: fig.setBounds(56, 447, 35, 35); break;
		case 54: fig.setBounds(8, 496, 35, 35); break;
		case 55: fig.setBounds(56, 496, 35, 35); break;
		case 56: fig.setBounds(253, 62, 35, 35); break;
		case 57: fig.setBounds(253, 110, 35, 35); break;
		case 58: fig.setBounds(253, 158, 35, 35); break;
		case 59: fig.setBounds(253, 207, 35, 35); break;
		case 60: fig.setBounds(253, 450, 35, 35); break;
		case 61: fig.setBounds(253, 402, 35, 35); break;
		case 62: fig.setBounds(253, 353, 35, 35); break;
		case 63: fig.setBounds(253, 304, 35, 35); break;
		case 64: fig.setBounds(302, 255, 35, 35); break;
		case 65: fig.setBounds(350, 255, 35, 35); break;
		case 66: fig.setBounds(398, 255, 35, 35); break;
		case 67: fig.setBounds(446, 255, 35, 35); break;
		case 68: fig.setBounds(58, 256, 35, 35); break;
		case 69: fig.setBounds(107, 256, 35, 35); break;
		case 70: fig.setBounds(156, 256, 35, 35); break;
		case 71: fig.setBounds(205, 256, 35, 35); break;
		}
		fig.getParent().validate();
	}
	
//	private JButton button;
//	private iBediener ib;
//	
//	public EventHandler(){
//		button = new JButton ("bla");
//		button.addActionListener(this);
//		
//		this.getContentPane().add(button);
//	}
//	
//	public void buttonClicked(int x, Component c){
//		System.out.println("Button " + x + " geglickt!");
//		showNewLogFeld(c, x);
//	}
//	
//	
//	public void showNewLogFeld(Component c, int x){
//		JTextArea log = (JTextArea)c;
//		String s = log.getText();
//		log.setText(s+"Das Feld "+ x + " wurde angewaehlt. PENIS!\n");
//	}
//	
//	@Override
//	public void actionPerformed(ActionEvent arg0) {
//		
//		
//		
//       		
//	}
//	
//	public void wrflAnzeigen(Component c){
//		JLabel jl =(JLabel)c;
//		ib.wuerfeln();
//		int wrflWrt = wrfln();
//		switch (wrflWrt){
//			case 1:jl.setIcon(new ImageIcon ("Augenzahl1.jpg")); break;
//			case 2:jl.setIcon(new ImageIcon ("Augenzahl2.jpg")); break;
//			case 3:jl.setIcon(new ImageIcon ("Augenzahl3.jpg")); break;
//			case 4:jl.setIcon(new ImageIcon ("Augenzahl4.jpg")); break;
//			case 5:jl.setIcon(new ImageIcon ("Augenzahl5.jpg")); break;
//			case 6:jl.setIcon(new ImageIcon ("Augenzahl6.jpg")); break;
//		}
//
//	}
//	
//	
//	
//	public int wrfln(){ 
//		return (int)((Math.random()*6)+1);
//	}
//	

	public void setBediener(iBediener ib){
		if(ib != null){
			this.ib = ib;
		}
	}
	
	private static BufferedImage getScreenShot(Component component) {

		    BufferedImage image = new BufferedImage(
		      component.getWidth(),
		      component.getHeight(),
		      BufferedImage.TYPE_INT_RGB
		      );
		    component.paint( image.getGraphics() ); // alternately use .printAll(..)
		    return image;
		  }
	
	
	
}