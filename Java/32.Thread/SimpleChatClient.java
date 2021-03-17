package day1209;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.Socket;
import java.rmi.activation.UnknownObjectException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class SimpleChatClient extends JFrame implements ActionListener {

	private JTextArea jtaTalkOutput; // 대화 출력
	private JScrollPane jspTalkOutputScroll;
	private JTextField jtfTalkInput; // 대화입력
	private JButton jbtnConnect; // 서버접속버튼

	private Socket client; // 서버접속

	private DataInputStream readStream; // 상대방 대화를 읽기
	private DataOutputStream writeStream; // 상대방에게 보낼 대화를 쓰기

	public SimpleChatClient() {
		super("채팅 클라이언트");

		jtaTalkOutput = new JTextArea(); // 대화 출력
		jspTalkOutputScroll = new JScrollPane(jtaTalkOutput);
		jtfTalkInput = new JTextField(); // 대화입력
		jbtnConnect = new JButton("서버 접속"); // 서버실행
		
		jtaTalkOutput.setEditable(false); //JTextArea를 편집불가
		
		jspTalkOutputScroll.setBorder(new TitledBorder("대화창"));
		jtfTalkInput.setBorder(new TitledBorder("대화입력"));
		
		JPanel jpNorth = new JPanel();
		jpNorth.add(jbtnConnect);
		
		add("North",jpNorth);
		add("Center",jspTalkOutputScroll);
		add("South", jtfTalkInput);
		
		
		setBounds(100,100,450,500);
		setVisible(true);
		
		
		jtfTalkInput.addActionListener(this);
		jbtnConnect.addActionListener(this);
				
		//윈도우를 종료할 때, 연결되어있는 Socket,Stream을 끊기 위해
		//윈도우 종료이벤트로 처리
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent we) {
				try {
					closeWin();
				} catch (IOException ie) {
					ie.printStackTrace();
				}finally{
					dispose();
				}//end finally
			}//windowClosing

			/**
			 * 프로그램이 종료되면 자원누수를 막기위하여 연결(Stream계열)되어있는 객체를 종료
			 * @throws IOException
			 */
			public void closeWin() throws IOException {
				
				if(readStream != null) {
					readStream.close();
				}//end if
				if(writeStream != null) {
					writeStream.close();
				}//end if
				if(client != null) {
					client.close();
				}//end if
				
			}//closeWin

		});
	}// SimpleChatServer

	@Override
	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource() == jbtnConnect) { //서버 접속
			try {
				connectToServer();
			} catch (UnknownObjectException e) {
				JOptionPane.showMessageDialog(this, "서버에 연결할 수 없습니다.");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//end if

		if(ae.getSource() == jtfTalkInput) { //대화가 입력된 상태
			String sendMessage = "[장일규]" + jtfTalkInput.getText();
			try {
				sendMsg(sendMessage);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "메시지를 보낼 수 없습니다.");
				e.printStackTrace();
			}finally {
				jtfTalkInput.setText("");
			}
		}//end if
		
	}// actionPerformed

	/**
	 * 입력한 메세지를 DataOutputStream에 출력하는 일을
	 * 
	 * @param msg
	 * @throws IOException
	 */
	public void sendMsg(String msg) throws IOException {
		//4. | 5 (전체적인 흐름은 6번 | 전 7)
		
		jtaTalkOutput.append(msg + "\n"); //Local 대화창에 메세지를 올려주고
		writeStream.writeUTF(msg); //접속자에게 보내준다.
		
		writeStream.flush();
	}// sendMsg

	/**
	 * 접속자가 대화를 보내오면 DataInputStream에 저장된 대화를 읽어들여 JTextArea에 추가한다.
	 * 
	 * @throws IOException
	 */
	public void readMsg() throws IOException {
		//4. | 5 (전체적인 흐름은 6번 | 전 7)
		
		String revMsg = "";
		
		while(true) {
		
			revMsg = readStream.readUTF();
			
			jtaTalkOutput.append(revMsg + "\n"); 
		
		}//end while

	}// readMsg

	/**
	 * Socket을 사용하여 Local컴퓨터의 포트를 열고, 서버에 연결시도, 대화를 읽거나, 보낼 수 있는 스트림을
	 * Socket에서 부터 연결한다
	 * 
	 * @throws IOException
	 * @throws BindException
	 */
	public void connectToServer() throws IOException, UnknownObjectException {
		
		String serverIpAddr = JOptionPane.showInputDialog("접속 컴퓨터의 주소\n");
		
		//1. (전체적인 흐름은 2번)
		client = new Socket("211.238.142." + serverIpAddr,2020); //ip를 구분할 때에는 .으로 구분하는데  .을 안써서 예외 떨어졌어요 

		jtaTalkOutput.setText("채팅 서버에 연결 되었습니다.\n 즐거운 채팅 하세요.\n");
		
		//2. (전체적인 흐름은 4번)
		readStream = new DataInputStream(client.getInputStream());
		
		//3. (전체적인 흐름은 5번)
		writeStream = new DataOutputStream(client.getOutputStream());

		try {
				readMsg();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}// connectToServer

	public static void main(String[] args) {
		SimpleChatClient scc = new SimpleChatClient();
//		try {
//			scc.readMsg();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}// main

}// class
