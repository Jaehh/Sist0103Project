package JavaProject;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	JButton btnPhoto,btnInsert;
	
	   private JButton btnHome;
	
	// 성별 정보를 저장할 변수 (EmpDto에 추가해야 함)
	private final String[] selectedGender = {" "};
	
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
					setVisible(false);
					new EmpMain().setVisible(true);;
					
				}
			});
		}
		
		//디자인
		public void initDesign() {
			this.setLayout(null);
			
			//홈화면 버튼
			
			// Home 버튼에 사용할 아이콘 생성
			 ImageIcon homeIcon = new ImageIcon("C:/Users/user/Desktop/home.png");
		        int width = 25;
		        int height = 25;
		        Image image = homeIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		        ImageIcon resizedIcon = new ImageIcon(image);
		        btnHome = new JButton(resizedIcon);
		        btnHome.setBounds(20, 20, 30, 30);
		        btnHome.addActionListener(this);
		        this.add(btnHome);
			
			//사진
			JLabel lbl2 = new JLabel(" ");
			lbl2.setBounds(30, 60, 60, 30);
			this.add(lbl2);
			
			btnPhoto = new JButton("사진선택");
			btnPhoto.setBounds(100, 270, 90, 30);
			this.add(btnPhoto);
			btnPhoto.addActionListener(this);
			
			//이미지 추가
			//PhotoDraw photoDraw = new PhotoDraw();
			photoDraw.setBounds(100, 70, 200, 250);
			this.add(photoDraw);
			
			//이미지명 나타나게
			lblPhoto = new JLabel(" ");
			//lblPhoto.setBorder(new LineBorder(Color.gray));
			lblPhoto.setBounds(20, 230, 300, 30);
			this.add(lblPhoto);
			
			
			//사원명
			JLabel lbl1 = new JLabel("사원명");
			lbl1.setBounds(330, 30, 100, 30);
			this.add(lbl1);
			
			tfName = new JTextField();
			tfName.setBounds(370,30,100,30);
			this.add(tfName);
			
			
			//성별
			JLabel lbl3 = new JLabel("성별");
			lbl3.setBounds(330, 70, 70, 30);
			this.add(lbl3);
			
			ButtonGroup group = new ButtonGroup();
			JRadioButton male = new JRadioButton("남");
			JRadioButton female = new JRadioButton("여");
			group.add(male);
			group.add(female);
			
			// 라디오 버튼을 패널에 추가
			male.setBounds(370, 70, 50, 30);
			female.setBounds(420, 70, 50, 30);
			this.add(male);
			this.add(female);


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
			cbDept.setBounds(370, 110, 70, 30);
			this.add(cbDept);
			
			JLabel lbl4 = new JLabel("부서");
			lbl4.setBounds(330, 110, 70, 30);
			this.add(lbl4);
			
			//직책
			String[] position = {"파트장","팀장","실장","본부장"};
			cbPosition = new JComboBox<String>(position);
			cbPosition.setBounds(370, 150, 70, 30);
			this.add(cbPosition);
			
			JLabel lbl5 = new JLabel("직책");
			lbl5.setBounds(330, 150, 70, 30);
			this.add(lbl5);
			
			
			//주소
			JLabel lbl6 = new JLabel("주소");
			lbl6.setBounds(330, 190, 70, 30);
			this.add(lbl6);
			
			tfAddr = new JTextField();
			tfAddr.setBounds(370, 190,150, 30);
			this.add(tfAddr);
			
			//월급
			JLabel lbl7 = new JLabel("월급");
			lbl7.setBounds(330, 230, 70, 30);
			this.add(lbl7);
			
			tfPay = new JTextField();
			tfPay.setBounds(370, 230, 70, 30);
			this.add(tfPay);
			
			//이메일
			JLabel lbl8 = new JLabel("이메일");
			lbl8.setBounds(330, 270, 70, 30);
			this.add(lbl8);
			
			tfEmail = new JTextField();
			tfEmail.setBounds(370, 270, 150, 30);
			this.add(tfEmail);
			
			//db추가버튼
			btnInsert = new JButton("추가");
			btnInsert.setBounds(550, 320, 100, 30);
			btnInsert.addActionListener(this);
			this.add(btnInsert);
		}
		
		//내부클래스-이미지삽입
	    class PhotoDraw extends Canvas{
	   
	    	public void paint(Graphics g) {
				// TODO Auto-generated method stub
	super.paint(g);

	if(photoName!=null) {
		Image image = new ImageIcon(photoName).getImage();
		g.drawImage(image, 10, 10, 60, 70, this);
	}
			}
	    }
	 // 이미지 크기를 유지하면서 조절하는 메서드
//	    private Image getScaledImage(Image image, int width, int height) {
//	        int originalWidth = image.getWidth(this);
//	        int originalHeight = image.getHeight(this);
//
//	        double widthRatio = (double) width / originalWidth;
//	        double heightRatio = (double) height / originalHeight;
//
//	        double ratio = Math.min(widthRatio, heightRatio);
//
//	        width = (int) (originalWidth * ratio);
//	        height = (int) (originalHeight * ratio);
//
//	        return image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
//	    }

		
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
				//lblPhoto.setText(photoName);
				//이미지 출력
				photoDraw.repaint();
			} else if(ob==btnInsert) {
				
			    EmpDto dto= new EmpDto();
			    

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
			    
			    //메인화면 띄우기
			    new EmpMain();
			}
			
		}
	    



	}
