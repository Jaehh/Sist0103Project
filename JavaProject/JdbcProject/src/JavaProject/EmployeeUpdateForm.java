package JavaProject;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeUpdateForm extends JFrame implements ActionListener {
    JTextField tfNum, tfName, tfAddr, tfPay, tfEmail;
    JRadioButton rbMale, rbFemale;
    ButtonGroup genderGroup;
    JComboBox<String> cbDept, cbPosition;
    JButton btnSearch, btnUpdate;
    private EmployeeMain employeeMain; // EmployeeMain 객체 참조를 저장할 변수 추가
    private EmployeeDto employee; // 직원 정보를 저장할 변수 추가

    EmployeeDbModel model = new EmployeeDbModel();
    
    // 생성자 수정: EmployeeDto 객체와 EmployeeMain 객체를 매개변수로 받도록 변경
    public EmployeeUpdateForm(EmployeeDto employee, EmployeeMain employeeMain) {
        this.employee = employee; // 전달받은 직원 정보를 저장
        this.employeeMain = employeeMain; // EmployeeMain 객체 참조 저장
        this.setBounds(200, 100, 400, 500);
        initDesign(); // 화면 구성을 위한 메서드 호출
        setData(employee); // 전달받은 직원 정보로 폼 데이터 설정
        this.setVisible(true);
    }
    
    // setData 메서드 정의: 직원 정보를 폼에 설정
    private void setData(EmployeeDto employee) {
        // 직원 정보를 사용하여 폼 데이터 설정
        tfNum.setText(employee.getNum());
        tfName.setText(employee.getName());
        if (employee.getGender().equals("남자")) {
            rbMale.setSelected(true);
        } else {
            rbFemale.setSelected(true);
        }
        cbDept.setSelectedItem(employee.getDept());
        cbPosition.setSelectedItem(employee.getPosition());
        tfAddr.setText(employee.getAddr());
        tfPay.setText(String.valueOf(employee.getPay()));
        tfEmail.setText(employee.getEmail());
        
        // 직원 번호는 수정할 필요가 없으므로 읽기 전용으로 설정
        tfNum.setEditable(false);
    }

    public void initDesign() {
        this.setLayout(null);

        JLabel lblNum = new JLabel("직원 번호");
        lblNum.setBounds(30, 10, 80, 30);
        this.add(lblNum);

        tfNum = new JTextField();
        tfNum.setBounds(120, 10, 100, 30);
        this.add(tfNum);   

        JLabel lblName = new JLabel("사원명");
        lblName.setBounds(30, 60, 80, 30);
        this.add(lblName);

        tfName = new JTextField();
        tfName.setBounds(120, 60, 200, 30);
        this.add(tfName);

        JLabel lbl3 = new JLabel("성별");
        lbl3.setBounds(30, 100, 70, 30);
        this.add(lbl3);

        rbMale = new JRadioButton("남자");
        rbMale.setBounds(120, 100, 70, 30);
        this.add(rbMale);

        rbFemale = new JRadioButton("여자");
        rbFemale.setBounds(190, 100, 70, 30);
        this.add(rbFemale);

        genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);

        JLabel lblDept = new JLabel("부서");
        lblDept.setBounds(30, 140, 70, 30);
        this.add(lblDept);

        String[] dept = {"개발부", "인사부", "기획부", "회계부"};
        cbDept = new JComboBox<>(dept);
        cbDept.setBounds(120, 140, 200, 30);
        this.add(cbDept);

        JLabel lblPosition = new JLabel("직급");
        lblPosition.setBounds(30, 180, 70, 30);
        this.add(lblPosition);

        String[] positions = {"사원", "대리", "과장", "차장", "부장"};
        cbPosition = new JComboBox<>(positions);
        cbPosition.setBounds(120, 180, 200, 30);
        this.add(cbPosition);

        JLabel lbl6 = new JLabel("주소");
        lbl6.setBounds(30, 220, 70, 30);
        this.add(lbl6);

        tfAddr = new JTextField();
        tfAddr.setBounds(120, 220, 200, 30);
        this.add(tfAddr);

        JLabel lbl7 = new JLabel("급여");
        lbl7.setBounds(30, 260, 70, 30);
        this.add(lbl7);

        tfPay = new JTextField();
        tfPay.setBounds(120, 260, 200, 30);
        this.add(tfPay);

        JLabel lbl8 = new JLabel("이메일");
        lbl8.setBounds(30, 300, 70, 30);
        this.add(lbl8);

        tfEmail = new JTextField();
        tfEmail.setBounds(120, 300, 200, 30);
        this.add(tfEmail);

        btnUpdate = new JButton("수정");
        btnUpdate.setBounds(150, 350, 100, 30);
        btnUpdate.addActionListener(this);
        this.add(btnUpdate);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == btnUpdate) {
            // 수정 버튼이 클릭되었을 때
            // 수정 폼에서 사용자가 입력한 정보 가져오기
            String name = tfName.getText();
            String gender = rbMale.isSelected() ? "남자" : "여자";
            String dept = (String) cbDept.getSelectedItem();
            String position = (String) cbPosition.getSelectedItem();
            String addr = tfAddr.getText();
            int pay = Integer.parseInt(tfPay.getText());
            String email = tfEmail.getText();

            // 가져온 정보로 EmployeeDto 객체 생성
            EmployeeDto dto = new EmployeeDto();
            dto.setNum(tfNum.getText()); // 기존 직원 번호
            dto.setName(name);
            dto.setGender(gender);
            dto.setDept(dept);
            dto.setPosition(position);
            dto.setAddr(addr);
            dto.setPay(pay);
            dto.setEmail(email);

            // EmployeeDbModel을 사용하여 데이터베이스에 해당 직원 정보 업데이트
            EmployeeDbModel dbModel = new EmployeeDbModel();
            dbModel.updateEmployee(dto.getNum(), dto);

            // 수정 완료 메시지 표시
            JOptionPane.showMessageDialog(this, "직원 정보가 성공적으로 수정되었습니다.", "수정 완료", JOptionPane.INFORMATION_MESSAGE);

            // 메인 화면으로 돌아가기
            returnToMainFrame();
            
            // 폼 닫기
            this.dispose();
        }
    }

    // 직원 번호를 이용하여 직원 정보를 가져오는 메서드
    private EmployeeDto getEmployeeInfo(String num) {
        EmployeeDbModel model = new EmployeeDbModel();
        return model.getEmployeeByNum(num);
    }
    
    // 메인 화면으로 돌아갈 때 호출되는 메서드
    private void returnToMainFrame() {
        // 메인 화면의 리스트 업데이트 및 데이터 쓰기 메서드 호출
        employeeMain.list = employeeMain.dbModel.getAllEmployees();
        employeeMain.dataWrite();
    }
}