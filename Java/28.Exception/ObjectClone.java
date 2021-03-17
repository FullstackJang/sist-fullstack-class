package day1127;

/**
 * 객체 복제
 * 모든 객체는 clone()를 호출할 수 있으나 복제되지 않는다.
 *  clone()은 protected이므로 복제하려는 클래스안에서만 복제된다.
 * @author owner
 */
public class ObjectClone implements Cloneable{
	private int year;
	private String name;

	public ObjectClone() {
		year = 2020;
		name = "류수정";
	}//ObjectClone
	
	public static void main(String[] args) {
		
		//1. 복제하려는 객체를 생성
		ObjectClone oc = new ObjectClone();
		
		//2. 복제
		//clone()method가 컴파일예외를 throws하고 있으므로개발자는 해당 예외를 반드시 try~catch로 잡아서 처리해야한다.
		//객체의 상태를 저장해야할 때 사용
		try {
		ObjectClone oc1 = (ObjectClone)oc.clone();
		System.out.println("복제 되었습니다.");
		System.out.println(oc + "/" + oc1);

		oc.year = 1010;
		oc.name = "테스트";
		oc1.year = 2010;
		oc1.name = "테스트1";
		
		System.out.println(oc.year + "/" + oc.name);
		System.out.println(oc1.year + "/" + oc1.name);
		
		}catch(CloneNotSupportedException cnse) {
		}//end catch
		
		//forName()가 ClassNotFoundException을 throws하고 있으므로 method를 호출하는 곳에서 try~catch로 예외를 잡아서 처리해야한다.
		try {
			Class str = Class.forName("day1127.ObjectClone");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}//main
}//class
