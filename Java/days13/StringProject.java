package days12;

// 주민번호를 입력받아 유효성 검사.
// 객체가 생성되면 인스턴스 변수에 주민버호를 저장한다.
// 1.저장된 주민번호의 글자수가 14자이면 true 그렇지 않으면 false 반환하는 메소드
// 2.저장된 주민번호의 7번째 자리에 '-'이 존재하면 true 그렇지 않으면 false를 반환하는 method
// 3.생년월일을 연산하여 String으로 반환하는 method 반환값형태:"1998년 1월1일"
// 4.나이를 연산하여 int로 반환하는 method 
// 5.성별을 연산하여 String으로 반환하는 method 반환값형태 남자 or 여자
// 1,2-1900년대생/  3,4-2000년대생 / 5,6-1900년대생 외국인 / 7,8-2000년대생 외국인
// 0,9-1800년대생
// 6번 띠를 구하여 String으로 반환하는 method

class Privacy{

	String securityNumber; //주민번호

	public Privacy(String securityNumber) {
		this.securityNumber = securityNumber; //주민번호 init
	}//생성자

	//Solve1 저장된 주민번호의 글자수가 14자이면 true 그렇지 않으면 false 반환하는 메소드
	public boolean snAvailable(){
		boolean flag = (securityNumber.length() == 14) ? true : false; //주민번호가길이가 14랑 같냐? 응 : 아니

		return flag;
	}//snAvailable

	//Solve2 저장된 주민번호의 7번째 자리에 '-'이 존재하면 true 그렇지 않으면 false를 반환하는 method
	public boolean hyphenCheck() {
		boolean flag = (securityNumber.contains("-") ? true : false); //주민번호에 -를 포함하냐? 응 : 아니

		return flag;
	}//hyphenCheck

	// 3.생년월일을 연산하여 String으로 반환하는 method 반환값형태:"1998년 1월1일"
	public String myBirthday() {
		// 1,2-1900년대생/  3,4-2000년대생 / 5,6-1900년대생 외국인 / 7,8-2000년대생 외국인
		// 0,9-1800년대생
		String yearmd = securityNumber.substring(0,6); // 880101
		String year = " "; 
		String myYear,myMonth,myDay = " "; 
		if((securityNumber.charAt(0)-48) == 0) { //00년대 생이면
			year = "20" + yearmd;
		}
		else { // 90년대 생이면
			year = "19" + yearmd;
		}

		myYear = year.substring(0,4)+"년"; // yyyy + "년"
		myMonth = year.substring(5,6)+"월"; // mm + '"월"
		myDay = year.substring(6,8)+"일"; // dd + "일"
		year = myYear + myMonth + myDay; // 문자열 연산
		return year;

	}//myBirthday

	// 4.나이를 연산하여 int로 반환하는 method 
	public int myAge() {

		int age = Integer.parseInt(securityNumber.substring(0,2)); //문자열인 주민번호 앞두자리 "YY" 숫자로 형변환

		int myage = 0;

		if((securityNumber.charAt(0)-48) == 0) { 
			myage = 2020-(2000+age)+1;
		}
		else {
			myage = 2020-(1900+age)+1;
		}

		return myage;
	}//myAge

	//Solve5 성별을 연산하여 String으로 반환하는 method 반환값형태 남자 or 여자
	// 1,2-1900년대생/  3,4-2000년대생 / 5,6-1900년대생 외국인 / 7,8-2000년대생 외국인  0,9-1800년대생

	public String myGender() {
		String gender = "여자";
		int genderValue = Integer.parseInt(securityNumber.substring(7,8))%2;

		if(genderValue == 1) {
			gender = "남성";
		}
		else {
			gender = "여성";
		}
		return gender;
	}//myGender


	//Solve6 띠를 구하여 String으로 반환하는 method
	/*
	0: 원숭이, 1: 닭, 2: 개, 3: 돼지, 4: 쥐, 5: 소,	//10월27일 UseElseIf.java 활용
	6: 호랑이, 7: 토끼, 8: 용, 9: 뱀, 10: 말, 11: 양
	 */
	public String myZodiac() {
		
		String myYear = securityNumber.substring(0,2);
		if((securityNumber.charAt(0)-48) == 0) { //00년대 생이면
			myYear = "20" + myYear;
		}
		else { // 90년대 생이면
			myYear = "19" + myYear;
		}
		int integerYear = Integer.parseInt(myYear);
		
		String[] zodiac = {"원숭이","닭","개","돼지","쥐","소","호랑이","토끼","용","뱀","말","양"};
		String myZodiac = " ";
		
		if(integerYear%12 == 0) myZodiac = zodiac[0];
		else if(integerYear%12 == 1)myZodiac = zodiac[1];
		else if(integerYear%12 == 2)myZodiac = zodiac[2];
		else if(integerYear%12 == 3)myZodiac = zodiac[3];
		else if(integerYear%12 == 4)myZodiac = zodiac[4];
		else if(integerYear%12 == 5)myZodiac = zodiac[5];
		else if(integerYear%12 == 6)myZodiac = zodiac[6];
		else if(integerYear%12 == 7)myZodiac = zodiac[7];
		else if(integerYear%12 == 8)myZodiac = zodiac[8];
		else if(integerYear%12 == 9)myZodiac = zodiac[9];
		else if(integerYear%12 == 10)myZodiac = zodiac[10];
		else if(integerYear%12 == 11)myZodiac = zodiac[11];

		return myZodiac;
	}//myZodiac

}//class

public class StringProject {

	public static void main(String[] args) {
		
		// 객체 인스턴스화
		// new를 통해 heap에 객체 생성
		// 생성자 실행
		// person1에는 new통해 heap에 생성된 인스턴스 객체의 주소를 가리키고 있다.
		Privacy person1 = new Privacy("910723-1234567");
		
		
		if(person1.snAvailable()) { //주민번호 유효숫자 확인
			if(person1.hyphenCheck()) { //하이픈 확인
				String birth = person1.myBirthday(); //YYYY년MM월DD일
				int age = person1.myAge();  // 나이
				String gender = person1.myGender(); // 성별
				String zodiac = person1.myZodiac(); // 띠
				System.out.printf("생년월일:%s\n나이:%d\n성별:%s\n띠:%s",birth,age,gender,zodiac);
			} else {
				System.out.println("-을 확인하세요.");
			}//end else

		} else {
			System.out.println("주민번호의 자릿수 확인");
		}//end else
	}//main
}//class
