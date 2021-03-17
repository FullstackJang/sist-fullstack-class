package day1125;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * ActionEvent�� ActionListener�� ó��
 * @author owner
 *
 */

//1. ������ ������Ʈ�� ���, XxxListener����
@SuppressWarnings("serial")
public class UseActionEvent extends JFrame implements ActionListener{
	
	//2. �̺�Ʈ�� �߻����� �� ó���� Component�� ����
	private JButton jbtn;
	
	
	//2. default constructor����, Component�� ����
	public UseActionEvent() {
		super("ActionEvent ó��");
	
		//3. Component�� ����
		jbtn = new JButton("Swing ��ư");
		
		//4. Component�� �̺�Ʈ�� ��� addXxxListener
		jbtn.addActionListener(this); //is a ����� �̺�Ʈ�� ó���ϴ� �����̹Ƿ� �� ��ü�ȿ��� �̺�Ʈ�� ó���� ���̴�.
		// �̺�Ʈ�� ó���ϰ��� �� �� this�� �־��ش�.
		
		//4. ��ġ(Component�� ����)
		add("Center",jbtn); //1�� 1��
		
		//5. ������ ũ�� ����
		setSize(400,200);
		
		//6.������ ������Ʈ�� ����ڿ��� �����ֱ�
		setVisible(true);
	
		//7. ������ ������Ʈ ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}//UseSwing
	
	//8. �߻� method Override
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//ConfirmDialog
//		int flag = JOptionPane.showConfirmDialog(this, "â�� �����ðڽ��ϴ�.");
//		
//		switch(flag) {
//		case JOptionPane.OK_OPTION:
//			dispose();
//			break;
//			
//		case JOptionPane.NO_OPTION :
//			System.out.println("�ƴϿ�");
//			break;
//		case JOptionPane.CANCEL_OPTION :
//			System.out.println("���");
//		}//end switch
//	
		
		//MessageDialog
//		JOptionPane.showMessageDialog(this, "������ ������.");
		
		//InputDialog
//		String msg = JOptionPane.showInputDialog("�ϰ���� �� �Է�");
//		System.out.println(msg);
		
		JOptionPane.showMessageDialog(this, "��ư�� Ŭ���Ǿ����ϴ�.");
	}
	
	public static void main(String[] args) {
		new UseActionEvent();
	}//main

}//UseSwing
