import javax.swing.*;
import java.text.DecimalFormat;

/**
 * 장학금 계산 및 자격 검증을 위한 클래스를 정의합니다.
 * 이 클래스는 장학금 수혜 자격을 확인하고, 장학금을 계산하는 메서드를 제공합니다.
 */
public class ScholarshipCalculator {
    public static final double MAX_GPA = 4.5; // 최대 평점
    private static final double REQUIRED_GPA = 3.1; // 필수 평점
    private static final int[] CREDIT_REQUIREMENTS = {15, 14, 9}; // 각 학년의 최소 학점 필요 요건
    private static final int TUITION_FEE = 4104000; // 등록금 전액

    /**
     * 장학금 수혜 자격을 검증합니다.
     *
     * @param grade 학년 (1-4)
     * @param creditsEarned 취득한 학점 (0 이상)
     * @param gpa 신청 평점 (0.0 - MAX_GPA)
     * @return 장학금 수혜 자격 여부 (true: 자격 있음, false: 자격 없음)
     */
    public static boolean isEligibleForScholarship(int grade, int creditsEarned, double gpa) {
        return creditsEarned >= CREDIT_REQUIREMENTS[grade - 1] && gpa >= REQUIRED_GPA;
    }

    // 소수점을 버리고 일의 자리를 올리는 메서드
    private static int calculateAdjustedRank(double rankPercentage) {
        return (int) Math.floor(rankPercentage) + 1; // 소수점 버리고 1 증가
    }

    /**
     * 장학금을 계산합니다.
     *
     * @param gpa 신청 평점 (0.0 - MAX_GPA)
     * @param rank 학생의 등수 (1 이상)
     * @param totalStudents 전체 학생 수 (1 이상)
     * @return 계산된 장학금 지급액 (원 단위)
     */
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

    /**
     * 장학금 종류를 결정합니다.
     *
     * @param gpa 신청 평점 (0.0 - MAX_GPA)
     * @param rank 학생의 등수 (1 이상)
     * @param totalStudents 전체 학생 수 (1 이상)
     * @return 장학금 종류를 나타내는 문자열
     *         - "최우수 장학금": GPA가 3.8 이상
     *         - "최우수 장학금": 1등일 경우
     *         - "성적우수1": GPA가 3.5 이상이고 상위 2%
     *         - "성적우수2": GPA가 3.1 이상이고 상위 10%
     *         - "성적우수3": GPA가 3.0 이상이고 상위 12%
     *         - "없음": 장학금 지급 없음
     */
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

    /**
     * 금액을 포맷팅하여 문자열로 반환합니다.
     *
     * @param amount 금액 (원 단위)
     * @return 포맷된 금액 문자열 (예: "4,104,000")
     */
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
