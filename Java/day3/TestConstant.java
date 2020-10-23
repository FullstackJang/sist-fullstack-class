/*
 	프로그램 작성에 기준 값이 필요하다면 Constant를 만들어 사용한다.
 	public static final 데이터형 상수명 = 값;의 문법으로 사용한다.
 	
 */

// class field : 상수 선언
public class TestConstant {
	
	//상수 선언
	public static final int MAX_SCORE = 100;
	public static final int MIN_SCORE = 0;
	
	public static void main(String[ ] args) {		
		// 상수는 값할당을 할 수 없다.
		
		System.out.println("최고 점수: " + MAX_SCORE);
		System.out.println("최하 점수: " + TestConstant.MIN_SCORE);
		
		int myScore = 89;
		
		myScore = 87;
		System.out.println("획득 점수: " + myScore);
		System.out.println("최고 점수(" + TestConstant.MAX_SCORE+ "점)에서 획득점수 (" + myScore + ")점 을 뺀 점수는 " + (TestConstant.MAX_SCORE - myScore)+ "점 입니다.");

	}
}
