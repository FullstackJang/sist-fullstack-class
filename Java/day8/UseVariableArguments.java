package day1102;

/*
 * 가변인자형(Variable Arguments)의 사용
 * method를 호출할 때 입력값(Arguments)를 동적으로 몇개를 넣어도 호출 가능한 method형태
 * V.A(Variable Arguments)는 parameter를 정의할때 가장 마지막에만 정의할 수 있다.
 * */
public class UseVariableArguments {

	public void testVA(int ... param) {
		//System.out.println(param); 배열은 참조형 데이터형이므로 주소가 출력된다.
		for(int val : param) {
			System.out.println(val);
		}//end for
	}//testVA
	
	
	//V.A예 대한 매개변수는 가장 마지막에만 사용할 수 있다. 
//	public int sumAge(int ... paramAge, char c) {	(X)
	public int sumAge(char c, int ...paramAge) { //	(O)
		int sum = 0;
		
		for(int inputAge : paramAge) {
			sum += inputAge;
		}//end for
		
		return sum;
	}//sumAge
	
	public static void main(String[] args) {

		UseVariableArguments uva = new UseVariableArguments();
		uva.testVA(1,2,3,4,5,6,7,8,9);
		//uva.testVA();  입력값을 다양하게 설정하여 호출 가능.
		uva.testVA(1);
		
		
		int sumAge = uva.sumAge('a',10,20,30,40);
		System.out.println(sumAge);
		
	}//main
}//class
