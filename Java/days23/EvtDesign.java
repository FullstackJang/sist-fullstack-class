package day1125;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * ActionEvent�� ActionListener�� ó��
 * @author owner
 *
 */

//1. ������ ������Ʈ�� ����
@SuppressWarnings("serial")
public class EvtDesign extends JFrame {
	
	//2. �̺�Ʈ�� �߻����� �� ó���� Component�� ����
	private JButton jbtn;
	private JLabel jlbl;
	private JTextField jtf;
	
	//2. default constructor����, Component�� ����
	public EvtDesign() {
		super("ActionEvent ó��");
	
		//3. Component�� ����
		jlbl = new JLabel("���JLabel");
		jbtn = new JButton("Swing ��ư");
		jtf=new JTextField();
		//4. �̺�Ʈó�� ��ü�� has a ����� �����ϰ�, 
		HasAEvt hasA = new HasAEvt(this);
		//�̺�Ʈ ó����ü���� �̺�Ʈ�� ó���� �� �ֵ��� ��� addXxxListener
		
		jbtn.addActionListener(hasA); //is a ����� �̺�Ʈ�� ó���ϴ� �����̹Ƿ� �� ��ü�ȿ��� �̺�Ʈ�� ó���� ���̴�.
		
		//4. ��ġ(Component�� ����)
		add("Center",jbtn); //1�� 1��
		add("North",jlbl);
		add("South",jtf);
		//5. ������ ũ�� ����
		setSize(400,200);
		
		//6.������ ������Ʈ�� ����ڿ��� �����ֱ�
		setVisible(true);
	
		//7. ������ ������Ʈ ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}//UseSwing
	

	//8. �̺�Ʈ ó��Ŭ�������� Component�� ����� �� �ֵ��� getter method�� �ۼ�
	public JButton getJbtn() {
		return jbtn;
	}//getJbtn


	public JLabel getJlbl() {
		return jlbl;
	}//getJlbl

	
	
	public JTextField getJtf() {
		return jtf;
	}//JTextField


	public static void main(String[] args) {
		new EvtDesign();
	}//main

}//UseSwing
