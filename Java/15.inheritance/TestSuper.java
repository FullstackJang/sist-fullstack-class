package day1110;

/**
 * �θ�Ŭ����: �ڽ�Ŭ�������� ����ؾ� �� ���� �ڵ�
 * @author owner
 */
public class TestSuper {
	int i;
	int j;
	
	public TestSuper() {
//		super();
		System.out.println("TestSuper �⺻������(�θ�)");
	}//TestSuper

	public TestSuper(int i) {
		this();
		System.out.println("TestSuper �Ű����� �ִ� ������(�θ�)");
	}//TestSuper


	public void print() {
		System.out.println("�θ�:i=" + i + ", j=" + j );
	}
}//class
