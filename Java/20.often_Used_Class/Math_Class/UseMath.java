package day1112;

/**
 * ���а��� Ŭ����(�����ڰ� ����)
 * @author owner
 *
 */
public class UseMath {


	public UseMath() {

		//Math m = new Math(); �����ڰ� �����Ƿ� ��üȭ�� �� ����

		//		//�ݿø�
		//		double d = 10.5;
		//		double d1 = 10.2;
		//		double d2 = 10.9;
		//		System.out.println(d + "�� �ݿø� " + Math.round(d)); //10.5�� �ݿø� 11
		//		System.out.println(d1 + "�� �ø� " + Math.ceil(d1)); //10.2�� �ݿø� 11.0 //�Ҽ������� ù��° �ڸ��� 0�� �ƴ϶�� �ø�
		//		System.out.println(d2 + "�� ���� " + Math.floor(d2));
		//		System.out.println(d2 + "�� ���� " + (int)d2);
		//		
		//		//���밪
		//		int i = -11;
		//		System.out.println(i + "�� ���밪: "+ Math.abs(i));
		//		
		//		//����
		//		d = Math.random(); //���� ��
		//		System.out.println("����:" + d);
		//		System.out.println("���� ����:" + d * 10); // �߻� �� *(���ϱ�) ����
		//		System.out.println("���� ������ ����:" + (int)(d * 10)); //(��������ȯ)(�߻� �� *(���ϱ�) ����)
		//		System.out.println("���� ������ ����:" + ((int)(d * 5)+1));
		//		
		//		// �빮�� A(65)~Z(90)�� ���� �ϳ� ���
		//		int d3 = 65;
		//		System.out.println((char)((int)(Math.random() * 26) + 65));



	}//UseMath

	public char[] createPassword() {

		char[] tempPassword = new char[8];
		int flagN = 0;
		//������ ����,�빮��,�ҹ��ڷ� ������ 8�ڸ��� ��й�ȣ�� �����Ͽ� �迭�� �ְ� ��ȯ�Ͽ� 
		//(97~122) �ҹ���  (65~90) �빮�� (48~57) ����
		//		for(int i =0; i< tempPassword.length; i++) {
		//			flagN = (int)(Math.random()*3); //0,1,2�� �ϳ��� �߻�
		//			switch(flagN) {
		//			
		//			case 0: tempPassword[i] = (char)( (Math.random() *10) + 48); break;
		//			case 1: tempPassword[i] = (char)( (Math.random() *26) + 65);break;
		//			case 2: tempPassword[i] = (char)( (Math.random() *26) + 97);break;
		//		}

		//���� 8���� ���ؼ� i--�ϱ� ������ ����� ���������� ��
		//		int tempNum = 0;
		//		for(int i = 0; i < tempPassword.length; i++) {
		//			tempNum = (int)(Math.random()*123);
		//
		//			if(tempNum >= 97 && tempNum <= 122 || tempNum >= 65 && tempNum <= 90 || tempNum >= 48 && tempNum <= 57) {
		//				tempPassword[i] = (char) tempNum;
		//			}
		//			else {
		//				i--; //���鶧���� ��� ���̳ʽ���
		//			}
		//		}

		String temp = "1234567890QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
		for(int i =0; i < tempPassword.length; i++) {
			//���ڿ��� ���̸�ŭ ������ �߻����� �ش� �ε����� ���ڸ� ���� �迭�� �ֱ�
			tempPassword[i] = temp.charAt((int)(Math.random()*temp.length()));		
		}//end for
		
		return tempPassword; //��ȯ
	}

	public static void main(String[] args) {
		//		new UseMath();

		//���
		char[] arr = new UseMath().createPassword();

		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}

	}//main
}//class
