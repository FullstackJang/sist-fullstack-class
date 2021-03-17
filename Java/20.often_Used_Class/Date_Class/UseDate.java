package day1113;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * ������ �ִ� ��¥ ������ ����� ��
 * @author owner
 *
 */
public class UseDate {

	public UseDate() {
		//1. Date ����: �ý����� ��¥ ������ ��´�.
		Date date = new Date();

//		System.out.println(date); //����ڰ� ���ϴ� ��¥������ �ƴ� Ȯ���� ����
		
		//1. SimpleDateFormat: ����ڰ� ���ϴ� ��¥������ ���� �� �ִ� Ŭ����
		//�� : M - 9  / MM - 09 
		//��:  d - 1  / dd - 01
		//OS�� ���� ��¥������ �����ش�.
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh(HH,kk):mm:ss EEEE");
		
		//�ٸ� ����� ��¥������ �����ٷ��� Locale Ŭ������ �����
		//new SimpleDateFormat("pattern", Locale.Constant);
		//OS�� ��ġ�����ʰ� �ٸ����� ��¥,������ �� �� ����
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-YYYY a hh(HH):mm:ss EEEE",Locale.CHINA);
		
//		System.out.println(sdf); //�ּҰ� ���´�. toString method�� Overriding ���߱������ ���� �� �� ����
		String formatDate = sdf.format(date); //��¥ ��ü�� ���޹޾� (has a) ���ϴ� ��¥ ������ ���ڿ��� ��´�.
		System.out.println(formatDate);
		
	}//UseDate
	
	public static void main(String[] args) {
		
		new UseDate();
		
		
		
	}//main
}//UseDate