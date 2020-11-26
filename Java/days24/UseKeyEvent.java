package day1126;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * Ű������ Ű�� ������ �� �߻��ϴ� �̺�Ʈ ó��
 * @author owner
 */
@SuppressWarnings("serial")
public class UseKeyEvent extends JFrame implements KeyListener {

	private JTextField jtf;
	private JTextArea jta;

	public UseKeyEvent() {
		super("Ű���� �̺�Ʈ ó��");

		jtf = new JTextField();
		jta = new JTextArea();
	
		
		//�̺�Ʈ ���
		jtf.addKeyListener(this);
//		jta.addKeyListener(l);
		
		JScrollPane jsp = new JScrollPane(jta);
		
		jtf.setBorder(new TitledBorder("�ƹ�Ű�� �����ּ���."));
		jsp.setBorder(new LineBorder(Color.red));
		
		
		add("North", jtf);
		add("Center", jsp);
	
		setBounds(100,100,400,300);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//UseKeyEvent
	
	@Override
	public void keyTyped(KeyEvent ke) {
//		System.out.println("2. keyTyped");
		// Ű�ڵ�� ������� �ʴ´�.
		System.out.println(ke.getKeyCode() + "/" + ke.getKeyChar());
		
	}//keyTyped

	@Override
	public void keyPressed(KeyEvent ke) {
//		System.out.println("1. keyPressed");
		// keyCode�� ASCII Code�� �ƴϰ� Ű������ Ű�� �ĺ��ϱ� ���� ���� ��
		//ASCII Code�� �ҹ��ڿ� �빮�ڸ� �ĺ��ϱ� ���� �ٸ� �ڵ� ���� ������. a(97), A(65)
		//KeyCode�� a��� ��ҹ��ڸ� ������ �ʰ� �����ϴ�.
		jta.append(ke.getKeyCode() + "/" + ke.getKeyChar() + "\n");
		
		int x = getX(); //�������� X��ǥ
		int y = getY(); //�������� y��ǥ
		
		switch(ke.getKeyCode()) {
		case KeyEvent.VK_LEFT : x -=10;break;
		case KeyEvent.VK_RIGHT : x +=10;break;
		case KeyEvent.VK_UP :  y-=10;break;
		case KeyEvent.VK_DOWN : y +=10;break;
		case KeyEvent.VK_ESCAPE :
			switch(JOptionPane.showConfirmDialog(this,"���α׷��� �����Ͻðڽ��ϱ�?")) {
			case JOptionPane.OK_OPTION :
				dispose();
			}
		}
		setLocation(x,y);
		
	}//keyPressed

	@Override
	public void keyReleased(KeyEvent ke) {
//		System.out.println("3. keyReleased");
		System.out.println(ke.getKeyCode() + "/" + ke.getKeyChar());
	}//keyReleased

    

	public static void main(String[] args) {
		new UseKeyEvent();
	}//main
}//class
