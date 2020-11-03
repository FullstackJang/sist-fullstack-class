package day1103;

/**
 * ����� �߻�ȭ �Ͽ� ����� Ŭ���� <br>
 * ����� ������� Ư¡: ��, �� ��, �̸�<br>
 * ����� �������� Ư¡: �Դ���<br>
 * �Ϲ�Ŭ�����̰� ��üȭ�� �Ͽ� ���<br>
 * ��üȭ ����: Person ��ü�� = new Person();
 * @author owner
 *
 */
public class Person {
	
	private int eye; //��
	private int nose; //��
	private int mouth; //��
	private String name; //�̸�
	
	/**
	 * ��� Ŭ������ �⺻ ������
	 * �� 2��, �� 1��, �� 1���� �����Ǵ� ��� ��ü�� ������ �� ���
	 */
	public Person() {
		eye = 2;
		nose = 1;
		mouth = 1;
	}//Person
	
	
	/**
	 *  �Ű����� �ִ� ������(�������� Overload)<br>
	 *  ��, ��, ���� ����ڰ� �����Ͽ� ��ü�� ���� 
	 * 
	 * @param eye ��
	 * @param nose ��
	 * @param mouth ��
	 */
	public Person(int eye, int nose, int mouth) {
		this.eye = eye;
		this.eye = nose;
		this.mouth = mouth;
	}//Person
	
	
	/**
	 * ������ �����ü�� ���� ������ �����ϴ� ��
	 * @param eye ���� ����
	 */
	public void setEye(int eye) {
		this.eye = eye;
	}//setEye
	
	/**
	 * ������ �����ü�� ������ ���� ������ ��ȯ �ϴ� ��
	 * @return
	 */
	public int getEye() {
		return eye;
	}//getEye
	
	/**
	 * ������ �����ü ���� ������ �����ϴ� ��
	 * @param nose ������ ���� ����
	 */
	public void setNose(int nose) {
		this.nose = nose;
	}//setNose
	
	/**
	 * ������ ����� �����Ǿ� �ִ� ���� ������ ��ȯ �ϴ� ��
	 * @return
	 */
	public int getNose() {
		return nose;
	}//getNose
	
	/**
	 * �����ü�� ���� �����ϴ���
	 * @param mouth ������ ���� ����
	 * @return
	 */
	public void setMouth(int mouth) {
		this.mouth = mouth;
	}//setMouth
	
	/**
	 * ������ ��� ��ü�� ���� ������ ��ȯ �ϴ� ��
	 * @return ���� ��
	 */
	public int getMouth() {
		return mouth;
	}//getMouth

	/**
	 * ������ ��� ��ü�� �̸��� �����ϴ� ��
	 * @param name ������ �̸�
	 */
	public void setName(String name) {
		this.name = name;
	}//setNmae
	
	/**
	 * ������ �����ü�� �����Ǿ��ִ� �̸��� ��ȯ �ϴ� ��
	 * @return �̸�
	 */
	public String getName() {
		return name;
	}//getName
	
	
	//-- ������ Ư¡
	
	/**
	 * ��� ��ü�� �������� Ư¡
	 * �����ü�� ������ ���� �Դ� �� ����
	 * @return ��Դ� �ൿ
	 */
	public String eat() {
		return name + "��(��) ���ּ� ���� �Դ´�."; 
	}//eat
	
	/**
	 * method overload: ���� �̸��� method�� ������ ����� ��
	 * ��� ��ü�� �ۿ��� ���� ��Դ� ��
	 * @param menu ���� ����
	 * @param price ���� ����
	 * @return �Ĵ翡�� ��Դ� ��
	 */
	public String eat(String menu, int price) { //�����ε�
		return name + "��(��) �Ĵ翡�� " + menu + "�� ������ "+ price +"�� ���� ��Խ��ϴ�."; 
	}//eat
	
}//class
