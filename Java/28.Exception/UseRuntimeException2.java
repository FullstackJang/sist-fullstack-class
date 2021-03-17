package day1127;

/**
 * RuntimeException 처리
 * 
 * ArrayIndexOutOfBoundsException : 배열, List에 없는 인덱스를 사용할 때
 * NumberFormatException : 문자열을 숫자로 변경할 때, 문자열이 숫자로 변경되지 못하는 형식으로 입력될 때.
 * ArithmeticException : 0으로 나눌 때 발생
 * @author owner
 *
 */
public class UseRuntimeException2 {
	public static void main(String[] args) {
		
		int num1 = 0;
		int num2 = 0;
		int result = 0;
		
	try {
		num1 = Integer.parseInt(args[0]);
	}catch(ArithmeticException aioobe) {
		
	}catch(NumberFormatException nfe) {
	}
	
	try {
		num2 = Integer.parseInt(args[1]);
	}catch(ArithmeticException aioobe) {
		
	}catch(NumberFormatException nfe) {
	}
	
	try {
		result = num1 / num2;
	}catch(ArithmeticException ae) {
		
	}
		System.out.println(num1 + "/" + num2 + "=" + result);
	
	}// main
}// class
