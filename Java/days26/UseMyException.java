package day1130;

import java.util.Random;

/**
 * ����� ���� ���� ó�� Ŭ������ ����ϴ� Ŭ����
 * @author owner
 *
 */
public class UseMyException {
// throws�� ������ ���ܴ� method�ȿ��� throw�� �߻��� ���ܰ� �Ǿ�� �Ѵ�
// �Ǵ� throws�� ������ ���ܴ� method�ȿ��� throw�� �߻��� ������ �θ� �� �� �ִ�. (�θ�� ���ܸ� ������ � ������ �߻��ߴ��� �˱� ��ƴ�.)
	public void method() throws TestException {
		
		if(new Random().nextBoolean()) {
			//���ܰ� �߻��ϴ� ��Ȳ
//			throw new TestException(); // �������� �޽����� ���
			throw new TestException("�������� �޽����� ���");
		}//end if
	}//method

	
	/**
	 * 
	 *  ������ method: ���� �ϴ� ���߿� �ʵ��� ��踦 �ǿ�� ���� ����ϸ� ���ܸ� �߻���Ų��.
	 * @return �ϴ����� ���
	 * @throws Exception �ʵ��� ��� �� ���
	 */
	public String ryuSujeong() throws CigaretteException { // �������� ���� �ɾ��.
		
		String result = "";
		String[] grade = {"�ʵ�","�ߵ�","���","���"};
		
		//�迭�� ������ŭ ������ ���, �迭���� ������° ���� ���� ��´�.
		String getGrade = grade[new Random().nextInt(grade.length)];
		
		if("�ʵ�".equals(getGrade)) { //���ڿ� ���ͷ��� equals�ؾ� null�����͸� �߻��Ƚ�ų�� �ִ�.
		//�ʵ��� ��踦 �ǿ�� ��Ȳ�� ���ܸ� �߻����� ó��
		
			throw new CigaretteException(getGrade + "�� �ݿ��� �ּ���.");
//			throw new CigaretteException(); //����ģ ���� �ﰡ�սô�.
		}//end if
		
		result = getGrade + "�� �� �� ��ô ��������.";

		
		return result;
	}//ryuSujeong
	
	
	public static void main(String[] args) {
		UseMyException ume = new UseMyException();
		
	
		try {
			ume.method();
			System.out.println("�������� �ڵ� ����");
		} catch (TestException te) {
			System.err.println("method�ȿ��� ���ܰ� �߻�: " + te.getMessage());
			te.printStackTrace();
		}//end catch
		
		try {
			String msg = ume.ryuSujeong();
			System.out.println(msg); //��������
		} catch(CigaretteException ce) { //�ֻ��� ���ܸ� throws�ϸ� method�� ȣ���Ͽ� ���� �ϴ� �Ͱ� ����� ���� �����̱� ������ �������� ��������.
		ce.printStackTrace();
		}//end catch
	}//main
}//class