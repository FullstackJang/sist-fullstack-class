package day1119;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class HomeWork extends JFrame {

	public HomeWork() {
		super("����");
		
		// �̸��� - �̸��ʵ�
		JLabel jlbName = new JLabel("�̸�");
		JTextField jtxName = new JTextField();
		
		// ���̶� - �����ؽ�Ʈ�ʵ�
		JLabel jlbAge = new JLabel("����");
		JTextField jtxAGE = new JTextField();
		
		// ������ - ������ư ��,�� / ��ư�׷�Ŭ������ �Ѱ��� ���� ����
		JLabel jlbGender = new JLabel("����");
		JRadioButton jrb1 = new JRadioButton("����");
		JRadioButton jrb2 = new JRadioButton("����");
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		JLabel jlbAd = new JLabel("�ּ�");
		JTextField jtxAd = new JTextField();
		
		//JTextArea
		JTextArea jtxa = new JTextArea();

		JButton jbtninput = new JButton("�Է�");
		JButton jbtnchange = new JButton("����");
		JButton jbtndel = new JButton("����");
		JButton jbtnseach = new JButton("�˻�");
		JButton jbtnclose = new JButton("�ݱ�");

		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		
		setLayout(null);
		//�̸�
		jlbName.setBounds(40,45,120,30);
		jtxName.setBounds(70,50,100,20);
		
		//����
		jlbAge.setBounds(40,85,120,30);
		jtxAGE.setBounds(70,90,100,20);
		
		//����
		jp1.add(jlbGender);
		jp1.add(jrb1);
		jp1.add(jrb2);
		jp1.setBounds(35,120,140,50);
		
		//�ּ�
		jlbAd.setBounds(40,160,120,30);
		jtxAd.setBounds(70,170,100,20);
		
		//�����
		jp2.add(jbtninput);
		jp2.add(jbtnchange);
		jp2.add(jbtndel);
		jp2.add(jbtnseach);
		jp2.add(jbtnclose);
		jp2.setBounds(120,250,350,150);
		
		//â
		jtxa.setBounds(200,57,330,170);
		add(jlbName);
		add(jtxName);
		add(jlbAge);
		add(jtxAGE);
		add(jp1);
		add(jlbAd);
		add(jtxAd);
		add(jtxa);
		add(jp2);
	
		setBounds(100,100,600,350);
		

		

		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {

		new HomeWork();
	}

}
