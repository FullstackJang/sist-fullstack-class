package day1113;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 하나의 날짜정보 얻을 때
 * 
 * @author owner
 *
 */
public class UseCalendar {


	public UseCalendar() {
		//객체 생성
		//is-a
		//		Calendar cal = new Caledar(); // 추상클래스여서 객체화 불가능
		Calendar cal = new GregorianCalendar();

		//method
		Calendar cal1 = Calendar.getInstance();

		//GregorianCalendar로 객체가 만들어짐
		//		System.out.println(cal); 
		//		System.out.println(cal1); 

		//		System.out.println(cal1.get(1)); //정수상수를 사용하면 어떤 값을 얻는지 알기 어렵다. 가독성 떨어짐
		//		System.out.println(cal1.get(Calendar.YEAR)); //Constant를 사용하면 어떤 값을 얻는지 알기 쉬워짐 가독성 향상

		int year = cal1.get(Calendar.YEAR);
		int month = cal1.get(Calendar.MONTH)+1; //0월~11월 12달 나온다. 사람이 보기 편하게 나온 결과 값에 +1을 해준다.
		int day = cal1.get(Calendar.DAY_OF_MONTH); 


		int hour = cal1.get(Calendar.HOUR_OF_DAY); //HOUR: 12시간  / HOUR_OF_DAY: 24시간
		int am_pm = cal1.get(Calendar.AM_PM);

		String[] amArr = {"오전","오후"}; // amArr[am_pm]으로 처리할 수 있음 0이면 오전 1이면 오후 
		String amArr1 = cal1.get(Calendar.AM_PM) == Calendar.AM ? "오전" : "오후";

		int minute = cal1.get(Calendar.MINUTE);
		int second = cal1.get(Calendar.SECOND);

		int week = cal1.get(Calendar.DAY_OF_WEEK);


		String[] weekTitle = {"일","월","화","수","목","금","토"}; // 배열을 직접 생성
		//{"","일","월","화","수","목","금","토"};

		String temp = "일,월,화,수,목,금,토"; // 문자열의 CSV데이터를
		String[] arr = temp.split(","); // split을 사용하여 배열로 만들고 

		System.out.println(year + "-" + month + "-" + day +" "+ amArr[am_pm] +"/"+hour + ":" + minute +":"+ second + " " + weekTitle[week-1]+ "/" + arr[week-1] + "/" + temp.split(",")[week-1]);

	}//UseCalendar

	//-------------------------------------------------------
	
	/**
	 * set method를 사용한 날짜 변경
	 */
	public void calendarSet() {

		Calendar cal = Calendar.getInstance(); // 현재 날짜 : 2020-11-13 
		
		//년 변경: 2020 => 2021
		cal.set(Calendar.YEAR, 2021); // 2021-11-13
		//월 변경: 11월 => 3월
		cal.set(Calendar.MONTH, 2); //0월부터 시작하기 때문에 현재 달에서 하나 적은 값으로 설정
		//일 변경: 13일 => 31일
		cal.set(Calendar.DAY_OF_MONTH, 31);
		
		System.out.println(cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.MONTH)+1) + "-" + cal.get(Calendar.DAY_OF_MONTH)+ " " +
		("일,월,화,수,목,금,토".split(",")[cal.get(Calendar.DAY_OF_WEEK)]));
	
	}//calendarSet

	public static void main(String[] args) {
		new UseCalendar();

		System.out.println("-----------------");

		UseCalendar uc = new UseCalendar();
		uc.calendarSet();
	}//main
}//class
