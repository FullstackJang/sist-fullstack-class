package day1126;

import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class UseListSelectionEvt extends JFrame implements ListSelectionListener {
	private DefaultListModel<String> dlmFriends;
	private DefaultListModel<String> dlmBlockFriends;
	private JList<String> jlFriends;
	private JList<String> jlBlockFriends;
	
	public UseListSelectionEvt() {
		super("JList 사용");
		
		//3. 컴포넌트 생성
		//데이터를 가진 Model 클래스로 객체 생성
		dlmFriends = new DefaultListModel<String>();
		dlmBlockFriends = new DefaultListModel<String>();
		
		//4. 값 설정
		dlmFriends.addElement("라이언");
		dlmFriends.addElement("무지");
		dlmFriends.addElement("어피치");
		dlmFriends.addElement("제이지");
		
		dlmBlockFriends.addElement("브라운");
		dlmBlockFriends.addElement("코니");

		//데이터를 보여줄 수 있는 View 객체를 생성
		jlFriends = new JList<String>(dlmFriends);
		jlBlockFriends = new JList<String>(dlmBlockFriends);
		
		
		//리스트에서 발생되는 이벤트를 처리하기 위해서 이벤트에 등록하고, 이벤트 처리할 객체를 넣어준다.
		jlFriends.addListSelectionListener(this); 
		
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

	boolean flag;
	@Override
	public void valueChanged(ListSelectionEvent lse) {
		
		if(flag) System.out.println(dlmFriends.get(jlFriends.getSelectedIndex()));
		flag = !flag;
	}//valueChanged
	
	public static void main(String[] args) {
		new UseListSelectionEvt();
	}//main
}//class
