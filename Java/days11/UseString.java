package day1104;

public class UseString {

	public static void main(String[] args) {

		String str = "ABCD"; // �⺻�� ������ ���
		String str1 = new String("ABCD"); // ������ ������ ���
		
		//���ڿ��� == ��
		//�⺻�������� ������ ���ڿ�������� �ּҸ� �״�� ����

		System.out.println(str +" �⺻�� ���� == ��");
		if(str == "ABCD") {
			System.out.println("����.");
		}//end if
		else {
			System.out.println("�ٸ���.");
		}//end else
		
		System.out.println(str + "������ ���� == ��");
		if(str1 == "ABCD") {
			System.out.println("����.");
		}//end if
		else {
			System.out.println("�ٸ���");
		}//end else

		System.out.println("---------------------");

		//���ڿ��� ��������� ������� ������ �񱳸� �ϱ� ���� equals method��  ����Ѵ�.
		//���ڿ�������.equals("���� ���ڿ�");

		System.out.println(str + "equals method ��");
		if(str.equals("ABCD")) {
			System.out.println("����");
		}
		else {
			System.out.println("�ٸ���");
		}//end else
		
		System.out.println(str1 + "equals method ��");
		if(str1.equals("ABCD")) {
			System.out.println("����");
		}
		else {
			System.out.println("�ٸ���");
		}//end else
		
		//"���ڿ��� String class���� �����ϴ� ��� method�� ȣ��(���) �� �� �ִ�.
		System.out.println("�ȳ��ϼ���?".length());
		
		String temp = "ABCD";
		String mail = new String("test@hanmail.net");
		
		System.out.println(temp + "�� ���� " + temp.length());
		System.out.println(mail + "�� ����" + mail.length());
		
		temp = "AbcdEf";
		System.out.println(temp + "�� ��� �빮�ڷ�" + temp.toUpperCase());
		System.out.println(temp + "�� ��� �ҹ��ڷ�" + temp.toLowerCase());

		System.out.println(temp + "���� 'd'�� �ε��� " + temp.indexOf('d'));
		System.out.println(temp + "���� 'g'�� �ε��� " + temp.indexOf('g'));

		//indexOf�� ���ڿ��� �Է��ϸ� ��ġ�ϴ� ���ڿ��� ���� �� ���� ó�� ���ڿ��� ���� �ε����� ��ȯ
		//indexOf("ã�����ڿ�"); // ã�� ������ L -> R
		System.out.println(temp + "���� 'cdE'�� �ε��� " + temp.indexOf("cdE"));
		
		temp = "JavaOracle";
		//index 0123456789
		//lastIndexOf�� R -> L�� ������ ���ڿ��� ã�´�.
		System.out.println(temp +"���� ó�� 'a'�� �ε��� " + temp.indexOf("a"));
		System.out.println(temp +"���� ������'a'�� �ε���"+ temp.lastIndexOf("a"));
		

	
		temp = "test@test.com";
		//indexOf�� ����Ͽ� temp������ ����ִ� �����ּҰ� ��ȿ���� �Ǵ��ϴ� �ڵ� �ۼ�
		//�ڵ� �ۼ�. '@'�� '.'�� �����鼭 a@b.com
		System.out.println(temp);
		if(temp.length() > 6 && temp.indexOf("@") != -1 && temp.indexOf(".") != -1) {
			System.out.println("������ ���� �ּ�");
		}
		else {
			System.out.println("�������� �����ּ�");
		}
		
		//5.�ε����� �ش��ϴ� ���� �ϳ� ��� : charAt(�ε���)
		//test@hanmail.net
		System.out.println(mail +"���� 8��° �ε����� �ش��ϴ� ����: " + mail.charAt(4));
		System.out.println(mail +"���� '@'�� �ش��ϴ� ���ھ��: " + mail.charAt(mail.indexOf("@")));
		
		//6.substring();
		temp = "����� �ӳɳɳ� �Ծ����ϴ�.";
		System.out.println(temp);
		//���� ������ ���� �ڸ��� ���ڿ��� null���ڰ� ����.
		//�� �ε����� �ش��ϴ� ���ڰ� �߷����� �ʴ´�.
		//substring(�����ε���,���ε���+1)
		System.out.println(temp.substring(4,8));
		System.out.println(temp.substring(9,15));
		
		
		//mail�������� ���� �ּҸ� �߶� ���
		//test@hanmail.net
		//�����ּ�@ �������ּ�
		System.out.println("�����ּ�: " + mail.substring(0,mail.indexOf("@")));
		System.out.println("�������ּ�: " + mail.substring(mail.indexOf("@")+1,mail.length()));
		
		//substring(�����ε���); �����ε����������� ���ε������� �߶��ش�.
		System.out.println("�������ּ�: " + mail.substring(mail.indexOf("@")+1));
		
		//���ڿ� ���̱�
		String temp1 = "������";
		System.out.println(temp1.concat(" �������Դϴ�."));
		
		//���ڿ��� �յ� ���� �ڸ���
		String temp2 = "   �� �ϱ�    ";
		System.out.println("["+temp2+"]"+"["+temp2.trim()+"]"); 
		
		//�Է��� ���ڿ��� �����ߴ���?
		String temp3 = "����� ������";
		System.out.println(temp3.startsWith("����"));
		
		
	}	//main
}//class
