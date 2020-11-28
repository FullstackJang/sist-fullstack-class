package day1120;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class UseJTable extends JFrame {

	public UseJTable() {
		super("JTable 연습");
		
		//3. 컴포넌트 생성
		//컬럼명을 저장하는 일차원 배열을 생성
		String[] columnNames = {"번호","이름","나이","이메일","비고"};
		
		//레코드 값을 저장하는 이차원 배열 생성
		String[][] rowData = {
								{"1","류수정","23","ryu@test.com",""},
								{"2","케이","25","kei@naver.com",""},
								{"3","서지수","26","seo@hanmail.net",""},
								{"4","유지애","27","you@daum.com",""},
							 };
		//데이터를 저장할 Model객체 생성
		DefaultTableModel dtm = new DefaultTableModel(rowData,columnNames);
	
		//데이터를 보여줄 객체 생성
		JTable jta = new JTable(dtm); //JTable의 jta와 DefaultTableModel의 dtm은 Has-A관계이다.
		
		//행의 크기설정
		jta.setRowHeight(20);
		
		//컬럼의 넓이 변경
		jta.getColumnModel().getColumn(0).setPreferredWidth(80);
		jta.getColumnModel().getColumn(1).setPreferredWidth(120);
		jta.getColumnModel().getColumn(2).setPreferredWidth(80);
		jta.getColumnModel().getColumn(3).setPreferredWidth(220);

		//배치관리자 설정
		setLayout(new BorderLayout());
		
		
		//dtm에 method를 사용하여 데이터를 추가
		//배열을 선언
		String[] data= {"5","이미주","26","lee@hotmail.net",""};
		//Model객체에 데이터추가
		dtm.addRow(data);
		
		//Vector 사용
		Vector<String> vec = new Vector<String>();
		vec.add("6");
		vec.add("정예인");
		vec.add("26");
		vec.add("jeong@nate.com");
		vec.add("");
		//Model객체에 데이터추가
		dtm.addRow(vec);
		
		//스클롤바 설정
		JScrollPane jsp = new JScrollPane(jta); // jsp와 jta는 Has-a 관계
		//테두리
		jsp.setBorder(new TitledBorder("학생정보"));
		//배치
		add(jsp);
		
		setBounds(100,100,700,400);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new UseJTable();
	}
}
