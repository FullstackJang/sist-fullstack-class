package day1111.sub;

/**
 * ����� ���� Ư¡�� Person���� ����ϰ�, �ڽ�Ŭ���������� �ڽŸ��� Ư¡�� �����Ͽ� ���<br>
 * @author owner
 * ������ ���� �ϱ����ؼ� Fly interface�� ����
 */
public class Clark extends Person implements Fly {
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
	/**
	 * @param stone
	 * @return
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

	/**
	 * Person�� �����ϴ� eat�� �ڽ�Ŭ������ ��Ȳ�� ���� �ʱ� ������ �ڽ�Ŭ������ �ڽ��� ��Ȳ�� �µ��� method�� �ٽ� ����� ��
	 */
	@Override
	public String eat() {
		//name������ private�̱� ������ �ڽ�Ŭ�������� ����� �� ����.
		//�θ�Ŭ������ private ������ setter method�� getter method�� ����Ͽ� �����Ѵ�.
		return super.getName() + "�� ������ '��'�� �Դ´�."; 
	}//eat

	@Override
	public String eat(String food, int price) { //�����ε�
		return super.getName() + "�� ����������� " + food + "�� ������ "+ price +"$ ���� ��Ծ����ϴ�."; 
	}//eat

	@Override
	public String[] language() {
		String[] lang = new String[3];
		lang[0] = "����";
		lang[1] = "���Ͼ�";
		lang[2] = "�ܷʾ�";
		return lang;
	}//language

	///////////////// Fly abstract method ////////////////////

	@Override
	public int upwardForce() {
		return 100;
	}

	@Override
	public int drivingForce() {
		return 400;
	}
	
}//class