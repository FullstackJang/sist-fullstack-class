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
 * 키보드의 키가 눌렸을 때 발생하는 이벤트 처리
 * @author owner
 */
@SuppressWarnings("serial")
public class UseKeyEvent extends JFrame implements KeyListener {

	private JTextField jtf;
	private JTextArea jta;

	public UseKeyEvent() {
		super("키보드 이벤트 처리");

		jtf = new JTextField();
		jta = new JTextArea();
	
		
		//이벤트 등록
		jtf.addKeyListener(this);
//		jta.addKeyListener(l);
		
		JScrollPane jsp = new JScrollPane(jta);
		
		jtf.setBorder(new TitledBorder("아무키나 눌러주세요."));
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
		// 키코드는 얻어지지 않는다.
		System.out.println(ke.getKeyCode() + "/" + ke.getKeyChar());
		
	}//keyTyped

	@Override
	public void keyPressed(KeyEvent ke) {
//		System.out.println("1. keyPressed");
		// keyCode는 ASCII Code가 아니고 키보드의 키를 식별하기 위한 고유 값
		//ASCII Code는 소문자와 대문자를 식별하기 위해 다른 코드 값을 가진다. a(97), A(65)
		//KeyCode는 a라면 대소문자를 가리지 않고 동일하다.
		jta.append(ke.getKeyCode() + "/" + ke.getKeyChar() + "\n");
		
		int x = getX(); //프례임의 X좌표
		int y = getY(); //프레임의 y좌표
		
		switch(ke.getKeyCode()) {
		case KeyEvent.VK_LEFT : x -=10;break;
		case KeyEvent.VK_RIGHT : x +=10;break;
		case KeyEvent.VK_UP :  y-=10;break;
		case KeyEvent.VK_DOWN : y +=10;break;
		case KeyEvent.VK_ESCAPE :
			switch(JOptionPane.showConfirmDialog(this,"프로그램을 종료하시겠습니까?")) {
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
