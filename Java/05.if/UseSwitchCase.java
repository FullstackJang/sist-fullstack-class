/*
 	switch~case: 일치하는 정수를 비교할 때 사용
 	switch에 입력된 변수의 값과 일치하는 case부터 끝까지 실행
 */

public class UseSwitchCase {
	//Constant: 변수를 상수처럼 사용할 때. (가독성 향상,값변경 불가)
	public static final int GRADE_A_PLUS = 10;
	public static final int GRADE_A = 9;
	public static final int GRADE_B = 8;
	public static final int GRADE_C = 7;
	public static final int GRADE_D = 6;

	public static void main(String[] args) {	

		int i = 1; //비교 가능 타입: byte,short,int,char, String(JDK1.7부터 사용가능)
		//case의 상수는 비교용도이기 때문에 위의 case와 인접상수(0,1,2,3)가 아니어도 된다.
		//가급적이면 인접상수로 case 작성한다. (비교 속도 향상)
		switch(i) {
			case 0: System.out.println("A"); break;
			case 1: System.out.println("B"); break;
			case 2: System.out.println("C"); 
			default: System.out.println("Z"); break;
		}//end switch


		/*
		  입력 점수에 대한 학점 구하기
		  90 ~ 100: A
		  80 ~ 89: B
		  70 ~ 79: C
		  60 ~ 69: D
		   0 ~ 59: F
		 */

		int score = Integer.parseInt(args[0]); // 입력값ㅇ르 정수로 변환하여 변수 할당
		char grade= 'F'; //학점을 저장할 변수
		System.out.println(score + "점");

		System.out.print(score + "점은 ");

		switch(score / 10){ // 99->9, 81->8, 77->7
			case 10:
			case 9: grade = 'A'; break;
			case 8: grade = 'B'; break;
			case 7: grade = 'C'; break;
			case 6: grade = 'D'; break;
			default: grade = 'F';
		} //end switch

		System.out.println(grade+ "학점");	

		System.out.print("------------------------------------------");

			grade= 64; //학점을 저장할 변수
			System.out.println(score + "점");
	
			System.out.print(score + "점은 ");
	
			switch(score / 10){ 
				case 6: grade++; 
				case 7: grade++; 
				case 8: grade++; 
				case 9: 
				case 10: grade++; break;
				default: grade+=6;
			} //end switch
			//A - 65, B - 66, C - 67, D- 68, E - 69, F - 70
			System.out.println(grade+ "학점");	

		System.out.print("------------------------------------------");
			score = Integer.parseInt(args[0]); // 입력값ㅇ르 정수로 변환하여 변수 할당
			grade= 'F'; //학점을 저장할 변수
			System.out.println(score + "점");
	
			System.out.print(score + "점은 ");
			switch(score / 10){ // 99->9, 81->8, 77->7
				case GRADE_A_PLUS:
				case GRADE_A: grade = 'A'; break;
				case GRADE_B: grade = 'B'; break;
				case GRADE_C: grade = 'C'; break;
				case GRADE_D: grade = 'D'; break;
				default: grade = 'F';
	
			} //end switch
	
			System.out.println(grade+ "학점");	
	}//main
}//class
