package JavaProject;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class EmpMain extends JFrame implements ActionListener{

	DefaultTableModel model;
	JTable table;
JButton btnAdd,btnDel,btnUpdate,btnList;
	

	//생성자
	public EmpMain() {
		super("인사 관리 시스템"); //제목을 보냄
		this.setBounds(200,100,700,400);
		initDesign();
		this.setVisible(true);
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new EmpAddForm();
				setVisible(false);
				
			}
		});
	}
	
	//디자인
		public void initDesign() {
			String [] title = {"사원번호","사원명","성별","부서","직책","주소","급여","이메일","입사일"};
			model = new DefaultTableModel(title,0);
			table = new JTable(model);
			JScrollPane js = new JScrollPane(table);
			js.setBounds(10, 10, 500, 270);
			this.add(js);
			
			JPanel pTop = new JPanel();
			this.add("North",pTop);
			
			//추가버튼
			btnAdd = new JButton("추가");
			//btnAdd.addActionListener(this);
			pTop.add(btnAdd);
			
			//addForm.btnAdd.addActionListener(this);
			
			//삭제버튼
			btnDel = new JButton("삭제");
			btnDel.addActionListener(this);
			pTop.add(btnDel);
			
			//수정버튼
			btnUpdate = new JButton("수정");
			btnUpdate.addActionListener(this);
			pTop.add(btnUpdate);
			
			//목록버튼
			btnList = new JButton("목록");
			btnList.addActionListener(this);
			pTop.add(btnList);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object ob = e.getSource();
			
			if(ob==btnAdd) {
				//System.out.println("add");
				EmpAddForm add = new EmpAddForm();
			}else if(ob==btnDel) {
				System.out.println("del");
			}else if(ob==btnUpdate) {
				System.out.println("update");
			}else if(ob==btnList) {
				System.out.println("list");
				EmpListForm listForm = new EmpListForm();
			}
			
		}
		
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub

			new EmpMain();
		}

	}
