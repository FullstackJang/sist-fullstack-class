package day1111;

/**
 * ���� Ŭ������ �ݵ�� �����ؾ��� ���� ��ϸ� ����
 * @author owner
 */

public interface TestSuper {
	
	//�����ڸ� ���� ���ÿ��� ���� �Ҵ�������ϴµ� �����ڰ� ����
	//int i; ������ ���� �� ����.
	public static final int MAX = 999999;
	
//	public TestSuper() { 
//		//�����ڸ� ���� �� ����.
//	}

//	public void test() {
//		//������ ������ �� �ִ� �Ϲ� method�� ���� �� ����
//	}
	
	public void methodA(); //abstract�� ������� ���� abstract method	
	public abstract void methodB(); //abstract�� ��� �� abstract method
	public abstract String name(); //abstract�� ��� �� abstract method
	
	
}//class