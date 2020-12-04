package day1204;

import java.io.IOException;

/**
 * ServerSocket 객체가 있는 클래스를 상속했을 때
 * @author owner
 *
 */
public class Test extends TestServer {

	public Test() throws IOException {
		super(); //부모클래스에 생성자가 예외를 날리면 try/cat로는 할 수없다. super()는 첫번째 줄에서만 사용할 수 있기 때문에 따라서 throws로 해야 에러가 안난다.
		
	}//Test

	public static void main(String[] args) {
		
	}//main
}//class
