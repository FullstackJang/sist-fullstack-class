package day1109;

/**
 * ����� ���� Ư¡�� Person���� ����ϰ�, �ڽ�Ŭ���������� �ڽŸ��� Ư¡�� �����Ͽ� ���<br>
 * @author owner
 *
 */
public class Clark extends Person {
	private int power;
	
	/**
	 * ����� �Ϲ����� ���� 2�����̰�, Clark�� ū ���� ������.
	 */
	public Clark() {
		power=7;
	}//Clark

	/**
	 * Clark�� ���� ���� ���� ����ȴ�.
	 * @param stone ���� Ÿ��
	 * @return ���� ���� ���
	 */
	public String power(String stone) {
		String result = "";
					
		if(stone.equals("���̾Ƹ��")) {
			power=10;
			result = "�����մϴ�. ^0^b";
		}else if(stone.equals("ũ���䳪��Ʈ")){
			power= 0;
			result = "���� �������. Orz";
		}else {
			power=11;
			result="���� ����!! (/ �Ѥ�)/";
		}//end else
		return result;
	}//power
	
}//class