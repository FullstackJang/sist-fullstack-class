/*
 	입력된 점수의 판정 유효성 검증
 	
 	0보다 작았을때, 100보다 컸을 대, 0~100사이일때의 비교 처리 
 */

public class UseElseIf {

	public static void main(String[ ] args) {
		
		int score = Integer.parseInt(args[0]);
		
		System.out.print(score + "점은");
		if(score < 0 ) { // 0보다 작은 경우
			System.out.println("0보다 작아서 실패");
		}
		else if(score > 100) { // 100보다 큰 경우
			System.out.println("100보다 커서 실패");
		} // 
		else {
			System.out.println("유효 점수");
		}// end else
		
		/*
		 	자격시험 점수 score 변수에 들어있다.
		 	자격시험 점수의 판정
		  	과락: 0 ~40
		  	다른 과목점수 참조 : 41 ~ 60 
		  	합격: 61 ~ 100
		 */

		if(score <= 40 && score >= 0) {
			System.out.println("과락");
		}
		else if(score > 40 && score < 61) {
			System.out.println("다른 과목점수 참조");
		}
		else if(score > 60 && score <= 100){
			System.out.println("합격");
		}
		else {
			System.out.println("잘못된 점수 입력");
		}
		
		/*	두번째 arguments를 입력받아 띠를 구하는 다중 if문
			태어난해를 12로 나눈 나머지는 0~11까지의 12개 수로 얻어진다.
			각각의 수에 해당하는 띠는 아래와 같고 띠에 대해 출력하는 코드
			0: 원숭이, 1: 닭, 2: 개, 3: 돼지, 4: 쥐, 5: 소,
			6: 호랑이, 7: 토끼, 8: 용, 9: 뱀, 10: 말, 11: 양
		*/
		
		int month = Integer.parseInt(args[1]);
		
		if(month%12 == 0) System.out.println("원숭이");
		else if(month%12 == 1)System.out.println("닭");
	}
}
