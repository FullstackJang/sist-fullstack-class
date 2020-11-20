package day1120;

import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 
 * JComboBox => java.awt에서 Choice 객체로 사용할 수 있음
 * 
 * JComboBox는 MVC패턴으로 만들어진거고
 * Choice는 MVc패턴이 아니다.
 * @author owner
 *
 */
@SuppressWarnings("serial")
public class UseJCombo extends JFrame {

	public UseJCombo() {
			super("");
			
			//3. 컴포넌트의 생성
			JLabel jlblEmail = new JLabel("이몌일");
			JTextField jtfEmail = new JTextField(15);
			JLabel jlblEmailAt = new JLabel("@");
			
			//Model객체 생성
			
			String[] tempDomain = {"gmail.com","daum.net","naver.com","nate.com"};
			
			DefaultComboBoxModel<String> dcbmDomain = new DefaultComboBoxModel<String>(tempDomain);
			
			//Model에 데이터를 추가로 추가해보자.
			dcbmDomain.addElement("hotmail.com");
			
			//View객체 생성하고, Model객체와 관계를 설정
			JComboBox<String> jcbDomain = new JComboBox<String>(dcbmDomain);
			
			//4. 배치관리자를 설정 
			setLayout(new FlowLayout()); //BorderLayout => FlowLayout으로 변경
			
			
			add(jlblEmail);
			add(jtfEmail);
			add(jlblEmailAt);
			add(jcbDomain);
			
			
			
			//5. 크기설정
			setBounds(200,100,400,100);
			
			
			//6. 가시화
			setVisible(true);

			//7. 종료
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
	}//UseJCombo
	
	public static void main(String[] args) {
		new UseJCombo();
	}//main
}//class
