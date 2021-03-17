package day1113;

import java.text.DecimalFormat;

/**
 * 숫자를 지정한 문자열의 형식으로 만들 때
 * @author owner
 *
 */
public class UseDecimalFormat {
	
	public UseDecimalFormat() {
		//'#' pattern : 해당 자리에 데이터가 존재하는 것만 출력
		DecimalFormat df = new DecimalFormat("#,###,###");

		int i = 2020;
		System.out.println(df.format(i));
		
		//'0' pattern : 해당 자리에 데이터가 존재하면 값을 출력하고, 존재하지 않으면 '0'을 넣어 출력
		DecimalFormat df1 = new DecimalFormat("0,000,000");

		int i1 = 2020;
		System.out.println(df1.format(i1));
		
		//실수의 처리:소수점 이하 자릿수 설정 가능 백만단위와 실수는 3자리 까지출력
		DecimalFormat df2 = new DecimalFormat("#,###,###.###");

		double d = 1.111111;
		
		System.out.println(df2.format(d));
				
		DecimalFormat df3 = new DecimalFormat("#,###.00");
		long l = 2147483649L;
//		long l = 2_147_483_649L;  // 코딩창에서 정수를 읽기 좋게 '_'를 넣어 사용할 수 있음 // JDK 1.7에서 부터 지원
		System.out.println(df3.format(l));
		
	}//UseDecimalFormat
	
	public static void main(String[] args) {
		new UseDecimalFormat();
	}
}
