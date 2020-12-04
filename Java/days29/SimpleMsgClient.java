package day1204;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class SimpleMsgClient {

	public SimpleMsgClient() throws IOException, UnknownHostException {
		Socket client = null;
		DataInputStream dis = null; // Java의 데이터를 받기 위한 스트림
		DataOutputStream dos = null; //서버로 데이터를 보내기 위한 스트림
		
		try {
			String ip = JOptionPane.showInputDialog("아이피 입력\n 37,26,22,44,33,45,21,28,31,27,39,32,34,24,38,25,40");
			// 2. Socket생성 : 임의의 PORT를 열고, 지정한 ip주소의 컴퓨터로 찾아서 지정한 PORT에 연결
//			client = new Socket("211.238.142"+ip, 55555);
			
			//자신컴퓨터로 접속 : ip address, loopback: localhost, 127.0.0.1
//			client = new Socket("localhost",55555); // 내자신 컴퓨터로 들어갈때는 localhost로 들어가도 된다. 단, PORT번호는 알아야한다.
			System.out.println("클라이언트 실행: 서버로 찾아간다.");

			// 4. 서버에서 전달하는 값을 받기위해 "소켓에서 입력스트림"얻기
//			dis = new DataInputStream(client.getInputStream());

			// 7. 서버에서 보내오는 메시지를 읽기
			
			String revMsg = dis.readUTF(); // 분리되어 넘어온 그자를 원래대로 만드는일 %AA%F3%1D -> 가
//			System.out.println("서버에서 전달된 메세지:" + revMsg);
			String sendMsg = JOptionPane.showInputDialog(revMsg);
			
			//입력받은 메시지를 보낼 스트림 얻기
			dos = new DataOutputStream(client.getOutputStream());
			
			//메시지를 스트림에 기록
			dos.writeUTF(sendMsg);
			
			//스트림의 내용을 목적지(소켓)로 분출
			dos.flush(); 
			
						
//			boolean flag = dis.readBoolean();
//			System.out.println(flag);

		} finally {
			
			if(dos != null) {
				dos.close();
			}//end if
			if (dis != null) {
				dis.close();
			}//end if
			if (client != null) {
				client.close();
			} // end if
		}
	}// SimpleMsgClient

	public static void main(String[] args) {
		// 8. 연결 끊기
		try {
			new SimpleMsgClient();
		} catch (UnknownHostException uhe) {
			System.err.println("서버 알 수 없음");
			uhe.printStackTrace();
		} catch (IOException ie) {
			System.err.println("통신 문제 발생");
			ie.printStackTrace();
		} // end catch
	}// main
}// class
