package day1112;

/**
 * 수학관련 클래스(생성자가 없음)
 * @author owner
 *
 */
public class UseMath {


	public UseMath() {

		//Math m = new Math(); 생성자가 없으므로 객체화될 수 없음

		//		//반올림
		//		double d = 10.5;
		//		double d1 = 10.2;
		//		double d2 = 10.9;
		//		System.out.println(d + "를 반올림 " + Math.round(d)); //10.5를 반올림 11
		//		System.out.println(d1 + "를 올림 " + Math.ceil(d1)); //10.2를 반올림 11.0 //소수점이하 첫번째 자리가 0이 아니라면 올림
		//		System.out.println(d2 + "를 내림 " + Math.floor(d2));
		//		System.out.println(d2 + "를 절삭 " + (int)d2);
		//		
		//		//절대값
		//		int i = -11;
		//		System.out.println(i + "의 절대값: "+ Math.abs(i));
		//		
		//		//난수
		//		d = Math.random(); //임의 수
		//		System.out.println("난수:" + d);
		//		System.out.println("범위 난수:" + d * 10); // 발생 수 *(곱하기) 범위
		//		System.out.println("범위 난수를 정수:" + (int)(d * 10)); //(강제형변환)(발생 수 *(곱하기) 범위)
		//		System.out.println("범위 난수를 정수:" + ((int)(d * 5)+1));
		//		
		//		// 대문자 A(65)~Z(90)중 임의 하나 얻기
		//		int d3 = 65;
		//		System.out.println((char)((int)(Math.random() * 26) + 65));



	}//UseMath

	public char[] createPassword() {

		char[] tempPassword = new char[8];
		int flagN = 0;
		//임의의 숫자,대문자,소문자로 구성된 8자리의 비밀번호를 생성하여 배열에 넣고 반환하여 
		//(97~122) 소문자  (65~90) 대문자 (48~57) 숫자
		//		for(int i =0; i< tempPassword.length; i++) {
		//			flagN = (int)(Math.random()*3); //0,1,2중 하나가 발생
		//			switch(flagN) {
		//			
		//			case 0: tempPassword[i] = (char)( (Math.random() *10) + 48); break;
		//			case 1: tempPassword[i] = (char)( (Math.random() *26) + 65);break;
		//			case 2: tempPassword[i] = (char)( (Math.random() *26) + 97);break;
		//		}

		//숫자 8개를 위해서 i--하기 때문에 몇번을 돌려야할지 모름
		//		int tempNum = 0;
		//		for(int i = 0; i < tempPassword.length; i++) {
		//			tempNum = (int)(Math.random()*123);
		//
		//			if(tempNum >= 97 && tempNum <= 122 || tempNum >= 65 && tempNum <= 90 || tempNum >= 48 && tempNum <= 57) {
		//				tempPassword[i] = (char) tempNum;
		//			}
		//			else {
		//				i--; //공백때문에 계속 마이너스함
		//			}
		//		}

		String temp = "1234567890QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
		for(int i =0; i < tempPassword.length; i++) {
			//문자열의 길이만큼 난수를 발생시켜 해당 인덱스에 문자를 꺼내 배열에 넣기
			tempPassword[i] = temp.charAt((int)(Math.random()*temp.length()));		
		}//end for
		
		return tempPassword; //반환
	}

	public static void main(String[] args) {
		//		new UseMath();

		//출력
		char[] arr = new UseMath().createPassword();

		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}

	}//main
}//class
