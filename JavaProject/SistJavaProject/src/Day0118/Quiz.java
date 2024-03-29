/*
 * 패널위에 5개의 버튼을 생성
 * 각각의 버튼명은 미리 라벨 배열로 작성
 * 색상또한 배열처리한다
 * 
 * 버튼의 색상은 해당색상의 글자색을 갖는다
 * 
 * 프레임에 안녕하세요라는 글자를 굵게 30으로 생성해 놓고
 * 위의 5개 버튼을 누를 때마다 안녕하세요 글자는 해당색상으로 변경된다
 * 
 * */

package Day0118;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.FontUIResource;

public class Quiz extends JFrame implements ActionListener{
	Container cp;
	JButton[] btn = new JButton[5];
	JLabel lblFont;
	String[] btnLabel = {"Red","Orange","Yellow","GREEN","BLUE"};
	Color[] btnColors = {Color.RED,Color.ORANGE,Color.YELLOW,Color.GREEN,Color.BLUE};
	
	public Quiz(String title) {
		super(title);

		cp = this.getContentPane();

		this.setBounds(300, 100, 600, 600);
		cp.setBackground(new Color(255,255,200));
		initDesign();
		this.setVisible(true);
	}
	
	public void setDesign() {
		lblFont = new JLabel("안녕하세요");
		lblFont.setBounds(20, 170, 250, 60);
		lblFont.setFont(new FontUIResource("", Font.BOLD, 25));
		this.add(lblFont);
		//lblFont.setText("안녕하세요");
	}
	
	public void initDesign() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		
		this.add(panel,BorderLayout.NORTH);
		
		for(int i = 0;i<btn.length;i++) {
			btn[i] = new JButton(btnLabel[i]);
			btn[i].setBackground(btnColors[i]);
			
			btn[i].addActionListener(this);
			
			panel.add(btn[i]);
		}
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		for(int i=0;i<btn.length;i++) {
			if(ob == btn[i]) {
				cp.setForeground(btnColors[i]);
				
				this.setTitle("Color : "+btnLabel[i]);
			}
		}
		
	}
	
	public static void main(String[] args) {
		new Quiz("퀴즈");
	}

}
