package day1102;

/**
 * ��ī���� ������� �����Ͽ� ���۵� Ŭ����<br>
 * �߻�ȭ�۾�: -������� Ư¡: �Ѳ�, ��ü, ��
 * 			-�������� Ư¡: ����.
 * @author owner
 *
 */
public class Marker { 

	private int cap,body; //private ���������ڴ� Ŭ���� �ܺο��� ���� ���� �Ұ���.
	private String color;

	/**
	 * �������� Ư¡: �Է¹��� �޼����� ������ ���� ��ī������ ȭ��Ʈ ���忡 ���� ��
	 * @param msg �޽���
	 * @return ���� �۾�
	 */
	public String wrie(String msg) {
		return msg + "��" + color + "���� ��ī������ ȭ��Ʈ���忡 ����.";
	}//write
	
	
}//class
