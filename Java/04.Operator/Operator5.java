package a1026;

/*
 	논리연산자:
 	일반논리:
 	&&: 전항과 후항이 모두 true일 때만 true반환
 	||: 전항과 후항이 모두 false일 때만 false반환
 	
 	비트논리:
 	&: 상위비트와 하위비트 모두 1인경우 1내림
 	|: 상위비트와 하위비트 모두 0인경우 0내림
 	^(XOR): 상위비트와 하위비트 둘 중 하나만 1인 경우 1내림
 */

public class Operator5 {

	public static void main(String[] args) {

		boolean flag1 = true, flag2=false, flag3=true, flag4=false;
		System.out.println((10 < 26) && (10 > 5));
		System.out.println("---------&&---------");
		//전항이 false이면, 후항에 상관없이 false가 나오기 때문에 후항을 계산하지 않는다.
		System.out.println(flag1 + "&&" + flag3 + "=" + (flag1 && flag3));//true
		System.out.println(flag1 + "&&" + flag2 + "=" + (flag1 && flag2));//false
		System.out.println(flag2 + "&&" + flag3 + "=" + (flag2 && flag3));//false
		System.out.println(flag2 + "&&" + flag4 + "=" + (flag2 && flag4));//false

		System.out.println("---------||---------");
		//전항이 true이면 후항에 상관없이true가 나오기 때문에 후항을 계산하지 않는다.
		System.out.println(flag1 + "||" + flag3 + "=" + (flag1 || flag3));//true
		System.out.println(flag1 + "||" + flag2 + "=" + (flag1 || flag2));//true
		System.out.println(flag2 + "||" + flag3 + "=" + (flag2 || flag3));//true
		System.out.println(flag2 + "||" + flag4 + "=" + (flag2 || flag4));//false


		System.out.println("------------------");
		flag1=true; //전항저장
		flag2=true; //후항저장
		flag3=true; //연산결과

		//전항이 false라면 후항을 계싼하지 않아 후항을 저장한 flag2변수에는 true가 그대로 들어가 있다.
		flag3 = (flag1=3<2) && (flag2 = 4 > 5);
		System.out.println("전항:" + flag1 + ",후항:" + flag2 + ", 연산결과:" + flag3 );
		System.out.println();
		
		System.out.println("--------비트논리----------");
		
		int i = 20;
		int j = 19;
		System.out.println(i + "&" + "=" + (i & j));
		// 0001 0100 & 0001 0011 = 0001 0000
		
		i = 17;
		j = 13;
		
		System.out.println(i + "|" + j + "=" + (i|j));
		// 0001 0001 | 0000 1101 = 0001 1101
		
		System.out.println(i + "^" + j + "=" + (i^j));
		// 0001 0001 ^ 0000 1101 = 0001 1100
		
	}
}
