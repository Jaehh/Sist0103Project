package JavaProject;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class EmpAddForm extends JFrame implements ActionListener{
	
	///체크박스, 콤보박스 추가해야
	JTextField tfName,tfAddr,tfPay,tfEmail;
	JComboBox<String> cbDept, cbPosition;
	JRadioButton tfGender;
	JLabel lblPhoto;
	String photoName;
	JButton btnHome,btnPhoto,btnInsert;
	
	//db모델 생성
	    EmpDbModel model = new EmpDbModel();
		//내부클래스
		PhotoDraw photoDraw = new PhotoDraw();
	
		public EmpAddForm()
		{	
			super("사원 추가"); //제목을 보냄
			this.setBounds(200,100,700,400);
			initDesign();
			this.setVisible(true);
			
			btnHome.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new EmpMain();
					setVisible(false);
					
				}
			});
		}
		
		//디자인
		public void initDesign() {
			this.setLayout(null);
			
			//홈화면 버튼
			btnHome = new JButton("Home");
			btnHome.setBounds(20, 20, 30, 30);
			this.add(btnHome);
			btnHome.addActionListener(this);
			
			//사진
			JLabel lbl2 = new JLabel("사진선택");
			lbl2.setBounds(30, 60, 60, 30);
			this.add(lbl2);
			
			btnPhoto = new JButton("사진선택");
			btnPhoto.setBounds(80, 60, 100, 30);
			this.add(btnPhoto);
			btnPhoto.addActionListener(this);
			
			//이미지 추가
			photoDraw.setBounds(250, 10, 80, 90);
			this.add(photoDraw);
			
			//이미지명 나타나게
			//lblPhoto = new JLabel("이미지명");
			//lblPhoto.setBorder(new LineBorder(Color.pink));
			//lblPhoto.setBounds(20, 120, 300, 30);
			//this.add(lblPhoto);
			
			
			//사원명
			JLabel lbl1 = new JLabel("사원명");
			lbl1.setBounds(360, 100, 100, 30);
			this.add(lbl1);
			
			tfName = new JTextField();
			tfName.setBounds(400,100,100,30);
			this.add(tfName);
			
			
			//성별
			JLabel lbl3 = new JLabel("성별");
			lbl3.setBounds(30, 150, 70, 30);
			this.add(lbl3);
			
			ButtonGroup group = new ButtonGroup();
			JRadioButton male = new JRadioButton("남");
			JRadioButton female = new JRadioButton("여");
			group.add(male);
			group.add(female);
			
			// 라디오 버튼을 패널에 추가
			male.setBounds(110, 150, 50, 30);
			female.setBounds(160, 150, 50, 30);
			this.add(male);
			this.add(female);

			// 성별 정보를 저장할 변수 (EmpDto에 추가해야 함)
			final String[] selectedGender = {" "};

			// 라디오 버튼에 대한 이벤트 리스너 추가
			male.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			    	selectedGender[0]  = "남";
			    }
			});

			female.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			    	selectedGender[0] = "여";
			    }
			});

			
			//부서
			String[] dept = {"인사부","개발부","영업부"};
			cbDept = new JComboBox<String>(dept);
			cbDept.setBounds(110, 190, 70, 30);
			this.add(cbDept);
			
			JLabel lbl4 = new JLabel("부서");
			lbl4.setBounds(30, 190, 70, 30);
			this.add(lbl4);
			
			//직책
			String[] position = {"파트장","팀장","실장","본부장"};
			cbPosition = new JComboBox<String>(position);
			cbPosition.setBounds(110, 230, 70, 30);
			this.add(cbPosition);
			
			JLabel lbl5 = new JLabel("직책");
			lbl5.setBounds(30, 230, 70, 30);
			this.add(lbl5);
			
			
			//주소
			JLabel lbl6 = new JLabel("주소");
			lbl6.setBounds(30, 270, 70, 30);
			this.add(lbl6);
			
			tfAddr = new JTextField();
			tfAddr.setBounds(110, 270, 70, 30);
			this.add(tfAddr);
			
			//월급
			JLabel lbl7 = new JLabel("월급");
			lbl7.setBounds(30, 310, 70, 30);
			this.add(lbl7);
			
			tfPay = new JTextField();
			tfPay.setBounds(110, 310, 70, 30);
			this.add(tfPay);
			
			//이메일
			JLabel lbl8 = new JLabel("이메일");
			lbl7.setBounds(30, 350, 70, 30);
			this.add(lbl7);
			
			tfEmail = new JTextField();
			tfEmail.setBounds(110, 350, 70, 30);
			this.add(tfEmail);
			
			//db추가버튼
			btnInsert = new JButton("DB 추가");
			btnInsert.setBounds(160, 240, 100, 30);
			btnInsert.addActionListener(this);
			this.add(btnInsert);
		}
		
		//내부클래스-이미지삽입
	    class PhotoDraw extends Canvas{
	   
	    	public void Paint(Graphics g) {
				// TODO Auto-generated method stub
	super.paint(g);

	if(photoName!=null) {
		Image image = new ImageIcon(photoName).getImage();
		g.drawImage(image, 10, 10, 60, 70, this);
	}
			}
	    }
		
	    @Override
		public void actionPerformed(ActionEvent e) {
			Object ob = e.getSource();
			
			if(ob==btnPhoto) {
				FileDialog dlg = new FileDialog(this, "이미지가져오기",FileDialog.LOAD);
				dlg.setVisible(true);
				
				//취소누르면 메서드 종료
				if(dlg.getDirectory()==null) {
					return;
				}//이미지명 얻기
				photoName = dlg.getDirectory()+dlg.getFile();
				
				//라벨에 이미지명 출력
				lblPhoto.setText(photoName);
				
				//이미지 출력
				photoDraw.repaint();
			} else if(ob==btnInsert) {
				
			    EmpDto dto= new EmpDto();
			    
			    //dto에 4개의 데이터를 넣는다
			    dto.setName(tfName.getText());
			    dto.setPhoto(photoName);
			    dto.setGender(selectedGender[0]);
			    dto.setDept(cbDept.getSelectedItem().toString());
			    dto.setPosition(cbPosition.getSelectedItem().toString());
			    dto.setAddr(tfAddr.getText());
			    dto.setPay(tfPay.getText());
			    dto.setEmail(tfEmail.getText());
			    
			    //db모델에서 insert 메서드 호출
			    model.insertEmp(dto);
			    
			    //현재창 닫기
			    this.setVisible(false);
			}
			
		}
	    
//		public static void main(String[] args) {
//			// TODO Auto-generated method stub
	//new ShopAddForm();
//		}


	}
