package day1030;


/*
 * instance ������ �ڵ��ʱ�ȭ ��
 * 
 * 
 * */

public class instanceVarialbeDefaultValue {
	//�⺻�� ���������� �ʱ�ȭ ��
	int i; //������ 0 (byte,short, int, long)
	char c; //������ \u0000
	float f; //�Ǽ��� 0.0 (float, double)
	boolean b; //�Ҹ��� false
	
	//������ ��������(array,String,class)�� �ʱ�ȭ �� : null
	int[] arr;
	String str;
	AccessModifier am; //class (������� ��� Ŭ����) 

	public static void main(String[] args) {
		//1. ��üȭ
		instanceVarialbeDefaultValue ivdv = new instanceVarialbeDefaultValue();
		//2. ��ü������ ���� ���
		System.out.println("������: " + ivdv.i);
		System.out.println("������:" + ivdv.c); // \u0000�� �ش��ϴ� ���ڰ� ���� ������ ��°���� ���� ������ �ʴ´�.
		System.out.println("�Ǽ���: " + ivdv.f);
		System.out.println("�Ҹ���: " + ivdv.b);
		
		System.out.println("������ �迭: " + ivdv.arr);
		System.out.println("������ ���ڿ�: " + ivdv.str);
		System.out.println("������ class: " + ivdv.am);
	}//main
}//class
