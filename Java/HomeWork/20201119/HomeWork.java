package day1119;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class HomeWork extends JFrame {

	public HomeWork() {
		super("숙제");
		
		// 이름라벨 - 이름필드
		JLabel jlbName = new JLabel("이름");
		JTextField jtxName = new JTextField();
		
		// 나이라벨 - 나이텍스트필드
		JLabel jlbAge = new JLabel("나이");
		JTextField jtxAGE = new JTextField();
		
		// 성별라벨 - 라디오버튼 남,녀 / 버튼그룹클래스로 한개만 선택 가능
		JLabel jlbGender = new JLabel("성별");
		JRadioButton jrb1 = new JRadioButton("남자");
		JRadioButton jrb2 = new JRadioButton("여자");
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		JLabel jlbAd = new JLabel("주소");
		JTextField jtxAd = new JTextField();
		
		//JTextArea
		JTextArea jtxa = new JTextArea();

		JButton jbtninput = new JButton("입력");
		JButton jbtnchange = new JButton("변경");
		JButton jbtndel = new JButton("삭제");
		JButton jbtnseach = new JButton("검색");
		JButton jbtnclose = new JButton("닫기");

		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		
		setLayout(null);
		//이름
		jlbName.setBounds(40,45,120,30);
		jtxName.setBounds(70,50,100,20);
		
		//나이
		jlbAge.setBounds(40,85,120,30);
		jtxAGE.setBounds(70,90,100,20);
		
		//성별
		jp1.add(jlbGender);
		jp1.add(jrb1);
		jp1.add(jrb2);
		jp1.setBounds(35,120,140,50);
		
		//주소
		jlbAd.setBounds(40,160,120,30);
		jtxAd.setBounds(70,170,100,20);
		
		//입출력
		jp2.add(jbtninput);
		jp2.add(jbtnchange);
		jp2.add(jbtndel);
		jp2.add(jbtnseach);
		jp2.add(jbtnclose);
		jp2.setBounds(120,250,350,150);
		
		//창
		jtxa.setBounds(200,57,330,170);
		add(jlbName);
		add(jtxName);
		add(jlbAge);
		add(jtxAGE);
		add(jp1);
		add(jlbAd);
		add(jtxAd);
		add(jtxa);
		add(jp2);
	
		setBounds(100,100,600,350);
		

		

		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {

		new HomeWork();
	}

}
