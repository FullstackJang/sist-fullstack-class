package day1029;

/*
 * Ư�������� ���
 * ���ڿ� �ȿ��� \�� �����ϴ� ����� ���� ����
 * 
 * */

public class EscapeCharacter {
	public static void main(String[] args) {
	
		System.out.println("\"�ȳ�\"");// "�ȳ�"
		System.out.println("c:\\dev\\env.bat");// c:\dev\env.bat
		
		//\r - return: Ŀ���� ������ ������.(�ܵ����� ����ϸ� �ٺ���)
		//�ܵ����� ����Ͽ� ���� ������ ���� �ִٸ� \n�� ����Ͽ� ��� OS���� ������ �� �ֵ��� �Ѵ�.
		System.out.println("��\r\n��"); //�ٺ���
		
		System.out.println("��\t��"); //tab
		System.out.println("��\'��\'"); // '�� ����ϰ� ������
		System.out.println("�ȳ�\b"); 
	}
}
