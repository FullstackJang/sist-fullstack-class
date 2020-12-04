package day1204;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server : 1. PORT�� ���� �����ڰ� �����⸦ ����ϴ� �� 2. (�帧��3��)������ ������ ������ �㰡�Ͽ� ������ ������ �޴�
 * ��
 * 
 * @author owner
 */

public class TestServer {

	public TestServer() throws IOException, BindException {

		// 1. ServerSocket ���� : �� �� PORT�� ������.(0~65535) (port�� �����ٰ� ��ȭ���� �����°� �ƴϴ�.)
		ServerSocket server = new ServerSocket(65000);
		System.out.println("��Ʈ ���� ����");
		
		//2. ������ ������ ������ ������ ������ �޴´�.
		Socket client = server.accept(); //�������.
		System.out.println("������ ���� " + client);
		
		//������ �ݴ´�.
		server.close();
	}// TestServer

	public static void main(String[] args) {
		try {
			new TestServer();
		}catch(BindException be) {
			System.out.println("��Ʈ�� �̹� ����� �Դϴ�.");
			be.printStackTrace();
		}catch (IOException ie) {
			ie.printStackTrace();
		}//end catch
	}// main
}// class
