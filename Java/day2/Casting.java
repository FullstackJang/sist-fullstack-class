/*
	���� �� ��ȯ�� ���� ��
	(���� �� ��������)���;
	(���� �� ��������)����;
*/

class Casting {
	public static void main(String[] args) {

		float f = 3.1415f; // �� ��� : ���ͷ��� ũ�� ��ü�� ����Ͽ� �� ���� ������ �Ҵ�
		int i = 0;

		//i=f; ���� ������ �ٸ��Ƿ� �Ҵ� �� �� ����.
		// ���� ����ȯ���� ���� �Ҵ� �� �� �ֵ�.

		i = (int)f; // .1415�� �������.
		System.out.println("float:"+f + "," + "int:" + i);

		float f1 = (float)3.14; // ���� �� ��ȯ : ���ͷ��� ũ�� ��ü�� �����ǰ� ������ �Ҵ��� �� ���� float���� �����Ͽ� �Ҵ�

		System.out.println("float: "+ f1);


		byte num1 = 4;
		byte num2 = 26;
		byte result = 0;

		result = (byte)(num1 + num2); //�ڵ�����ȯ => ��������ȯ

		System.out.println(num1 + " + " + num2 + " = " + result);

		char c = 'A'; // Unicode ����
		System.out.println(c + "�� Unicode��: " + (int)c);

		//casting�� ���� �ʴ� ��� - �⺻�� ��������(���� ����)�� ������ ��������(�ּ� ����)���� ��ȯ
		/*
		int temp = 4; 
		String s = (int)tmp; => (X)
		*/

		//������ ��������(�ּ� ����)�� �⺻�� ��������(���� ����)���� ��ȯ.
		/*
		String s = "4";
		int temp = (int)s; => (X)
		*/


		//boolean���� �ٸ� ������������ ��������ȯ ���� �ʴ´�.
		/*
		boolean b1 = true;
		System.out.println((int)b1); => (X)
		*/


	}
}
