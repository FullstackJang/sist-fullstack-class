package day1030;

/*
 *		입력된 값으로만 업무를 처리하는 static method 사용 
 */
public class UseStaticMethod {
	
	/**
	 * 입력되는 수의 절대값을 구하는 일
	 * @param param 입력되는 수
	 * @return 절대값
	 */
	public static int abs(int param) {
		return param < 0 ? -param : param;
	}//abs

	public static void main(String[] args) {
		//static method는 객체화 없이 호출
		
		int num = 30;
		int resultValue = UseStaticMethod.abs(num);
		
		System.out.println(num + "의 절대값: " + resultValue );
		
	}//main
}//class
