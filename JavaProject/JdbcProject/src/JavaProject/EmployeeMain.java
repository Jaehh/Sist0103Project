package JavaProject;

import java.awt.Canvas;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import oracleDb.DbConnect;

public class EmployeeMain extends JFrame implements ActionListener{
	DbConnect db = new DbConnect();
	Container cp;
	JButton btnAdd, btnDel, btnUpdate;
	EmployeeDbModel dbModel = new EmployeeDbModel();
	ImageDraw draw = new ImageDraw(); // 이미지 출력을 위한 내부클래스
	String imageName;
	DefaultTableModel model; // 테이블
	JTable table;
	Vector<EmployeeDto> list;
	//UpdateEmployeeInfo updateForm = new UpdateEmployeeInfo("데이터 수정");

	public EmployeeMain() {
		super("사원 리스트");
		this.setBounds(200, 100, 800, 400);
		initDesign();
		this.setVisible(true);
	}

	public void initDesign() {
		this.setLayout(null);

		btnAdd = new JButton("등록");
		btnDel = new JButton("삭제");
		btnUpdate = new JButton("수정");

		btnAdd.setBounds(10, 320, 100, 30);
		btnDel.setBounds(120, 320, 100, 30);
		btnUpdate.setBounds(230, 320, 100, 30);

		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnUpdate.addActionListener(this);

		this.add(btnAdd);
		this.add(btnDel);
		this.add(btnUpdate);

		list = dbModel.getAllEmployees(); // db로부터 목록 얻기
		String[] title = {"No.","사원명","성별","부서","직급","주소","급여","이메일","입사날짜"};
		model = new DefaultTableModel(title, 0);
		table = new JTable(model);
		JScrollPane js = new JScrollPane(table);
		js.setBounds(10, 10, 500, 300);
		this.add(js);

		draw.setBounds(520, 50, 260, 320); // 이미지 위치
		this.add(draw);		

		this.dataWrite(); // 데이터를 출력해 주는 메서드

		// 출력된 데이터 이벤트 --> 익명내부클래스
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				// 행번호 얻기
				int row = table.getSelectedRow(); 

				// list에서 row에 해당하는 dto를 꺼내 이미지명을 얻기
				imageName = list.get(row).getPhoto();

				// 이미지 나오게하는 메서드 호출
				draw.repaint();
				super.mouseClicked(e);
			}

		});
	}

	// 데이터를 출력해 주는 메서드
	public void dataWrite() {
		// 테이블 기존 데이터 삭제
		model.setRowCount(0);

		// 테이블에 데이터 추가
		for(EmployeeDto dto: list) {
			Vector<String> data = new Vector<String>();

			data.add(dto.getNum());
			data.add(dto.getName());
			data.add(dto.getGender());
			data.add(dto.getDept());
			data.add(dto.getPosition());
			data.add(dto.getAddr());
			data.add(String.valueOf(dto.getPay()));
			data.add(dto.getEmail());
			data.add(String.valueOf(dto.getIpsaday()));

			// 테이블 모델에 데이터 추가
			model.addRow(data);
		}

	}

	// 내부 클래스
	class ImageDraw extends Canvas{
		@Override
		public void paint(Graphics g) {
			super.paint(g);

			if(imageName!=null) {
				Image image = new ImageIcon(imageName).getImage();
				g.drawImage(image, 0, 0, 200, 260, this);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		if(ob==btnAdd) {
			
			EmployeeAddForm addForm = new EmployeeAddForm(this);

		} else if(ob ==btnDel) {
			
			String num = JOptionPane.showInputDialog("삭제할 num을 입력해 주세요");
			dbModel.deleteEmployee(num);
			
			list = dbModel.getAllEmployees();
	        dataWrite();
	        
		} else if(ob ==btnUpdate){

		    String num = JOptionPane.showInputDialog("수정할 num을 입력해 주세요");
		    EmployeeDto employee = dbModel.getEmployeeByNum(num);
		    
		    if (employee != null) {
		    	// DB에서 해당 직원 정보를 가져왔으면 수정폼 띄우기
		        EmployeeUpdateForm updateForm = new EmployeeUpdateForm(employee, this);
		    } else {
		        JOptionPane.showMessageDialog(this, "해당하는 직원이 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
		    }
		    
		}
		
	}

	public static void main(String[] args) {
		new EmployeeMain();

	}



}