/*
	�⺻�� ���������� �̿��� ������ ����� ���
	�ڵ� ����ȯ, �����
*/

class DataType {
	public static void main(String[] args) {

		//������ ������ �� �ִ� ��������. byte,short,int,long
		byte a = 10; // �ڵ�����ȯ
		short b = 20; // �ڵ�����ȯ
		int c = 30; 
		long d = 40; // ���ͷ��� ũ�⺸�� ���� ���� ���� ��, ����� ���� ����
		long e = 2147483648L; // ����� (���ͷ��� ũ�⺸�� ū ���� ���)
		
		System.out.println("byte : " + a + "short: " + b + "int : " + c + "long : " + d + "," + e); 

		//-----������-----
		char f = 'A'; // Unicode �� 65 �Ҵ�
		char g = 'a'; // Unicode �� 97 �Ҵ�
		char h = '0'; // Unicode �� 48 �Ҵ�

		System.out.println("char:"+f+","+g+","+h); // �ڵ� ���� �ش��ϴ� ���ڸ� ���
		

		//-----�Ǽ���-----
		float i = 2020.22f; // ����� �ʼ�(8byte�� ���ͷ��� 4byte�� ���)
		double j = 2020.22; // ����� ��������
		System.out.println("float:"+i+", double:"+j);
	
		//-----�Ǽ���-----
		boolean k = true;
		boolean l = false;

		System.out.println("boolean:" + k + "," + l);


		//�ڵ�����ȯ: int�� �������������� ����Ǹ� ����� int�� ���´�.

		byte num1 = 3;
		short num2 = 4;
		// short result = num1 + num2; byte�� short�� ��ȯ�� �� short���� ����Ǿ� ����� int�� �߻��Ͽ� short���������� �Ҵ� �� �� ����.
		int result = num1 + num2; // error�ذ��� short�� int�� �ٲ۴�.

		System.out.println(num1 + "+" + num2 + "=" + result);


	}
}
