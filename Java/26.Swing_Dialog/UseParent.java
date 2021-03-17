package day1126;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * �� ����� ������ �ִ� ���� â(�θ� â)
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class UseParent extends JFrame {

	private JButton jbtn;

	public UseParent() {
		super("�θ� â");

		jbtn = new JButton("�ΰ����� ��� ���");

		// �̺�Ʈ ��ü ���� ���輳��
		ParentEvt pe = new ParentEvt(this);

		// ������Ʈ���� �̺�Ʈ�� �߻���Ű�� �̺�Ʈ�� ó���� �� ���
		jbtn.addActionListener(pe);
		addWindowListener(pe);

		JPanel jpSouth = new JPanel();
		jpSouth.add(jbtn);

		add("South", jpSouth);

		setBounds(100, 100, 1000, 700);

		setVisible(true);

	}// UseParent

	public JButton getJbtn() {
		return jbtn;
	}

	public static void main(String[] args) {
		new UseParent();
	}// main

}// class
