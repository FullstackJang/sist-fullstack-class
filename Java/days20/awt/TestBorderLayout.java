package day1118;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * BorderLayout: 경계레이아웃
 * 컴포넌트의 고유크기가 무시되고 배치되는 위치의 크기에 맞게 변경되는 레이아웃
 * 하나의 영역에는 하나의 컴포넌트만 배치 가능
 * 윈도우 컴포넌트의 기본 레이아웃
 * @author owner
 *
 */
@SuppressWarnings("serial")
//1. 윈도우 컴포넌트인 JFrame을 상속받는다.
public class TestBorderLayout extends JFrame{
	
	//2. 생성자 작성
	public TestBorderLayout() {
		super("BorderLayout의 연습");

		//3.Component 생성
		JButton jbtnNorth = new JButton("North");
		JButton jbtnEast = new JButton("East");
		JTextField jtf = new JTextField("South"); // JTextField는 한줄
		JLabel jlblWest = new JLabel("West");
		JTextArea jtaCenter = new JTextArea("Center"); //JTextArea는 여러줄 가능
		
		//4. 배치 관리자를 설정
		setLayout(new BorderLayout());
		
		//5. 컴포넌트의 배치
		//문자열 상수로 컴포넌트가 배치되는 위치를 설정할 수 있음
		add("Center",jtaCenter);
		add("North",jbtnNorth);
//		BorderLayout의 상수(Constant)로 컴포넌트가 배치되는 위치를 설정할 수 있음
		add(BorderLayout.WEST,jlblWest);
		add(BorderLayout.SOUTH,jtf);
		add(jbtnEast,BorderLayout.EAST); // 오버로딩 해서 jbtnEast, BorderLayout.EAST 파라미터 위치가 바껴도 무관하다.
		//6. 윈도우 크기 설정
		setSize(500,500);
		
		//7.사용자에게 보여주기
		setVisible(true);
		//8. 윈도우 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//TestBorderLayout
	
	
	public static void main(String[] args) {
		new TestBorderLayout();
	}//main
}//class
