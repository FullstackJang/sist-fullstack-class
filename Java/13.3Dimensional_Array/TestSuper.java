package day1109;

/**
 * �θ� Ŭ����: �ڽ� Ŭ������ �������� ���� Ư¡�� ����
 * (�ڽ�Ŭ������ ���������� ����� ����, method�� ����)
 * @author owner
 */
public class TestSuper {
	public int a;
	protected int b;
	int c; //default, package ���� ������
	private int d;
	
	public TestSuper() {
		System.out.println("�θ�Ŭ������ ������");
	}//TestSuper
	
	public void methodSuper() {
		System.out.println("�θ�Ŭ������ method");
	}//methodSuper
	
}//class