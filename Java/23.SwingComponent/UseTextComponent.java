package day1119;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
//1. ������ ������Ʈ ���
public class UseTextComponent extends JFrame {

	//2.������
	public UseTextComponent() {
		super("�ؽ�Ʈ ������Ʈ�� ���"); //TextComponent - JTextField, JPasswordField,JTextArea
		
		
		//3. ������Ʈ�� ����
		JLabel jlblID = new JLabel("���̵�");
		JTextField jtfID = new JTextField(8);
		JLabel jlbPasswd = new JLabel("��й�ȣ");
		JPasswordField jpfPasswd = new JPasswordField(8);
		
		//���⹮�� ����
//		jpfPasswd.setEchoChar('*');
		
		JTextArea jtaTemp = new JTextArea(); //��ũ�ѹٰ� ����.
		TextArea taTemp = new TextArea(); //��ũ�ѹٰ� ����.
		
		//�Էµ� ���ڿ��� TextArea�� �� ������ �Ѿ�� ���� ����
		jtaTemp.setLineWrap(true);		
		
		//�ܾ� ��ȣ: �ѱ� �ȵ�
		jtaTemp.setWrapStyleWord(true);
		
		//��ũ�ѹ� ��ü ����
		JScrollPane jspTemp = new JScrollPane(jtaTemp); //jspTemp�� jtaTemp�� Has a ����
		
		//4. ��ġ������ ����
		setLayout(new BorderLayout()); //JFrame�� ��ġ�����ڴ� Border Layout
		
		//North�� ���� Component�� ��ġ�ϱ����� Container Component����
		JPanel jpNorth = new JPanel(); //FlowLayout
		//Center�� Component�� ��ġ�ϱ����� Container Component����
		JPanel jpCenter = new JPanel();//FlowLayout
		jpCenter.setLayout(new GridLayout(1,2)); //FlowLayout �̿��ٰ� GridLayout���� ����
		
		//5. ������Ʈ ��ġ
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
		
		//6. ������ ������Ʈ�� ũ�� ����
		setBounds(200,100,600,400);
		
		//7. ������������Ʈ�� ����ڿ��� ��������
		setVisible(true);
		
		//8. �����̺�Ʈ ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}//UseTextComponent
	
	public static void main(String[] args) {
			new UseTextComponent();
	}//main
}//class
