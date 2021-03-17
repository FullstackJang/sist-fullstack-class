package day1125;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 이벤트 비교
 * 아이디 TextField에서 엔터가 눌려지면 JTextArea에 설정
 * 비밀번호 JPasswordField에서 옌터가 눌려지면 TextArea에 설정
 * @author owner
 *
 */
@SuppressWarnings("serial")
//1. 윈도우 컴포넌트 상송. 이벤트 처리객체 구현
public class EventCompare extends JFrame implements ActionListener{

	//2. 이벤트 처리에 관련있는 객체 선언
	private JTextField jtfID;
	private JPasswordField jpfPasswd;
	private JTextArea jtaTemp;
	private TextArea taTemp;
	
	//2.생성자 작성, 컴포넌트 생성
	public EventCompare() {
		super("텍스트 컴포넌트의 사용"); //TextComponent - JTextField, JPasswordField,JTextArea
		
		//3.  컴포넌트를 생성
		JLabel jlblID = new JLabel("아이디");
		jtfID = new JTextField(8);
		JLabel jlbPasswd = new JLabel("비밀번호");
		jpfPasswd = new JPasswordField(8);
		
		jtaTemp = new JTextArea(); //스크롤바가 없음.
		taTemp = new TextArea(); //스크롤바가 있음.
		
		//입력된 문자열이 TextArea의 열 범위를 넘어가면 줄을 변경
		jtaTemp.setLineWrap(true);		
		
		//단어 보호: 한글 안됨
		jtaTemp.setWrapStyleWord(true);
		
		//스크롤바 객체 생성
		JScrollPane jspTemp = new JScrollPane(jtaTemp); //jspTemp와 jtaTemp는 Has a 관계
		
		//4. Component에서 발생한 이벤트를 JVM에서 감지할 수 있도록 이벤트를 등록
		//이벤트를 처리할 객체를 넣어준다.
		jtfID.addActionListener(this);
		jpfPasswd.addActionListener(this);

		
		//5. 배치관리자 설정
		setLayout(new BorderLayout()); //JFrame의 배치관리자는 Border Layout
		
		//North에 여러 Component를 배치하기위해 Container Component생성
		JPanel jpNorth = new JPanel(); //FlowLayout
		//Center에 Component를 배치하기위해 Container Component생성
		JPanel jpCenter = new JPanel();//FlowLayout
		jpCenter.setLayout(new GridLayout(1,2)); //FlowLayout 이였다가 GridLayout으로 변경
		
		//6. 컴포넌트 배치
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
		
		//7. 윈도우 컴포넌트의 크기 설정
		setBounds(200,100,600,400);
		
		//8. 윈도우컴포넌트를 사용자에게 보여주자
		setVisible(true);
		
		//9. 종료이벤트 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseTextComponent
	
	//11. 이벤트가 발생했을 때 제공할 코드를 정의하는 method를 Override한다.
	@Override
	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource() == jtfID) {
			//텍스트필드의 값을 가져와서
			String id = jtfID.getText();
			
			//JTextArea에 추가
			jtaTemp.append(id + "\n");
			
			//TextField 값을 초기화
			jtfID.setText("");
			
			System.out.println("텍스트필드에서 이벤트 발생");
		}
		if(ae.getSource() == jpfPasswd) {
			System.out.println("패스워드에서 이벤트 발생");
			
			//JPasswordField에 값을 가져와서
			String pass = String.valueOf(jpfPasswd.getPassword());
			
			//TextArea에 추가
			taTemp.append(pass + "\n");
			
			//TextArea 값을 초기화
			jpfPasswd.setText("");
		}
	}//actionPerformed
	
	public static void main(String[] args) {
			new EventCompare();
	}//main
}//class
