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
		// 1. ���� ����(PORT ����)
		ServerSocket server = null;
		Socket client = null;
		DataOutputStream dos = null; // Java������(int,char,String....)�� JVM�ܺη� ������ �� ����ϴ� ��Ʈ��
		DataInputStream dis = null;
		
		try {
			server = new ServerSocket(55555); // PORT 0 ~ 65535
			System.out.println("��������: �����ڰ� �����⸦ ��ٸ���.");

			// 3. ������ ������ �����Ѵٸ� ������ ������ �޴´�.
			while (true) {

				client = server.accept();

				InetAddress ia = client.getInetAddress();

				System.out.println("������ ����.:" + ia.getHostAddress());

				// ��Ʈ�� �Ŵ°� �Ѵ� ���� ���� 4��
				// 4. ������ �����ϴ� �����͸� �����ڿ��� ������ ���� "��Ʈ���� ����"�Ѵ�.
				dos = new DataOutputStream(client.getOutputStream());

				String msg = "java.net.ConnectException: Connection refused: connect";

				// 5. �����͸� ��Ʈ�� ���
				dos.writeUTF(msg); // �ѱ��� packet���� ���� �� �� �ְ� ��ȯ ex: �� -> %A0%BB%FF -16������ �ٲ��� ���� �ȴ�.

				// 6. ��Ʈ���� ��ϵ� ������ �������� ����
				dos.flush();

//				boolean flag = true;
//				dos.writeBoolean(flag);
//				dos.flush();
				
				//---------Ŭ���̾�Ʈ�� ���� ���� ������ �ޱ�
				//client(������)�� �������� ���� �ޱ����� ��Ʈ��
				dis = new DataInputStream(client.getInputStream());
				
				//�����ڰ� �������� �� �б�
				String revData = dis.readUTF();

				System.out.println("�����ڰ� ������ ������ :" + revData);
				
			} // end while

		} finally {
			// 8. ���� ����
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
			System.err.println("������ �̹� ���� �� �Դϴ�."); // port�� ���� �ִ� ���
			be.printStackTrace();
		} catch (IOException ie) {
			System.out.println("��ſ� �����߻�");
			ie.printStackTrace();
		} // end catch
	}// main
}// class
