package day1125;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class Homework extends JFrame {
	
	//�̺�Ʈ�� �߻����� �� ó���� Component�� ����
			private JTextField jtxID;
			private JPasswordField jtxPW;
			private JTextField jtxPrint;

	// default constructor����, Component�� ����
	public Homework() {
		super();
		
		//������Ʈ ����
		//���̵�
		jtxID = new JTextField();
		TitledBorder tb = new TitledBorder("���̵�");
		jtxID.setBorder(tb);
		//��й�ȣ
		jtxPW = new JPasswordField();
		TitledBorder tb1 = new TitledBorder("��й�ȣ");
		jtxPW.setBorder(tb1);
		//���
		jtxPrint = new JTextField();
		TitledBorder tb2 = new TitledBorder("���");
		jtxPrint.setBorder(tb2);

		//has-a
		HomeworkHasA hwha = new HomeworkHasA(this);
		
		jtxID.addActionListener(hwha);
		jtxPW.addActionListener(hwha);
		jtxPrint.addActionListener(hwha);
		
		setLayout(null);
		
		//���̵�
		jtxID.setBounds(10,10,450,50);
		
		//��й�ȣ
		jtxPW.setBounds(10,80,450,50);
		
		//���
		jtxPrint.setBounds(10,160,450,50);

		add(jtxID);
		add(jtxPW);
		add(jtxPrint);
		
		setBounds(100,100,500,280);
		
		setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//Homework

	
	public JTextField jtxID() {
		return jtxID;
	}

	public JTextField getJtxID() {
		return jtxID;
	}


	public JPasswordField getJtxPW() {
		return jtxPW;
	}


	public JTextField getJtxPrint() {
		return jtxPrint;
	}


	public static void main(String[] args) {
		new Homework();
	}
}
