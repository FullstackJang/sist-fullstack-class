/*
   ���׿�����.
   ~, !, +,-,++, --
 */

public class Operator1 {

	public static void main(String[] args) {
		
		int i = 3;
		int j = -34;

		System.out.println("~" + i + "=" + ~i); //��ȣ���� 1����
		System.out.println("~" + j + "=" + ~j); // ��ȣ���� 1����
		
		System.out.println(!(3>4));
		
		boolean flag1 = true,flag2 = false;
		
		System.out.println("!" + flag1 + "=" + !flag1);
		System.out.println("!" + flag2 + "=" + !flag2);
		
		
		System.out.println("~" + i + "=" + +i); 
		System.out.println("~" + j + "=" + +j);

		System.out.println("~" + i + "=" + -i); 
		System.out.println("~" + j + "=" + -j); 
		
		i = 1;
		j = 5;
		//�������� : ������ ���ü ;
		++i; // 1 -> 2
		--j; // 5 -> 4
		System.out.println("���� ���� �� i:" + i + ", j:" + j );
		//��������: ���ü ������;
		i++; // 2 -> 3
		j--; // 4 -> 3
		System.out.println("���� ���� �� i:" + i +", j:" + j);
	
		//++,--���� ����� ���� ������ �ٸ� ���� �����Ѵ�.
	
		i = 4;
		int result = 0;
		//����: ���� ����. (���� ������ ������ ����� ����)
		result = ++i;
		System.out.println("���� ���� �� result:" + result + ", i:" + i); // 5,5

		i = 4;
		result = 0;
		//����: ���� �� ����.(���� ������ ���� �����ϰ�, ���� ���� ����)
		result = i++;
		System.out.println("���� ���� �� result:" + result + ", i:" + i); // 4,5
	}
	
}
