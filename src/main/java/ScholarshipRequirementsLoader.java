import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 장학금 요건을 파일에서 불러오는 클래스를 정의합니다.
 * 이 클래스는 지정된 파일에서 장학금 신청 요건을 읽어오는 기능을 제공합니다.
 */
public class ScholarshipRequirementsLoader {

    /**
     * 장학금 요건을 불러옵니다.
     *
     * @param filePath 파일 경로
     * @param requirementsArea 요건을 표시할 텍스트 영역
     */
    public static void loadScholarshipRequirements(String filePath, JTextArea requirementsArea) {
        try {
            readScholarshipRequirements(filePath, requirementsArea);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "파일을 읽는 중 오류 발생: " + ex.getMessage(), "오류", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * 파일에서 장학금 요건을 읽어옵니다.
     *
     * @param filePath 파일 경로
     * @param requirementsArea 요건을 표시할 텍스트 영역
     * @throws IOException 파일 읽기 중 오류 발생 시
     */
    private static void readScholarshipRequirements(String filePath, JTextArea requirementsArea) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder requirements = new StringBuilder();
        String line;

        requirements.append("장학금 신청 요건:\n");
        while ((line = reader.readLine()) != null) {
            requirements.append(line).append("\n");// 파일 내용을 읽어 requirements에 추가
        }
        requirementsArea.setText(requirements.toString()); // 텍스트 영역에 요건 표시
        reader.close(); // BufferedReader 닫기
    }
}
