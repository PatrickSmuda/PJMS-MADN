package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventHandler extends JFrame implements ActionListener {

	private JButton button;
	
	public EventHandler(){
		button = new JButton ("bla");
		button.addActionListener(this);
		
		this.getContentPane().add(button);
	}
	
	public void buttonClicked(int x){
		System.out.println("Button " + x + " geglickt!");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
       		
	}
	
	

	
	
}
