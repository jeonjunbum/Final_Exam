import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ScholarshipRequirementsLoader {
    public static void loadScholarshipRequirements(String filePath, JTextArea requirementsArea) {
        try {
            readScholarshipRequirements(filePath, requirementsArea);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "파일을 읽는 중 오류 발생: " + ex.getMessage(), "오류", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void readScholarshipRequirements(String filePath, JTextArea requirementsArea) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder requirements = new StringBuilder();
        String line;

        requirements.append("장학금 신청 요건:\n");
        while ((line = reader.readLine()) != null) {
            requirements.append(line).append("\n");
        }
        requirementsArea.setText(requirements.toString());
        reader.close();
    }
}
