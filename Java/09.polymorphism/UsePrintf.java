package day1102;

/*
 * JDK1.5예써 뿌터 찌원뙤는 Variable Arguments를 사용한 method
 * 
 * */
public class UsePrintf {
	
	public static void main(String[] args) {
		
		int age = 25;
		int year = 2020;
		
		//정수의 출력 : %d사용
		System.out.printf("%d살 올해는%d년\n",age,year);
		
		//문자의 출력
		System.out.printf("%c %c\n", 'A', '가');
		
		//실수의 출력
		System.out.printf("%f %f\n", 2020.1102, 2020.1102);
		
		//문자열의 출력
		System.out.printf("%s %s\n","오늘은","월요일");
		
		//자릿수의 설정, -양수: 오른쪽정렬, -음수: 왼쪽정렬
		System.out.printf("[%4d][%-5d]\n",11,11);
		System.out.printf("[%8.1f][%-8.1f]\n",12.345,12.456);
		
		// printf와format사용하는것은 같다.
		System.out.format("[%4d][%-5d]\n",11,11);
		System.out.format("[%8.1f][%-8.1f]\n",12.345,12.456);
	
	}//main
}//class
