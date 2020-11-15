package day1113;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 형식이 있는 날짜 정보를 사용할 때
 * @author owner
 *
 */
public class UseDate {

	public UseDate() {
		//1. Date 생성: 시스템의 날짜 정보를 얻는다.
		Date date = new Date();

//		System.out.println(date); //사용자가 원하는 날짜형식이 아닐 확률이 높음
		
		//1. SimpleDateFormat: 사용자가 원하는 날짜형식을 만들 수 있는 클래스
		//월 : M - 9  / MM - 09 
		//일:  d - 1  / dd - 01
		//OS의 언어로 날짜형식을 보여준다.
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh(HH,kk):mm:ss EEEE");
		
		//다른 언어의 날짜형식을 보여줄려면 Locale 클래스를 사용함
		//new SimpleDateFormat("pattern", Locale.Constant);
		//OS를 설치하지않고도 다른나라 날짜,요일을 볼 수 있음
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-YYYY a hh(HH):mm:ss EEEE",Locale.CHINA);
		
//		System.out.println(sdf); //주소가 나온다. toString method를 Overriding 안했구나라는 것을 알 수 있음
		String formatDate = sdf.format(date); //날짜 객체를 전달받아 (has a) 원하는 날짜 형식의 문자열을 얻는다.
		System.out.println(formatDate);
		
	}//UseDate
	
	public static void main(String[] args) {
		
		new UseDate();
		
		
		
	}//main
}//UseDate