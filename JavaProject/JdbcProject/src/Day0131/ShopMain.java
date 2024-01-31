package Day0131;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ShopMain extends JFrame implements ActionListener{

	JButton btnAdd,btnDel,btnUpdate,btnList;
	
	//생성자
	public ShopMain() {
		super("ShopMain"); //제목을 보냄
		this.setBounds(200,100,400,400);
		initDesign();
		this.setVisible(true);
	}
	//디자인
	public void initDesign() {
		this.setLayout(new GridLayout(2,2));
		btnAdd = new JButton("상품추가");
		btnDel = new JButton("상품삭제");
		btnUpdate = new JButton("상품수정");
		btnList = new JButton("상품목록");
		
		this.add(btnAdd);
		this.add(btnDel);
		this.add(btnUpdate);
		this.add(btnList);
		
		//이벤트
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnList.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if(ob==btnAdd) {
			//System.out.println("add");
			ShopAddForm add = new ShopAddForm();
		}else if(ob==btnDel) {
			System.out.println("del");
		}else if(ob==btnUpdate) {
			System.out.println("update");
		}else if(ob==btnList) {
			System.out.println("list");
			ShopListForm listForm = new ShopListForm();
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ShopMain();
	}

}
