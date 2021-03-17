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

	private JTextArea jtaTalkOutput; // ��ȭ ���
	private JScrollPane jspTalkOutputScroll;
	private JTextField jtfTalkInput; // ��ȭ�Է�
	private JButton jbtnConnect; // �������ӹ�ư

	private Socket client; // ��������

	private DataInputStream readStream; // ���� ��ȭ�� �б�
	private DataOutputStream writeStream; // ���濡�� ���� ��ȭ�� ����

	public SimpleChatClient() {
		super("ä�� Ŭ���̾�Ʈ");

		jtaTalkOutput = new JTextArea(); // ��ȭ ���
		jspTalkOutputScroll = new JScrollPane(jtaTalkOutput);
		jtfTalkInput = new JTextField(); // ��ȭ�Է�
		jbtnConnect = new JButton("���� ����"); // ��������
		
		jtaTalkOutput.setEditable(false); //JTextArea�� �����Ұ�
		
		jspTalkOutputScroll.setBorder(new TitledBorder("��ȭâ"));
		jtfTalkInput.setBorder(new TitledBorder("��ȭ�Է�"));
		
		JPanel jpNorth = new JPanel();
		jpNorth.add(jbtnConnect);
		
		add("North",jpNorth);
		add("Center",jspTalkOutputScroll);
		add("South", jtfTalkInput);
		
		
		setBounds(100,100,450,500);
		setVisible(true);
		
		
		jtfTalkInput.addActionListener(this);
		jbtnConnect.addActionListener(this);
				
		//�����츦 ������ ��, ����Ǿ��ִ� Socket,Stream�� ���� ����
		//������ �����̺�Ʈ�� ó��
		
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
			 * ���α׷��� ����Ǹ� �ڿ������� �������Ͽ� ����(Stream�迭)�Ǿ��ִ� ��ü�� ����
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

		if(ae.getSource() == jbtnConnect) { //���� ����
			try {
				connectToServer();
			} catch (UnknownObjectException e) {
				JOptionPane.showMessageDialog(this, "������ ������ �� �����ϴ�.");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//end if

		if(ae.getSource() == jtfTalkInput) { //��ȭ�� �Էµ� ����
			String sendMessage = "[���ϱ�]" + jtfTalkInput.getText();
			try {
				sendMsg(sendMessage);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "�޽����� ���� �� �����ϴ�.");
				e.printStackTrace();
			}finally {
				jtfTalkInput.setText("");
			}
		}//end if
		
	}// actionPerformed

	/**
	 * �Է��� �޼����� DataOutputStream�� ����ϴ� ����
	 * 
	 * @param msg
	 * @throws IOException
	 */
	public void sendMsg(String msg) throws IOException {
		//4. | 5 (��ü���� �帧�� 6�� | �� 7)
		
		jtaTalkOutput.append(msg + "\n"); //Local ��ȭâ�� �޼����� �÷��ְ�
		writeStream.writeUTF(msg); //�����ڿ��� �����ش�.
		
		writeStream.flush();
	}// sendMsg

	/**
	 * �����ڰ� ��ȭ�� �������� DataInputStream�� ����� ��ȭ�� �о�鿩 JTextArea�� �߰��Ѵ�.
	 * 
	 * @throws IOException
	 */
	public void readMsg() throws IOException {
		//4. | 5 (��ü���� �帧�� 6�� | �� 7)
		
		String revMsg = "";
		
		while(true) {
		
			revMsg = readStream.readUTF();
			
			jtaTalkOutput.append(revMsg + "\n"); 
		
		}//end while

	}// readMsg

	/**
	 * Socket�� ����Ͽ� Local��ǻ���� ��Ʈ�� ����, ������ ����õ�, ��ȭ�� �аų�, ���� �� �ִ� ��Ʈ����
	 * Socket���� ���� �����Ѵ�
	 * 
	 * @throws IOException
	 * @throws BindException
	 */
	public void connectToServer() throws IOException, UnknownObjectException {
		
		String serverIpAddr = JOptionPane.showInputDialog("���� ��ǻ���� �ּ�\n");
		
		//1. (��ü���� �帧�� 2��)
		client = new Socket("211.238.142." + serverIpAddr,2020); //ip�� ������ ������ .���� �����ϴµ�  .�� �ȽἭ ���� ��������� 

		jtaTalkOutput.setText("ä�� ������ ���� �Ǿ����ϴ�.\n ��ſ� ä�� �ϼ���.\n");
		
		//2. (��ü���� �帧�� 4��)
		readStream = new DataInputStream(client.getInputStream());
		
		//3. (��ü���� �帧�� 5��)
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
