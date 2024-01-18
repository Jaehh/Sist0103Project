package Day0118;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class SwingStart extends JFrame{

	Container cp;
	
	public SwingStart(String title) {
		super(title);
		
		cp = this.getContentPane();
		
		this.setBounds(300, 100, 300, 300);
		cp.setBackground(new Color(210,255,200));
		this.setVisible(true);
	}
	public static void main(String[] args) {
		
		new SwingStart("스윙시작");
	}
}
