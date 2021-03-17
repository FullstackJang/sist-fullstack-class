package day1127;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrintErrorMsg {
	public static void main(String[] args) {

//		System.out.println("���� ���");
//		System.err.println("������ ���");
		
	try {
		int i = Integer.parseInt(args[0]);
		System.out.println(i);
	}catch(ArrayIndexOutOfBoundsException aioobe) {
		System.err.println(aioobe.getMessage()); //Index 0 out of bounds for length 0
	}catch(NumberFormatException ne) {
		System.err.println(ne.getMessage()); //���� ���� 
		//For input string: "��"
		
		System.err.println(ne); // ����ó��Ŭ������ ���� ����
		// java.lang.NumberFormatException: For input string: "��"
		
		ne.printStackTrace(); //Stack�� ���� �ڼ��� ���� �޽���
		/*java.lang.NumberFormatException: For input string: "��"
			at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:68)
			at java.base/java.lang.Integer.parseInt(Integer.java:652)
			at java.base/java.lang.Integer.parseInt(Integer.java:770)
			at day1127.PrintErrorMsg.main(PrintErrorMsg.java:10)
		*/
	}//end catch
	
	System.out.println("---------------------");

	// instanceof : ������ - ��ü�� Ŭ����(�������̽�)�� ������ ��ü���� �Ǵ�.
	// ��ü instanceof Ŭ����
	PrintErrorMsg pem = new PrintErrorMsg();
	System.out.println(pem instanceof PrintErrorMsg);
	
	ActionListener ae = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};

	System.out.println(ae instanceof ActionListener);
	
	}//main
}//class
