package day1230;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")

//1. Window Component인 JFrame 상속받기
public class ZipcodeSearch extends JFrame {

	private JButton jbtnInput;
	private JTextArea jtaZipcodeDisplay;
	private JScrollPane jspZipcodeScroll;
	private JTextField jtfDong;

	// 2. 생성자 작성
	public ZipcodeSearch() {
		super("우편번호 검색");

		// 3. 컴포넌트를 생성
		// jlb=jlabel + Name => 컴포넌트종류 + 하는일로 이름을 지정하는 것을 헝가리안 네임이라고 한다.
		JLabel jlblZipcode = new JLabel("우편번호");
		jtfDong = new JTextField(20);
		jbtnInput = new JButton("입력");
		jtaZipcodeDisplay = new JTextArea();
		jspZipcodeScroll = new JScrollPane(jtaZipcodeDisplay);

		// 4. 배치관리자 설정
//		setLayout(new BorderLayout());//BorderLayout은 하나의 영역에 하나의 컴포넌트만 배치할 수 있다.

		// 북쪽에는 여러개의 컴포넌트가 한번에 배치되어야하므로 Container Component인 JPanel이 필요하다.

		JPanel jpNorth = new JPanel(); // FlowLayout
		// 컨테이너 컴포넌트에 레이아웃 설정
		jpNorth.setLayout(new FlowLayout());

		// 일반 컴포넌트를 컨테이너 컴포넌트에 배치
		jpNorth.add(jlblZipcode);
		jpNorth.add(jtfDong);
		jpNorth.add(jbtnInput);

		// 5. Component배치
		// BorderLayout은 하나의 영역에 하나의 컴포넌트만 배치할 수 있다.
		add("North", jpNorth);
		add("North", jpNorth);
		add("North", jpNorth); // jlblName과jtfName은 없어지는게 아니라 jbtnInput밑에 깔린다.
		add("Center", jspZipcodeScroll);

		//inner class로 이벤트 처리 (관계는 HAS a)
		//inner class로 만들어도 HAS A이다.
		
		InnerEvt ie = this.new InnerEvt();
					 //바깥클래스명.new 객체명();
		jbtnInput.addActionListener(ie);
		jtfDong.addActionListener(ie);
		
		// 6.윈도우 컴포넌트인 JFrame크기설정
		setLocation(500, 100);
		setSize(400, 300);

		// 7. 윈도우 컴포넌트인 JFrame을 사용자에게 보여주기
		setVisible(true);

		// 8. 윈도우 컴포넌트의 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// UseLayOutManager

	/////////////////////// inner class로 이벤트 처리 코드 구현 /////////////////////////////
	
	public class InnerEvt implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			String dong = jtfDong.getText().trim();
			if(!"".equals(dong)) {
				setZipcode(dong);
				jtfDong.setText("");
			}//end if
		
		}//actionPerformed
		
		public void setZipcode(String dong) {

		ZipcodeDAO zDAO = ZipcodeDAO.getInsctance();
		try {
			List<ZipcodeVO> listZipcode = zDAO.selectZipcode(dong);//PreparedStatement
//			List<ZipcodeVO> listZipcode = zDAO.selectStatementZipcode(dong);//Statement
			
			StringBuilder sbOutput = new StringBuilder();
			
			sbOutput.append("[").append(dong).append("] 으로 검색한 결과 \n");
			sbOutput.append("==============================================\n");
			sbOutput.append("우편번호\t주소\n");
			if(listZipcode.isEmpty()) {
				sbOutput.append("입력하신 동은 존재하지 않습니다.\n 동이름을 확인하세요.");
			}//end if
			
			for(ZipcodeVO zVO : listZipcode) {
				sbOutput.append(zVO.getZipcode()).append("\t")
				.append(zVO.getSido()).append(" ")
				.append(zVO.getGugun()).append(" ")
				.append(zVO.getDong()).append(" ")
				.append(zVO.getBunji()).append("\n");
				
			}//end for
			
			jtaZipcodeDisplay.setText(sbOutput.toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		}//setZipcode
		
	}//class
	/////////////////////// inner class로 이벤트 처리 코드 구현 /////////////////////////////
	
	public static void main(String[] args) {

		new ZipcodeSearch();

	}// main
}// class