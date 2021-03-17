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
public class UseRuntimeException {
	public static void main(String[] args) {
		
		int num1 = 0;
		int num2 = 0;
		int result = 0;
		
		try {
		num1 = Integer.parseInt(args[0]);
		num2 = Integer.parseInt(args[1]);
		
		result = num1 / num2;
		
		System.out.println(num1 + "/" + num2 + "=" + result);
		//상속관계가 아닌 것에서는 무엇을 먼저 써도 상관 없다.
		}catch(ArrayIndexOutOfBoundsException aioobe/*JVM이 객체생성해줌*/) {
			System.out.println("프로그램을 실행 할때 값은 2개를 넣어서 실행하셔야 합니다.");
			System.out.println("사용법 형식) java day1127.UseRunctimeException 값1 값2");
		}catch(NumberFormatException nfe) {
			System.out.println("값은 정수만 입력해주세요.");
		}catch(ArithmeticException ae){
			System.out.println("0으로 나눌수 없습니다.");
		}catch(Exception e) { // 마지막엔 최상위 부모인 Exception으로 처리해준다.
			System.out.println("개발자가 인식하지 못하는 예외를 처리하기 위한 최상위 예외클래스");
		}finally {
			System.out.println("반드시 실행되어야할 코드");
		}//end finally
		
	}// main
}// class
