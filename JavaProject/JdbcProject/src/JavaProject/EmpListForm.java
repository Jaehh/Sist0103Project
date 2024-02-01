package JavaProject;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EmpListForm extends JFrame{
	
	EmpDbModel dbModel = new EmpDbModel();
	
	ImageDraw draw = new ImageDraw();
	String photoName;
	
	//테이블
		DefaultTableModel model;
		JTable table;
		Vector<EmpDto> list;
		
		public EmpListForm() {
			super("전체 사원 리스트"); //제목을 보냄
			this.setBounds(200,100,700,400);
			initDesign();
			this.setVisible(true);
		}
		
		public void initDesign() {
			this.setLayout(null);
			
			//db로부터 목록부터 얻기
			list=dbModel.getAllEmp();
			
			
			//table
			String [] title = {"사원번호","사원명","성별","부서","직책","주소","급여","이메일","입사일"};
			model = new DefaultTableModel(title,0);
			table = new JTable(model);
			JScrollPane js = new JScrollPane(table);
			js.setBounds(10, 10, 500, 270);
			this.add(js);
			
			//이미지 위치
			draw.setBounds(520, 50, 160, 220);
			this.add(draw);
			
			//데이터 출력해 주는 메서드
			this.datawrite();
			
			//출력된 데이터 이벤트- 익명내부클래스
			table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			    
				//행번호얻기
				int row=table.getSelectedRow();
				
				//list에서 row에 해당하는 dto를 꺼내서 거기에서 이미지명을 얻는다
				photoName = list.get(row).getPhoto();
				
				//이미지나오게하는 메서드 호출
				draw.repaint();
				super.mouseClicked(e);
			}
			
			});
		}
		
		//데이터 출력해 주는 메서드
		public void datawrite() {
			//테이블 기존 데이터 삭제
			model.setRowCount(0);
			
			//테이블에 데이터 추가하기
			for(EmpDto dto:list) {
				Vector<String> data = new Vector<String>();
				data.add(dto.getNum());
				data.add(dto.getName());
				data.add(dto.getGender());
				data.add(dto.getDept());
				data.add(dto.getPosition());
				data.add(dto.getAddr());
				data.add(dto.getPay());
				data.add(dto.getEmail());
				//data.add(String.valueOf(dto.getImpsaday()));
				
				//테이블 모델에 추가
				model.addRow(data);
			}
		}
		
		//내부클래스
		class ImageDraw extends Canvas{
			
			@Override
			public void paint(Graphics g) {
				// TODO Auto-generated method stub
				super.paint(g);
				
				if(photoName!=null) {
					Image image = new ImageIcon(photoName).getImage();
					g.drawImage(image, 0, 0, 160, 200, this);
				}
			}
		}
//		public static void main(String[] args) {
//			new EmpListForm();
//		}

	}

