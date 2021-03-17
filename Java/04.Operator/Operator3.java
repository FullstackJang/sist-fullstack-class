/*
  쉬프트 연산자(비트밀기연산)
  <<, >>, >>>

 */
package a1026;

public class Operator3 {

	public static void main(String[] args)
	{
		
		int i = 30;
		
		System.out.println(i + "<< = " + (i << 2));
		// 0001 1110 << 2 = 0111 1000
		
		i = 128;
		System.out.println(i + ">> 3 =" + (i >>3));
		// 1000 0000 >> 3 = 0001 0000
	
		i = 96;
		System.out.println(i + ">>> 4 = " + (i >>> 4));	
		// 0110 0000 >>> 4 = 0000 0110
		
		i = 1;
		System.out.println(i + "<< 31 = " + (i << 31) );
		//  0000 0000 0000 0000 0000 0000 0000 0000 << 1
		//= 1000 0000 0000 0000 0000 0000 0000 0000

		i = -1;
		System.out.println(i + ">> 10 = " + (i >> 10) );
		// 1111 1111 1111 1111 1111 1111 1111 1111 >> 10
		
		i = -1;
		System.out.println(i + ">>> =" + (i >>> 1));
		// 0111 1111 1111 1111 1111 1111 1111 1111 >>> 1
		
	}//main
}//class
