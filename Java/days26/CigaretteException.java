package day1130;

@SuppressWarnings("serial")
public class CigaretteException extends Exception {

	/**
	 * �Ϲ����� �ݿ��� ������ �޽���
	 */
	public CigaretteException() {
		super("����ģ ���� �ﰡ�սô�.");
	}// CigaretteException
	
	/**
	 * ��Ȳ�� �´� �ݿ��� �޽���
	 * @param msg
	 */
	public CigaretteException(String msg) {
		super(msg);
	}//CigartteException
	
}//class
