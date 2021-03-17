package day1029;

/*
 *  시작과 끝을 ㅇ라 수 없을 때 사용하는 반복문
 *  while : 최소 0번 수행 최대 조건까지 수행
 */

public class UseWhile {
	public static void main(String[] args) {
		int i = 10; // 초기값
		
		while(i < 10) { //조건식
			System.out.println("i = " + i);//반복 수행 문장
			i++; // 증,감소식
		}//end while
		
		//------------------------------------------
		
		//while을 사용하여 구구단 5단 출력
		int j = 1, dan = 5;
		while(j < 10) {
			System.out.println(dan + "*" + j + "=" + dan*j);
			j++;
		}
		
		//------------------------------------------
		//100d에서 부터 0까지 1씩 감소하는 코드
		
		int k = 100;
		
		while(k >= 0) {
			System.out.println(k);
			k--;
		}
		
		
		
		
		
		
		
		
	}//main
}//class
