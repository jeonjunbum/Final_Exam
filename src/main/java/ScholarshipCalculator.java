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

    // 소수점을 버리고 일의 자리를 올리는 메서드
    private static int calculateAdjustedRank(double rankPercentage) {
        return (int) Math.floor(rankPercentage) + 1; // 소수점 버리고 1 증가
    }

    public static double calculateScholarship(double gpa, int rank, int totalStudents) throws IllegalArgumentException {
        double scholarshipAmount = 0;

        // GPA가 4.5인 경우에는 반드시 1등이어야 함
        if (gpa == 4.5 && rank != 1) {
            throw new IllegalArgumentException("GPA가 4.5인 경우 1등이어야 합니다.");
        }

        // 장학금 계산
        if (rank == 1 && gpa >= 3.5) {
            scholarshipAmount = TUITION_FEE; // 최우수 장학금 (1등에게 전액 지급)
        } else if (gpa >= 3.5 && rank <= calculateAdjustedRank(totalStudents * 0.02)) {
            scholarshipAmount = TUITION_FEE * 2 / 3; // 성적우수1 (수업료의 2/3)
        } else if (gpa >= 3.1 && rank <= calculateAdjustedRank(totalStudents * 0.10)) {
            scholarshipAmount = TUITION_FEE / 3; // 성적우수2 (수업료의 1/3)
        } else if (gpa >= 3.0 && rank <= calculateAdjustedRank(totalStudents * 0.12)) {
            scholarshipAmount = TUITION_FEE / 5; // 성적우수3 (수업료의 1/5)
        }

        return scholarshipAmount; // 장학금 지급액 반환
    }

    public static String determineScholarshipType(double gpa, int rank, int totalStudents) {
        if (rank == 1 && gpa >= 3.5) {
            return "최우수 장학금"; // GPA가 3.5 이상이고 1등일 경우 최우수 장학금
        } else if (gpa >= 3.5 && rank <= calculateAdjustedRank(totalStudents * 0.02)) {
            return "성적우수1"; // 성적우수1
        } else if (gpa >= 3.1 && rank <= calculateAdjustedRank(totalStudents * 0.10)) {
            return "성적우수2"; // 성적우수2
        } else if (gpa >= 3.0 && rank <= calculateAdjustedRank(totalStudents * 0.12)) {
            return "성적우수3"; // 성적우수3
        }
        return "없음"; // 장학금 지급 없음
    }

    public static String formatAmount(double amount) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(amount);
    }

    public static double calculateFinalScholarship(double gpa, int rank, int totalStudents) {
        double scholarshipAmount = calculateScholarship(gpa, rank, totalStudents);
        String scholarshipType = determineScholarshipType(gpa, rank, totalStudents);

        // 장학금 중복 지급 방지: 가장 높은 장학금만 지급
        if (scholarshipAmount > 0) {
            return scholarshipAmount; // 장학금 지급액 반환
        }
        return 0; // 지급할 장학금이 없을 경우
    }
}
