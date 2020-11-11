package day1111;

//import java.util.*; //패키지명.*을 사용하면 해당 패키지내의 모든 클래스,인터페이스를 사용할 수 있음
//import java.sql.Date; // 패키지가 다르고 클래스의 이름이 같다면 두 클래스를 동시에 import 할 수 없음
//소스에서 많이 사용되는 클래스를 import로 처리하고, 적게사용되는 클래스를 full path로 처리하여 사용한다.
import java.util.Date;
import java.util.Calendar;
import java.util.List;

/**
 * import: 외부 패키지에 존재하는 클래스를 사용하는 방법
 * @author owner
 */
public class TestImport {
	public static void main(String[] args) {
		Date d = new Date(); //java.util.Date
		Calendar cal = null;
		List list = null;
		java.sql.Date da = null; //java.sql.Date full path의 사용
	}//main
}//class