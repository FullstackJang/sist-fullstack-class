/*
	�ּ��� �����Ϸ��� �ؼ����� ����
	 
*/

class UsePrint{
	
	public static void main(String[] args){


// ���� ���� ��� -����
	int i = 10; // �⺻�� ��������
	UsePrint up = new UsePrint(); // ������ ��������
	UsePrint us;
	System.out.println("-------���� ���----------");
	System.out.println(i); //�⺻�� ��������
	System.out.println(up); // ������ ��������: �ּҰ� ���
	System.out.println("-------������� ���----------");
	System.out.println("10+22="+10+22);
	// ���ڿ��� +��ȣ�� ����ϸ� �������� �ǹ�
	System.out.println("10+22="+ (10+22));

	//�ڵ� ����ȯ : int�� ������������(byte,short)���� ���� �����ϰ�, ���� �Ҵ� �� �߻�
	byte b = 1; // 4byte�� ���ͷ��� 1byte�� ��ȯ�Ǿ� b������ �Ҵ�
	short s = 1; // 4byte�� ���ͷ��� 2byte�� ��ȯ�Ǿ� s������ �Ҵ�

	System.out.println(b + "," + s);

	//������ �ڵ�����ȯ: int�� �������������� ����Ǹ� ����� int�� ���´�.
	
	byte b1 = 10;
	byte b2 = 20;

	int result = 0; //error: 4byte�� ����� 1byte�� ������ �� ����.
	//int result = 0; // success: 4byte�� ����� 4byte�� ������ �� �ִ�.
	result = (byte)b1+(byte)b2; // b1(1byte)�� b2(1byte)�� ���ϸ� ����� 4byte(int)�� �߻�

	System.out.println(b1 + " + " + b2 + "=" + result);


	char c = 'A'; //���� A�� ���� Unicode�ڵ� �� �Ҵ�
	System.out.println(c); // ����� Unicode���� �ش��ϴ� ���ڸ� ���


	float f = 3.14f; // 8byte�� ���ͷ��� 4byte�� �Ҵ� �� �� ����. �� ��� f�� �ٿ�����Ѵ�.
	// ����� F�� ����ϸ� 8byte�� ���ͷ��� 4byte�� ���ͷ��� ��� ��ȯ
	System.out.println(f);

	double d = 3.14D; // ����� D�� �ַ� �����Ѵ�.
	System.out.println(d);
	
	}//main
}// class