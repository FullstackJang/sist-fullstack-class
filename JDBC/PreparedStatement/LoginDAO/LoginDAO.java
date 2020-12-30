package day1230.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	private static LoginDAO lDAO;

	private LoginDAO() {

	}// LoginDAO

	public static LoginDAO getInstance() {
		if (lDAO == null) {
			lDAO = new LoginDAO();
		} // end if
		return lDAO;
	}// getInstance

	public String login(String id, String passwd) throws SQLException {
		String userId = "";
		// 1. ����̺� ����
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String dboid = "scott";
		String dbopass = "tiger";
		try {
			// 2. Ŀ�ؼ� ���
			con = DriverManager.getConnection(url, dboid, dbopass);

			// 3. ������ ������ü ���
			String sql = "SELECT name FROM test_login WHERE id = ? and pass=?";

			pstmt = con.prepareStatement(sql);
			// 4.������ ���� �� ��� ���
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);

			String name = "";
			rs = pstmt.executeQuery();

			if (rs.next()) {
				name = rs.getString("name");
			} // end if
			userId = name;
			
		} finally {
			// 5.���� ����
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

		return userId;
	}

}// class
