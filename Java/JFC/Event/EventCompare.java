package day1125;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * �̺�Ʈ ��
 * ���̵� TextField���� ���Ͱ� �������� JTextArea�� ����
 * ��й�ȣ JPasswordField���� ���Ͱ� �������� TextArea�� ����
 * @author owner
 *
 */
@SuppressWarnings("serial")
//1. ������ ������Ʈ ���. �̺�Ʈ ó����ü ����
public class EventCompare extends JFrame implements ActionListener{

	//2. �̺�Ʈ ó���� �����ִ� ��ü ����
	private JTextField jtfID;
	private JPasswordField jpfPasswd;
	private JTextArea jtaTemp;
	private TextArea taTemp;
	
	//2.������ �ۼ�, ������Ʈ ����
	public EventCompare() {
		super("�ؽ�Ʈ ������Ʈ�� ���"); //TextComponent - JTextField, JPasswordField,JTextArea
		
		//3.  ������Ʈ�� ����
		JLabel jlblID = new JLabel("���̵�");
		jtfID = new JTextField(8);
		JLabel jlbPasswd = new JLabel("��й�ȣ");
		jpfPasswd = new JPasswordField(8);
		
		jtaTemp = new JTextArea(); //��ũ�ѹٰ� ����.
		taTemp = new TextArea(); //��ũ�ѹٰ� ����.
		
		//�Էµ� ���ڿ��� TextArea�� �� ������ �Ѿ�� ���� ����
		jtaTemp.setLineWrap(true);		
		
		//�ܾ� ��ȣ: �ѱ� �ȵ�
		jtaTemp.setWrapStyleWord(true);
		
		//��ũ�ѹ� ��ü ����
		JScrollPane jspTemp = new JScrollPane(jtaTemp); //jspTemp�� jtaTemp�� Has a ����
		
		//4. Component���� �߻��� �̺�Ʈ�� JVM���� ������ �� �ֵ��� �̺�Ʈ�� ���
		//�̺�Ʈ�� ó���� ��ü�� �־��ش�.
		jtfID.addActionListener(this);
		jpfPasswd.addActionListener(this);

		
		//5. ��ġ������ ����
		setLayout(new BorderLayout()); //JFrame�� ��ġ�����ڴ� Border Layout
		
		//North�� ���� Component�� ��ġ�ϱ����� Container Component����
		JPanel jpNorth = new JPanel(); //FlowLayout
		//Center�� Component�� ��ġ�ϱ����� Container Component����
		JPanel jpCenter = new JPanel();//FlowLayout
		jpCenter.setLayout(new GridLayout(1,2)); //FlowLayout �̿��ٰ� GridLayout���� ����
		
		//6. ������Ʈ ��ġ
		//BorderLayout�� North������ �� ������Ʈ�� Container Component�� ��ġ
		jpNorth.add(jlblID);
		jpNorth.add(jtfID);
		jpNorth.add(jlbPasswd);
		jpNorth.add(jpfPasswd);
		
		//BorderLayout�� Center������ �� ������Ʈ�� Container Component�� ��ġ
		jpCenter.add(jspTemp);
		jpCenter.add(taTemp);
		
		//�������� ������Ʈ�� ���� Container Component �ϳ��� Window Component�� ��ġ
		add("North",jpNorth);
		add("Center",jpCenter);
		
		//7. ������ ������Ʈ�� ũ�� ����
		setBounds(200,100,600,400);
		
		//8. ������������Ʈ�� ����ڿ��� ��������
		setVisible(true);
		
		//9. �����̺�Ʈ ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseTextComponent
	
	//11. �̺�Ʈ�� �߻����� �� ������ �ڵ带 �����ϴ� method�� Override�Ѵ�.
	@Override
	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource() == jtfID) {
			//�ؽ�Ʈ�ʵ��� ���� �����ͼ�
			String id = jtfID.getText();
			
			//JTextArea�� �߰�
			jtaTemp.append(id + "\n");
			
			//TextField ���� �ʱ�ȭ
			jtfID.setText("");
			
			System.out.println("�ؽ�Ʈ�ʵ忡�� �̺�Ʈ �߻�");
		}
		if(ae.getSource() == jpfPasswd) {
			System.out.println("�н����忡�� �̺�Ʈ �߻�");
			
			//JPasswordField�� ���� �����ͼ�
			String pass = String.valueOf(jpfPasswd.getPassword());
			
			//TextArea�� �߰�
			taTemp.append(pass + "\n");
			
			//TextArea ���� �ʱ�ȭ
			jpfPasswd.setText("");
		}
	}//actionPerformed
	
	public static void main(String[] args) {
			new EventCompare();
	}//main
}//class
