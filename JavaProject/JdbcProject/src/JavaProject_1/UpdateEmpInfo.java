package JavaProject_1;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UpdateEmpInfo extends JFrame{
	
	Container cp;
	JTextField tfName,tfJava,tfJsp,tfSpring;
	JComboBox<String> cbBan;
	JButton btnUpdate;
	String num; //수정할 번호
	
	
	public UpdateEmpInfo(String title) {
		super(title);
		
		cp = this.getContentPane();
		this.setBounds(200, 100, 200, 250);
		cp.setBackground(new Color(255,204,204));
		initDesign();
		//this.setVisible(true);
	}
	
	public void initDesign()
	{
		this.setLayout(null);
		
		JLabel lblTitle1 = new JLabel("이름");
		JLabel lblTitle2 = new JLabel("반");
		JLabel lblTitle3 = new JLabel("JAVA");
		JLabel lblTitle4 = new JLabel("JSP");
		JLabel lblTitle5 = new JLabel("SPRING");
		
		tfName = new JTextField(4);
		tfJava = new JTextField(3);
		tfJsp = new JTextField(3);
		tfSpring = new JTextField(3);
	
		String[] ban = {"aws반","front반","backend반","design반"};
		cbBan = new JComboBox<String>(ban);
		btnUpdate = new JButton("수정");
		
		//라벨5개
		lblTitle1.setBounds(30, 10, 60, 30);
		this.add(lblTitle1);
		lblTitle2.setBounds(30, 40, 60, 30);
		this.add(lblTitle2);
		lblTitle3.setBounds(30, 70, 60, 30);
		this.add(lblTitle3);
		lblTitle4.setBounds(30, 100, 60, 30);
		this.add(lblTitle4);
		lblTitle5.setBounds(30, 130, 60, 30);
		this.add(lblTitle5);
		
		//이름,반,자바,jsp,spring 순으로 
		tfName.setBounds(80, 15, 70, 22);
		this.add(tfName);
		
		cbBan.setBounds(80, 45, 70, 22);
		this.add(cbBan);
		
		tfJava.setBounds(80, 75, 70, 22);
		this.add(tfJava);
		
		tfJsp.setBounds(80, 105, 70, 22);
		this.add(tfJsp);
		
		tfSpring.setBounds(80, 135, 70, 22);
		this.add(tfSpring);
		
		//버튼
		btnUpdate.setBounds(70, 160, 70, 30);
		this.add(btnUpdate);
		
	}
	
//	public static void main(String[] args) {
//		new UpdateStuInfo("학생정보수정창");
//	}

}
