package day1029;


/*
		 시작과 끝을 알 수 없을때 사용하는 반복문
		 최소 1번은 실행!! 최대 조건까지 수행
		 do {
		 	반복수행 문장들
		 }while(조건식);
*/

public class UseDoWhile {

	public static void main(String[] args) {

		
		int i = 100; //초기값
		
		do {
			System.out.println("i=" + i); //반복수행 문장
			i++; //증,감소식
		}while(i < 10); // 조건식
		
		//-------------------------------------------------------
		//Solve 1
		//1~100까지의 수 중에 4의 배수의 갯수를 출력
		int cnt = 0; //배수의 갯수
		int sum = 0;
		int j = 1;
		do {
			
			if(j%4 == 0) {
				sum += j; //같은 표현 sum = sum + j;
				cnt++; //같은 표현  ++cnt; // cnt+=1; // cnt= cnt+1;
			}// end if
			j++;
		}while(j <= 100);
		System.out.println("4의 배수의 합:" + sum + " 4의 배수 갯수:" + cnt);
		
		
	}//main
}//class
