package Day0118;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingImageIcon_06 extends JFrame implements ActionListener{
	
	Container cp;
	
	//이미지 아이콘 가져온다
	ImageIcon icon1 = new ImageIcon("C:\\sist0103\\image\\swingimage\\LEFT.GIF");
	ImageIcon icon2 = new ImageIcon("C:\\sist0103\\image\\swingimage\\leftDown.gif");
	ImageIcon icon3 = new ImageIcon("C:\\sist0103\\image\\swingimage\\leftRollover.gif");
	ImageIcon icon4 = new ImageIcon("C:\\sist0103\\image\\swingimage\\chick.gif");
	ImageIcon icon5 = new ImageIcon("C:\\sist0103\\image\\swingimage\\an07.gif");
	
	JButton btn1,btn2,btn3,btn4;
	
	public SwingImageIcon_06(String title) {
super(title);
		
		cp = this.getContentPane();
		
		this.setBounds(300, 100, 300, 300);
		cp.setBackground(new Color(255,255,200));
		
		initDesign();
		this.setVisible(true);
	}
	
	public void initDesign() {
		//2행 2열
		this.setLayout(new GridLayout(2,2));
		btn1 = new JButton("hello",icon1);
		btn1.setHorizontalTextPosition(JButton.CENTER);
		btn1.setVerticalTextPosition(JButton.BOTTOM);
		this.add(btn1);
		
		btn1.setRolloverIcon(icon2);
		btn1.setPressedIcon(icon3);
		
		//버튼2
		btn2 = new JButton(icon4);
		btn2.setRolloverIcon(icon5);
		btn2.setPressedIcon(icon5);
		this.add(btn2);
		
		//버튼3
		btn3 = new JButton("스윙버튼");
		this.add(btn3);
		
		//버튼4
		btn4 = new JButton("안녕",icon5);
	    this.add(btn4);
	    
	  //이벤트객체
	  		btn1.addActionListener(this);
	  		btn2.addActionListener(this);
	  		btn3.addActionListener(this);
	  		btn4.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		
		if(ob == btn1) {
			JOptionPane.showMessageDialog(this, "1번째 버튼 클릭");
		} else if(ob == btn2) {
			JOptionPane.showMessageDialog(this, "2번째 버튼 클릭");
		}else if(ob == btn3) {
			JOptionPane.showMessageDialog(this, "3번째 버튼 클릭");
		}else if(ob == btn4) {
			JOptionPane.showMessageDialog(this, "4번째 버튼 클릭");
		}
		
	}
	
public static void main(String[] args) {
	new SwingImageIcon_06("이미지버튼6");
}
}
