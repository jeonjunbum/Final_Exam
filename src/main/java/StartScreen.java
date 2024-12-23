import javax.swing.*;
import java.awt.*;

public class StartScreen extends JFrame {
    public StartScreen() {
        setTitle("장학금 찾기 프로그램 시작 화면");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setLocationRelativeTo(null); // 화면 중앙에 위치

        // 레이아웃 설정
        setLayout(new FlowLayout());

        // "장학금 찾기 start" 버튼 추가
        JButton startButton = new JButton("장학금 찾기 start");
        startButton.setBackground(new Color(73, 106, 159));
        startButton.setForeground(Color.WHITE);
        startButton.addActionListener(e -> {
            // ScholarshipFrame 창 열기
            ScholarshipFrame scholarshipFrame = new ScholarshipFrame();
            scholarshipFrame.setVisible(true);
            this.dispose(); // 시작 화면 닫기
        });

        // 버튼 추가
        add(startButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StartScreen startScreen = new StartScreen();
            startScreen.setVisible(true);
        });
    }
}
