import javax.swing.*;
import java.awt.*;

public class ScholarshipFrame extends JFrame {
    private static final String FILE_PATH = "src/Scholarship.txt"; // 자동으로 불러올 파일 경로

    public ScholarshipFrame() {
        setTitle("장학금 찾기 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // 요건 설명 영역
        JTextArea requirementsArea = new JTextArea(10, 30);
        requirementsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(requirementsArea);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        add(scrollPane, gbc);

        // 버튼: 장학금 요건 불러오기
        JButton loadButton = new JButton("장학금 요건 불러오기");
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        add(loadButton, gbc);

        // 학년 입력
        JLabel gradeLabel = new JLabel("학생의 학년 (1-4):");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(gradeLabel, gbc);

        JTextField gradeField = new JTextField(10);
        gbc.gridx = 1;
        add(gradeField, gbc);

        // 학년 전체 인원 입력
        JLabel totalStudentsLabel = new JLabel("학년 전체 인원:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(totalStudentsLabel, gbc);

        JTextField totalStudentsField = new JTextField(10);
        gbc.gridx = 1;
        add(totalStudentsField, gbc);

        // 학생의 등수 입력
        JLabel rankLabel = new JLabel("학생의 등수:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(rankLabel, gbc);

        JTextField rankField = new JTextField(10);
        gbc.gridx = 1;
        add(rankField, gbc);

        // 취득한 학점 입력
        JLabel creditsLabel = new JLabel("취득한 학점:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(creditsLabel, gbc);

        JTextField creditsField = new JTextField(10);
        gbc.gridx = 1;
        add(creditsField, gbc);

        // 신청 평점 입력
        JLabel gpaLabel = new JLabel("신청 평점 (0.0 - 4.5):");
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(gpaLabel, gbc);

        JTextField gpaField = new JTextField(10);
        gbc.gridx = 1;
        add(gpaField, gbc);

        // 버튼: 장학금 신청
        JButton applyButton = new JButton("장학금 찾기");
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        add(applyButton, gbc);

        // 결과 출력 영역
        JTextArea resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        JScrollPane resultScrollPane = new JScrollPane(resultArea);
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        add(resultScrollPane, gbc);
    }
}