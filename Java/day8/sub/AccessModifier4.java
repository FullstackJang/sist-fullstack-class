package day1030.sub;
import day1030.AccessModifier;

/*
 * 	�ٸ� ��Ű���� �ִ� AccessModifier�� ����ؼ� ���������
 * 
 * */

public class AccessModifier4  extends AccessModifier{
	int pub = 1;
	public static void main(String[] args) {

		//1.��üȭ
		AccessModifier4 am4 = new AccessModifier4();
		
		//2. ������ ���.
		System.out.println("public : " + am4.pub);
		System.out.println("protected : " + am4.pro);
//		System.out.println("private : " + am4.pri); // private ��� �Ұ�
//		System.out.println("default:" + am4.def); // default ��� �Ұ�
	}//main
}//class
