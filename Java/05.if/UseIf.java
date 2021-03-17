/*
 	단일 if문 : 조건에 맞을 때에만 코드를 실행해야 할 때.

 	if( 조건식 ) {
 		조건에 맞을 때 수행 될 문장들...
 	}
  
 */


public class UseIf {

	public static void main(String[] args) {

		int i = 27;
		
		if(i < 0) {
			i = -i;
		}// end if
		
		System.out.println("i는 " + i);
		
		System.out.println("------------------------------------");
		
		if( (i >= 0) && (i<=100)) {
			System.out.println(i);
		}//end if
		
		System.out.println("감사합니다.");
		
	}//main
}// class