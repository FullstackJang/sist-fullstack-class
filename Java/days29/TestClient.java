package day1204;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �ڽ��� ������ ��Ʈ�� ���� ������ �����ϴ� ��
 * @author owner
 *
 */
public class TestClient {

	public TestClient() throws IOException,UnknownHostException {
			//1.(��Ʈ��ũ����� 2��°) Socket����
			Socket client = new Socket("211.238.142.34",65000); //���ͳݿ��� host�� ã�� 65000�������� ��
																//��������(TestServer.java)������ ���������� �п� �������Ϳ� ���� ���ؼ� �������Ϳ� �ּҿ� ���� ���� �˾ƾ��Ѵ�.
			System.out.println("Ŭ���̾�Ʈ ����: ������ ���� �õ�.");
			
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