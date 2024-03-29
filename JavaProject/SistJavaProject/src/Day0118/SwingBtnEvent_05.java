package Day0118;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingBtnEvent_05 extends JFrame implements ActionListener{
	
	Container cp;
	
	JButton btn1,btn2;
	public SwingBtnEvent_05(String title) {
super(title);
		
		cp = this.getContentPane();
		
		this.setBounds(300, 100, 300, 300);
		cp.setBackground(new Color(255,255,200));
		
		initDegin();
		this.setVisible(true);
		
		
	}
	
	public void initDegin() {
		this.setLayout(new FlowLayout()); 
		
		btn1 = new JButton("◀");
		btn2 = new JButton("▶");
		
		//버튼색상
		btn1.setBackground(Color.DARK_GRAY);
		btn2.setBackground(Color.LIGHT_GRAY);
		
		//글자색상
		btn1.setForeground(Color.WHITE);
		btn2.setForeground(Color.WHITE);
		
		//이벤트객체
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		this.add(btn1);
		this.add(btn2);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		
		if(ob == btn1) {
			JOptionPane.showMessageDialog(this, "왼쪽 버튼 클릭");
		} else if(ob == btn2) {
			JOptionPane.showMessageDialog(this, "오른쪽 버튼 클릭");
		}
		
	}
public static void main(String[] args) {
	new SwingBtnEvent_05("버튼이벤트5");
}

}
