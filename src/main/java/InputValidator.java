/**
 * 장학금 신청을 위한 입력값 검증 클래스를 정의합니다.
 * 이 클래스는 사용자 입력값의 유효성을 검증하는 메서드를 제공합니다.
 */
public class InputValidator {

    /**
     * 학년을 검증합니다.
     *
     * @param grade 학년 (1-4)
     * @throws IllegalArgumentException 유효하지 않은 학년일 경우
     */
    public static void validateGrade(int grade) {
        if (grade < 1 || grade > 4) {
            throw new IllegalArgumentException("학년은 1에서 4 사이여야 합니다.");
        }
    }

    /**
     * 전체 학생 수를 검증합니다.
     *
     * @param totalStudents 전체 학생 수 (1 이상)
     * @throws IllegalArgumentException 유효하지 않은 학생 수일 경우
     */
    public static void validateTotalStudents(int totalStudents) {
        if (totalStudents <= 0) {
            throw new IllegalArgumentException("학년 전체 인원은 1 이상이어야 합니다.");
        }
    }

    /**
     * 학생의 등수를 검증합니다.
     *
     * @param rank 학생의 등수 (1 이상)
     * @param totalStudents 전체 학생 수 (1 이상)
     * @throws IllegalArgumentException 유효하지 않은 등수일 경우
     */
    public static void validateRank(int rank, int totalStudents) {
        if (rank <= 0 || rank > totalStudents) {
            throw new IllegalArgumentException("등수는 1 이상 " + totalStudents + " 이하이어야 합니다.");
        }
    }

    /**
     * 취득한 학점을 검증합니다.
     *
     * @param creditsEarned 취득한 학점 (0 이상)
     * @throws IllegalArgumentException 유효하지 않은 학점일 경우
     */
    public static void validateCredits(double creditsEarned) {
        if (creditsEarned < 0) {
            throw new IllegalArgumentException("취득한 학점은 0 이상이어야 합니다.");
        }
        if (creditsEarned > 30) {
            throw new IllegalArgumentException("취득한 학점은 최대 30학점이어야 합니다.");
        }
    }
    /**
     * 신청 평점을 검증합니다.
     *
     * @param gpa 신청 평점 (0.0 - MAX_GPA)
     * @throws IllegalArgumentException 유효하지 않은 평점일 경우
     */
    public static void validateGPA(double gpa) {
        if (gpa < 0 || gpa > ScholarshipCalculator.MAX_GPA) {
            throw new IllegalArgumentException("신청 평점은 0.0에서 " + ScholarshipCalculator.MAX_GPA + " 사이여야 합니다.");
        }
    }
}
