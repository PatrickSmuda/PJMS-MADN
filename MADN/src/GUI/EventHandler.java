package GUI;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class EventHandler extends JFrame implements ActionListener {

	private JButton button;
	
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
	
	

	
	
}
