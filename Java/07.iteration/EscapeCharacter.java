package day1029;

/*
 * 특수문자의 사용
 * 문자열 안에서 \로 시작하는 기능을 가진 문자
 * 
 * */

public class EscapeCharacter {
	public static void main(String[] args) {
	
		System.out.println("\"안녕\"");// "안녕"
		System.out.println("c:\\dev\\env.bat");// c:\dev\env.bat
		
		//\r - return: 커서를 앞으로 보낸다.(단독으로 사용하면 줄변경)
		//단독으로 사용하여 줄을 변경할 일이 있다면 \n만 사용하여 모든 OS에서 동작할 수 있도록 한다.
		System.out.println("안\r\n녕"); //줄변경
		
		System.out.println("안\t녕"); //tab
		System.out.println("안\'녕\'"); // '을 출력하고 싶을때
		System.out.println("안녕\b"); 
	}
}
