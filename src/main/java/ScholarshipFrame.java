import javax.swing.*;
import java.awt.*;

public class ScholarshipFrame extends JFrame {
    private static final String FILE_PATH = "src/Scholarship.txt"; // 자동으로 불러올 파일 경로

    public ScholarshipFrame() {
        setTitle("장학금 찾기 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);

        // 아이콘 설정
        ImageIcon icon = new ImageIcon("src/main/resources/UniversityLogo.png"); // 아이콘 이미지 경로
        setIconImage(icon.getImage()); // 프레임 아이콘 설정

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
        loadButton.setBackground(new Color(73, 106, 159)); // RGB 값을 사용하여 배경색 설정
        loadButton.setForeground(Color.WHITE); // 글자색을 하얀색으로 설정
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

        // 버튼: 장학금 찾기
        JButton applyButton = new JButton("장학금 찾기");
        applyButton.setBackground(new Color(73, 106, 159)); // RGB 값을 사용하여 배경색 설정
        applyButton.setForeground(Color.WHITE); // 글자색을 하얀색으로 설정
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

        // 프로그램 시작 시 자동으로 장학금 요건 불러오기
        ScholarshipRequirementsLoader.loadScholarshipRequirements(FILE_PATH, requirementsArea);

        loadButton.addActionListener(e -> ScholarshipRequirementsLoader.loadScholarshipRequirements(FILE_PATH, requirementsArea));

        applyButton.addActionListener(e -> {
            try {
                int grade = Integer.parseInt(gradeField.getText());
                int totalStudents = Integer.parseInt(totalStudentsField.getText());
                int rank = Integer.parseInt(rankField.getText());
                double creditsEarned = Double.parseDouble(creditsField.getText());
                double gpa = Double.parseDouble(gpaField.getText());

                // 입력값 검증
                InputValidator.validateGrade(grade);
                InputValidator.validateTotalStudents(totalStudents);
                InputValidator.validateRank(rank, totalStudents);
                InputValidator.validateCredits(creditsEarned);
                InputValidator.validateGPA(gpa);

                // 장학금 자격 검증 및 장학금 계산
                if (ScholarshipCalculator.isEligibleForScholarship(grade, (int) creditsEarned, gpa)) {
                    double scholarshipAmount = ScholarshipCalculator.calculateScholarship(gpa, rank, totalStudents);
                    String scholarshipType = ScholarshipCalculator.determineScholarshipType(gpa, rank, totalStudents);
                    resultArea.setText("선발되었습니다! 장학금 종류: " + scholarshipType +
                            "\n지급액: " + ScholarshipCalculator.formatAmount(scholarshipAmount) + "원");
                } else {
                    showErrorDialog("장학금 수혜 자격이 없습니다.");
                }
            } catch (NumberFormatException ex) {
                showErrorDialog("입력값이 잘못되었습니다. 다시 입력해주세요.");
            } catch (IllegalArgumentException ex) {
                showErrorDialog(ex.getMessage());
            }
        });
    }

    private void showErrorDialog(String message) {
        JDialog errorDialog = new JDialog(this, "입력 오류", true);
        errorDialog.setLayout(new BorderLayout());
        errorDialog.add(new JLabel(message), BorderLayout.CENTER);

        JButton okButton = new JButton("확인");
        okButton.addActionListener(e -> errorDialog.dispose());
        errorDialog.add(okButton, BorderLayout.SOUTH);

        errorDialog.setSize(300, 150);
        errorDialog.setLocationRelativeTo(this);
        errorDialog.setVisible(true);
    }
}
