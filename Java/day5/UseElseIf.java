/*
 	�Էµ� ������ ���� ��ȿ�� ����
 	
 	0���� �۾�����, 100���� ���� ��, 0~100�����϶��� �� ó�� 
 */

public class UseElseIf {

	public static void main(String[ ] args) {
		
		int score = Integer.parseInt(args[0]);
		
		System.out.print(score + "����");
		if(score < 0 ) { // 0���� ���� ���
			System.out.println("0���� �۾Ƽ� ����");
		}
		else if(score > 100) { // 100���� ū ���
			System.out.println("100���� Ŀ�� ����");
		} // 
		else {
			System.out.println("��ȿ ����");
		}// end else
		
		/*
		 	�ڰݽ��� ���� score ������ ����ִ�.
		 	�ڰݽ��� ������ ����
		  	����: 0 ~40
		  	�ٸ� �������� ���� : 41 ~ 60 
		  	�հ�: 61 ~ 100
		 */

		if(score <= 40 && score >= 0) {
			System.out.println("����");
		}
		else if(score > 40 && score < 61) {
			System.out.println("�ٸ� �������� ����");
		}
		else if(score > 60 && score <= 100){
			System.out.println("�հ�");
		}
		else {
			System.out.println("�߸��� ���� �Է�");
		}
		
		/*	�ι�° arguments�� �Է¹޾� �츦 ���ϴ� ���� if��
			�¾�ظ� 12�� ���� �������� 0~11������ 12�� ���� �������.
			������ ���� �ش��ϴ� ��� �Ʒ��� ���� �쿡 ���� ����ϴ� �ڵ�
			0: ������, 1: ��, 2: ��, 3: ����, 4: ��, 5: ��,
			6: ȣ����, 7: �䳢, 8: ��, 9: ��, 10: ��, 11: ��
		*/
		
		int month = Integer.parseInt(args[1]);
		
		if(month%12 == 0) System.out.println("������");
		else if(month%12 == 1)System.out.println("��");
	}
}
