package day1104;

/**
 * this�� method����<br>
 * ���� ) this(��,,,);
 * �����ڿ��� �ٸ� �����ڸ� ȣ�� �� ��
 * @author owner
 *
 */
public class UseThis {

	/**
	 * �⺻������: new UseThis();
	 */
	public UseThis() {
		this(11);
		System.out.println("�⺻������:Default Constructor");
	}//UseThis

	/**
	 * �����ε��� ������ : new UseThis(�����ǰ�);
	 * @param tmep
	 */
	public UseThis(int tmep) {
		//this(); // �������� ù��° �ٿ����� ��� ����
		System.out.println("�Ű����� �ִ� ������:Overload Constructor");
	}//UseThis

	public static void main(String[] args) {

		new UseThis();

	}//main
}//class
