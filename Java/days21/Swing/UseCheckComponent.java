package day1119;

//import java.awt.Checkbox;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class UseCheckComponent extends JFrame {

	public UseCheckComponent() {
		super("üũ�� ������ ������Ʈ");
		
		JLabel jlblHobby = new JLabel("���");
		JCheckBox jcb1 = new JCheckBox("����");
		JCheckBox jcb2 = new JCheckBox("�丮",true);
		JCheckBox jcb3 = new JCheckBox("���ǰ���");
		JCheckBox jcb4 = new JCheckBox("�ڹ�",true);
		JCheckBox jcb5 = new JCheckBox("���");
		
		
		
		JLabel jlblGender = new JLabel("����");
		JRadioButton jrb1 = new JRadioButton("����",true);
		JRadioButton jrb2 = new JRadioButton("����");
		//���� ��ư�� ������ �� �ϳ��� ���õǾ�� �ϱ� ������ ButtonGroup���� ���´�.
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		
		//���̾ƿ� �Ŵ��� ����
		setLayout(new GridLayout(2,1)); //2��1��¥�� GridLayout Frame�� layout�� GridLayout���� ���� 
		
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		
		//��ġ
		jp1.add(jlblHobby);
		jp1.add(jcb1);
		jp1.add(jcb2);
		jp1.add(jcb3);
		jp1.add(jcb4);
		jp1.add(jcb5);
		
		jp2.add(jlblGender);
		jp2.add(jrb1);
		jp2.add(jrb2);

		//������������Ʈ�� ��ġ
		add(jp1);
		add(jp2);
		
		//ũ�� ����
		setBounds(100,100,500,200);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
			new UseCheckComponent();
	}

}
