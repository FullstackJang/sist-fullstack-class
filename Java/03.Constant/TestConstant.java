/*
 	���α׷� �ۼ��� ���� ���� �ʿ��ϴٸ� Constant�� ����� ����Ѵ�.
 	public static final �������� ����� = ��;�� �������� ����Ѵ�.
 	
 */

// class field : ��� ����
public class TestConstant {
	
	//��� ����
	public static final int MAX_SCORE = 100;
	public static final int MIN_SCORE = 0;
	
	public static void main(String[ ] args) {		
		// ����� ���Ҵ��� �� �� ����.
		
		System.out.println("�ְ� ����: " + MAX_SCORE);
		System.out.println("���� ����: " + TestConstant.MIN_SCORE);
		
		int myScore = 89;
		
		myScore = 87;
		System.out.println("ȹ�� ����: " + myScore);
		System.out.println("�ְ� ����(" + TestConstant.MAX_SCORE+ "��)���� ȹ������ (" + myScore + ")�� �� �� ������ " + (TestConstant.MAX_SCORE - myScore)+ "�� �Դϴ�.");

	}
}
