package day1118;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * BorderLayout: ��跹�̾ƿ�
 * ������Ʈ�� ����ũ�Ⱑ ���õǰ� ��ġ�Ǵ� ��ġ�� ũ�⿡ �°� ����Ǵ� ���̾ƿ�
 * �ϳ��� �������� �ϳ��� ������Ʈ�� ��ġ ����
 * ������ ������Ʈ�� �⺻ ���̾ƿ�
 * @author owner
 *
 */
@SuppressWarnings("serial")
//1. ������ ������Ʈ�� JFrame�� ��ӹ޴´�.
public class TestBorderLayout extends JFrame{
	
	//2. ������ �ۼ�
	public TestBorderLayout() {
		super("BorderLayout�� ����");

		//3.Component ����
		JButton jbtnNorth = new JButton("North");
		JButton jbtnEast = new JButton("East");
		JTextField jtf = new JTextField("South"); // JTextField�� ����
		JLabel jlblWest = new JLabel("West");
		JTextArea jtaCenter = new JTextArea("Center"); //JTextArea�� ������ ����
		
		//4. ��ġ �����ڸ� ����
		setLayout(new BorderLayout());
		
		//5. ������Ʈ�� ��ġ
		//���ڿ� ����� ������Ʈ�� ��ġ�Ǵ� ��ġ�� ������ �� ����
		add("Center",jtaCenter);
		add("North",jbtnNorth);
//		BorderLayout�� ���(Constant)�� ������Ʈ�� ��ġ�Ǵ� ��ġ�� ������ �� ����
		add(BorderLayout.WEST,jlblWest);
		add(BorderLayout.SOUTH,jtf);
		add(jbtnEast,BorderLayout.EAST); // �����ε� �ؼ� jbtnEast, BorderLayout.EAST �Ķ���� ��ġ�� �ٲ��� �����ϴ�.
		//6. ������ ũ�� ����
		setSize(500,500);
		
		//7.����ڿ��� �����ֱ�
		setVisible(true);
		//8. ������ ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//TestBorderLayout
	
	
	public static void main(String[] args) {
		new TestBorderLayout();
	}//main
}//class
