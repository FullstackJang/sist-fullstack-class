package day1119;

//import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")

//1. Window Component인 JFrame 상속받기
public class UseLayOutManager extends JFrame {

	//2. 생성자 작성
	public UseLayOutManager() {
		super("여러개의 레이아웃 사용");
		
		//3. 컴포넌트를 생성
		// jlb=jlabel + Name => 컴포넌트종류 + 하는일로 이름을 지정하는 것을 헝가리안 네임이라고 한다.
		JLabel jlblName = new JLabel("이름");
		JTextField jtfName = new JTextField(20);
		JButton jbtnInput = new JButton("입력");
		JTextArea jtaNameDisplay = new JTextArea();
		
		
		//4. 배치관리자 설정		
//		setLayout(new BorderLayout());//BorderLayout은 하나의 영역에 하나의 컴포넌트만 배치할 수 있다.
		
		//북쪽에는 여러개의 컴포넌트가 한번에 배치되어야하므로 Container Component인 JPanel이 필요하다.
		
		JPanel jpNorth = new JPanel(); //FlowLayout
		//컨테이너 컴포넌트에 레이아웃 설정
		jpNorth.setLayout(new FlowLayout());
		
		//일반 컴포넌트를 컨테이너 컴포넌트에 배치
		jpNorth.add(jlblName);
		jpNorth.add(jtfName);
		jpNorth.add(jbtnInput);
		
		//5. Component배치
		//BorderLayout은 하나의 영역에 하나의 컴포넌트만 배치할 수 있다.
		add("North",jpNorth);
		add("North",jpNorth);
		add("North",jpNorth); //jlblName과jtfName은 없어지는게 아니라 jbtnInput밑에 깔린다.
		add("Center",jtaNameDisplay);
		
		//6.윈도우 컴포넌트인 JFrame크기설정
		setLocation(500,100);
		setSize(400,300);
		
		//7. 윈도우 컴포넌트인 JFrame을 사용자에게 보여주기
		setVisible(true);
		
		//8. 윈도우 컴포넌트의 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseLayOutManager
	
	public static void main(String[] args) {

		new UseLayOutManager();
		
	}//main
}//class
