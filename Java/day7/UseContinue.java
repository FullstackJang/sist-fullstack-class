package day1029;
/*
 * continue
 * �ݺ����� ������ �ǳ� �� �� ����ϴ� �б⹮ 
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
