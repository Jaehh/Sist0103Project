package Day0119;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {
    private JCheckBox maleCheckBox;
    private JRadioButton redRadioButton, greenRadioButton, blueRadioButton;
    private JCheckBox italyCheckBox, usaCheckBox, franceCheckBox, germanyCheckBox;
    private JLabel resultLabel;

    public Quiz(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        initUI();
        setVisible(true);
    }

    private void initUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        maleCheckBox = new JCheckBox("남자");
        maleCheckBox.addActionListener(this);
        panel.add(maleCheckBox);

        ButtonGroup colorGroup = new ButtonGroup();
        redRadioButton = new JRadioButton("빨강");
        greenRadioButton = new JRadioButton("초록");
        blueRadioButton = new JRadioButton("파랑");

        redRadioButton.addActionListener(this);
        greenRadioButton.addActionListener(this);
        blueRadioButton.addActionListener(this);

        colorGroup.add(redRadioButton);
        colorGroup.add(greenRadioButton);
        colorGroup.add(blueRadioButton);

        JPanel colorPanel = new JPanel();
        colorPanel.setLayout(new GridLayout(1, 3));
        colorPanel.setBorder(BorderFactory.createTitledBorder("색깔"));
        colorPanel.add(redRadioButton);
        colorPanel.add(greenRadioButton);
        colorPanel.add(blueRadioButton);
        panel.add(colorPanel);

        JPanel countryPanel = new JPanel();
        countryPanel.setLayout(new GridLayout(1, 4));
        countryPanel.setBorder(BorderFactory.createTitledBorder("내가 가본 나라"));
        italyCheckBox = new JCheckBox("이탈리아");
        usaCheckBox = new JCheckBox("미국");
        franceCheckBox = new JCheckBox("프랑스");
        germanyCheckBox = new JCheckBox("독일");

        italyCheckBox.addActionListener(this);
        usaCheckBox.addActionListener(this);
        franceCheckBox.addActionListener(this);
        germanyCheckBox.addActionListener(this);

        countryPanel.add(italyCheckBox);
        countryPanel.add(usaCheckBox);
        countryPanel.add(franceCheckBox);
        countryPanel.add(germanyCheckBox);
        panel.add(countryPanel);

        resultLabel = new JLabel("결과창", JLabel.CENTER);
        resultLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        resultLabel.setOpaque(true);  // 배경색을 표시하기 위해 투명도 활성화
        add(panel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StringBuilder result = new StringBuilder();

        if (e.getSource() == maleCheckBox) {
            resultLabel.setText(maleCheckBox.isSelected() ? "남자입니다." : "여자입니다.");
        }

        if (e.getSource() == italyCheckBox || e.getSource() == usaCheckBox ||
                e.getSource() == franceCheckBox || e.getSource() == germanyCheckBox) {
            result.append("내가 가본 나라는 ");

            if (italyCheckBox.isSelected()) {
                result.append("[이탈리아] ");
            }
            if (usaCheckBox.isSelected()) {
                result.append("[미국] ");
            }
            if (franceCheckBox.isSelected()) {
                result.append("[프랑스] ");
            }
            if (germanyCheckBox.isSelected()) {
                result.append("[독일] ");
            }

            if (!(italyCheckBox.isSelected() || usaCheckBox.isSelected() ||
                    franceCheckBox.isSelected() || germanyCheckBox.isSelected())) {
                result.append("없습니다.");
            }

            resultLabel.setText(result.toString());
        }

        // 색상 변경
        if (e.getSource() == redRadioButton) {
            resultLabel.setBackground(Color.RED);
        } else if (e.getSource() == greenRadioButton) {
            resultLabel.setBackground(Color.GREEN);
        } else if (e.getSource() == blueRadioButton) {
            resultLabel.setBackground(Color.BLUE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Quiz("사용자 인터페이스"));
    }
}
