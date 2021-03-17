package day1120;

import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class UseJList extends JFrame {

	public UseJList() {
		super("JList 사용");
		
		//3. 컴포넌트 생성
		//데이터를 가진 Model 클래스로 객체 생성
		DefaultListModel<String> dlmFriends = new DefaultListModel<String>();
		DefaultListModel<String> dlmBlockFriends = new DefaultListModel<String>();
		
		//4. 값 설정
		dlmFriends.addElement("라이언");
		dlmFriends.addElement("무지");
		dlmFriends.addElement("어피치");
		dlmFriends.addElement("제이지");
		
		dlmBlockFriends.addElement("브라운");
		dlmBlockFriends.addElement("코니");

		//데이터를 보여줄 수 있는 View 객체를 생성
		JList<String> jlFriends = new JList<String>(dlmFriends);
		JList<String> jlBlockFriends = new JList<String>(dlmBlockFriends);
		
		
		//스크롤바를 설정
		JScrollPane jspFriends = new JScrollPane(jlFriends);
		JScrollPane jspBlockFriends = new JScrollPane(jlBlockFriends);
		
		//Component에 TitledBorder 설정
		jspFriends.setBorder(new TitledBorder("친구목록"));
		jspBlockFriends.setBorder(new TitledBorder("차단목록"));
		
		//배치
		setLayout(new GridLayout(1,2));

		add(jspFriends);
		add(jspBlockFriends);
		
		
		//JList는 ScrollBar가 없다.
//		add(jlFriends);
//		add(jlBlockFriends);
		
		setBounds(100,100,400,300);
		
		setVisible(true);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//UseJList
	
	public static void main(String[] args) {
		new UseJList();
	}//main
}//class
