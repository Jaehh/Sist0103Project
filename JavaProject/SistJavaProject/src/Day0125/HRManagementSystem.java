package Day0125;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class HRManagementSystem extends JFrame {

    public HRManagementSystem() {
        setTitle("HR Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 각 패널에 배경색 설정
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(240, 240, 240));

        JPanel employeePanel = new JPanel(new BorderLayout());
        employeePanel.setBackground(new Color(255, 255, 255));

        JPanel attendancePanel = new JPanel(new BorderLayout());
        attendancePanel.setBackground(new Color(255, 255, 255));

        // 직원 목록 테이블 생성
        String[] columnNames = {"Employee ID", "Name", "Department", "Position"};
        Object[][] data = {{"1", "John Doe", "IT", "Software Engineer"}};

        JTable employeeTable = new JTable(data, columnNames);
        JScrollPane employeeScrollPane = new JScrollPane(employeeTable);

        // 직원 사진 표시를 위한 JLabel
        JLabel employeePhotoLabel = new JLabel();
        try {
            BufferedImage img = ImageIO.read(new File("path/to/employee/photo.jpg"));
            Image scaledImage = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            employeePhotoLabel.setIcon(new ImageIcon(scaledImage));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JButton addEmployeeButton = new JButton("Add Employee");
        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(HRManagementSystem.this, "Add Employee button clicked");
            }
        });

        // 출퇴근 기록 테이블 생성
        String[] attendanceColumnNames = {"Record ID", "Employee ID", "Datetime", "Type"};
        Object[][] attendanceData = {{"1", "1", "2024-01-25 09:00:00", "출근"}};

        JTable attendanceTable = new JTable(attendanceData, attendanceColumnNames);
        JScrollPane attendanceScrollPane = new JScrollPane(attendanceTable);

        JButton addAttendanceButton = new JButton("Add Attendance");
        addAttendanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(HRManagementSystem.this, "Add Attendance button clicked");
            }
        });

        // 패널에 컴포넌트 추가
        employeePanel.add(new JLabel("Employee List"), BorderLayout.NORTH);
        employeePanel.add(employeePhotoLabel, BorderLayout.WEST);  // 사진 추가
        employeePanel.add(employeeScrollPane, BorderLayout.CENTER);
        employeePanel.add(addEmployeeButton, BorderLayout.SOUTH);

        attendancePanel.add(new JLabel("Attendance Records"), BorderLayout.NORTH);
        attendancePanel.add(attendanceScrollPane, BorderLayout.CENTER);
        attendancePanel.add(addAttendanceButton, BorderLayout.SOUTH);

        // 메인 패널에 탭 추가
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Employee Management", employeePanel);
        tabbedPane.addTab("Attendance Management", attendancePanel);

        mainPanel.add(tabbedPane, BorderLayout.CENTER);

        // 프레임에 메인 패널 추가
        add(mainPanel);

        // 화면 가운데에 표시
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    // Look and Feel 설정 (예시로 Nimbus 사용)
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                new HRManagementSystem().setVisible(true);
            }
        });
    }
}
