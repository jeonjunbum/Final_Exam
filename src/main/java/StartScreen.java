import javax.swing.*;
import java.awt.*;

/**
 * 장학금 찾기 프로그램의 시작 화면을 위한 GUI 프레임 클래스입니다.
 * 이 클래스는 프로그램의 시작 화면을 구성하며,
 * 사용자에게 장학금 찾기 프로그램으로의 진입 버튼을 제공합니다.
 *
 * @author [jeonjunbum]
 * @version 1.0
 */
public class StartScreen extends JFrame {

    /**
     * StartScreen 생성자.
     * 시작 화면의 GUI 요소를 초기화하고 설정합니다.
     */
    public StartScreen() {
        setTitle("장학금 찾기 프로그램 시작 화면"); // 프레임 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 버튼 설정
        setSize(300, 300);  // 프레임 크기를 300x300으로 설정
        setLocationRelativeTo(null); // 화면 중앙에 위치

        // 아이콘 이미지 설정
        ImageIcon icon = new ImageIcon("src/main/resources/UniversityLogo.png"); // 아이콘 이미지 경로
        setIconImage(icon.getImage()); // 프레임 아이콘 설정

        // 배경색을 하얀색으로 설정
        getContentPane().setBackground(Color.WHITE);

        // GridBagLayout 설정
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // 가로 방향으로 채우기
        gbc.insets = new Insets(10, 10, 10, 10); // 여백 설정

        // "장학금 찾기 start" 버튼 추가
        JButton startButton = new JButton("장학금 찾기 start");
        startButton.setBackground(new Color(73, 106, 159)); // 버튼 배경색 설정
        startButton.setForeground(Color.WHITE); // 버튼 글자색 설정
        startButton.setBorderPainted(false); // 버튼 테두리 제거
        startButton.setFocusPainted(false); // 버튼 클릭 시 테두리 제거

        // 버튼 클릭 시 동작 정의
        startButton.addActionListener(e -> {
            // ScholarshipCalculator, InputValidator, ScholarshipRequirementsLoader 인스턴스 생성
            ScholarshipCalculator calculator = new ScholarshipCalculator();
            InputValidator validator = new InputValidator();
            ScholarshipRequirementsLoader requirementsLoader = new ScholarshipRequirementsLoader();

            // ScholarshipFrame 창 열기
            ScholarshipFrame scholarshipFrame = new ScholarshipFrame(calculator, validator, requirementsLoader);
            scholarshipFrame.setVisible(true); // 장학금 찾기 프레임을 보이도록 설정
            this.dispose(); // 시작 화면 닫기
        });

        // 버튼을 그리드에 추가
        gbc.gridx = 0; // 첫 번째 열
        gbc.gridy = 0; // 첫 번째 행
        gbc.weighty = 0.1; // 버튼의 높이 비율 설정
        add(startButton, gbc); // 버튼 추가

        // 이미지 로드 및 크기 조정
        ImageIcon logoIcon = new ImageIcon("src/main/resources/UniversityLogo.png"); // 이미지 경로
        Image logoImage = logoIcon.getImage().getScaledInstance(200, 185, Image.SCALE_SMOOTH); // 크기 조정
        JLabel logoLabel = new JLabel(new ImageIcon(logoImage)); // 조정된 이미지를 JLabel로 생성

        // 로고를 그리드에 추가 (가운데 정렬)
        gbc.gridy = 1; // 두 번째 행
        gbc.weighty = 0.8; // 로고의 높이 비율 설정
        gbc.anchor = GridBagConstraints.CENTER; // 가운데 정렬 설정
        add(logoLabel, gbc); // 버튼 바로 아래에 로고 추가

        // 빈 공간 추가하여 로고가 중앙에 위치하도록 조정
        gbc.gridy = 2; // 세 번째 행
        gbc.weighty = 0.1; // 로고 아래 빈 공간을 위해 설정
        add(new JLabel(), gbc); // 빈 JLabel 추가
    }

    /**
     * 프로그램 실행의 진입점입니다.
     * SwingUtilities.invokeLater를 사용하여 UI를 안전하게 생성합니다.
     *
     * @param args 프로그램 인수
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StartScreen startScreen = new StartScreen(); // StartScreen 인스턴스 생성
            startScreen.setVisible(true); // 화면에 표시
        });
    }
}
