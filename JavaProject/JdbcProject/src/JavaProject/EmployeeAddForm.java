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
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;


public class EmployeeAddForm extends JFrame implements ActionListener {

	JTextField tfName, tfGender, tfAddr, tfPay, tfEmail;
	JRadioButton rbMale, rbFemale;
	ButtonGroup genderGroup;
	JComboBox<String> cbDept, cbPosition;
	JLabel lblPhoto;
	String imageName;
	JButton btnImage, btnInsert;
	private EmployeeMain employeeMain;

	// db모델 생성
	EmployeeDbModel model = new EmployeeDbModel();

	// 내부클래스
	PhotoDraw photoDraw = new PhotoDraw();

	// 생성자 수정
    public EmployeeAddForm(EmployeeMain employeeMain) {
        this.employeeMain = employeeMain; // EmployeeMain 객체 초기화
		//super("사원 추가폼");
		this.setBounds(200, 100, 400, 500);
		initDesign();
		this.setVisible(true);	
	}
	

	public void initDesign() {
		this.setLayout(null);

		JLabel lbl1 = new JLabel("사원명");



		lbl1.setBounds(30, 10, 60, 30);
		this.add(lbl1);

		tfName = new JTextField();
		tfName.setBounds(110, 10, 100, 30);
		this.add(tfName);

		JLabel lbl2 = new JLabel("사진선택");
		lbl2.setBounds(30, 60, 60, 30);
		this.add(lbl2);

		btnImage = new JButton("사진선택");
		btnImage.setBounds(110, 60, 100, 30);
		this.add(btnImage);
		btnImage.addActionListener(this);

		//이미지추가
		photoDraw.setBounds(250, 10, 80, 90);
		this.add(photoDraw);

		//		//이미지명
		lblPhoto = new JLabel("이미지명");
		lblPhoto.setBorder(new LineBorder(Color.white));
		lblPhoto.setBounds(20, 120, 300, 30);
		this.add(lblPhoto);

		JLabel lbl3 = new JLabel("성별");
		lbl3.setBounds(30, 160, 70, 30);
		this.add(lbl3);

		rbMale = new JRadioButton("남자");
		rbMale.setBounds(110, 160, 60, 30);
		this.add(rbMale);

		rbFemale = new JRadioButton("여자");
		rbFemale.setBounds(170, 160, 60, 30);
		this.add(rbFemale);

		genderGroup = new ButtonGroup();
		genderGroup.add(rbMale);
		genderGroup.add(rbFemale);

		// 부서 라벨 생성
		JLabel lblDept = new JLabel("부서");
		lblDept.setBounds(30, 200, 70, 30); // 라벨 위치 설정
		this.add(lblDept); // 라벨을 화면에 추가

		String[] dept = {"개발부", "인사부", "기획부", "회계부"};
		cbDept = new JComboBox<String>(dept);
		cbDept.setBounds(110, 200, 100, 30); // 콤보 박스 위치 설정
		this.add(cbDept); // 콤보 박스를 화면에 추가

		//직급
		JLabel lblPosition = new JLabel("직급");
		lblPosition.setBounds(30, 240, 70, 30);
		this.add(lblPosition);

		String[] positions = {"사원", "대리", "과장", "차장", "부장"}; // 직급 옵션들
		cbPosition = new JComboBox<String>(positions);
		cbPosition.setBounds(110, 240, 100, 30);
		this.add(cbPosition);

		//주소
		JLabel lbl6 = new JLabel("주소");
		lbl6.setBounds(30, 280, 70, 30);
		this.add(lbl6);

		tfAddr = new JTextField();
		tfAddr.setBounds(110, 280, 150, 30);
		this.add(tfAddr);

		//급여
		JLabel lbl7 = new JLabel("급여");
		lbl7.setBounds(30, 320, 70, 30);
		this.add(lbl7);

		tfPay = new JTextField();
		tfPay.setBounds(110, 320, 150, 30);
		this.add(tfPay);

		//이메일
		JLabel lbl8 = new JLabel("이메일");
		lbl8.setBounds(30, 360, 70, 30); 
		this.add(lbl8);

		tfEmail = new JTextField();
		tfEmail.setBounds(110, 360, 150, 30);
		this.add(tfEmail);

		//db추가버튼
		btnInsert = new JButton("DB추가");
		btnInsert.setBounds(250, 400, 100, 30);
		btnInsert.addActionListener(this);
		this.add(btnInsert);

	}

	// 내부클래스 --> 이미지 삽입을 위해
	class PhotoDraw extends Canvas{

		@Override
		public void paint(Graphics g) {
			super.paint(g);

			if(imageName!=null) {
				Image image = new ImageIcon(imageName).getImage();
				g.drawImage(image, 10, 10, 60, 70, this);
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		if(ob==btnImage) {
			FileDialog dlg = new FileDialog(this, "이미지 가져오기", FileDialog.LOAD);
			dlg.setVisible(true);

			// 취소 누르면 메서드 종료
			if(dlg.getDirectory()==null)
				return;
			// 이미지명 얻기
			imageName = dlg.getDirectory() + dlg.getFile();

			// 라벨에 이미지명 출력
			lblPhoto.setText(imageName);

			// 이미지 출력
			photoDraw.repaint();

		} else if (ob == btnInsert) {
			// ShopDto 생성
			EmployeeDto dto = new EmployeeDto();

			// dto에 4개의 데이터 넣기
			dto.setName(tfName.getText());
			dto.setPhoto(imageName);
			// 성별 처리
			if (rbMale.isSelected()) {
				dto.setGender("남자");
			} else if (rbFemale.isSelected()) {
				dto.setGender("여자");
			} else {
				dto.setGender("선택 안 함");
			}
			dto.setDept((String)cbDept.getSelectedItem());
			dto.setPosition((String)cbPosition.getSelectedItem());
			dto.setAddr(tfAddr.getText());
			dto.setPay(Integer.parseInt(tfPay.getText()));
			dto.setEmail(tfEmail.getText());

			// db모델에서 insert메서드 호출 
			model.insertEmployee(dto);

			// 메인 화면으로 돌아가기
            returnToMainFrame();
            // 현재 창 닫기
            this.dispose();

		}

	}
	// 메인 화면으로 돌아갈 때 호출되는 메서드
    private void returnToMainFrame() {
        // 메인 화면의 리스트 업데이트 및 데이터 쓰기 메서드 호출
        employeeMain.list = employeeMain.dbModel.getAllEmployees();
        employeeMain.dataWrite();
    }
}