package day1103;

public class TestConstructor {

	/**
	 * �⺻������
	 */
	public TestConstructor() {
		System.out.println("�⺻ ������");
	}

	/**
	 * �������� Overload : �����ڸ� ������ ���� �� �����Ƿ�
	 * ��üȭ�� �پ��ϰ� �� �� �ִ�.
	 * @param i
	 */
	public TestConstructor(int i) {
		System.out.println("�Ű����� �ִ� ������");
//		TestConstructor(); //�����ڴ� ���� ȣ�� �� �� ����.
//		method(); // method�� ���� ȣ��
	}


	public void method() {
		System.out.println("�Ϲ�method");
	}

	public static void main(String[] args) {
		new TestConstructor(20); //�����ڸ� ȣ���ϸ� ��ü�� �ϳ� �����ȴ�.
	}//main
}//class
