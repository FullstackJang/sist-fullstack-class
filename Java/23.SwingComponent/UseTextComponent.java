package day1119;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
//1. 윈도우 컴포넌트 상송
public class UseTextComponent extends JFrame {

	//2.생성자
	public UseTextComponent() {
		super("텍스트 컴포넌트의 사용"); //TextComponent - JTextField, JPasswordField,JTextArea
		
		
		//3. 컴포넌트를 생성
		JLabel jlblID = new JLabel("아이디");
		JTextField jtfID = new JTextField(8);
		JLabel jlbPasswd = new JLabel("비밀번호");
		JPasswordField jpfPasswd = new JPasswordField(8);
		
		//반향문자 설정
//		jpfPasswd.setEchoChar('*');
		
		JTextArea jtaTemp = new JTextArea(); //스크롤바가 없음.
		TextArea taTemp = new TextArea(); //스크롤바가 있음.
		
		//입력된 문자열이 TextArea의 열 범위를 넘어가면 줄을 변경
		jtaTemp.setLineWrap(true);		
		
		//단어 보호: 한글 안됨
		jtaTemp.setWrapStyleWord(true);
		
		//스크롤바 객체 생성
		JScrollPane jspTemp = new JScrollPane(jtaTemp); //jspTemp와 jtaTemp는 Has a 관계
		
		//4. 배치관리자 설정
		setLayout(new BorderLayout()); //JFrame의 배치관리자는 Border Layout
		
		//North에 여러 Component를 배치하기위해 Container Component생성
		JPanel jpNorth = new JPanel(); //FlowLayout
		//Center에 Component를 배치하기위해 Container Component생성
		JPanel jpCenter = new JPanel();//FlowLayout
		jpCenter.setLayout(new GridLayout(1,2)); //FlowLayout 이였다가 GridLayout으로 변경
		
		//5. 컴포넌트 배치
		//BorderLayout의 North영역에 들어갈 컴포넌트를 Container Component에 배치
		jpNorth.add(jlblID);
		jpNorth.add(jtfID);
		jpNorth.add(jlbPasswd);
		jpNorth.add(jpfPasswd);
		
		
		
		//BorderLayout의 Center영역에 들어갈 컴포넌트를 Container Component에 배치
		jpCenter.add(jspTemp);
		jpCenter.add(taTemp);
		
		//여러개의 컴포넌트를 가진 Container Component 하나를 Window Component에 배치
		add("North",jpNorth);
		add("Center",jpCenter);
		
		//6. 윈도우 컴포넌트의 크기 설정
		setBounds(200,100,600,400);
		
		//7. 윈도우컴포넌트를 사용자에게 보여주자
		setVisible(true);
		
		//8. 종료이벤트 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}//UseTextComponent
	
	public static void main(String[] args) {
			new UseTextComponent();
	}//main
}//class
