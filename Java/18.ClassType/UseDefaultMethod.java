package day1111;

/**
 * interface�ȿ��� ������ ���� �� �� �ִ� default method�� ���
 * interface�� extends�� ����Ͽ� interface���� ���߻���� �� �� ����
 * �ڽ� interface�� �θ�interface�� abstract method�� Override���� ����
 * @author owner
 *
 */
public interface UseDefaultMethod extends SuperA,SuperB{

	public void methodC();
	
	public default void methodDef() {
		System.out.println("�������̽��� �����ϴ� ������ ����");
	}//methodDef
	
	public default String methodDef1() {
		return "��ȯ���� �ִ� default method";
	}//methodDef
	
}
