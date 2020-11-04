package day1104;

/**
 * 호출하는 객체의 주소로 변경되는 this keyword의 사용
 * @author owner
 *
 */
public class UseThisKeyword {
	int i;
	public void useInstance(int i, UseThisKeyword utk) {
		//i=i; //지역변수의 이름과 instance 변수의 이름이 같다면 지역변수를 먼저 사용한다.
		
		utk.i = i; //instance 변수와 지역변수를 구분하기위해 인스턴스변수명 앞에 객체명을 기술한다.
		//위와 같이 하면 코드가 길어지고 가독성이 안좋다.
		
		System.out.println("stack i =" + i);
	}
	
	
	/**
	 * this라는 키워드를 사용하면 method를 호출 할 때 사용된 객체의 주소로 this가 변경된다.
	 * t.method(); this는 t객체의 주소로 변경된다.
	 * @param i
	 */
	public void UseThis(int i) {
//		System.out.println(this); //this는 method를 호출하는 객체의 주소로 변경된다.
		this.i = i;
	}//useThis
	
	public static void main(String[] args) {
		
		UseThisKeyword utk = new UseThisKeyword();
		UseThisKeyword utk1 = new UseThisKeyword();
		System.out.println(utk + "/" + utk1);
		utk.UseThis(20);
		utk1.UseThis(200);
		System.out.println(utk.i+"/" + utk1.i);
//		utk.useInstance(2020, utk);
//		System.out.println("main i=" + utk.i);
		
	}//main
}//class
