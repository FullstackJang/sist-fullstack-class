package a1026;

/*
 	��������:
 	�Ϲݳ�:
 	&&: ���װ� ������ ��� true�� ���� true��ȯ
 	||: ���װ� ������ ��� false�� ���� false��ȯ
 	
 	��Ʈ��:
 	&: ������Ʈ�� ������Ʈ ��� 1�ΰ�� 1����
 	|: ������Ʈ�� ������Ʈ ��� 0�ΰ�� 0����
 	^(XOR): ������Ʈ�� ������Ʈ �� �� �ϳ��� 1�� ��� 1����
 */

public class Operator5 {

	public static void main(String[] args) {

		boolean flag1 = true, flag2=false, flag3=true, flag4=false;
		System.out.println((10 < 26) && (10 > 5));
		System.out.println("---------&&---------");
		//������ false�̸�, ���׿� ������� false�� ������ ������ ������ ������� �ʴ´�.
		System.out.println(flag1 + "&&" + flag3 + "=" + (flag1 && flag3));//true
		System.out.println(flag1 + "&&" + flag2 + "=" + (flag1 && flag2));//false
		System.out.println(flag2 + "&&" + flag3 + "=" + (flag2 && flag3));//false
		System.out.println(flag2 + "&&" + flag4 + "=" + (flag2 && flag4));//false

		System.out.println("---------||---------");
		//������ true�̸� ���׿� �������true�� ������ ������ ������ ������� �ʴ´�.
		System.out.println(flag1 + "||" + flag3 + "=" + (flag1 || flag3));//true
		System.out.println(flag1 + "||" + flag2 + "=" + (flag1 || flag2));//true
		System.out.println(flag2 + "||" + flag3 + "=" + (flag2 || flag3));//true
		System.out.println(flag2 + "||" + flag4 + "=" + (flag2 || flag4));//false


		System.out.println("------------------");
		flag1=true; //��������
		flag2=true; //��������
		flag3=true; //������

		//������ false��� ������ ������� �ʾ� ������ ������ flag2�������� true�� �״�� �� �ִ�.
		flag3 = (flag1=3<2) && (flag2 = 4 > 5);
		System.out.println("����:" + flag1 + ",����:" + flag2 + ", ������:" + flag3 );
		System.out.println();
		
		System.out.println("--------��Ʈ��----------");
		
		int i = 20;
		int j = 19;
		System.out.println(i + "&" + "=" + (i & j));
		// 0001 0100 & 0001 0011 = 0001 0000
		
		i = 17;
		j = 13;
		
		System.out.println(i + "|" + j + "=" + (i|j));
		// 0001 0001 | 0000 1101 = 0001 1101
		
		System.out.println(i + "^" + j + "=" + (i^j));
		// 0001 0001 ^ 0000 1101 = 0001 1100
		
	}
}
