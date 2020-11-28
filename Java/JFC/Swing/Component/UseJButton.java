package day1119;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
//1. 윈도우 컴포넌트 상속
public class UseJButton extends JFrame{

	//2. 생성자
	public UseJButton() {
		super("이미지를 가진 JButton 사용");
		
		//3. 컴포넌트 생성
		//자바에서 사용하는 경로는 /나 \ 모두 사용 가능
		// \를 사용할 때에는 특수문자의 시작기호와 겹쳐서 \뒤의 한글자와 함께 특수문자 처리된다.
		//이때 \뒤에 한 문자가 자바에서 지원하는 특수문자가 아니라면 Error가 발생한다.
		// \를 사용하여 경로를 표현을 할 때에는 \\를 사용하여 경로를 표현한다.
		ImageIcon ii1 = new ImageIcon("/C:/dev/workspace/javase_pj/src/day1119/img/img_1.png");
		ImageIcon ii2 = new ImageIcon("C:/dev/workspace/javase_pj/src/day1119/img/img_2.png");
		ImageIcon ii3 = new ImageIcon("C:/dev/workspace/javase_pj/src/day1119/img/img_3.png");
		ImageIcon ii4 = new ImageIcon("C:/dev/workspace/javase_pj/src/day1119/img/img_4.png");

		JButton jbtn1 = new JButton("라이언",ii1);
		JButton jbtn2 = new JButton("어피치",ii2);
		JButton jbtn3 = new JButton("무지",ii3);
		
		//border 설정
		jbtn1.setBorder(new TitledBorder("카카오 프렌즈"));
		jbtn2.setBorder(new TitledBorder("카카오 프렌즈"));
		jbtn3.setBorder(new TitledBorder("카카오 프렌즈"));
		
		//버튼 3에 마우스 포인터가 올라가거나 클릭되면 이미지를 변경 : RollOver
		jbtn3.setRolloverIcon(ii4);

		//jbtn1의 텍스트의 수평 위치 이동 (LEFT, CENTER, RIGHT)
		jbtn1.setHorizontalTextPosition(JButton.RIGHT);
		
		//jbtn2의 텍스트 수직위치 이동(TOP,CENTER, BOTTOM)
		jbtn2.setVerticalTextPosition(JButton.BOTTOM);
		
		jbtn3.setHorizontalTextPosition(JButton.CENTER);
		jbtn3.setVerticalTextPosition(JButton.BOTTOM);

		//풍선도움말: Tooltip Text
		jbtn1.setToolTipText("백수의 왕");
		jbtn2.setToolTipText("복숭아의 왕");
		jbtn3.setToolTipText("단무지의 왕");
		//4. 배치관리자 설정
		setLayout(new GridLayout(1,3));
		
		//5. 배치
		add(jbtn1);
		add(jbtn2);
		add(jbtn3);
		
		//6.윈도우 크기설정
		setBounds(100,200,600,300);
		
		//7. 윈도우를 사용자에게 보여주기
		setVisible(true);
		
		//8. 종료 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseJButton
	
	public static void main(String[] args) {
			new UseJButton();
	}//main
}//class
