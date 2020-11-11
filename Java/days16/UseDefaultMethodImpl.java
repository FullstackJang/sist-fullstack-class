package day1111;

/**
 * implements�� �������̽��� ������ Ŭ����
 * interface�� ����� �޾Ҵٸ� �θ� interface�� ��� abstract method�� Override�ؾ� ��
 * @author owner
 *
 */
public class UseDefaultMethodImpl implements UseDefaultMethod {

	/**
	 * SuperA �������̽��� �����ϴ� abstract method
	 */
	@Override
	public void methodA() {
		System.out.println("methodA Override");
	}//MethodA
	
	/**
	 * SuperB �������̽��� methodB
	 */
	@Override
	public int methodB(String param) {
		return 11;
	}//methodB
	
	/**
	 * UseDefaultMethod�� �����ϴ� abstract method
	 */
	public void methodC() {
		System.out.println("methodC Override");
	}
	
	
	
	public static void main(String[] args) {
		//is-a ������ ��üȭ �θ� - �ڽ�
		UseDefaultMethod udm = new UseDefaultMethodImpl();
		
		//udm���� ȣ�� ������ method
		//������ interface�� �����ϴ� ��� �߻�method
		//Default method
		
		//ȣ����� ������ �ڽ�Ŭ������ ���� ����ȯ �Ͽ� ȣ��
		//((�ڽ�Ŭ������)��ü��).�θ���method();
		((UseDefaultMethodImpl)udm).methodA();
		
		udm.methodA();
		
		int temp = udm.methodB("�ȳ�");
		System.out.println(temp);
		
		udm.methodC();
		
		
		/////default method
		udm.methodDef();
		System.out.println(udm.methodDef1());
		
		
	}//main
}//class
