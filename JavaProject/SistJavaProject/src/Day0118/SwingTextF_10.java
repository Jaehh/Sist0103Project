package Day0118;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;

//2개의 텍스트필드에 숫자를 넣고 버튼을 만든 후 클릭하면 라벨에 2+3=5

public class SwingTextF_10 extends JFrame{

	Container cp;
	JTextField tfNum1,tfNum2;
	JButton btnAdd,btnMinus,btnMulti,btnDivide;
	JLabel lblNum1,lblNum2,lblResult;
	
	
	public SwingTextF_10() {
		super("텍스트필드문제");

		cp = this.getContentPane();

		this.setBounds(300, 100, 500, 300);
		cp.setBackground(new Color(255,255,200));
		setDesign();
		this.setVisible(true);
	}
	public void setDesign() {
		this.setLayout(null);
		lblNum1 = new JLabel("숫자1");
		lblNum2 = new JLabel("숫자2");
		
		lblNum1.setBounds(20, 20, 50, 30);
		this.add(lblNum1);
		
		lblNum2.setBounds(20, 60, 50, 30);
		this.add(lblNum2);
		
		tfNum1 = new JTextField();
		tfNum1.setBounds(80, 20, 60, 30);
		this.add(tfNum1);
		
		tfNum2 = new JTextField();
		tfNum2.setBounds(80, 60, 80, 30);
		this.add(tfNum2);
		
		btnAdd = new JButton("+");
		btnAdd.setBounds(40, 110, 50, 50);
		this.add(btnAdd);
		
		btnAdd = new JButton("-");
		btnAdd.setBounds(90, 110, 50, 50);
		this.add(btnMinus);
		
		btnAdd = new JButton("x");
		btnAdd.setBounds(140, 110, 50, 50);
		this.add(btnMulti);
		
		btnAdd = new JButton("/");
		btnAdd.setBounds(190, 110, 50, 50);
		this.add(btnDivide);
		
		lblResult = new JLabel("결과나오는 곳");
		lblResult.setBounds(20, 170, 250, 60);
		lblResult.setBorder(new TitledBorder("결과확인"));
		lblResult.setFont(new FontUIResource("", Font.BOLD, 25));//글꼴변경
		this.add(lblResult);
		
		//익명내부클래스
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int num1 = Integer.parseInt(tfNum1.getText().trim()); //앞뒤 공백 제거후 변환
				int num2 = Integer.parseInt(tfNum2.getText().trim());
				
				int sum = num1 + num2;
				
				String s = num1+"+"+num2+"="+sum;
				lblResult.setText(s);
				
			}
		});
		
		btnMinus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int num1 = Integer.parseInt(tfNum1.getText().trim());
				int num2 = Integer.parseInt(tfNum2.getText().trim());
				
				if(num1>=num2) {
					int result = num1 - num2;
					String s = num1+"-"+num2+"="+result;
					lblResult.setText(s);
				} else {
					int result = num2  - num1;
					String s = num2+"-"+num1+"="+result;
					lblResult.setText(s);
				}
			

				
			}
		});
		
	
	}

	public static void main(String[] args) {
		new SwingTextF_10();
	}
}
