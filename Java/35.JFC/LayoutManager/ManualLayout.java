package day1119;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
//1. 윈도우 컴포넌트 상속
public class ManualLayout extends JFrame {

	//2. 생성자 작성
	public ManualLayout() {
		super("수동배치 사용");
		
		//3. 컴포넌트 생성
		JLabel jlblName = new JLabel("이름");
		JTextField jtfName = new JTextField();// 컬럼의 크기를 설정하더라도 setSize가 사용되면 setSize가 우선 된다.
		JButton jbtnInput = new JButton("입력");
		
		//4. 배치관리자 설정
		setLayout(null); //기존의 설정된 배치관리자인 BorderLayout이 사라진다.
		
		//5. 컴포넌트의 위치와 크기 설정 : 컴포넌트의 setLocation은 JFrame의 타이틀바 아래 왼쪽 상단이 시작점
//		jlblName.setLocation(10, 30);
//		jlblName.setSize(80,25);
		jlblName.setBounds(10,20,80,25);
		jtfName.setBounds(100,80,120,30);
		jbtnInput.setBounds(250,400,90,25);
		//6. 컴포넌트 배치
		add(jlblName);
		add(jtfName);
		add(jbtnInput);
		//7. 윈도우 크기 보여지는 위치 설정 : 프레임의 setLocation은 모니터의 왼쪽상단이 시작점
		setBounds(100,100,400,500);
		
		//8. 사용자에게 보여주기
		setVisible(true);
		
		//윈도우 크기조절 막기
		setResizable(false);
		
		//9. 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//ManualLayout
	
	public static void main(String[] args) {
		new ManualLayout();
	}//main
}//class
