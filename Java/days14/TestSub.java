package day1109;

/**
 * �ڽ� Ŭ������ �����ϸ�, �θ�Ŭ������ ���� ������
 * @author owner
 *
 */
public class TestSub extends TestSuper{
	
	public TestSub() {
		super();
		System.out.println("�ڽ� Ŭ������ ������");
	}//TestSub
	
	public static void main(String[] args) {
		TestSub ts = new TestSub(); //��ü ����
		
		//�ڵ��� ���뼺: �θ�Ŭ������ ������ method�� �ڽ� Ŭ�������� �ڽ��� �ν��Ͻ��� ����ϴ� ��
		System.out.println("public ����: " + ts.a); //TestSubŬ������ ������ TestSubŬ������ �ִ� �� ó�� ��� ����
		System.out.println("protected����: " + ts.b);
		System.out.println("default����: " + ts.c);//���� ��Ű�� ��밡��, �ٸ� ��Ű�� ���Ұ�

		ts.methodSuper();
		
	}//main
}//class
