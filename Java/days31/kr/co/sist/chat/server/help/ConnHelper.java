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

		this.client = client; // ������ �ް�
		this.conncnt = conncnt; // ������ ����
		this.dlmConnList = dlmConnList; // ������â�� ������ �����ϱ����� Model ��ü
		this.jspConnScroll = jspConnScroll; //��ũ�ѹٸ� �����ϱ� ���ؼ� 

		try { // throws�� ������ �ʴ� ���� : server�ʿ� �����ڿ� try catch�� �ϸ� 10���� 1���� ��ְ� �߻��ϸ� 10�� �� ê����
				// �ȵȴ�.
			// �б� ��Ʈ�� ����
			readStream = new DataInputStream(client.getInputStream());

			// ���� ��Ʈ�� ����
			writeStream = new DataOutputStream(client.getOutputStream());

			//�г����� �޴´�.
			nick = readStream.readUTF();
			
			
			this.start(); // �޽����� ���ѷ����� �о���� �� �ִ� ���·� �����.
			connIp = client.getInetAddress().getHostAddress();

			StringBuilder sbServerMsg = new StringBuilder();
			sbServerMsg.append(conncnt).append("��° ������ ���� (").append("[").append(nick).append("����]").append(connIp).append(")");
			dlmConnList.addElement(sbServerMsg.toString()); //����â �������� �����
			//���� ������ ��� �����ڿ��� ä�ÿ� ���������� �˷��ش�.
			broadcast(conncnt +"��° �����ڰ�+ "+ nick + "�� ����Ͽ� ä�ÿ� �����Ͽ����ϴ�.");
		
			setScrollPosition();//��ũ�ѹ��� ��ġ�� �����Ѵ�.

		} catch (IOException ie) {
			StringBuilder sbServerMsg = new StringBuilder();
			sbServerMsg.append(conncnt).append("��° �����ڿ��� ������ �߻� (").append(connIp).append(")");

			dlmConnList.addElement(sbServerMsg.toString());
			setScrollPosition();//��ũ�ѹ��� ��ġ�� �����Ѵ�.
			
			ie.printStackTrace();
		} // end catch
	}// ConnHelper

	@Override
	public void run() {

		String revMsg = "";

		try {
			while (true) {
				revMsg = readStream.readUTF();// �޽����� �о� �鿴��
				broadcast(revMsg); // ��� �����ڿ��� �޽����� ����Ѵ�.
			} // end while
		} catch (IOException ie) { // �޽����� �����ų� ���� �� ���ٸ� ���ܹ߻�.

			// ����Ʈ���� this(������ ������ ������ ���� ChatHelper)�����Ѵ�.
			MultiChatServer.listConn.remove(this);

			// ������â�� ��ǻ�Ȳ�� �ø���
			StringBuilder sbMsg = new StringBuilder();
			sbMsg.append(nick).append("�����ڰ� ����Ͽ����ϴ�. (").append(connIp).append(")");

			dlmConnList.addElement(sbMsg.toString());
			setScrollPosition();//��ũ�ѹ��� ��ġ�� �����Ѵ�.

			// ������ ������ �����ڸ� ������ ��� �����ڿ��� ��� ��Ȳ�� �˸���
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
	 * ��� ������(MultiChatServer�� List�� �����ڰ� ����)���� �޽����� ������ ��
	 * synchronized : method�� ���ÿ� ȣ������ ���ϵ��� ����ȭ ������ �� ���
	 * @param msg
	 * @throws IOException
	 */
	public synchronized void broadcast(String msg) throws IOException {
		
		// ChatServer�� �����ϴ� ��� �����ڸ� �����ϴ� List�� �޾ƿͼ�
		List<ConnHelper> tempList = MultiChatServer.listConn;

		ConnHelper ch = null;

		for (int i = 0; i < tempList.size(); i++) { // �������� ����ŭ �ݺ�

			ch = tempList.get(i);

			ch.writeStream.writeUTF(msg); // �����ں� ��½�Ʈ���� ������ �޽����� ����ϰ�
			ch.writeStream.flush(); // �����ں� ��� ��Ʈ���� ������ ����

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
