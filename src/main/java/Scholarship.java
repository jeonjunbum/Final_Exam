import javax.swing.*;

public class Scholarship {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ScholarshipFrame(new ScholarshipCalculator(), new InputValidator(), new ScholarshipRequirementsLoader()).setVisible(true);
        });
    }
}
