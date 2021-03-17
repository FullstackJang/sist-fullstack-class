/*
	if~else��: �� �� �ϳ��� �ڵ尡 �ݵ�� ���� �Ǿ���� ��
	����:
		if(���ǽ�) {
			���ǿ� ���� �� ����� �����...
		}
		else {
			���ǿ� ���� ���� �� ���� �� �����...
		}
 */

public class UseIfElse {

	public static void main(String[] args){

		int num = Integer.parseInt(args[0]);

		System.out.print(num + "��(��)");

		if(num >= 0) {
			System.out.println("���");
		}
		else {
			System.out.println("����");
		}//end else

		//�Է¹��� ���� "Ȧ��"���� "¦��"���� ��� �ڵ�

		if(num % 2 == 1) {
			System.out.println("Ȧ��");
		}
		else {
			System.out.println("¦��");
		}//end else

		//�ԷµǴ� �ι�° arguments�� �����Դϴ�. �Էµ� ���̸� ����Ͽ� "����"���� "�̼���"������ ����ϴ� �ڵ� �ۼ�
		// ���� ���� 19�� �̻� �̴�.

		int age = Integer.parseInt(args[1]);

		System.out.print("�Է³��� " + age + "����");

		if(age > 18) {
			System.out.println("����");
		}
		else {
			System.out.println("�̼���");
		}

		// ����° arguments�� ������ �Էµȴ�. �Էµ� ������ 0 ~ 100�� ���̸� "��ȿ����" �׷��� ������ "�߸��� ����"�� ���

		int score = Integer.parseInt(args[2]);

		if(score >= 0 && score <= 100) {
			System.out.println("��ȿ����");
		}
		else {
			System.out.println("�߸��� ����");
		}

		// �׹�° arguments�� ����� ������ �Էµȴ�. 
		// �Էµ� �� Java �Ǵ� Python �Ǵ� C# �� ������ "�ֱ� OOP���"�� ����ϰ�
		// �׷��� �ʴٸ� "���α׷��� ���"�� ���

		if(args[3].equals("Java") || args[3].equals("Python") || args[3].equals("C#")) {
			System.out.println("�ֱ�OOP���");
		}
		else {
			System.out.println("���α׷��� ���");
		}


		// �ټ���° �Է°��� long(Wrapper class)���� ó���ϰ�
		//�Է°��� int�� ����(Wrapper Class Contant)�϶���
		// "int"�� ����ϰ� �׷��� ������ "long"�� ����ϴ� �ڵ� �ۼ�

		long inputNum = Long.parseLong(args[4]);

		if(inputNum >= Integer.MIN_VALUE  && inputNum <= Integer.MAX_VALUE) {
			System.out.println("int�� ����");
		}
		else {
			System.out.println("long�� ����");
		}//end else
		
		
		
		
		
	}//main
}
