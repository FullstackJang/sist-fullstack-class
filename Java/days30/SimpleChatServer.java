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

	private JTextArea jtaTalkOutput; // 대화 출력
	private JScrollPane jspTalkOutputScroll;
	private JTextField jtfTalkInput; // 대화입력
	private JButton jbtnOpenServer; // 서버실행

	private ServerSocket server; // 포트를 열기
	private Socket client; // 접속자 받기

	private DataInputStream readStream; // 상대방 대화를 읽기
	private DataOutputStream writeStream; // 상대방에게 보낼 대화를 쓰기

	public SimpleChatServer() {
		super("채팅 서버");

		jtaTalkOutput = new JTextArea(); // 대화 출력
		jspTalkOutputScroll = new JScrollPane(jtaTalkOutput);
		jtfTalkInput = new JTextField(); // 대화입력
		jbtnOpenServer = new JButton("서버 실행"); // 서버실행

		jtaTalkOutput.setEditable(false); // JTextArea를 편집불가

		jspTalkOutputScroll.setBorder(new TitledBorder("대화창"));
		jtfTalkInput.setBorder(new TitledBorder("대화입력"));

		JPanel jpNorth = new JPanel();
		jpNorth.add(jbtnOpenServer);

		add("North", jpNorth);
		add("Center", jspTalkOutputScroll);
		add("South", jtfTalkInput);

		setBounds(100, 100, 450, 500);
		setVisible(true);

		jtfTalkInput.addActionListener(this);
		jbtnOpenServer.addActionListener(this);

		// 윈도우를 종료할 때, 연결되어있는 ServerSoket,Socket,Stream을 끊기 위해
		// 윈도우 종료이벤트로 처리

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
			 * 프로그램이 종료되면 자원누수를 막기위하여 연결(Stream계열)되어있는 객체를 종료
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
		if (ae.getSource() == jbtnOpenServer) { // 서버열기

			try {
				openServer();
			} catch (BindException e) {
				JOptionPane.showMessageDialog(this, "서버가 가동중이거나, 포트가 사용중 입니다.");
			} catch (IOException e) {
				e.printStackTrace();
			}

		} // end if

		if (ae.getSource() == jtfTalkInput) { // 대화가 입력되었을 때
			String sendMessage = "[장일규]: " + jtfTalkInput.getText();

			try {
				sendMsg(sendMessage);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "접속자가 없습니다.");
				e.printStackTrace();
			}finally {
				jtfTalkInput.setText("");
			}// end finally
		} // end if

	}// actionPerformed

	/**
	 * 입력한 메세지를 DataOutputStream에 출력하는 일을
	 * 
	 * @param msg
	 * @throws IOException
	 */
	public void sendMsg(String msg) throws IOException {
		// 입력된 대화를 내 대화창에 올리고
		jtaTalkOutput.append(msg + "\n");

		// 5또는 6 (전체적인 흐름6 또는 7번)
		writeStream.writeUTF(msg);

		writeStream.flush();

	}// sendMsg

	/**
	 * 접속자가 대화를 보내오면 DataInputStream에 저장된 대화를 읽어들여 JTextArea에 추가한다.
	 * @throws IOException
	 */
	public void readMsg() throws IOException {

	String revMsg ="";
	while(true) {
		// 5번또는 6번 (전체적인 흐름6번 또는 7번)
		revMsg = readStream.readUTF();
		
		jtaTalkOutput.append(revMsg + "\n");
		
	}//end while
		
	}// readMsg

	/**
	 * ServerSocket 을 사용하여 포트를 열고, 접속자 소켓이 있다면 접속자소켓을 받고, 대화를 읽거나, 보낼 수 있는 스트림을
	 * Socket에서 부터 연결한다
	 * 
	 * @throws IOException
	 * @throws BindException
	 */
	public void openServer() throws IOException, BindException {

		// 1.
		server = new ServerSocket(2020); // 1024번 이하의 포트는 사용중인 포트가 많기 때문에 가급적이면 1025 ~ 65535사이의 포트를 열어준다.
		jtaTalkOutput.setText("서버 가동중. 접속자 연결을 기다리고 있음\n");

		// 2. (전체적인 흐름은 3번)
		client = server.accept();
		
		jtaTalkOutput.append("접속자가 접속하였습니다.\n즐거운 채팅되세요.\n");

		// 3. (전체적인 흐름은 4번)
		readStream = new DataInputStream(client.getInputStream());

		// 4. (저체적인 흐름은 5번) (스트림 붙이는건 3번이 먼저오든 4번이 먼저오든 상관없다. 3번4번은 연결만 해놓는 것)
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
