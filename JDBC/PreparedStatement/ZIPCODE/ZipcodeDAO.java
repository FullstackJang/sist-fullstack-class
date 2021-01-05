package day1230;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ZipcodeDAO {

	private static ZipcodeDAO zDAO;

	private ZipcodeDAO() {

	}// ZipcodeDAO

	public static ZipcodeDAO getInsctance() {
		if (zDAO == null) {
			zDAO = new ZipcodeDAO();
		} // end if

		return zDAO;
	}// getInsctance

	public List<ZipcodeVO> selectZipcode(String dong) throws SQLException {
		List<ZipcodeVO> list = new ArrayList<ZipcodeVO>();

		// 1.드라이브 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String passwd = "tiger";

		try {
			// 2.
			con = DriverManager.getConnection(url, id, passwd);
			// 3.
			StringBuilder selectZipcode = new StringBuilder();
			selectZipcode.append(" select zipcode,sido,gugun,dong, nvl(bunji,' ') bunji	").append(" from zipcode	")
					.append(" where dong like ?||'%' ");
			//오라클의 검색 문자인 %와 자바의 바인드 변수가 함께 사용되면 Java에서 바인드 변수를 인식하지 못한다.
			//해결방법 : 검색 문자를 단순문자로 만들고 바인드 변수에 붙인다.
			pstmt = con.prepareStatement(selectZipcode.toString());

			// 4.
			pstmt.setString(1, dong);
			// 5.
			rs = pstmt.executeQuery();

			String zipcode = "";
			String sido = "";
			String gugun = "";
			String db_dong = "";
			String bunji = "";


			ZipcodeVO zv = null;

			while (rs.next()) {
				zipcode = rs.getString("zipcode");
				sido = rs.getString("sido");
				gugun = rs.getString("gugun");
				db_dong = rs.getString("dong");
				bunji = rs.getString("bunji");
				
//				if(bunji == null) {
//					bunji = " ";
//				}

				zv = new ZipcodeVO(zipcode, sido, gugun, db_dong, bunji);

				list.add(zv);

			} // end while

		} finally {
			// 6. 연결 끊기
			if (rs != null) {
				rs.close();
			} // end if

			if (pstmt != null) {
				pstmt.close();
			} // end if

			if (con != null) {
				con.close();
			} // end if

		} // end finally

		return list;
	}// selectZipcode

	
	/**
	 * SQLInjection이 발생
	 * @param dong
	 * @return
	 * @throws SQLException
	 */
	public List<ZipcodeVO> selectStatementZipcode(String dong) throws SQLException {
		
		List<ZipcodeVO> list = new ArrayList<ZipcodeVO>();
		//SQLInjection 방어 코드 : ',--의 특수 문자를 제거한다. 공백을 제거한다. 쿼리문에 관련된 문장을 제거
		if(dong.contains("'") || dong.contains("-") || dong.contains(" ")) {
			dong = dong.replace("'", "").replace("-", "").replace(" ", "");
		}//end if
		// 1.드라이브 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch

		Connection con = null;
		Statement stmt = null; //SQLInjection이 발생할 수 있다.
		ResultSet rs = null;

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String passwd = "tiger";

		try {
			// 2.
			con = DriverManager.getConnection(url, id, passwd);
			// 3.
			stmt = con.createStatement();
			
			// 4.
			StringBuilder selectZipcode = new StringBuilder();
			selectZipcode.append(" select zipcode,sido,gugun,dong, nvl(bunji,' ') bunji	").append(" from zipcode	")
					.append(" where dong like '").append(dong).append("%'");

			rs = stmt.executeQuery(selectZipcode.toString());

			String zipcode = "";
			String sido = "";
			String gugun = "";
			String db_dong = "";
			String bunji = "";


			ZipcodeVO zv = null;

			while (rs.next()) {
				zipcode = rs.getString("zipcode");
				sido = rs.getString("sido");
				gugun = rs.getString("gugun");
				db_dong = rs.getString("dong");
				bunji = rs.getString("bunji");
				
//				if(bunji == null) {
//					bunji = " ";
//				}

				zv = new ZipcodeVO(zipcode, sido, gugun, db_dong, bunji);

				list.add(zv);

			} // end while

		} finally {
			// 6. 연결 끊기
			if (rs != null) {
				rs.close();
			} // end if

			if (stmt != null) {
				stmt.close();
			} // end if

			if (con != null) {
				con.close();
			} // end if

		} // end finally

		return list;
	}// selectStatementZipcode
	
	

//단위테스트용 메소드
//										//main mehot에서 throws를 날리면 자바가상머신이 예외를 잡아준다.
//	public static void main(String[] args ) throws SQLException {
//	
//		ZipcodeDAO z = ZipcodeDAO.getInsctance();
//		
//		System.out.println(z.selectStatementZipcode("효성동"));
//		
//	}
	
}// class