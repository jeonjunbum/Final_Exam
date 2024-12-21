public class InputValidator {

    public static void validateGrade(int grade) {
        if (grade < 1 || grade > 4) {
            throw new IllegalArgumentException("학년은 1에서 4 사이여야 합니다.");
        }
    }

    public static void validateTotalStudents(int totalStudents) {
        if (totalStudents <= 0) {
            throw new IllegalArgumentException("학년 전체 인원은 1 이상이어야 합니다.");
        }
    }

    public static void validateRank(int rank, int totalStudents) {
        if (rank <= 0 || rank > totalStudents) {
            throw new IllegalArgumentException("등수는 1 이상 " + totalStudents + " 이하이어야 합니다.");
        }
    }

    public static void validateCredits(double creditsEarned) {
        if (creditsEarned < 0) {
            throw new IllegalArgumentException("취득한 학점은 0 이상이어야 합니다.");
        }
        if (creditsEarned > 30) {
            throw new IllegalArgumentException("취득한 학점은 최대 30학점이어야 합니다.");
        }
    }

    public static void validateGPA(double gpa) {
        if (gpa < 0 || gpa > ScholarshipCalculator.MAX_GPA) {
            throw new IllegalArgumentException("신청 평점은 0.0에서 " + ScholarshipCalculator.MAX_GPA + " 사이여야 합니다.");
        }
    }
}
