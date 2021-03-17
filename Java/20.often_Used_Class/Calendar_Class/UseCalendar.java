package day1113;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * �ϳ��� ��¥���� ���� ��
 * 
 * @author owner
 *
 */
public class UseCalendar {


	public UseCalendar() {
		//��ü ����
		//is-a
		//		Calendar cal = new Caledar(); // �߻�Ŭ�������� ��üȭ �Ұ���
		Calendar cal = new GregorianCalendar();

		//method
		Calendar cal1 = Calendar.getInstance();

		//GregorianCalendar�� ��ü�� �������
		//		System.out.println(cal); 
		//		System.out.println(cal1); 

		//		System.out.println(cal1.get(1)); //��������� ����ϸ� � ���� ����� �˱� ��ƴ�. ������ ������
		//		System.out.println(cal1.get(Calendar.YEAR)); //Constant�� ����ϸ� � ���� ����� �˱� ������ ������ ���

		int year = cal1.get(Calendar.YEAR);
		int month = cal1.get(Calendar.MONTH)+1; //0��~11�� 12�� ���´�. ����� ���� ���ϰ� ���� ��� ���� +1�� ���ش�.
		int day = cal1.get(Calendar.DAY_OF_MONTH); 


		int hour = cal1.get(Calendar.HOUR_OF_DAY); //HOUR: 12�ð�  / HOUR_OF_DAY: 24�ð�
		int am_pm = cal1.get(Calendar.AM_PM);

		String[] amArr = {"����","����"}; // amArr[am_pm]���� ó���� �� ���� 0�̸� ���� 1�̸� ���� 
		String amArr1 = cal1.get(Calendar.AM_PM) == Calendar.AM ? "����" : "����";

		int minute = cal1.get(Calendar.MINUTE);
		int second = cal1.get(Calendar.SECOND);

		int week = cal1.get(Calendar.DAY_OF_WEEK);


		String[] weekTitle = {"��","��","ȭ","��","��","��","��"}; // �迭�� ���� ����
		//{"","��","��","ȭ","��","��","��","��"};

		String temp = "��,��,ȭ,��,��,��,��"; // ���ڿ��� CSV�����͸�
		String[] arr = temp.split(","); // split�� ����Ͽ� �迭�� ����� 

		System.out.println(year + "-" + month + "-" + day +" "+ amArr[am_pm] +"/"+hour + ":" + minute +":"+ second + " " + weekTitle[week-1]+ "/" + arr[week-1] + "/" + temp.split(",")[week-1]);

	}//UseCalendar

	//-------------------------------------------------------
	
	/**
	 * set method�� ����� ��¥ ����
	 */
	public void calendarSet() {

		Calendar cal = Calendar.getInstance(); // ���� ��¥ : 2020-11-13 
		
		//�� ����: 2020 => 2021
		cal.set(Calendar.YEAR, 2021); // 2021-11-13
		//�� ����: 11�� => 3��
		cal.set(Calendar.MONTH, 2); //0������ �����ϱ� ������ ���� �޿��� �ϳ� ���� ������ ����
		//�� ����: 13�� => 31��
		cal.set(Calendar.DAY_OF_MONTH, 31);
		
		System.out.println(cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DAY_OF_MONTH)+ " " +
		("��,��,ȭ,��,��,��,��".split(",")[cal.get(Calendar.DAY_OF_WEEK)]));
	
	}//calendarSet

	public static void main(String[] args) {
		new UseCalendar();

		System.out.println("-----------------");

		UseCalendar uc = new UseCalendar();
		uc.calendarSet();
	}//main
}//class
