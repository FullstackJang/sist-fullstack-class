package day1030.sub;
import day1030.AccessModifier;

/*
	�ٸ� ��Ű���� Ŭ�������� �ٸ� Ŭ������ instance���� ���
	public�� ����
*/

public class AccessModifier3 {

	public static void main(String[] args) {

		//1.��üȭ
		AccessModifier am = new AccessModifier();
		//2. ������ ���.
		System.out.println("public : " + am.pub);
//		System.out.println("protected : " + am.pro);
//		System.out.println("private : " + am.pri); // private ��� �Ұ�
//		System.out.println("default:" + am.def);
	}//main
}//class
