package day1127;

/**
 * RuntimeException ó��
 * 
 * ArrayIndexOutOfBoundsException : �迭, List�� ���� �ε����� ����� ��
 * NumberFormatException : ���ڿ��� ���ڷ� ������ ��, ���ڿ��� ���ڷ� ������� ���ϴ� �������� �Էµ� ��.
 * ArithmeticException : 0���� ���� �� �߻�
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
