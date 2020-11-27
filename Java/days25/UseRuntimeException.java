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
		//��Ӱ��谡 �ƴ� �Ϳ����� ������ ���� �ᵵ ��� ����.
		}catch(ArrayIndexOutOfBoundsException aioobe/*JVM�� ��ü��������*/) {
			System.out.println("���α׷��� ���� �Ҷ� ���� 2���� �־ �����ϼž� �մϴ�.");
			System.out.println("���� ����) java day1127.UseRunctimeException ��1 ��2");
		}catch(NumberFormatException nfe) {
			System.out.println("���� ������ �Է����ּ���.");
		}catch(ArithmeticException ae){
			System.out.println("0���� ������ �����ϴ�.");
		}catch(Exception e) { // �������� �ֻ��� �θ��� Exception���� ó�����ش�.
			System.out.println("�����ڰ� �ν����� ���ϴ� ���ܸ� ó���ϱ� ���� �ֻ��� ����Ŭ����");
		}finally {
			System.out.println("�ݵ�� ����Ǿ���� �ڵ�");
		}//end finally
		
	}// main
}// class
