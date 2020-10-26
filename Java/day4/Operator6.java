package a1026;

/*
 	삼항(조건)연산자

	문법) 조건식 ? 항1 : 항2

 */
public class Operator6 {

	public static void main(String[] args) {

		int i = 10;
		// i변수에 존재하는 수가 "양수"인지 "음수"인지를 출력하는 코드
		System.out.println(i + "은(는) " + (i >= 0 ? "양수" : "음수"));

		//i변수에 존재하는 수가 "짝수"인지 "홀수"인지를 출력하는 코드
		System.out.println(i +"은(는) " + (i%2==0 ? "짝수" : "홀수"));
	}
}
