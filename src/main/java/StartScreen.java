import javax.swing.*;
import java.awt.*;

public class StartScreen extends JFrame {
    public StartScreen() {
        setTitle("장학금 찾기 프로그램 시작 화면");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);  // 크기를 300x300으로 설정
        setLocationRelativeTo(null); // 화면 중앙에 위치

        // 배경색을 하얀색으로 설정
        getContentPane().setBackground(Color.WHITE);

        // GridBagLayout 설정
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); // 여백 설정

        // "장학금 찾기 start" 버튼 추가
        JButton startButton = new JButton("장학금 찾기 start");
        startButton.setBackground(new Color(73, 106, 159));
        startButton.setForeground(Color.WHITE);
        startButton.setBorderPainted(false); // 버튼 테두리 제거
        startButton.setFocusPainted(false); // 버튼 클릭 시 테두리 제거
        startButton.addActionListener(e -> {
            // ScholarshipFrame 창 열기
            ScholarshipFrame scholarshipFrame = new ScholarshipFrame();
            scholarshipFrame.setVisible(true);
            this.dispose(); // 시작 화면 닫기
        });

        // 버튼을 그리드에 추가
        gbc.gridx = 0; // 첫 번째 열
        gbc.gridy = 0; // 첫 번째 행
        gbc.weighty = 0.1; // 버튼의 높이 비율 설정
        add(startButton, gbc);

        // 이미지 로드 및 크기 조정
        ImageIcon logoIcon = new ImageIcon("src/main/resources/UniversityLogo.png"); // 이미지 경로
        Image logoImage = logoIcon.getImage().getScaledInstance(200, 182, Image.SCALE_SMOOTH); // 크기 조정
        JLabel logoLabel = new JLabel(new ImageIcon(logoImage));

        // 로고를 그리드에 추가 (가운데 정렬)
        gbc.gridy = 1; // 두 번째 행
        gbc.weighty = 0.8; // 로고의 높이 비율 설정
        gbc.anchor = GridBagConstraints.CENTER; // 가운데 정렬 설정
        add(logoLabel, gbc); // 버튼 바로 아래에 추가

        // 빈 공간 추가하여 로고가 중앙에 위치하도록 조정
        gbc.gridy = 2; // 세 번째 행
        gbc.weighty = 0.1; // 로고 아래 빈 공간을 위해 설정
        add(new JLabel(), gbc); // 빈 JLabel 추가
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StartScreen startScreen = new StartScreen();
            startScreen.setVisible(true);
        });
    }
}
