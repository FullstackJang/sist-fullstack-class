package day1113;

import java.text.DecimalFormat;

/**
 * ���ڸ� ������ ���ڿ��� �������� ���� ��
 * @author owner
 *
 */
public class UseDecimalFormat {
	
	public UseDecimalFormat() {
		//'#' pattern : �ش� �ڸ��� �����Ͱ� �����ϴ� �͸� ���
		DecimalFormat df = new DecimalFormat("#,###,###");

		int i = 2020;
		System.out.println(df.format(i));
		
		//'0' pattern : �ش� �ڸ��� �����Ͱ� �����ϸ� ���� ����ϰ�, �������� ������ '0'�� �־� ���
		DecimalFormat df1 = new DecimalFormat("0,000,000");

		int i1 = 2020;
		System.out.println(df1.format(i1));
		
		//�Ǽ��� ó��:�Ҽ��� ���� �ڸ��� ���� ���� �鸸������ �Ǽ��� 3�ڸ� �������
		DecimalFormat df2 = new DecimalFormat("#,###,###.###");

		double d = 1.111111;
		
		System.out.println(df2.format(d));
				
		DecimalFormat df3 = new DecimalFormat("#,###.00");
		long l = 2147483649L;
//		long l = 2_147_483_649L;  // �ڵ�â���� ������ �б� ���� '_'�� �־� ����� �� ���� // JDK 1.7���� ���� ����
		System.out.println(df3.format(l));
		
	}//UseDecimalFormat
	
	public static void main(String[] args) {
		new UseDecimalFormat();
	}
}
