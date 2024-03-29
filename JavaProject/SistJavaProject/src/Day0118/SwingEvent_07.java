package Day0118;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingEvent_07 extends JFrame implements ActionListener{
	Container cp;
	JButton btn1,btn2;
	
	public SwingEvent_07(String title) {
super(title);
		
		cp = this.getContentPane();
		
		this.setBounds(300, 100, 300, 300);
		cp.setBackground(new Color(255,255,200));
		initDesign();
		this.setVisible(true);
	}
	public void initDesign() {
		//Flow 레이아웃으로 버튼 2개 생성
		//버튼색상 그레이로 변경, 버튼색상 그린으로 변경
		this.setLayout(new FlowLayout());
		
		
		btn1 = new JButton("버튼색상 그레이로 변경");
		btn2 = new JButton("버튼색상 그린으로 변경");
	
	
		this.add(btn1);
		this.add(btn2);
		
		//버튼1의 생성 및 이벤트 주기(익명내부클래스 형식)
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//getContentPane().setBackground(Color.GRAY);
				cp.setBackground(Color.GRAY);
			}
		});
		
		
		//버튼 2
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cp.setBackground(Color.BLACK);
				
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    // Implement the required method
	}
	public static void main(String[] args) {
		new SwingEvent_07("버튼클래스_07");
	}
}
