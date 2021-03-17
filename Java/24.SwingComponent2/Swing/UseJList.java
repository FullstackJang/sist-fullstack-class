package day1120;

import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UseJList extends JFrame {

	public UseJList() {
		super("JList ���");
		
		//3. ������Ʈ ����
		//�����͸� ���� Model Ŭ������ ��ü ����
		DefaultListModel<String> dlmFriends = new DefaultListModel<String>();
		DefaultListModel<String> dlmBlockFriends = new DefaultListModel<String>();
		
		//4. �� ����
		dlmFriends.addElement("���̾�");
		dlmFriends.addElement("����");
		dlmFriends.addElement("����ġ");
		dlmFriends.addElement("������");
		
		dlmBlockFriends.addElement("����");
		dlmBlockFriends.addElement("�ڴ�");

		//�����͸� ������ �� �ִ� View ��ü�� ����
		JList<String> jlFriends = new JList<String>(dlmFriends);
		JList<String> jlBlockFriends = new JList<String>(dlmBlockFriends);
		
		
		//��ũ�ѹٸ� ����
		JScrollPane jspFriends = new JScrollPane(jlFriends);
		JScrollPane jspBlockFriends = new JScrollPane(jlBlockFriends);
		
		//Component�� TitledBorder ����
		jspFriends.setBorder(new TitledBorder("ģ�����"));
		jspBlockFriends.setBorder(new TitledBorder("���ܸ��"));
		
		//��ġ
		setLayout(new GridLayout(1,2));

		add(jspFriends);
		add(jspBlockFriends);
		
		
		//JList�� ScrollBar�� ����.
//		add(jlFriends);
//		add(jlBlockFriends);
		
		setBounds(100,100,400,300);
		
		setVisible(true);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//UseJList
	
	public static void main(String[] args) {
		new UseJList();
	}//main
}//class
