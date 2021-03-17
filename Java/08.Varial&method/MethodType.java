package day1030;
/*
 * method�� 4���� ����
 * 
*/


public class MethodType {

	/**
	 * ��ȯ�� ���� �Ű����� ���� ��: ���� ��
	 */
	public void typeA() {
		System.out.println("typeA: ���� ��");
	}//typeA
	
	/**
	 * ��ȯ�� ����, �Ű����� �ִ� ��: ���� ��
	 * @param i �Է� ��
	 */
	public void typeB(int i) {
		System.out.println("���� ��: " + i);
	}//typeB
	
	/**
	 * ��ȯ���ְ�, �Ű����� ���� ��: ���� ��
	 * @return ���� ��
	 */
	public int typeC() {
		
		return 30;
	}//typeC
	
	/**
	 * 
	 * ��ȯ�� �ְ�, �Ű����� �ִ� �� - ���� ��
	 * @return
	 */
	public int typeD(char c) {
		
		return (int)c;
	}//typeD
	
	
	public static void main(String[] args) {
	
		//��üȭ:
		MethodType mt = new MethodType();
		mt.typeA();
		
		mt.typeB(10);
		mt.typeB(20);
		mt.typeB(30);
		
		int today = mt.typeC();
		System.out.println(today);
		
		
		int code = mt.typeD('A');
		System.out.println(code);
	}//main
}//class
