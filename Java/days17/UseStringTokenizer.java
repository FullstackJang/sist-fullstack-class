package day1112;

import java.util.StringTokenizer;

/**
 * 문자열을 자를때 사용하는 클래스
 * @author owner
 */
public class UseStringTokenizer {

	public UseStringTokenizer() {
		String str = "ㄴㅂㅂㅂㄸㅇ 오지고 지리고 레잇고,와앙,앙냥냥,항냥냥냥";

		//1. 문자열을 공백으로 구분하는 StringTokenizer의 사용
//		StringTokenizer stk = new StringTokenizer(str);
		
		//값이라는 것이 동적이기 때문에 아래와 같이는 돌리지 않는다.
//		System.out.println("토큰의 수: " + stk.countTokens()); //pointer가 이동하면 토큰의 수가 줄어듬
//		System.out.println("토큰이 존재하는지: " + stk.hasMoreTokens());
//		System.out.println("pointer가 존재하는 위치에 값을 얻고, pointer를 이동: " + stk.nextToken());
//		System.out.println("토큰이 존재하는지: " + stk.hasMoreTokens());
//		System.out.println("토큰의 수: " + stk.countTokens());
//		System.out.println("토큰이 존재하는지: " + stk.hasMoreTokens());
//--------------------------------
		
		//2. 문자열을 특정문자로 구분하여 자르기: StringTokenizer(문자열,"자를기준");
		//기준 문자를 보호하지 않음(버린다.)
//		StringTokenizer stk = new StringTokenizer(str, "고, "); 
		
		//3.문자열을 특정문자로 구분하여 자르기: StringTokenizer(문자열,"자를기준",보호여부);
		StringTokenizer stk = new StringTokenizer(str, "고, ",false); 
		//기준문자를 보호할지에 대한 여부: true- 보호 flase- 비보호
		
		
		//토큰 수를 알 수 없지만 토큰이 없을 때까지 잘라내야한다.
		//시작과 끝을 알 수 없을 때 사용하는 반복문 while 사용
		while(stk.hasMoreTokens()) {
			System.out.println(stk.nextToken()); //값을 가져오고 포인터를 다음위치로 이동\
			System.out.println(stk.countTokens());
		}//end while

		// 포인터는 한번 지나가면 거기서 끝
		// 다시 사용하고 싶으면 객체를 다시 생성해야함
//		while(stk.hasMoreTokens()) {
//			System.out.println(stk.nextToken()); //값을 가져오고 포인터를 다음위치로 이동\
//			System.out.println(stk.countTokens());
//		}//end while
		
		
	}//UseStringTokenizer
	
	public static void main(String[] args) {
		new UseStringTokenizer();
	}//main
}//class
