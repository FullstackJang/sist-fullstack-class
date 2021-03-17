package day1029;
/*
 * continue
 * 반복문의 수행을 건너 뛸 때 사용하는 분기문 
 * 
 * */

public class UseContinue {

	public static void main(String[] args) {

		for(int i = 1; i < 101; i++) {
			if(i%2== 1) {
				continue;
			}
			System.out.println(i + " ");
		}//end for
	}//main
}//class
