package day1119;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
//1. ������ ������Ʈ ���
public class ManualLayout extends JFrame {

	//2. ������ �ۼ�
	public ManualLayout() {
		super("������ġ ���");
		
		//3. ������Ʈ ����
		JLabel jlblName = new JLabel("�̸�");
		JTextField jtfName = new JTextField();// �÷��� ũ�⸦ �����ϴ��� setSize�� ���Ǹ� setSize�� �켱 �ȴ�.
		JButton jbtnInput = new JButton("�Է�");
		
		//4. ��ġ������ ����
		setLayout(null); //������ ������ ��ġ�������� BorderLayout�� �������.
		
		//5. ������Ʈ�� ��ġ�� ũ�� ���� : ������Ʈ�� setLocation�� JFrame�� Ÿ��Ʋ�� �Ʒ� ���� ����� ������
//		jlblName.setLocation(10, 30);
//		jlblName.setSize(80,25);
		jlblName.setBounds(10,20,80,25);
		jtfName.setBounds(100,80,120,30);
		jbtnInput.setBounds(250,400,90,25);
		//6. ������Ʈ ��ġ
		add(jlblName);
		add(jtfName);
		add(jbtnInput);
		//7. ������ ũ�� �������� ��ġ ���� : �������� setLocation�� ������� ���ʻ���� ������
		setBounds(100,100,400,500);
		
		//8. ����ڿ��� �����ֱ�
		setVisible(true);
		
		//������ ũ������ ����
		setResizable(false);
		
		//9. ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//ManualLayout
	
	public static void main(String[] args) {
		new ManualLayout();
	}//main
}//class
