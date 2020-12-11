package kr.co.sist.chat.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class MultiChatClient extends JFrame implements Runnable, ActionListener {

	private JTextField jtfServerIp; // ������ �����ּ�
	private JTextField jtfNick; // ��ȭ��
	private JTextField jtfTalkInput; // ��ȭ�Է�

	private JTextArea jtaTalkView; // ��ȭ�� �����ֱ�
	private JScrollPane jspTalkScroll; // ��ũ�ѹ�

	private JButton jbtnConnect; // ���� ��ư
	private JButton jbtnCapture; // ĸ�� ��ư

	private Socket client; // ���ӿ� ����
	private DataInputStream readStream;// ��ȭ�� �б����� ��Ʈ��
	private DataOutputStream writeStream; // ��ȭ�� ����(������)���� ��Ʈ��

	private Thread readThread; // ȭ���̳� ��ȭ�� ������ �Ͱ� ������ �б� �۾��ϱ����� Thread

	public MultiChatClient() {
		super("========ä��Ŭ���̾�Ʈ========");

		jtfServerIp = new JTextField("211.238.142.", 12); // ������ �����ּ�
		jtfNick = new JTextField(12); // ��ȭ��
		jtfTalkInput = new JTextField(); // ��ȭ�Է�

		jtaTalkView = new JTextArea(); // ��ȭ�� �����ֱ�
		jtaTalkView.setEditable(false);
		jspTalkScroll = new JScrollPane(jtaTalkView); // ��ũ�ѹ�

		jbtnConnect = new JButton("��������"); // ���� ��ư
		jbtnCapture = new JButton("��ȭ ����"); // ĸ�� ��ư

		JPanel jpNorth = new JPanel();
		jpNorth.add(new JLabel("���� �ּ�"));
		jpNorth.add(jtfServerIp);
		jpNorth.add(new JLabel("�г���"));
		jpNorth.add(jtfNick);
		jpNorth.add(jbtnConnect);
		jpNorth.add(jbtnCapture);

		jspTalkScroll.setBorder(new TitledBorder("��ȭ����"));
		jtfTalkInput.setBorder(new TitledBorder("��ȭ"));

		add("North", jpNorth);
		add("Center", jspTalkScroll);
		add("South", jtfTalkInput);

		setBounds(100, 100, 600, 400);

		setVisible(true);

		jbtnConnect.addActionListener(this);
		jbtnCapture.addActionListener(this);
		jtfTalkInput.addActionListener(this);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent we) {
				try {
					close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					dispose();
				} // end finally
			}// windowClosing

			@Override
			public void windowClosed(WindowEvent we) {
				System.exit(JFrame.ABORT);
			}// windowClosed

		});

	}// MultiChatClient

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == jbtnConnect) {
			String ip = jtfServerIp.getText();

			try {
				connectToServer(ip);
			} catch (UnknownHostException e) {
				JOptionPane.showMessageDialog(this, "������ �������� �ʽ��ϴ�.");
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} // ������ ����
		} // end if

		if (ae.getSource() == jbtnCapture) { // ��ȭ���� ����
			try {
				capture();
			} catch (IOException ie) {
				ie.printStackTrace();
			} // end catch
		} // end if

		if (ae.getSource() == jtfTalkInput) { // ��ȭ�� �ԷµǾ��°�.
			// ���� ä���� ���´��� �𸣱⶧���� ��ȭ�� �����;������� �г��ӵ� �����;��Ѵ�.
			String sendMsg = jtfTalkInput.getText();
			String sendNick = jtfNick.getText();

			StringBuilder sendData = new StringBuilder();
			sendData.append("[").append(sendNick).append("]").append(sendMsg);

			try {
				sendMsg(sendData.toString());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "������ ������� �ʾҽ��ϴ�.");
				e.printStackTrace();
			} finally {
				jtfTalkInput.setText("");
				jtfTalkInput.requestFocus();
			} // end finally

		} // end if

	}// actionPerformed

	public void close() throws IOException {

		if (readStream != null) {
			readStream.close();
		} // end if

		if (writeStream != null) {
			writeStream.close();
		} // end if

		if (client != null) {
			client.close();
		}
	}// close

	public void sendMsg(String msg) throws IOException {
		writeStream.writeUTF(msg);
		writeStream.flush();

	}// sendMsg

	/**
	 * ������ ����(Socket), ��ȭ�� �����ų� �б����� ��Ʈ�� ����(DataInputStream,DataOutputStream)
	 * 
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public void connectToServer(String serverIp) throws UnknownHostException, IOException {

		if (readThread == null) {
			client = new Socket(serverIp, 3482); // ������ ���� �õ�
			JOptionPane.showMessageDialog(this, "������ �����Ͽ����ϴ�.");
			jtaTalkView.setText("������ �����Ͽ����ϴ�.\n ��ſ� ä�� �Ǽ���.\n");
			readStream = new DataInputStream(client.getInputStream()); // �б� ��Ʈ��
			writeStream = new DataOutputStream(client.getOutputStream()); // ���� ��Ʈ��

			readThread = new Thread(this);
			readThread.start(); // �޽����� �д� ���·�
			
			//��Ʈ���� ����� ���� ������ �г����� ������.
			String nick = jtfNick.getText();
			writeStream.writeUTF(nick);
			writeStream.flush();
			
			jtaTalkView.append("********ä�ÿ� �����Ͽ����ϴ�.********\n");
			
		} else {
			JOptionPane.showMessageDialog(this, "������ ���ӵ� �����Դϴ�.");
		} // end else
	}// connectToServer

	public void capture() throws IOException { // ��ȭ���� ����

		switch (JOptionPane.showConfirmDialog(this, "��ȭ������ �����Ͻðڽ��ϱ�?")) {
		case JOptionPane.OK_OPTION:
			File saveDir = new File("c:/dev/capture");

			if (!saveDir.exists()) { // ��ȭ������ ������ ������ �������� ������
				saveDir.mkdirs(); // ������ ����
			} // end if

			StringBuilder sbSaveFileNamePath = new StringBuilder();

			sbSaveFileNamePath.append(saveDir.getAbsolutePath()).append("/capture_").append(System.currentTimeMillis())
					.append(".txt");

			File saveFileName = new File(sbSaveFileNamePath.toString());

			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(saveFileName)); //�����Ȱ�ο� �θ������� ��Ʈ���� ����
				bw.write(jtaTalkView.getText()); //��Ʈ���� ��ȭ������ ����
				bw.flush(); //��Ʈ���� ������ �������� ����
			} finally {
				if (bw != null) {
					bw.close();
				}
			}
			JOptionPane.showMessageDialog(this, sbSaveFileNamePath.toString() + "�� ����Ǿ����ϴ�.");

		}// end switch
	}// capture

	@Override
	public void run() {
		// �޽����� �б�.
		String revMsg = "";

		try {
			while (true) {
				revMsg = readStream.readUTF(); // �޽����� �о�鿩
				jtaTalkView.append(revMsg + "\n");
				setScrollPosition(); // ��ũ�ѹ��� ��ġ�� �����ش�.
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "�������� ��ְ� �߻��Ͽ����ϴ�.\n ������ ���������ϴ�.");
			e.printStackTrace();
		}

	}// run

	public void setScrollPosition() {
		jspTalkScroll.getVerticalScrollBar().setValue(jspTalkScroll.getVerticalScrollBar().getMaximum());
	}// setScrollPosition

	public static void main(String[] args) {
		new MultiChatClient();
	}// main

}// class