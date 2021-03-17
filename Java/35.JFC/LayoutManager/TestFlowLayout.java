package day1118;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * FlowLayout: �帧���̾ƿ�
 * Ư¡
 * - ������Ʈ�� ���� ũ�⸦ ������ ��ġ�ϴ� ������� ��ġ�ȴ�.
 * - �������� ũ�Ⱑ �ٰų� �þ�� ������Ʈ�� ��ġ�� ������ �Ʒ��� �̵��Ѵ�.
 * @author owner
 *
 */
@SuppressWarnings("serial")
//1. ������ ������Ʈ�� ��ӹ޴´�.
public class TestFlowLayout extends JFrame {

	//2. ������ �ۼ�
	public TestFlowLayout() {
		super("FlowLayout�� ���.");
		
		//3.������Ʈ�� ����
		JLabel jlblName = new JLabel("�̸�");
		JTextField jtfName = new JTextField(10); //�빮�� A���� 10���� ������ ��
		JLabel jlblAge = new JLabel("����");
		
		Integer[] arrAge = new Integer[100];
		
		for(int i = 0 ; i < arrAge.length; i++) {
			arrAge[i] = i+1;
		}
		
		JComboBox<Integer> jcbAge = new JComboBox<Integer>(arrAge);
		
		JButton jbtnInput = new JButton("�Է�");
		
		//4.��ġ������ ����: BorderLayout => FlowLayout���� ����
		setLayout(new FlowLayout());
		
		//5.������Ʈ ��ġ
		add(jlblName);
		add(jtfName);
		add(jlblAge);
		add(jcbAge);
		add(jbtnInput);
		//6.������ ũ�� ����
		setSize(600,400);
	
		//7.����ڿ��� �����ֱ�
		setVisible(true);
		
		//8.������ �����̺�Ʈ ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//TestFlowLayout
	
	public static void main(String[] args) {
	
		new TestFlowLayout();
	}//main
}//class
