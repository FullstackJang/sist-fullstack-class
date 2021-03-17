package day1118;

import java.awt.Button;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * AWT ���� ��� �� Window Application�� ������ �� �ִ� Swing�� ���
 * @author owner
 *
 */

//1. javax.swing.JFrame�� ��� �޴´�.
@SuppressWarnings("serial")
public class UseSwing extends JFrame {
	
	//2. default constructor
	public UseSwing() {
		super("JFrame�� ����Ͽ� ������ ������ ����.");
	
		//3. Component�� ����
		Button btn = new Button("AWT ��ư");
		JButton jbtn = new JButton("Swing ��ư");
		
		//4. ��ġ(Component�� ����)
		//��ġ ������(Layout Manager)�� ����Ͽ� ������Ʈ�� ��ġ
		setLayout(new GridLayout(1, 2));
		add(btn); //1�� 0��
		add(jbtn); //1�� 1��
		
		//5. ������ ũ�� ����
		setSize(400,200);
		
		//6.������ ������Ʈ�� ����ڿ��� �����ֱ�
		setVisible(true);
	
		//������ ������Ʈ ����
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//addWindowListener������Ʈ�ε� ���ᰡ ������ ���� setDefaultCloseOperation�� ���ٷ� �����ϴ°� �� ȿ�����̴�.	
//        addWindowListener(new WindowAdapter() {
//        	
//        	@Override
//        	public void windowClosing(WindowEvent e) {
//        		dispose();
//        	}
//		}); //�͸�Ŭ������ WindowAdapter�� �θ��̴�.
	}//UseSwing
	
	public static void main(String[] args) {
		new UseSwing();
	}//main
}//UseSwing
