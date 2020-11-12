package day1112;

/**
 * 상속을 하지 못하게 막는 클래스
 * @author owner
 *
 */
public final class FinalSuper{

//	public final void methodA() {  // method의 접근지정자에 final이 있다면 자식클래스에서 Override 할 수 없다.
	public void methodA() {
		System.out.println("methodA");
	}//methodA
	
	public void methodB() {
		System.out.println("methodB");
	}//methodB
	
}
