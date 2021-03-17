package day1112;

/**
 * �� ���ڿ��� ����� �� ���� Ŭ����: StringBuffer, StringBuilder ���
 * @author owner
 *
 */
public class UseStringBuilder {

	StringBuffer sb;

	public void useStringBuffer() {
		//1. ����: Ŭ�������� �ٸ� Ŭ������ ����� ����ϱ����� ���(is-a)�� ���� ���� �ְ�, ��ü�� ���� ����(has-a)�Ͽ� ����� ���� ����
		sb = new StringBuffer();

		//2. methodȣ��: ��ü�� �����ϴ� �� ���
		//�� �߰� (����,�Ǽ�,����,�Ҹ�,���ڿ�)
//		sb.append("������ ");
//		sb.append(11);
//		sb.append("��");
//		sb.append(12);
//		sb.append("��");
		
		//�޼ҵ� ü��
		//��� �޼��尡 �ϳ��� ü������ ����
		sb.append("������ ").append(11).append(12).append("��");

		//�� ���� (�ε����� �����Ͽ� ���� �ִ´�.)
		//������ 11�� 12��
		//0123456789 <- String index ����
		sb.insert(4, "2020��");
		//������ 2020��11��12��

		//�� ����: ���ڿ����� �⵵ 4�ڸ��� �� 2�ڸ� ����
		// delete(�����ε���, �� �ε��� + 1) // +1 �ϴ� ���� null���ڰ� ���ԵǾ��ֱ� ����
		sb.delete(4,5+1);

		//
		sb.reverse();
		
		//StringBuffer�� ������ String �Ҵ�
		String str = sb.toString();
		System.out.println(str);

	}//useStringBuffer

	public void useStringBuilder() {
		//1. ����: Ŭ�������� �ٸ� Ŭ������ ����� ����ϱ����� ���(is-a)�� ���� ���� �ְ�, ��ü�� ���� ����(has-a)�Ͽ� ����� ���� ����
		StringBuilder sb = new StringBuilder();

		//2. methodȣ��: ��ü�� �����ϴ� �� ���
		//�� �߰� (����,�Ǽ�,����,�Ҹ�,���ڿ�)
		sb.append("������ ");
		sb.append(11);
		sb.append("��");
		sb.append(12);
		sb.append("��");

		//�� ���� (�ε����� �����Ͽ� ���� �ִ´�.)
		//������ 11�� 12��
		//0123456789 <- String index ����
		sb.insert(4, "2020��");
		//������ 2020��11��12��

		//�� ����: ���ڿ����� �⵵ 4�ڸ��� �� 2�ڸ� ����
		// delete(�����ε���, �� �ε��� + 1) // +1 �ϴ� ���� null���ڰ� ���ԵǾ��ֱ� ����
		sb.delete(4,5+1);

		//
		sb.reverse();
		
		String str = sb.toString();		
		System.out.println(str);
		
	}//useStringBuilder

	
	
	public static void main(String[] args) {
		UseStringBuilder usb = new UseStringBuilder();
		usb.useStringBuffer();
		System.out.println("---");
		usb.useStringBuilder();

		//String(���ڿ�)�� + ������ ����ϸ� Compiler�� +������ StringBuilder�� ������
		//		String str = "�ȳ�";
		//		str += "�ϼ���";
		//		str += "������ ������Դϴ�.";
		//		System.out.println(str);
	}//main
}//class