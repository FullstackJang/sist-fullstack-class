package a1026;

/*
 	����(����)������

	����) ���ǽ� ? ��1 : ��2

 */
public class Operator6 {

	public static void main(String[] args) {

		int i = 10;
		// i������ �����ϴ� ���� "���"���� "����"������ ����ϴ� �ڵ�
		System.out.println(i + "��(��) " + (i >= 0 ? "���" : "����"));

		//i������ �����ϴ� ���� "¦��"���� "Ȧ��"������ ����ϴ� �ڵ�
		System.out.println(i +"��(��) " + (i%2==0 ? "¦��" : "Ȧ��"));
	}
}
