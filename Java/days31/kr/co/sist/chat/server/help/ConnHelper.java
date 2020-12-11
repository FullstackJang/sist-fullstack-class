package kr.co.sist.chat.server.help;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;

import kr.co.sist.chat.server.MultiChatServer;

public class ConnHelper extends Thread {

	private Socket client;
	private DataInputStream readStream;
	private DataOutputStream writeStream;

	private int conncnt;
	private DefaultListModel<String> dlmConnList;
	private String connIp;
	
	private JScrollPane jspConnScroll;
	private String nick;

	public ConnHelper(Socket client, int conncnt, DefaultListModel<String> dlmConnList,JScrollPane jspConnScroll) {

		this.client = client; // 소켓을 받고
		this.conncnt = conncnt; // 접속한 순서
		this.dlmConnList = dlmConnList; // 관리자창에 정보를 제공하기위한 Model 객체
		this.jspConnScroll = jspConnScroll; //스크롤바를 제어하기 위해서 

		try { // throws로 던지지 않는 이유 : server쪽에 생성자에 try catch를 하면 10명중 1명이 장애가 발생하면 10명 다 챗팅이
				// 안된다.
			// 읽기 스트림 연결
			readStream = new DataInputStream(client.getInputStream());

			// 쓰기 스트림 연결
			writeStream = new DataOutputStream(client.getOutputStream());

			//닉네임을 받는다.
			nick = readStream.readUTF();
			
			
			this.start(); // 메시지를 무한루프로 읽어들일 수 있는 상태로 만든다.
			connIp = client.getInetAddress().getHostAddress();

			StringBuilder sbServerMsg = new StringBuilder();
			sbServerMsg.append(conncnt).append("번째 접속자 접속 (").append("[").append(nick).append("접속]").append(connIp).append(")");
			dlmConnList.addElement(sbServerMsg.toString()); //관리창 접속정보 남기기
			//나를 제외한 모든 접속자에게 채팅에 참여했음을 알려준다.
			broadcast(conncnt +"번째 접속자가+ "+ nick + "을 사용하여 채팅에 참여하였습니다.");
		
			setScrollPosition();//스크롤바의 위치를 변경한다.

		} catch (IOException ie) {
			StringBuilder sbServerMsg = new StringBuilder();
			sbServerMsg.append(conncnt).append("번째 접속자에서 문제가 발생 (").append(connIp).append(")");

			dlmConnList.addElement(sbServerMsg.toString());
			setScrollPosition();//스크롤바의 위치를 변경한다.
			
			ie.printStackTrace();
		} // end catch
	}// ConnHelper

	@Override
	public void run() {

		String revMsg = "";

		try {
			while (true) {
				revMsg = readStream.readUTF();// 메시지를 읽어 들였음
				broadcast(revMsg); // 모든 접속자에게 메시지를 출력한다.
			} // end while
		} catch (IOException ie) { // 메시지를 보내거나 읽을 수 없다면 예외발생.

			// 리스트에서 this(연결이 끊어진 소켓을 가진 ChatHelper)삭제한다.
			MultiChatServer.listConn.remove(this);

			// 관리자창에 퇴실상황을 올리고
			StringBuilder sbMsg = new StringBuilder();
			sbMsg.append(nick).append("접속자가 퇴실하였습니다. (").append(connIp).append(")");

			dlmConnList.addElement(sbMsg.toString());
			setScrollPosition();//스크롤바의 위치를 변경한다.

			// 연결이 끊어진 접속자를 제외한 모든 접속자에게 퇴실 상황을 알리고
			try {
				broadcast(sbMsg.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // end catch

			ie.printStackTrace();
		} finally {
			try {
				close();
			} catch (IOException e) {
				e.printStackTrace();
			} // end catch
		} // end finally

	}// run
	

	public void setScrollPosition() {
		jspConnScroll.getVerticalScrollBar().setValue(jspConnScroll.getVerticalScrollBar().getMaximum());
	}// setScrollPosition


	/**
	 * 모든 접속자(MultiChatServer의 List에 접속자가 존재)에게 메시지를 보내는 일
	 * synchronized : method를 동시에 호출하지 못하도록 동기화 설정할 때 사용
	 * @param msg
	 * @throws IOException
	 */
	public synchronized void broadcast(String msg) throws IOException {
		
		// ChatServer에 존재하는 모든 접속자를 관리하는 List를 받아와서
		List<ConnHelper> tempList = MultiChatServer.listConn;

		ConnHelper ch = null;

		for (int i = 0; i < tempList.size(); i++) { // 접속자의 수만큼 반복

			ch = tempList.get(i);

			ch.writeStream.writeUTF(msg); // 접속자별 출력스트림에 보내온 메시지를 기록하고
			ch.writeStream.flush(); // 접속자별 출력 스트림의 내용을 분출

		} // end for

	}// broadcast

	public void close() throws IOException {

		if (readStream != null) {
			readStream.close();
		} // end if

		if (writeStream != null) {
			writeStream.close();
		} // end if

		if (client != null) {
			client.close();
		} // end if

	}// close

}// class
