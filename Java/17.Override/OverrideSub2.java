package day1110;

/**
 * OverrideSuper�� �ڽ�Ŭ����<br>
 * �ڽ�Ŭ���������� �θ�Ŭ������ �� �� ����<br>
 * �ڽ�Ŭ������ ��üȭ�Ǹ�, �θ� Ŭ������ ���� �����ǰ� �� �� �ڽ�Ŭ������ ������(�θ��� ��� ����� ����� �� ����)
 * @author owner
 *
 */
public class OverrideSub2 extends OverrideSuper {
	/**
	 * Override�� method
	 * Override��Ģ : ���������ڴ� �޶� �ǰ�, ��ȯ��, method��, �Ű������� ���ƾ��Ѵ�.
	 */
	@Override
	public void methodA() {
		System.out.println("OverrideSub2Ŭ�������� Override�� methodA");
	}//methodA

	/**
	 * Override�� method
	 */
	@Override
	public void methodB() {
		System.out.println("OverrideSub2Ŭ�������� Override�� methodB");
	}//methodB

	public void childMethod() { // IS-a������ ��üȭ�� �Ǿ��� ������ ����� �� ����
		System.out.println("�ڽ� method");
	}

}