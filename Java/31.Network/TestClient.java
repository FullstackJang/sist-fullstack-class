package day1204;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 자신의 임의의 포트를 열고 서버에 접속하는 일
 * @author owner
 *
 */
public class TestClient {

	public TestClient() throws IOException,UnknownHostException {
			//1.(네트워크연결상 2번째) Socket생성
			Socket client = new Socket("211.238.142.34",65000); //인터넷에서 host를 찾고 65000번방으로 들어가
																//교육센터(TestServer.java)서버는 열려있으니 학원 교육센터에 오기 위해서 교육센터에 주소와 들어가는 문을 알아야한다.
			System.out.println("클라이언트 생성: 서버에 접속 시도.");
			
			client.close();
				
	}//TestClient
	
	public static void main(String[] args) {
		try {
			new TestClient();
		}catch(UnknownHostException uhe) {
			uhe.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}
	}//main
}//class