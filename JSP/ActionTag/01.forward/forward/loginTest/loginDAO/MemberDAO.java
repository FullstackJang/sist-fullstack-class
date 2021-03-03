package com.sist.loginDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sist.BeanVo.MemberVo;

public class MemberDAO {

	private static MemberDAO mDAO;
	
	private MemberDAO() {
		
	}
	
	public static MemberDAO getInstance() {
		
		if(mDAO == null) {
			mDAO = new MemberDAO();
		}
		return mDAO;
	}
	
	private Connection getConnection() throws SQLException {
		// 1. 드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end catch

		// 2. Connection 얻기
		Connection con = null;

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";

		con = DriverManager.getConnection(url, id, pass);

		return con;
	}// getConnection
	
	public boolean isMember(String userID, String userPw) throws SQLException{
		
		boolean flag = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			
			String SQL = "SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? ";
			
			conn = getConnection();
			
			pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1,userID);
			pstmt.setString(2, userPw);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
					flag = true;
			}
			
		}finally {
			
			if(rs != null) {
				rs.close();
			}
			
			if(pstmt != null) {
				pstmt.close();
			}
			
			if(conn != null) {
				conn.close();
			}
			
		}//end finally
		
		return flag;
	}
	
	
	public int insertMember(MemberVo m) {
		int re = -1;

		Connection conn =null;
		PreparedStatement pstmt = null;
		
		try {
			
			String sql = " INSERT INTO member VALUES(?,?,?,?) ";
			
			conn = getConnection();
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1,m.getId());
			pstmt.setString(2, m.getName());
			pstmt.setString(3,m.getPwd());
			pstmt.setString(4,m.getEmail());
			
			re = pstmt.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return re;
	}//insertMember
	
	
}//class
