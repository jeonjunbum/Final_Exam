import javax.swing.*;
import java.awt.*;

/**
 * 장학금 찾기 프로그램을 위한 GUI 프레임 클래스입니다.
 * 이 클래스는 사용자가 장학금 요건을 입력하고,
 * 자격을 검증하여 장학금 종류와 지급액을 계산하는 기능을 제공합니다.
 *
 * 프로그램의 주요 기능:
 * - 장학금 요건을 불러오고 표시
 * - 사용자 입력에 기반한 장학금 자격 검증
 * - 장학금 종류 및 지급액 계산
 *
 * @author [jeonjunbum]
 * @version 1.0
 */
public class ScholarshipFrame extends JFrame {

    /** 자동으로 불러올 장학금 요건 파일의 경로 */
    private static final String FILE_PATH = "src/Scholarship.txt";

    /** 장학금 계산을 수행하는 인스턴스 */
    private final ScholarshipCalculator calculator;

    /** 사용자 입력을 검증하는 인스턴스 */
    private final InputValidator validator;

    /** 장학금 요건을 불러오는 인스턴스 */
    private final ScholarshipRequirementsLoader requirementsLoader;

    /**
     * ScholarshipFrame 생성자.
     * 주어진 장학금 계산기, 입력 검증기 및 요건 로더를 초기화하고,
     * GUI 요소를 설정합니다.
     *
     * @param calculator 장학금 계산을 수행하는 인스턴스
     * @param validator 사용자 입력을 검증하는 인스턴스
     * @param requirementsLoader 장학금 요건을 불러오는 인스턴스
     */
    public ScholarshipFrame(ScholarshipCalculator calculator, InputValidator validator, ScholarshipRequirementsLoader requirementsLoader) {
        this.calculator = calculator;
        this.validator = validator;
        this.requirementsLoader = requirementsLoader;

        setTitle("장학금 찾기 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);

        // 프로그램 아이콘 설정
        ImageIcon icon = new ImageIcon("src/main/resources/UniversityLogo.png");
        setIconImage(icon.getImage());

        // 레이아웃 설정
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // 요건 설명 영역 설정
        JTextArea requirementsArea = new JTextArea(10, 30);
        requirementsArea.setEditable(false); // 사용자가 수정할 수 없도록 설정
        JScrollPane scrollPane = new JScrollPane(requirementsArea);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        add(scrollPane, gbc);

        // 장학금 요건 불러오기 버튼 설정
        JButton loadButton = new JButton("장학금 요건 불러오기");
        loadButton.setBackground(new Color(73, 106, 159));
        loadButton.setForeground(Color.WHITE);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        add(loadButton, gbc);

        // 학년 입력 레이블 및 필드
        JLabel gradeLabel = new JLabel("학생의 학년 (1-4):");
        gbc.gridx = 0; // 그리드에서 x축 위치를 0으로 설정 (첫 번째 열)
        gbc.gridy = 2; // 그리드에서 y축 위치를 2로 설정 (세 번째 행)
        add(gradeLabel, gbc); // 레이블을 프레임에 추가

        JTextField gradeField = new JTextField(10); // 10개의 문자 공간을 가진 텍스트 필드 생성
        gbc.gridx = 1; // 그리드에서 x축 위치를 1로 설정 (두 번째 열)
        add(gradeField, gbc); // 텍스트 필드를 프레임에 추가

        // 학년 전체 인원 입력 레이블 및 필드
        JLabel totalStudentsLabel = new JLabel("학년 전체 인원:");
        gbc.gridx = 0; // 그리드에서 x축 위치를 0으로 설정 (첫 번째 열)
        gbc.gridy = 3; // 그리드에서 y축 위치를 3으로 설정 (네 번째 행)
        add(totalStudentsLabel, gbc); // 레이블을 프레임에 추가

        JTextField totalStudentsField = new JTextField(10); // 10개의 문자 공간을 가진 텍스트 필드 생성
        gbc.gridx = 1; // 그리드에서 x축 위치를 1로 설정 (두 번째 열)
        add(totalStudentsField, gbc); // 텍스트 필드를 프레임에 추가

        // 학생의 등수 입력 레이블 및 필드
        JLabel rankLabel = new JLabel("학생의 등수:");
        gbc.gridx = 0; // 그리드에서 x축 위치를 0으로 설정 (첫 번째 열)
        gbc.gridy = 4; // 그리드에서 y축 위치를 4로 설정 (다섯 번째 행)
        add(rankLabel, gbc); // 레이블을 프레임에 추가

        JTextField rankField = new JTextField(10); // 10개의 문자 공간을 가진 텍스트 필드 생성
        gbc.gridx = 1; // 그리드에서 x축 위치를 1로 설정 (두 번째 열)
        add(rankField, gbc); // 텍스트 필드를 프레임에 추가

        // 취득한 학점 입력 레이블 및 필드
        JLabel creditsLabel = new JLabel("취득한 학점:");
        gbc.gridx = 0; // 그리드에서 x축 위치를 0으로 설정 (첫 번째 열)
        gbc.gridy = 5; // 그리드에서 y축 위치를 5로 설정 (여섯 번째 행)
        add(creditsLabel, gbc); // 레이블을 프레임에 추가

        JTextField creditsField = new JTextField(10); // 10개의 문자 공간을 가진 텍스트 필드 생성
        gbc.gridx = 1; // 그리드에서 x축 위치를 1로 설정 (두 번째 열)
        add(creditsField, gbc); // 텍스트 필드를 프레임에 추가

        // 신청 평점 입력 레이블 및 필드
        JLabel gpaLabel = new JLabel("신청 평점 (0.0 - 4.5):");
        gbc.gridx = 0; // 그리드에서 x축 위치를 0으로 설정 (첫 번째 열)
        gbc.gridy = 6; // 그리드에서 y축 위치를 6으로 설정 (일곱 번째 행)
        add(gpaLabel, gbc); // 레이블을 프레임에 추가

        JTextField gpaField = new JTextField(10); // 10개의 문자 공간을 가진 텍스트 필드 생성
        gbc.gridx = 1; // 그리드에서 x축 위치를 1로 설정 (두 번째 열)
        add(gpaField, gbc); // 텍스트 필드를 프레임에 추가

        // 장학금 찾기 버튼 설정
        JButton applyButton = new JButton("장학금 찾기");
        applyButton.setBackground(new Color(73, 106, 159));
        applyButton.setForeground(Color.WHITE);
        gbc.gridx = 0; // 그리드에서 x축 위치를 0으로 설정 (첫 번째 열)
        gbc.gridy = 7; // 그리드에서 y축 위치를 7로 설정 (여덟 번째 행)
        gbc.gridwidth = 2; // 버튼이 두 개의 열을 차지하도록 설정
        add(applyButton, gbc); // 버튼을 프레임에 추가

        // 결과 출력 영역 설정
        JTextArea resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false); // 결과를 수정할 수 없도록 설정
        JScrollPane resultScrollPane = new JScrollPane(resultArea);
        gbc.gridx = 0; // 그리드에서 x축 위치를 0으로 설정 (첫 번째 열)
        gbc.gridy = 8; // 그리드에서 y축 위치를 8로 설정 (아홉 번째 행)
        gbc.gridwidth = 2; // 스크롤 패널이 두 개의 열을 차지하도록 설정
        gbc.fill = GridBagConstraints.BOTH; // 패널이 가용 공간을 모두 차지하도록 설정
        add(resultScrollPane, gbc); // 결과 출력 영역을 프레임에 추가

        // 프로그램 시작 시 자동으로 장학금 요건 불러오기
        requirementsLoader.loadScholarshipRequirements(FILE_PATH, requirementsArea);

        // 장학금 요건 불러오기 버튼에 액션 리스너 추가
        loadButton.addActionListener(e -> requirementsLoader.loadScholarshipRequirements(FILE_PATH, requirementsArea));

        // 장학금 찾기 버튼에 액션 리스너 추가
        applyButton.addActionListener(e -> {
            try {
                // 사용자 입력값을 읽어와서 변수에 저장
                int grade = Integer.parseInt(gradeField.getText());
                int totalStudents = Integer.parseInt(totalStudentsField.getText());
                int rank = Integer.parseInt(rankField.getText());
                double creditsEarned = Double.parseDouble(creditsField.getText());
                double gpa = Double.parseDouble(gpaField.getText());

                // 입력값 검증
                validator.validateGrade(grade); // 학년 검증
                validator.validateTotalStudents(totalStudents); // 전체 인원 검증
                validator.validateRank(rank, totalStudents); // 등수 검증
                validator.validateCredits(creditsEarned); // 취득한 학점 검증
                validator.validateGPA(gpa); // 신청 평점 검증

                // 장학금 자격 검증 및 장학금 계산
                if (calculator.isEligibleForScholarship(grade, (int) creditsEarned, gpa)) {
                    double scholarshipAmount = calculator.calculateScholarship(gpa, rank, totalStudents); // 장학금 지급액 계산
                    String scholarshipType = calculator.determineScholarshipType(gpa, rank, totalStudents); // 장학금 종류 결정
                    resultArea.setText("선발되었습니다! 장학금 종류: " + scholarshipType +
                            "\n지급액: " + calculator.formatAmount(scholarshipAmount) + "원"); // 결과 표시
                } else {
                    showErrorDialog("장학금 수혜 자격이 없습니다."); // 자격이 없을 경우 오류 메시지 표시
                }
            } catch (NumberFormatException ex) {
                showErrorDialog("입력값이 잘못되었습니다. 다시 입력해주세요."); // 숫자 형식 오류 처리
            } catch (IllegalArgumentException ex) {
                showErrorDialog(ex.getMessage()); // 입력값 검증에서 발생한 오류 처리
            }
        });
    }

    /**
     * 오류 메시지를 포함한 대화상자를 표시합니다.
     * 사용자가 입력한 값이 잘못되었을 때 호출됩니다.
     *
     * @param message 오류 메시지
     */
    private void showErrorDialog(String message) {
        JDialog errorDialog = new JDialog(this, "입력 오류", true);
        errorDialog.setLayout(new BorderLayout());
        errorDialog.add(new JLabel(message), BorderLayout.CENTER);

        JButton okButton = new JButton("확인");
        okButton.addActionListener(e -> errorDialog.dispose());
        errorDialog.add(okButton, BorderLayout.SOUTH);

        errorDialog.setSize(300, 150);
        errorDialog.setLocationRelativeTo(this); // 대화상자를 현재 프레임의 중앙에 위치
        errorDialog.setVisible(true); // 대화상자 표시
    }
}
