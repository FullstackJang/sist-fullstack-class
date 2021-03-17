package day1125;

import java.awt.BorderLayout;
//import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")

//1. Window Component�� JFrame ��ӹޱ�, �̺�Ʈó�� Listener ����
public class UseActionEvent2 extends JFrame implements ActionListener{
	//2. �̺�Ʈó���� �����ִ� ������Ʈ ����
	private JTextField jtfName;
	private JButton jbtnInput;
	private JTextArea jtaNameDisplay;

	//2. ������ �ۼ�
	public UseActionEvent2() {
		super("�������� ���̾ƿ� ���");
		
		//3. ������Ʈ�� �ۼ�. ������Ʈ ����
		// jlb=jlabel + Name => ������Ʈ���� + �ϴ��Ϸ� �̸��� �����ϴ� ���� �밡���� �����̶�� �Ѵ�.
		JLabel jlblName = new JLabel("�̸�");
		 jtfName = new JTextField(20);
		 jbtnInput = new JButton("�Է�");
		 jtaNameDisplay = new JTextArea();
		
		 //4. �̺�Ʈ�� ��� . add XxxListener
		 jbtnInput.addActionListener(this); //��ư�� Ŭ���Ǹ� �̺�Ʈ ó�� �ڵ����
		 jtfName.addActionListener(this); //JTextField���� ����Ű�� ������ �̺�Ʈ ó���ڵ� ����
		
		//5. ��ġ������ ����		
//		setLayout(new BorderLayout());//BorderLayout�� �ϳ��� ������ �ϳ��� ������Ʈ�� ��ġ�� �� �ִ�.
		
		//���ʿ��� �������� ������Ʈ�� �ѹ��� ��ġ�Ǿ���ϹǷ� Container Component�� JPanel�� �ʿ��ϴ�.
		
		JPanel jpNorth = new JPanel(); //FlowLayout
		//�����̳� ������Ʈ�� ���̾ƿ� ����
		jpNorth.setLayout(new FlowLayout());
		
		//�Ϲ� ������Ʈ�� �����̳� ������Ʈ�� ��ġ
		jpNorth.add(jlblName);
		jpNorth.add(jtfName);
		jpNorth.add(jbtnInput);
		
		//6. Component��ġ
		//BorderLayout�� �ϳ��� ������ �ϳ��� ������Ʈ�� ��ġ�� �� �ִ�.
		add("North",jpNorth);
		add("North",jpNorth);
		add("North",jpNorth); //jlblName��jtfName�� �������°� �ƴ϶� jbtnInput�ؿ� �򸰴�.
		add("Center",jtaNameDisplay);
		
		//7.������ ������Ʈ�� JFrameũ�⼳��
		setLocation(500,100);
		setSize(400,300);
		
		//8. ������ ������Ʈ�� JFrame�� ����ڿ��� �����ֱ�
		setVisible(true);
		
		//9. ������ ������Ʈ�� ����ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseLayOutManager
	
	//10. abstract method Override
	@Override
	public void actionPerformed(ActionEvent e) {
		//JTextField�� �Է°��� �����ͼ� 
		String text = jtfName.getText();
//		System.out.println(text);
		
		//JTextArea�� �߰�
		jtaNameDisplay.append(text+ "\n");
		//JTextField�� ���� ����
		jtfName.setText("");
		
		//JTextField�� cursor�� ��ġ: 
		jtfName.requestFocus();
		
	}//actionPerformed
	
	
	public static void main(String[] args) {

		new UseActionEvent2();
		
	}//main

	
}//class
