import javax.swing.*;

public class Scholarship {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ScholarshipFrame frame = new ScholarshipFrame();
            frame.setVisible(true);
        });
    }
}