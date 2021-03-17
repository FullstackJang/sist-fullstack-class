package kr.co.sist.chat.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import kr.co.sist.chat.server.help.ConnHelper;

@SuppressWarnings("serial")
public class MultiChatServer extends JFrame implements ActionListener, Runnable {

	private JList<String> jlConnList;
	private DefaultListModel<String> dlmJlConnList;
	private JScrollPane jspConnScroll;

	private JButton jbtnServerStart;
	private JButton jbtnServerClose;

	private ServerSocket server;

	private Thread threadServer;

	public static List<ConnHelper> listConn; //접속자를 관리할 List

	public MultiChatServer() {
		super("채팅 관리자");

//		listConn = new ArrayList<ConnHelper>(); //동시접근가능
		listConn = new Vector<ConnHelper>(); //동시접근 불가능
		
		
		dlmJlConnList = new DefaultListModel<String>();
		dlmJlConnList.addElement("관지라님 안녕하세요?");

		jlConnList = new JList<String>(dlmJlConnList);
		jspConnScroll = new JScrollPane(jlConnList);
		jspConnScroll.setBorder(new TitledBorder("접속자 리스트"));

		jbtnServerStart = new JButton("서버가동");
		jbtnServerClose = new JButton("서버종료");

		JPanel jpSouth = new JPanel();
		jpSouth.add(jbtnServerStart);
		jpSouth.add(jbtnServerClose);

		add("Center", jspConnScroll);
		add("South", jpSouth);

		setBounds(100, 100, 400, 600);
		setVisible(true);

		jbtnServerStart.addActionListener(this);
		jbtnServerClose.addActionListener(this);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				try {
					close();
				} catch (IOException ie) {
					ie.printStackTrace();
				} // end catch
			}// windowClosing
		
			@Override
			public void windowClosed(WindowEvent e) {
				System.exit(JFrame.ABORT); //웹에서는 절대 System.exit()사용하면안됨 앱은 괜찮음
			}//windowClosed
		
		});// addWindowListener

		
		
	}// MultiChatServer

	@Override
	public void run() {
		try {
			server = new ServerSocket(3482); // PORT가 개방됨
			// PORT가 열렸다고 방화벽이 열리는 것은 아님

			dlmJlConnList.addElement("서버가동 성공 : PORT 3482");

			int cntConn = 0;// 접속자 수
			Socket tempClient = null; // 접속자소켓을 임시로 저장하기위한 소켓
			ConnHelper ch = null; // 접속자소켓을 받아서 스트림을 연결하고
			// Thread로 대화를 읽어들여,모든 접속자에게 대화를 출력하는 일

			while (true) {
				tempClient = server.accept(); //접속자가 들어오면
				// Helper를 생성하고, java.util.List에 추가
				ch = new ConnHelper(tempClient, cntConn, dlmJlConnList,jspConnScroll);
				
				//여러 접속자를 관리하기위해서 java.util.List에 추가
				listConn.add(ch);

				dlmJlConnList.addElement(cntConn + "번째 접속");

				cntConn++;
			} // end for

		} catch (IOException e) {
			e.printStackTrace();
		} // end catch

	}// run

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == jbtnServerStart) {
			startServer();

		} // end if

		if (ae.getSource() == jbtnServerClose) {
			try {
				close();
			} catch (IOException e) {
				e.printStackTrace();
			} // end catch
		} // end if

	}// actionPerformed

	public void startServer() {

		if (threadServer == null) {
			// 접속차 처리를 Thread로 하여 디자인과 접속차 처리를 동시에 실행 시킬 수 있도록 한다.
			threadServer = new Thread(this);
			threadServer.start(); // 이것으로해서 run()이 호출된다.
		} else {
			JOptionPane.showMessageDialog(this, "서버가 이미 실행중입니다.");
		}

	}// startServer

	public void close() throws IOException {

		if (server != null) {
			server.close();
		} // end if
		
		dispose();

	}// close

	public static void main(String[] args) {
		new MultiChatServer();
	}// main
}// class