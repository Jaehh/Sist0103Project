package JavaProject;

import javax.swing.*;

import JavaProject.EmpAddForm.PhotoDraw;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmpUpdateForm extends JFrame implements ActionListener {

	 private final EmpDto dto; // EmpDto 객체 추가
	 
    JTextField tfNum, tfName, tfAddr, tfPay, tfEmail;
    JComboBox<String> cbDept, cbPosition;
    JRadioButton male,female;
    JButton btnUpdate, btnCancel,btnPhoto;
    JLabel lblPhoto;
	String photoName;

    private JButton btnHome;
    
    private final String[] selectedGender = {" "};
    
    // db모델 생성
    EmpDbModel model = new EmpDbModel();
    
    PhotoDraw photoDraw = new PhotoDraw();

    public EmpUpdateForm(EmpDto dto) {
        super("사원 정보 수정"); // 제목을 보냄
        this.setBounds(200, 100, 700, 400);
        this.dto = dto; // 받은 dto를 인스턴스 변수에 설정
        initDesign(); // initDesign 메서드 호출 시에 이미 받은 dto를 사용
        this.setVisible(true);
        
        
        btnHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new EmpMain().setVisible(true);
						}
	});
       
    }

    // 디자인
    public void initDesign() {
        this.setLayout(null);

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
			
        // 사원번호
        JLabel lbl0 = new JLabel("사원번호");
        lbl0.setBounds(80, 30, 100, 30);
        this.add(lbl0);

        tfNum = new JTextField();
        tfNum.setBounds(150, 30, 50, 30);
        tfNum.setEditable(false);
        this.add(tfNum);

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

        // 수정 버튼
        btnUpdate = new JButton("수정");
        btnUpdate.setBounds(430, 320, 100, 30);
        btnUpdate.addActionListener(this);
        this.add(btnUpdate);

        // 취소 버튼
        btnCancel = new JButton("취소");
        btnCancel.setBounds(550, 320, 100, 30);
        btnCancel.addActionListener(this);
        this.add(btnCancel);

        // 기존 데이터 표시
        tfNum.setText(dto.getNum());
        tfName.setText(dto.getName());
        if (dto.getGender().equals("남")) {
            male.setSelected(true);
        } else {
            female.setSelected(true);
        }
        cbDept.setSelectedItem(dto.getDept());
        cbPosition.setSelectedItem(dto.getPosition());
        tfAddr.setText(dto.getAddr());
        tfPay.setText(dto.getPay());
        tfEmail.setText(dto.getEmail());
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
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object ob = e.getSource();

        if (ob == btnUpdate) {
            // 기존의 EmpDto 객체 사용
            this.dto.setNum(tfNum.getText());
            this.dto.setName(tfName.getText());
            this.dto.setPhoto(photoName);
            this.dto.setGender(male.isSelected() ? "남" : "여");
            this.dto.setDept(cbDept.getSelectedItem().toString());
            this.dto.setPosition(cbPosition.getSelectedItem().toString());
            this.dto.setAddr(tfAddr.getText());
            this.dto.setPay(tfPay.getText());
            this.dto.setEmail(tfEmail.getText());

            // db모델에서 update 메서드 호출
            model.updateEmp(this.dto);

            // 현재창 닫기
            this.setVisible(false);

            // 메인화면 띄우기
            new EmpMain().setVisible(true); // 이 부분을 수정함
        }
    }

}
