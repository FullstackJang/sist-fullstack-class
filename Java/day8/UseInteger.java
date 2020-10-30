package day1030;

/*	
 * 		Integer class���� �����ϴ� instance method�� static method�� ���
 * 		-instance method�� ��ü�� instance ������ ���� ����Ͽ� ����ó���ϴ� method
 * 		-static method�� �Էµ� �����θ� ����ó���ϴ� method
 * 
 * */
public class UseInteger {

	public static void main(String[] args) {
			
		//��üȭ: Ŭ������ ��ü�� = new Ŭ������();
		// Integer�� �Ʒ� ó�� ���°� ���������� �����ڸ� ������ʾƼ�.. �ϴ� ��üȭ		
		Integer i = new Integer(30);
//		byte b =i; ������ Ÿ���� �⺻�� Ÿ�Կ� ���� ������. Ÿ���� �ٸ�
		System.out.println("��ü i�� ������: " + i);
		
		// i��ü�� �����ϰ� �ִ� instance ������ ���� instance method�� ����Ͽ�
		// byte���� ������ ��ȯ �޾Ҵ�.
		byte b = i.byteValue();
		System.out.println("byte�� ���� ��: " + b);
		
		double d = i.doubleValue();
		System.out.println("double�� ���� ��: " + d);
		
		//static method�� ��ü�� ���� ���� �ƴ� �Էµ� �����θ� �Ͻ����� ����ó���� �ϴ� method
		Integer.parseInt("2020");
		
		//static method�� ��ü������ ȣ������ �ʴ´�.
		//i.parseInt("2020"); The static method parseInt(String) from the type Integer should be accessed in a static way
		
		
	}//main
}//class

