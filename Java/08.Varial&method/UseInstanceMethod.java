package day1030;
/*
 * instance ������ ����Ͽ� ������ ó���� �� �ַ� ����� instance method�� ��� ��
 * 
 */

public class UseInstanceMethod {
	int year = 2020;
	
	/**
	 * �¾ �⵵�� �Է¹޾� ���̸� �����ϴ� ����<br>
	 * ����� : ���� - �¾ �� + 1<br>
	 * ���ش� 2020������ instance variable�� ����Ǿ� �ִ�.
	 * @param birth �¾��
	 * @return ����� ����
	 */
	public int getAge(int birth) {
		return year-birth+1;
	}//getAge
	
	public static void main(String[] args) {
		
		
//		getAge(1993); //static ������ instance �������� ���� ȣ��Ǳ� ������
		// instance ������ ������method�� ���� ȣ���� �� ����.
		
		//1. ��üȭ: static �������� instance ������ �ڿ�(����,method)�� ����ϱ� ����
		UseInstanceMethod uim = new UseInstanceMethod();
		
		//2. methodȣ��(��ü�� ���� ����Ͽ� ������ ó���Ѵ�.)
		int birthYear=1993;
		int age = uim.getAge(birthYear); //instance method ȣ��
		
		System.out.println(birthYear + "�� ���� " + age + "��");
	
	}//main
}//class
