package day1118;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * FlowLayout: 흐름레이아웃
 * 특징
 * - 컴포넌트는 고유 크기를 가지고 배치하는 순서대로 배치된다.
 * - 윈도우의 크기가 줄거나 늘어나면 컴포넌트의 위치가 위에서 아래로 이동한다.
 * @author owner
 *
 */
@SuppressWarnings("serial")
//1. 윈도우 컴포넌트를 상속받는다.
public class TestFlowLayout extends JFrame {

	//2. 생성자 작성
	public TestFlowLayout() {
		super("FlowLayout의 사용.");
		
		//3.컴포넌트의 생성
		JLabel jlblName = new JLabel("이름");
		JTextField jtfName = new JTextField(10); //대문자 A기준 10글자 보여줄 때
		JLabel jlblAge = new JLabel("나이");
		
		Integer[] arrAge = new Integer[100];
		
		for(int i = 0 ; i < arrAge.length; i++) {
			arrAge[i] = i+1;
		}
		
		JComboBox<Integer> jcbAge = new JComboBox<Integer>(arrAge);
		
		JButton jbtnInput = new JButton("입력");
		
		//4.배치관리자 설정: BorderLayout => FlowLayout으로 변경
		setLayout(new FlowLayout());
		
		//5.컴포넌트 배치
		add(jlblName);
		add(jtfName);
		add(jlblAge);
		add(jcbAge);
		add(jbtnInput);
		//6.윈도우 크기 설정
		setSize(600,400);
	
		//7.사용자에게 보여주기
		setVisible(true);
		
		//8.윈도우 종료이벤트 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//TestFlowLayout
	
	public static void main(String[] args) {
	
		new TestFlowLayout();
	}//main
}//class
