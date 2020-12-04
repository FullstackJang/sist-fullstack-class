package day1204;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server : 1. PORT를 열고 접속자가 들어오기를 대기하는 일 2. (흐름상3번)접속자 소켓이 들어오면 허가하여 접속자 소켓을 받는
 * 일
 * 
 * @author owner
 */

public class TestServer {

	public TestServer() throws IOException, BindException {

		// 1. ServerSocket 생성 : 이 때 PORT가 열린다.(0~65535) (port가 열린다고 방화벽이 열리는게 아니다.)
		ServerSocket server = new ServerSocket(65000);
		System.out.println("포트 열기 성공");
		
		//2. 접속자 소켓이 들어오면 접속자 소켓을 받는다.
		Socket client = server.accept(); //어서오세요.
		System.out.println("접속자 있음 " + client);
		
		//서버를 닫는다.
		server.close();
	}// TestServer

	public static void main(String[] args) {
		try {
			new TestServer();
		}catch(BindException be) {
			System.out.println("포트가 이미 사용중 입니다.");
			be.printStackTrace();
		}catch (IOException ie) {
			ie.printStackTrace();
		}//end catch
	}// main
}// class
