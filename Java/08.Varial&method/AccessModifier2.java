package day1030;

/*
	���� ��Ű���� Ŭ�������� �ٸ� Ŭ������ instance���� ���
*/

public class AccessModifier2 {

	public static void main(String[] args) {

		//1.��üȭ
		AccessModifier am = new AccessModifier();
		//2. ������ ���.
		System.out.println("public : " + am.pub);
		System.out.println("protected : " + am.pro);
//		System.out.println("protected : " + am.pri); // private ��� �Ұ�
		System.out.println("default:" + am.def);
	}//main
}//class
