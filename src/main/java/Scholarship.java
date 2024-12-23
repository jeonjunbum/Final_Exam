import javax.swing.*;

/**
 * 장학금 찾기 프로그램의 메인 클래스를 정의합니다.
 * 이 클래스는 프로그램 실행의 시작점을 제공합니다.
 *
 * 변경(커밋) 내역:
 *
 * - 2024년 12월 24일:
 *   - 각 클래스들의 인스턴스를 생성자에서 받아 사용
 *   - 클래스 상속 되도록 수정
 *   - 학생수를 %로 나누었을 때 소수점 산출 오류 수정
 *
 * - 2024년 12월 23일:
 *   - 시작화면, Frame화면 아이콘 이미지 추가
 *   - 청주대 로고 파일 추가 및 가이드 정렬
 *   - resources 파일에 청주대 로고 이미지 삽입
 *   - 시작 버튼 색상 및 글자 색상 변경
 *   - 시작 화면 클래스 추가
 *
 * - 2024년 12월 21일:
 *   - 예외처리 부분 수정
 *   - 전체 학생 수에 대한 %로 계산 로직 추가
 *   - 예외처리 부분 클래스 생성
 *   - 취득한 학점 및 신청 평점 기준 오류 수정
 *   - 오류 창 생성
 *   - 버튼 배경 색상 및 글자 색상 추가
 *
 * - 2024년 12월 8일:
 *   - 장학금 신청 요건 파일 읽기 기능 클래스 추가
 *   - 등록금 기준 계산 기능 추가
 *
 * - 2024년 12월 6일:
 *   - 프로그램 시작 시 자동으로 장학금 요건 표시를 위한 코드 작성
 *   - 장학금 찾기 시스템 UI 및 텍스트 파일 개발
 *
 * - 2024년 11월 22일:
 *   - 프로젝트 시작
 *
 * @author jeonjunbum
 * @version 1.0
 */
public class Scholarship {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ScholarshipFrame(new ScholarshipCalculator(), new InputValidator(), new ScholarshipRequirementsLoader()).setVisible(true);
        });
    }
}
