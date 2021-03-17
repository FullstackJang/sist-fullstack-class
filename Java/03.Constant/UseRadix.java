/*
 	코딩창에서 여러 진수 사용하기
 	0숫자 - 8진수 (Octal)
 	숫자 - 10진수 (Decimal)
 	0x숫자 - 16진수 (Hex)
*/
public class UseRadix {

	public final int a = 1;
	
	public static void main(String[] args) {
		
		int i = 012; // 8진수
		int j = 10; // 10진수
		int k = 0xa; // 16진수
		
		System.out.println(i + j + k); // 30		

	}
	
}
