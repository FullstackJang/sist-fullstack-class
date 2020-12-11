package day1211;

/**
 * 람다식에서 사용할 수 있는 인터페이스는 SAM(Single Abstract Method)이어야 한다.
 * annotation을 사용하면 인터페이스가 하나의 abstract method만 가질 수 있게된다.
 * @FunctionalInterface 는 추상메소드를 하나만 가지고 있어야한다.
 * @author owner
 */
@FunctionalInterface
public interface Lamda1 {

	public void test();
	
}//interface