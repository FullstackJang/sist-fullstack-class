/*
   단항연산자.
   ~, !, +,-,++, --
 */

public class Operator1 {

	public static void main(String[] args) {
		
		int i = 3;
		int j = -34;

		System.out.println("~" + i + "=" + ~i); //부호변경 1증가
		System.out.println("~" + j + "=" + ~j); // 부호변경 1감소
		
		System.out.println(!(3>4));
		
		boolean flag1 = true,flag2 = false;
		
		System.out.println("!" + flag1 + "=" + !flag1);
		System.out.println("!" + flag2 + "=" + !flag2);
		
		
		System.out.println("~" + i + "=" + +i); 
		System.out.println("~" + j + "=" + +j);

		System.out.println("~" + i + "=" + -i); 
		System.out.println("~" + j + "=" + -j); 
		
		i = 1;
		j = 5;
		//전위연산 : 연산자 대상체 ;
		++i; // 1 -> 2
		--j; // 5 -> 4
		System.out.println("전위 연산 후 i:" + i + ", j:" + j );
		//후위연산: 대상체 연산자;
		i++; // 2 -> 3
		j--; // 4 -> 3
		System.out.println("후위 연산 후 i:" + i +", j:" + j);
	
		//++,--전위 연산과 후위 연산이 다른 값을 대입한다.
	
		i = 4;
		int result = 0;
		//전위: 내것 먼저. (단항 연산을 수행한 결과를 대입)
		result = ++i;
		System.out.println("전위 연산 후 result:" + result + ", i:" + i); // 5,5

		i = 4;
		result = 0;
		//후위: 남의 것 먼저.(대입 연산을 먼저 수행하고, 단항 연산 수행)
		result = i++;
		System.out.println("후위 연산 후 result:" + result + ", i:" + i); // 4,5
	}
	
}
