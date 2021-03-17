package a1026;

/*
	main method�� arguments �Է�
	java Ŭ������ ���� �� �ܺο��� ���� �־� �����ϱ�
	�ܺ� ���� �Է¹����� ����ڰ� �Է��� ������ ���α׷��� �����ϱ� ������ ���α׷��� �������� ������
	����) java Ŭ������ �� �� �� �� , , , ,
 */

public class UseArguments {

	public static void main(String[] args) {

		System.out.println("ù��° �Է� ��:" + args[0]);
		System.out.println("�ι�° �Է� ��:" + args[1]);
		System.out.println("����° �Է� ��:" + args[2]);

		// �ܺΰ��� �Է¹ޱ� ���� parameter�� ���������� String���̰�
		// String���� �����ڸ� �̿��� ������ �� �� ����. ( Error )
		// + ������ �� �� �ִµ� + ������ �������� ������ �����Ѵ�.

		System.out.println(args[0] + args[1]); // 1026 - �������� ����

		// int num1 = args[0]; // ���ڿ�(��������������)�� �������� �Ҵ� �� �� ����.
		// ���ڿ��� ������ ��ȯ�Ͽ� �Ҵ�. 
		// Integer.parseInt() method�� ���
		int num1 = Integer.parseInt(args[0]); // ���������� ���ڿ��� ��ȯ����
		int num2 = Integer.parseInt(args[1]);
		System.out.println(num1+num2); // 36 - ��Ģ���� 
		// ���ڿ��� ������ ��ȯ�Ͽ� ������ �����ϰ�, ����� ������ �����Ѵ�.
		
	}//main
}// class
