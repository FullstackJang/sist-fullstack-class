package day1204;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleMsgServer {

	public SimpleMsgServer() throws IOException, BindException {
		// 1. 서버 소켓(PORT 열기)
		ServerSocket server = null;
		Socket client = null;
		DataOutputStream dos = null; // Java데이터(int,char,String....)를 JVM외부로 내보낼 때 사용하는 스트림
		DataInputStream dis = null;
		
		try {
			server = new ServerSocket(55555); // PORT 0 ~ 65535
			System.out.println("서버실행: 접속자가 들어오기를 기다린다.");

			// 3. 접속자 소켓이 존재한다면 접속자 소켓을 받는다.
			while (true) {

				client = server.accept();

				InetAddress ia = client.getInetAddress();

				System.out.println("접속자 있음.:" + ia.getHostAddress());

				// 스트림 꼽는건 둘다 동일 순서 4번
				// 4. 서버에 존재하는 데이터를 접속자에게 보내기 위해 "스트림을 연결"한다.
				dos = new DataOutputStream(client.getOutputStream());

				String msg = "java.net.ConnectException: Connection refused: connect";

				// 5. 데이터를 스트림 기록
				dos.writeUTF(msg); // 한글이 packet으로 전달 될 수 있게 변환 ex: 가 -> %A0%BB%FF -16진수로 바껴서 전달 된다.

				// 6. 스트림에 기록된 내용을 목적지로 분출
				dos.flush();

//				boolean flag = true;
//				dos.writeBoolean(flag);
//				dos.flush();
				
				//---------클라이언트가 보낸 값을 서버로 받기
				//client(접속자)가 보내오는 값을 받기위한 스트림
				dis = new DataInputStream(client.getInputStream());
				
				//접속자가 보내오는 값 읽기
				String revData = dis.readUTF();

				System.out.println("접속자가 보내온 데이터 :" + revData);
				
			} // end while

		} finally {
			// 8. 연결 끊기
			if (dos != null) {
				dos.close();
			}
			if (client != null) {
				server.close();
			} // end if
			if (server != null) {
				server.close();
			} // end if
		}
	}// SimpleMsgServer

	public static void main(String[] args) {

		try {
			new SimpleMsgServer();
		} catch (BindException be) {
			System.err.println("서버가 이미 실행 중 입니다."); // port가 열려 있는 경우
			be.printStackTrace();
		} catch (IOException ie) {
			System.out.println("통신에 문제발생");
			ie.printStackTrace();
		} // end catch
	}// main
}// class
