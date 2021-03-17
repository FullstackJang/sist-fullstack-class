package day1030;

/*
 * instance variable의 접근지정자의 사용
 * public: 패키지에 상관없이 외부에서 접근 가능
 * protected: 같은 패키지의 다른 클래스에서는 사용가능 / 패키지가 다르면 상속관계의 자식클래스에서 사용가능
 * private: 내 클래스 안에서만 사용 가능
 * default: 같은 패키지의 다른 클래스에서 사용가능 / 패키지가 다르면 사용할 수 없다.
*/

public class AccessModifier {

	public int pub;
	protected int pro;
	private int pri; // 내 클래스안에서 사용되지 않으면 외부에서 절대 사용 될 수 없다.
	int def;

	public static void main(String[] args) {

		//1.객체화
		AccessModifier am = new AccessModifier();
		//2. 변수의 사용: 변수가 정의된 클래스 안에서는 접근지정자에 상관없이
		//모두 사용 가능
		System.out.println("AccessModifier: " + am.pub + "/" + am.pro + "/" + am.pri + "/" + am.def );
		
		
	}
}
