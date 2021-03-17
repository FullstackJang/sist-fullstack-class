package day1110;

/**
 * ����� ���ؼ� ����� Ŭ����
 * �ڽ�Ŭ������ �ݵ�� �����ؾ��� ���� ����� abstract method�� ������ �� ����.
 * @author owner
 *
 */
public abstract class AbstractSuper {

	public AbstractSuper() {
		System.out.println("�߻�Ŭ������ ������");
	}//AbstractSuper

	public void methodA() { // �ڽ�Ŭ������ ȣ���Ͽ� ����� �� �ִ� method
		System.out.println("�Ϲ� method");
	}//methodA
	
	//abstract method�� ������ �������� ����(�ڽ�Ŭ�������� �ݵ�� Override �ؾ���)
	//method�� body�� ���� abstract method : body�� ��� ���� �� �� ����
	public abstract void methodB();
	public abstract int methodC();
	
	public static void main(String[] args) {
		//new AbstractSuper(); //�߻�Ŭ������ ���� ��üȭ �� �� ����
	}//main

}//class
