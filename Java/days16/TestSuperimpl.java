package day1111;

/**
 * �������̽��� ������ Ŭ����
 * Ŭ�������� �ʿ��� ��� �������̽��� ������ �� ����
 * ����
 * ���������� class Ŭ������ implements �������̽���,,,,{ }
 * 
 * @author owner
 *
 */
public class TestSuperimpl implements TestSuper {

	@Override
	public void methodA() {
		System.out.println("Override�� methodA ȣ��");
	}//methodA

	@Override
	public void methodB() {
		System.out.println("Override�� methodB ȣ��");
	}//methodB

	@Override
	public String name() {

		return "���ϱ�";
	}//name

	public void subMethod() {
		System.out.println("�ڽ��� method");
	}//subMethod

	public static void main(String[] args) {
		//�������̽��� ��üȭ�� ���� ����
		//TestSuperimpl ts = new TestSuper(); //�����ڰ� ��� ��üȭ�� �Ұ�

		//�������̽��� ������ Ŭ������ ���� �ִ� ��ü �ּҸ� ������ �� ����(is-a������ ��üȭ)
		//ts��ü�� ȣ�� ������ ��: �θ��� ���� ����, �θ��� method(abstract method)=>Override�� method ȣ��
		// �θ� �ڽ��� ����Ű�� ����
		TestSuper ts = new TestSuperimpl();
		ts.methodA();
		ts.methodB();
		//ts.subMethod(); // is-a������ ��üȭ�� �ϸ� �ڽ��� �ڿ�(����,method)�� ����� �� ����. ��, �θ�� �ڽ��� ����ų �� ������ �ڽ��� ���ϴ��� ��
		System.out.println(ts.name());
		System.out.println(ts);// �θ� �ּҰ� �ƴ� �ڽĿ� �ּҰ� �������ϳ� �θ� �ּҰ� ����. TestSuperimpl@7bfcd12c

	}
}