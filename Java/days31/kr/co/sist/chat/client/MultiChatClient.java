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

	private JTextField jtfServerIp; // 접속할 서버주소
	private JTextField jtfNick; // 대화명
	private JTextField jtfTalkInput; // 대화입력

	private JTextArea jtaTalkView; // 대화를 보여주기
	private JScrollPane jspTalkScroll; // 스크롤바

	private JButton jbtnConnect; // 접속 버튼
	private JButton jbtnCapture; // 캡쳐 버튼

	private Socket client; // 접속용 소켓
	private DataInputStream readStream;// 대화를 읽기위한 스트림
	private DataOutputStream writeStream; // 대화를 쓰기(보내기)위한 스트림

	private Thread readThread; // 화면이나 대화를 보내는 것과 별개로 읽기 작업하기위한 Thread

	public MultiChatClient() {
		super("========채팅클라이언트========");

		jtfServerIp = new JTextField("211.238.142.", 12); // 접속할 서버주소
		jtfNick = new JTextField(12); // 대화명
		jtfTalkInput = new JTextField(); // 대화입력

		jtaTalkView = new JTextArea(); // 대화를 보여주기
		jtaTalkView.setEditable(false);
		jspTalkScroll = new JScrollPane(jtaTalkView); // 스크롤바

		jbtnConnect = new JButton("서버접속"); // 접속 버튼
		jbtnCapture = new JButton("대화 저장"); // 캡쳐 버튼

		JPanel jpNorth = new JPanel();
		jpNorth.add(new JLabel("서버 주소"));
		jpNorth.add(jtfServerIp);
		jpNorth.add(new JLabel("닉네임"));
		jpNorth.add(jtfNick);
		jpNorth.add(jbtnConnect);
		jpNorth.add(jbtnCapture);

		jspTalkScroll.setBorder(new TitledBorder("대화내용"));
		jtfTalkInput.setBorder(new TitledBorder("대화"));

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
				JOptionPane.showMessageDialog(this, "서버가 존재하지 않습니다.");
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} // 서버에 접속
		} // end if

		if (ae.getSource() == jbtnCapture) { // 대화내용 저장
			try {
				capture();
			} catch (IOException ie) {
				ie.printStackTrace();
			} // end catch
		} // end if

		if (ae.getSource() == jtfTalkInput) { // 대화가 입력되었는가.
			// 누가 채팅을 보냈는지 모르기때문에 대화도 가져와야하지만 닉네임도 가져와야한다.
			String sendMsg = jtfTalkInput.getText();
			String sendNick = jtfNick.getText();

			StringBuilder sendData = new StringBuilder();
			sendData.append("[").append(sendNick).append("]").append(sendMsg);

			try {
				sendMsg(sendData.toString());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "서버에 연결되지 않았습니다.");
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
	 * 서버에 연결(Socket), 대화를 보내거나 읽기위해 스트림 연결(DataInputStream,DataOutputStream)
	 * 
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public void connectToServer(String serverIp) throws UnknownHostException, IOException {

		if (readThread == null) {
			client = new Socket(serverIp, 3482); // 서버와 연결 시도
			JOptionPane.showMessageDialog(this, "서버에 접속하였습니다.");
			jtaTalkView.setText("서버에 접속하였습니다.\n 즐거운 채팅 되세요.\n");
			readStream = new DataInputStream(client.getInputStream()); // 읽기 스트림
			writeStream = new DataOutputStream(client.getOutputStream()); // 쓰기 스트림

			readThread = new Thread(this);
			readThread.start(); // 메시지를 읽는 상태로
			
			//스트림이 연결된 직후 접속자 닉네임을 보낸다.
			String nick = jtfNick.getText();
			writeStream.writeUTF(nick);
			writeStream.flush();
			
			jtaTalkView.append("********채팅에 참여하였습니다.********\n");
			
		} else {
			JOptionPane.showMessageDialog(this, "서버에 접속된 상태입니다.");
		} // end else
	}// connectToServer

	public void capture() throws IOException { // 대화내용 저장

		switch (JOptionPane.showConfirmDialog(this, "대화내용을 저장하시겠습니까?")) {
		case JOptionPane.OK_OPTION:
			File saveDir = new File("c:/dev/capture");

			if (!saveDir.exists()) { // 대화내용을 저장할 폴더가 존재하지 않으면
				saveDir.mkdirs(); // 폴더를 생성
			} // end if

			StringBuilder sbSaveFileNamePath = new StringBuilder();

			sbSaveFileNamePath.append(saveDir.getAbsolutePath()).append("/capture_").append(System.currentTimeMillis())
					.append(".txt");

			File saveFileName = new File(sbSaveFileNamePath.toString());

			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(saveFileName)); //생성된경로와 팡리명으로 스트림을 연결
				bw.write(jtaTalkView.getText()); //스트림에 대화내용을 쓰고
				bw.flush(); //스트림의 내요을 목적지로 분출
			} finally {
				if (bw != null) {
					bw.close();
				}
			}
			JOptionPane.showMessageDialog(this, sbSaveFileNamePath.toString() + "에 저장되었습니다.");

		}// end switch
	}// capture

	@Override
	public void run() {
		// 메시지를 읽기.
		String revMsg = "";

		try {
			while (true) {
				revMsg = readStream.readUTF(); // 메시지를 읽어들여
				jtaTalkView.append(revMsg + "\n");
				setScrollPosition(); // 스크롤바의 위치를 내려준다.
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "서버에서 장애가 발생하였습니다.\n 연결이 끊어졌습니다.");
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