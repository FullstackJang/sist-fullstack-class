package day1104;

public class UseString {

	public static void main(String[] args) {

		String str = "ABCD"; // 기본형 형식의 사용
		String str1 = new String("ABCD"); // 참조형 형식의 사용
		
		//문자열비교 == 비교
		//기본형형식은 변수에 문자열저장소의 주소를 그대로 저장

		System.out.println(str +" 기본형 형식 == 비교");
		if(str == "ABCD") {
			System.out.println("같다.");
		}//end if
		else {
			System.out.println("다르다.");
		}//end else
		
		System.out.println(str + "참조형 형식 == 비교");
		if(str1 == "ABCD") {
			System.out.println("같다.");
		}//end if
		else {
			System.out.println("다르다");
		}//end else

		System.out.println("---------------------");

		//문자열은 생성방법과 상관없이 동일한 비교를 하기 위해 equals method를  사용한다.
		//문자열변수명.equals("비교할 문자열");

		System.out.println(str + "equals method 비교");
		if(str.equals("ABCD")) {
			System.out.println("같다");
		}
		else {
			System.out.println("다르다");
		}//end else
		
		System.out.println(str1 + "equals method 비교");
		if(str1.equals("ABCD")) {
			System.out.println("같다");
		}
		else {
			System.out.println("다르다");
		}//end else
		
		//"문자열은 String class에서 제공하는 모든 method를 호출(사용) 할 수 있다.
		System.out.println("안녕하세요?".length());
		
		String temp = "ABCD";
		String mail = new String("test@hanmail.net");
		
		System.out.println(temp + "의 길이 " + temp.length());
		System.out.println(mail + "의 길이" + mail.length());
		
		temp = "AbcdEf";
		System.out.println(temp + "를 모두 대문자로" + temp.toUpperCase());
		System.out.println(temp + "를 모두 소문자로" + temp.toLowerCase());

		System.out.println(temp + "에서 'd'의 인덱스 " + temp.indexOf('d'));
		System.out.println(temp + "에서 'g'의 인덱스 " + temp.indexOf('g'));

		//indexOf에 문자열을 입력하면 일치하는 문자열이 있을 때 가장 처음 문자열에 대한 인덱스를 반환
		//indexOf("찾을문자열"); // 찾는 방향이 L -> R
		System.out.println(temp + "에서 'cdE'의 인덱스 " + temp.indexOf("cdE"));
		
		temp = "JavaOracle";
		//index 0123456789
		//lastIndexOf는 R -> L의 순서로 문자열을 찾는다.
		System.out.println(temp +"에서 처음 'a'의 인덱스 " + temp.indexOf("a"));
		System.out.println(temp +"에서 마지막'a'의 인덱스"+ temp.lastIndexOf("a"));
		

	
		temp = "test@test.com";
		//indexOf를 사용하여 temp변수에 들어있는 메일주소가 유효한지 판단하는 코드 작성
		//코드 작성. '@'과 '.'이 있으면서 a@b.com
		System.out.println(temp);
		if(temp.length() > 6 && temp.indexOf("@") != -1 && temp.indexOf(".") != -1) {
			System.out.println("정상적 메일 주소");
		}
		else {
			System.out.println("비정상적 메일주소");
		}
		
		//5.인덱스에 해당하는 문자 하나 얻기 : charAt(인덱스)
		//test@hanmail.net
		System.out.println(mail +"에서 8번째 인덱스에 해당하는 문자: " + mail.charAt(4));
		System.out.println(mail +"에서 '@'에 해당하는 문자얻기: " + mail.charAt(mail.indexOf("@")));
		
		//6.substring();
		temp = "김밥을 앙냥냥냥 먹었습니다.";
		System.out.println(temp);
		//가장 마지막 문자 자리에 문자열의 null문자가 들어간다.
		//끝 인덱스에 해당하는 문자가 잘려지지 않는다.
		//substring(시작인덱스,끝인덱스+1)
		System.out.println(temp.substring(4,8));
		System.out.println(temp.substring(9,15));
		
		
		//mail변수에서 메일 주소를 잘라서 출력
		//test@hanmail.net
		//메일주소@ 도메인주소
		System.out.println("메일주소: " + mail.substring(0,mail.indexOf("@")));
		System.out.println("도메인주소: " + mail.substring(mail.indexOf("@")+1,mail.length()));
		
		//substring(시작인덱스); 시작인덱스에서부터 끝인덱스까지 잘라준다.
		System.out.println("도메인주소: " + mail.substring(mail.indexOf("@")+1));
		
		//문자열 붙이기
		String temp1 = "오늘은";
		System.out.println(temp1.concat(" 수요일입니다."));
		
		//문자열의 앞뒤 공백 자르기
		String temp2 = "   장 일규    ";
		System.out.println("["+temp2+"]"+"["+temp2.trim()+"]"); 
		
		//입력한 문자열로 시작했는지?
		String temp3 = "서울시 마포구";
		System.out.println(temp3.startsWith("서울"));
		
		
	}	//main
}//class
