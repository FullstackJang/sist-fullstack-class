package day1119;

//import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")

//1. Window Component�� JFrame ��ӹޱ�
public class UseLayOutManager extends JFrame {

	//2. ������ �ۼ�
	public UseLayOutManager() {
		super("�������� ���̾ƿ� ���");
		
		//3. ������Ʈ�� ����
		// jlb=jlabel + Name => ������Ʈ���� + �ϴ��Ϸ� �̸��� �����ϴ� ���� �밡���� �����̶�� �Ѵ�.
		JLabel jlblName = new JLabel("�̸�");
		JTextField jtfName = new JTextField(20);
		JButton jbtnInput = new JButton("�Է�");
		JTextArea jtaNameDisplay = new JTextArea();
		
		
		//4. ��ġ������ ����		
//		setLayout(new BorderLayout());//BorderLayout�� �ϳ��� ������ �ϳ��� ������Ʈ�� ��ġ�� �� �ִ�.
		
		//���ʿ��� �������� ������Ʈ�� �ѹ��� ��ġ�Ǿ���ϹǷ� Container Component�� JPanel�� �ʿ��ϴ�.
		
		JPanel jpNorth = new JPanel(); //FlowLayout
		//�����̳� ������Ʈ�� ���̾ƿ� ����
		jpNorth.setLayout(new FlowLayout());
		
		//�Ϲ� ������Ʈ�� �����̳� ������Ʈ�� ��ġ
		jpNorth.add(jlblName);
		jpNorth.add(jtfName);
		jpNorth.add(jbtnInput);
		
		//5. Component��ġ
		//BorderLayout�� �ϳ��� ������ �ϳ��� ������Ʈ�� ��ġ�� �� �ִ�.
		add("North",jpNorth);
		add("North",jpNorth);
		add("North",jpNorth); //jlblName��jtfName�� �������°� �ƴ϶� jbtnInput�ؿ� �򸰴�.
		add("Center",jtaNameDisplay);
		
		//6.������ ������Ʈ�� JFrameũ�⼳��
		setLocation(500,100);
		setSize(400,300);
		
		//7. ������ ������Ʈ�� JFrame�� ����ڿ��� �����ֱ�
		setVisible(true);
		
		//8. ������ ������Ʈ�� ����ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseLayOutManager
	
	public static void main(String[] args) {

		new UseLayOutManager();
		
	}//main
}//class
