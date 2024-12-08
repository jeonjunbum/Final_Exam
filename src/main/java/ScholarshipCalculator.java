import javax.swing.*;
import java.text.DecimalFormat;

public class ScholarshipCalculator {
    public static final double MAX_GPA = 4.5; // 최대 평점
    private static final double REQUIRED_GPA = 3.1; // 필수 평점
    private static final int[] CREDIT_REQUIREMENTS = {15, 14, 9}; // 각 학년의 최소 학점 필요 요건
    private static final int TUITION_FEE = 4104000; // 등록금 전액

    public static boolean isEligibleForScholarship(int grade, int creditsEarned, double gpa) {
        return creditsEarned >= CREDIT_REQUIREMENTS[grade - 1] && gpa >= REQUIRED_GPA;
    }

    public static double calculateScholarship(double gpa, int rank) {
        if (gpa >= 3.5 && rank == 1) {
            return TUITION_FEE; // 최우수 장학금 (전액 지급)
        } else if (gpa >= 3.5) {
            return TUITION_FEE * 2 / 3; // 성적우수1 (수업료의 2/3)
        } else if (gpa >= 3.1) {
            return TUITION_FEE / 3; // 성적우수2 (수업료의 1/3)
        }
        return 0; // 장학금 지급 없음
    }

    public static String determineScholarshipType(double gpa) {
        if (gpa >= 3.8) {
            return "최우수 장학금";
        } else if (gpa >= 3.5) {
            return "성적우수1";
        } else if (gpa >= 3.1) {
            return "성적우수2";
        }
        return "없음"; // 장학금 지급 없음
    }

    public static String formatAmount(double amount) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(amount);
    }
}