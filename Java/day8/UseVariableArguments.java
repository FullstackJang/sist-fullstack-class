package day1102;

/*
 * ����������(Variable Arguments)�� ���
 * method�� ȣ���� �� �Է°�(Arguments)�� �������� ��� �־ ȣ�� ������ method����
 * V.A(Variable Arguments)�� parameter�� �����Ҷ� ���� ���������� ������ �� �ִ�.
 * */
public class UseVariableArguments {

	public void testVA(int ... param) {
		//System.out.println(param); �迭�� ������ ���������̹Ƿ� �ּҰ� ��µȴ�.
		for(int val : param) {
			System.out.println(val);
		}//end for
	}//testVA
	
	
	//V.A�� ���� �Ű������� ���� ���������� ����� �� �ִ�. 
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
		//uva.testVA();  �Է°��� �پ��ϰ� �����Ͽ� ȣ�� ����.
		uva.testVA(1);
		
		
		int sumAge = uva.sumAge('a',10,20,30,40);
		System.out.println(sumAge);
		
	}//main
}//class
