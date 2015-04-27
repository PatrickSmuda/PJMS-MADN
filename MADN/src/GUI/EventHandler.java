package GUI;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import classes.iBediener;

public class EventHandler extends JFrame implements ActionListener {

	private JButton button;
	private iBediener ib;
	
	public EventHandler(){
		button = new JButton ("bla");
		button.addActionListener(this);
		
		this.getContentPane().add(button);
	}
	
	public void buttonClicked(int x, Component c){
		System.out.println("Button " + x + " geglickt!");
		showNewLogFeld(c, x);
	}
	
	
	public void showNewLogFeld(Component c, int x){
		JTextArea log = (JTextArea)c;
		String s = log.getText();
		log.setText(s+"Das Feld "+ x + " wurde angewaehlt. PENIS!\n");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		
       		
	}
	
	public void wrflAnzeigen(Component c){
		JLabel jl =(JLabel)c;
//		ib.wuerfeln();
		int wrflWrt = wrfln();
		switch (wrflWrt){
			case 1:jl.setIcon(new ImageIcon ("Augenzahl1.jpg")); break;
			case 2:jl.setIcon(new ImageIcon ("Augenzahl2.jpg")); break;
			case 3:jl.setIcon(new ImageIcon ("Augenzahl3.jpg")); break;
			case 4:jl.setIcon(new ImageIcon ("Augenzahl4.jpg")); break;
			case 5:jl.setIcon(new ImageIcon ("Augenzahl5.jpg")); break;
			case 6:jl.setIcon(new ImageIcon ("Augenzahl6.jpg")); break;
		}

	}
	
	
	
	public int wrfln(){ 
		return (int)((Math.random()*6)+1);
	}
	

	
	
}
