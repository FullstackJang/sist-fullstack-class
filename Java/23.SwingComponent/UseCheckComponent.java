package day1119;

//import java.awt.Checkbox;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class UseCheckComponent extends JFrame {

	public UseCheckComponent() {
		super("체크가 가능한 컴포넌트");
		
		JLabel jlblHobby = new JLabel("취미");
		JCheckBox jcb1 = new JCheckBox("낚시");
		JCheckBox jcb2 = new JCheckBox("요리",true);
		JCheckBox jcb3 = new JCheckBox("음악감상");
		JCheckBox jcb4 = new JCheckBox("자바",true);
		JCheckBox jcb5 = new JCheckBox("등산");
		
		
		
		JLabel jlblGender = new JLabel("성별");
		JRadioButton jrb1 = new JRadioButton("남자",true);
		JRadioButton jrb2 = new JRadioButton("여자");
		//라디오 버튼은 여러개 중 하나만 선택되어야 하기 때문에 ButtonGroup으로 묶는다.
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		
		//레이아웃 매니저 설정
		setLayout(new GridLayout(2,1)); //2행1열짜리 GridLayout Frame에 layout만 GridLayout으로 변경 
		
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		
		//배치
		jp1.add(jlblHobby);
		jp1.add(jcb1);
		jp1.add(jcb2);
		jp1.add(jcb3);
		jp1.add(jcb4);
		jp1.add(jcb5);
		
		jp2.add(jlblGender);
		jp2.add(jrb1);
		jp2.add(jrb2);

		//윈도우컴포넌트에 배치
		add(jp1);
		add(jp2);
		
		//크기 설정
		setBounds(100,100,500,200);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
			new UseCheckComponent();
	}

}
