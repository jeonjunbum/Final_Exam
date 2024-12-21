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

    public static double calculateScholarship(double gpa, int rank, int totalStudents) {
        double scholarshipAmount = 0;

        if (gpa >= 3.5 && rank == 1) {
            scholarshipAmount = TUITION_FEE; // 최우수 장학금 (1등에게 전액 지급)
        } else if (gpa >= 3.5 && rank <= totalStudents * 0.02) {
            scholarshipAmount = TUITION_FEE * 2 / 3; // 성적우수1 (수업료의 2/3)
        } else if (gpa >= 3.1 && rank <= totalStudents * 0.10) {
            scholarshipAmount = TUITION_FEE / 3; // 성적우수2 (수업료의 1/3)
        } else if (gpa >= 3.0 && rank <= totalStudents * 0.12) {
            scholarshipAmount = TUITION_FEE / 5; // 성적우수3 (수업료의 1/5)
        }

        return scholarshipAmount; // 장학금 지급액 반환
    }

    public static String determineScholarshipType(double gpa, int rank, int totalStudents) {
        if (gpa >= 3.8) {
            return "최우수 장학금"; // GPA가 3.8 이상일 경우 최우수 장학금
        } else if (gpa >= 3.5 && rank == 1) {
            return "최우수 장학금"; // 1등일 경우 최우수 장학금
        } else if (gpa >= 3.5 && rank <= totalStudents * 0.02) {
            return "성적우수1"; // 성적우수1 추가
        } else if (gpa >= 3.1 && rank <= totalStudents * 0.10) {
            return "성적우수2"; // 성적우수2 추가
        } else if (gpa >= 3.0 && rank <= totalStudents * 0.12) {
            return "성적우수3"; // 성적우수3 추가
        }
        return "없음"; // 장학금 지급 없음
    }

    public static String formatAmount(double amount) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(amount);
    }
}
