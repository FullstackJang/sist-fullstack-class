package day1126;

import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class UseListSelectionEvt extends JFrame implements ListSelectionListener {
	private DefaultListModel<String> dlmFriends;
	private DefaultListModel<String> dlmBlockFriends;
	private JList<String> jlFriends;
	private JList<String> jlBlockFriends;
	
	public UseListSelectionEvt() {
		super("JList ���");
		
		//3. ������Ʈ ����
		//�����͸� ���� Model Ŭ������ ��ü ����
		dlmFriends = new DefaultListModel<String>();
		dlmBlockFriends = new DefaultListModel<String>();
		
		//4. �� ����
		dlmFriends.addElement("���̾�");
		dlmFriends.addElement("����");
		dlmFriends.addElement("����ġ");
		dlmFriends.addElement("������");
		
		dlmBlockFriends.addElement("����");
		dlmBlockFriends.addElement("�ڴ�");

		//�����͸� ������ �� �ִ� View ��ü�� ����
		jlFriends = new JList<String>(dlmFriends);
		jlBlockFriends = new JList<String>(dlmBlockFriends);
		
		
		//����Ʈ���� �߻��Ǵ� �̺�Ʈ�� ó���ϱ� ���ؼ� �̺�Ʈ�� ����ϰ�, �̺�Ʈ ó���� ��ü�� �־��ش�.
		jlFriends.addListSelectionListener(this); 
		
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

	boolean flag;
	@Override
	public void valueChanged(ListSelectionEvent lse) {
		
		if(flag) System.out.println(dlmFriends.get(jlFriends.getSelectedIndex()));
		flag = !flag;
	}//valueChanged
	
	public static void main(String[] args) {
		new UseListSelectionEvt();
	}//main
}//class
