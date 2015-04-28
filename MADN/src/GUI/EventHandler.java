package GUI;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.RuntimeErrorException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;

import classes.Wuerfel;
import classes.iBediener;
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
	public EventHandler(Aufgabe_b gui){
		this.gui = gui;
	}
	
	/**
	 * Die Methode faengt das Event ab und fuehrt die jeweilige Aktion aus 
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Component c = (Component) e.getSource();
		String cases = c.getName();
		
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
		
			int wrflWrt = (int)((Math.random()*6)+1);
			switch (wrflWrt){
				case 1:jlb.setIcon(new ImageIcon ("Augenzahl1.jpg")); break;
				case 2:jlb.setIcon(new ImageIcon ("Augenzahl2.jpg")); break;
				case 3:jlb.setIcon(new ImageIcon ("Augenzahl3.jpg")); break;
				case 4:jlb.setIcon(new ImageIcon ("Augenzahl4.jpg")); break;
				case 5:jlb.setIcon(new ImageIcon ("Augenzahl5.jpg")); break;
				case 6:jlb.setIcon(new ImageIcon ("Augenzahl6.jpg")); break;
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
			System.out.println(southEbene1.getName());
			JScrollPane logsp = (JScrollPane) southEbene1.getComponent(0);
			System.out.println(logsp.getComponentCount());
			System.out.println(logsp.getComponent(0));
			System.out.println(logsp.getComponent(1));
			System.out.println(logsp.getComponent(2));
			
			JViewport ebene4 = (JViewport) logsp.getComponent(0);
			System.out.println(ebene4.getComponent(0));
			JTextArea logta = (JTextArea) ebene4.getComponent(0);
			String s = logta.getText();
			String split[] = cases.split("_");
			int x = Integer.parseInt(split[1]);
			logta.setText(s+"Das Feld " + (x+1) + " wurde angewaehlt. \n");
			
			
		case "Bewege_0":	
			JLabel figur = null;
			JLabel jl = (JLabel) c.getParent();
			
			
			
			break;
			
		case "Bewege_1":	
			System.out.println(cases);
			break;
		case "Bewege_2":	
			System.out.println(cases);
			break;
		case "Bewege_3":	
			System.out.println(cases);
			break;
		
		default:
			throw new RuntimeException("Hups, "+ cases + " wurde nicht richtig gemacht!");
		}
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

	
	
}
