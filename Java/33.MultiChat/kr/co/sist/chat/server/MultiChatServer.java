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

	public static List<ConnHelper> listConn; //�����ڸ� ������ List

	public MultiChatServer() {
		super("ä�� ������");

//		listConn = new ArrayList<ConnHelper>(); //�������ٰ���
		listConn = new Vector<ConnHelper>(); //�������� �Ұ���
		
		
		dlmJlConnList = new DefaultListModel<String>();
		dlmJlConnList.addElement("������� �ȳ��ϼ���?");

		jlConnList = new JList<String>(dlmJlConnList);
		jspConnScroll = new JScrollPane(jlConnList);
		jspConnScroll.setBorder(new TitledBorder("������ ����Ʈ"));

		jbtnServerStart = new JButton("��������");
		jbtnServerClose = new JButton("��������");

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
				System.exit(JFrame.ABORT); //�������� ���� System.exit()����ϸ�ȵ� ���� ������
			}//windowClosed
		
		});// addWindowListener

		
		
	}// MultiChatServer

	@Override
	public void run() {
		try {
			server = new ServerSocket(3482); // PORT�� �����
			// PORT�� ���ȴٰ� ��ȭ���� ������ ���� �ƴ�

			dlmJlConnList.addElement("�������� ���� : PORT 3482");

			int cntConn = 0;// ������ ��
			Socket tempClient = null; // �����ڼ����� �ӽ÷� �����ϱ����� ����
			ConnHelper ch = null; // �����ڼ����� �޾Ƽ� ��Ʈ���� �����ϰ�
			// Thread�� ��ȭ�� �о�鿩,��� �����ڿ��� ��ȭ�� ����ϴ� ��

			while (true) {
				tempClient = server.accept(); //�����ڰ� ������
				// Helper�� �����ϰ�, java.util.List�� �߰�
				ch = new ConnHelper(tempClient, cntConn, dlmJlConnList,jspConnScroll);
				
				//���� �����ڸ� �����ϱ����ؼ� java.util.List�� �߰�
				listConn.add(ch);

				dlmJlConnList.addElement(cntConn + "��° ����");

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
			// ������ ó���� Thread�� �Ͽ� �����ΰ� ������ ó���� ���ÿ� ���� ��ų �� �ֵ��� �Ѵ�.
			threadServer = new Thread(this);
			threadServer.start(); // �̰������ؼ� run()�� ȣ��ȴ�.
		} else {
			JOptionPane.showMessageDialog(this, "������ �̹� �������Դϴ�.");
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