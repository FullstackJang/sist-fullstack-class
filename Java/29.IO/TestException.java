package day1130;

/**
 * ����� ���� ����ó�� Ŭ����
 * @author owner
 */

//1. ����ó�� Ŭ������ ���
@SuppressWarnings("serial")
public class TestException extends Exception {

	public TestException() {
		super("���� �߻��� �������� �޽���");
	}//TestException
	
	public TestException(String msg) {
		super(msg);
	}//TestException
}//class