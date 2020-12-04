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
		DataInputStream dis = null; // Java�� �����͸� �ޱ� ���� ��Ʈ��
		DataOutputStream dos = null; //������ �����͸� ������ ���� ��Ʈ��
		
		try {
			String ip = JOptionPane.showInputDialog("������ �Է�\n 37,26,22,44,33,45,21,28,31,27,39,32,34,24,38,25,40");
			// 2. Socket���� : ������ PORT�� ����, ������ ip�ּ��� ��ǻ�ͷ� ã�Ƽ� ������ PORT�� ����
//			client = new Socket("211.238.142"+ip, 55555);
			
			//�ڽ���ǻ�ͷ� ���� : ip address, loopback: localhost, 127.0.0.1
//			client = new Socket("localhost",55555); // ���ڽ� ��ǻ�ͷ� ������ localhost�� ���� �ȴ�. ��, PORT��ȣ�� �˾ƾ��Ѵ�.
			System.out.println("Ŭ���̾�Ʈ ����: ������ ã�ư���.");

			// 4. �������� �����ϴ� ���� �ޱ����� "���Ͽ��� �Է½�Ʈ��"���
//			dis = new DataInputStream(client.getInputStream());

			// 7. �������� �������� �޽����� �б�
			
			String revMsg = dis.readUTF(); // �и��Ǿ� �Ѿ�� ���ڸ� ������� ������� %AA%F3%1D -> ��
//			System.out.println("�������� ���޵� �޼���:" + revMsg);
			String sendMsg = JOptionPane.showInputDialog(revMsg);
			
			//�Է¹��� �޽����� ���� ��Ʈ�� ���
			dos = new DataOutputStream(client.getOutputStream());
			
			//�޽����� ��Ʈ���� ���
			dos.writeUTF(sendMsg);
			
			//��Ʈ���� ������ ������(����)�� ����
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
		// 8. ���� ����
		try {
			new SimpleMsgClient();
		} catch (UnknownHostException uhe) {
			System.err.println("���� �� �� ����");
			uhe.printStackTrace();
		} catch (IOException ie) {
			System.err.println("��� ���� �߻�");
			ie.printStackTrace();
		} // end catch
	}// main
}// class
