package day1030;

/*
 *		�Էµ� �����θ� ������ ó���ϴ� static method ��� 
 */
public class UseStaticMethod {
	
	/**
	 * �ԷµǴ� ���� ���밪�� ���ϴ� ��
	 * @param param �ԷµǴ� ��
	 * @return ���밪
	 */
	public static int abs(int param) {
		return param < 0 ? -param : param;
	}//abs

	public static void main(String[] args) {
		//static method�� ��üȭ ���� ȣ��
		
		int num = 30;
		int resultValue = UseStaticMethod.abs(num);
		
		System.out.println(num + "�� ���밪: " + resultValue );
		
	}//main
}//class
