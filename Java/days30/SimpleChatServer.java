package day1209;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class SimpleChatServer extends JFrame implements ActionListener {

	private JTextArea jtaTalkOutput; // ��ȭ ���
	private JScrollPane jspTalkOutputScroll;
	private JTextField jtfTalkInput; // ��ȭ�Է�
	private JButton jbtnOpenServer; // ��������

	private ServerSocket server; // ��Ʈ�� ����
	private Socket client; // ������ �ޱ�

	private DataInputStream readStream; // ���� ��ȭ�� �б�
	private DataOutputStream writeStream; // ���濡�� ���� ��ȭ�� ����

	public SimpleChatServer() {
		super("ä�� ����");

		jtaTalkOutput = new JTextArea(); // ��ȭ ���
		jspTalkOutputScroll = new JScrollPane(jtaTalkOutput);
		jtfTalkInput = new JTextField(); // ��ȭ�Է�
		jbtnOpenServer = new JButton("���� ����"); // ��������

		jtaTalkOutput.setEditable(false); // JTextArea�� �����Ұ�

		jspTalkOutputScroll.setBorder(new TitledBorder("��ȭâ"));
		jtfTalkInput.setBorder(new TitledBorder("��ȭ�Է�"));

		JPanel jpNorth = new JPanel();
		jpNorth.add(jbtnOpenServer);

		add("North", jpNorth);
		add("Center", jspTalkOutputScroll);
		add("South", jtfTalkInput);

		setBounds(100, 100, 450, 500);
		setVisible(true);

		jtfTalkInput.addActionListener(this);
		jbtnOpenServer.addActionListener(this);

		// �����츦 ������ ��, ����Ǿ��ִ� ServerSoket,Socket,Stream�� ���� ����
		// ������ �����̺�Ʈ�� ó��

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent we) {
				try {
					closeWin();
				} catch (IOException ie) {
					ie.printStackTrace();
				} finally {
					dispose();
				} // end finally
			}// windowClosing

			/**
			 * ���α׷��� ����Ǹ� �ڿ������� �������Ͽ� ����(Stream�迭)�Ǿ��ִ� ��ü�� ����
			 * 
			 * @throws IOException
			 */
			public void closeWin() throws IOException {

				if (readStream != null) {
					readStream.close();
				} // end if
				if (writeStream != null) {
					writeStream.close();
				} // end if
				if (client != null) {
					client.close();
				} // end if

			}// closeWin

		});
	}// SimpleChatServer

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == jbtnOpenServer) { // ��������

			try {
				openServer();
			} catch (BindException e) {
				JOptionPane.showMessageDialog(this, "������ �������̰ų�, ��Ʈ�� ����� �Դϴ�.");
			} catch (IOException e) {
				e.printStackTrace();
			}

		} // end if

		if (ae.getSource() == jtfTalkInput) { // ��ȭ�� �ԷµǾ��� ��
			String sendMessage = "[���ϱ�]: " + jtfTalkInput.getText();

			try {
				sendMsg(sendMessage);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "�����ڰ� �����ϴ�.");
				e.printStackTrace();
			}finally {
				jtfTalkInput.setText("");
			}// end finally
		} // end if

	}// actionPerformed

	/**
	 * �Է��� �޼����� DataOutputStream�� ����ϴ� ����
	 * 
	 * @param msg
	 * @throws IOException
	 */
	public void sendMsg(String msg) throws IOException {
		// �Էµ� ��ȭ�� �� ��ȭâ�� �ø���
		jtaTalkOutput.append(msg + "\n");

		// 5�Ǵ� 6 (��ü���� �帧6 �Ǵ� 7��)
		writeStream.writeUTF(msg);

		writeStream.flush();

	}// sendMsg

	/**
	 * �����ڰ� ��ȭ�� �������� DataInputStream�� ����� ��ȭ�� �о�鿩 JTextArea�� �߰��Ѵ�.
	 * @throws IOException
	 */
	public void readMsg() throws IOException {

	String revMsg ="";
	while(true) {
		// 5���Ǵ� 6�� (��ü���� �帧6�� �Ǵ� 7��)
		revMsg = readStream.readUTF();
		
		jtaTalkOutput.append(revMsg + "\n");
		
	}//end while
		
	}// readMsg

	/**
	 * ServerSocket �� ����Ͽ� ��Ʈ�� ����, ������ ������ �ִٸ� �����ڼ����� �ް�, ��ȭ�� �аų�, ���� �� �ִ� ��Ʈ����
	 * Socket���� ���� �����Ѵ�
	 * 
	 * @throws IOException
	 * @throws BindException
	 */
	public void openServer() throws IOException, BindException {

		// 1.
		server = new ServerSocket(2020); // 1024�� ������ ��Ʈ�� ������� ��Ʈ�� ���� ������ �������̸� 1025 ~ 65535������ ��Ʈ�� �����ش�.
		jtaTalkOutput.setText("���� ������. ������ ������ ��ٸ��� ����\n");

		// 2. (��ü���� �帧�� 3��)
		client = server.accept();
		
		jtaTalkOutput.append("�����ڰ� �����Ͽ����ϴ�.\n��ſ� ä�õǼ���.\n");

		// 3. (��ü���� �帧�� 4��)
		readStream = new DataInputStream(client.getInputStream());

		// 4. (��ü���� �帧�� 5��) (��Ʈ�� ���̴°� 3���� �������� 4���� �������� �������. 3��4���� ���Ḹ �س��� ��)
		writeStream = new DataOutputStream(client.getOutputStream());

		
		try {
			readMsg();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}// openServer

	public static void main(String[] args) {
		SimpleChatServer scs = new SimpleChatServer();
		
//		try {
//			scs.readMsg();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}// main

}// class
