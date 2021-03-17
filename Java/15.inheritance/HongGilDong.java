package day1110;

/**
 * ����� ���� Ư¡�� Person���� ����ϰ�, �ڽ�Ŭ���������� �ڽŸ��� Ư¡�� �����Ͽ� ���<br>
 * �ο��� ������ �ִ� 10���� �ö󰡸� �Ϲ����� �ɷ��� 3�����̴�.
 * @author owner
 *
 */
public class HongGilDong extends Person {

	private int level;

	/**
	 * �ο��� ������ �ִ� 10���� �ö󰡸� �Ϲ����� �ɷ��� 3�����̳�, ȫ�浿��
	 * ���� �ο� �ɷ�ġ�� ������.
	 */
	public HongGilDong() {
		this.level = 6;
	}//HongGilDong

	/**
	 * �ο� ���� ������ method<br>
	 * ���� �ɷº��� ���� ���� �ο�� �̱�� ���,���� �ɷ°� ���� ���� �ο�� ���� ���
	 * ���� �ɷº��� ���� ���� �ο�� ���� ����� ��ȯ
	 * @param yourLevel ����� ����
	 * @return �ο��� ���
	 */
	public String fight(int yourLevel) { // ���� ���
		String result = " ";

		if(level < yourLevel) {
			level--;
			if(level < 0) {
				level = 0;
			}//end if
			result ="���� ~(_-_)~";
		}else if(level > yourLevel) { // �̱�� ���
			level++;
			if(level > 10) {
				level=10;
			}//end if
			result="�̰�� s('.^)v";
		}else { // ���� ���
			result ="���� �Ѥ�";
		}
		return result;
	}//fight		

	/**
	 * �θ�Ŭ�������� �����ϴ� ����� �ڽ�Ŭ������ ���� �ʱ� ������ �ڽ�Ŭ������ ��Ȳ�� �µ��� method�� Override
	 */
	@Override
	public String eat(String menu, int price) { //�����ε�
		return super.getName() + "��(��) �ָ����� " + menu + "�� ������ "+ price +"�� ���� ��Ծ����ϴ�."; 
	}//eat

	@Override
	public String eat() {
		return getName()+"�� ������ ���� �Դ´�.";
	}

	@Override
	public String[] language() {
		
		String[] lang = {"�ѱ���","�߱���"};
		return lang;
	}//language
}//class