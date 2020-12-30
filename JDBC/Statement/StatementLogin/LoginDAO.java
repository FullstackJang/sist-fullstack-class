package day1230.StatementLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {

	private static LoginDAO lDAO;
	
	private LoginDAO() {
		
	}//LoginDAO
	
	public static LoginDAO getInstance() {
		if(lDAO == null) {
			lDAO = new LoginDAO();
		}//end if
		return lDAO;
	}//getInstance
	
	public String login(String id, String passwd) throws SQLException{
		String name = "";
		
		id = id.replaceAll("'", "").replaceAll(" ", "");
		
		//1. 드라이버 로딩
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}//end catch
			
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String dboid = "scott";
			String dbopass = "tiger";
			
		try {	
		//2. 커넥션얻기
			con = DriverManager.getConnection(url,dboid,dbopass);
		//3.쿼리문 생성객체 얻기
			stmt = con.createStatement();
		//4.
			StringBuilder selectId = new StringBuilder();
			
			selectId
			.append(" select name ")
			.append(" from test_login ")
			.append(" where id='").append(id).append("' and pass= '")
			.append(passwd).append("'");
			
			rs = stmt.executeQuery(selectId.toString());
			
			
			if(rs.next()) {
				name = rs.getString("name");
			}//end if
			
		}finally {
		//5. 연결 끊기
			if(rs != null) {
				rs.close();
			}//end if
			
			if(stmt != null) {
				stmt.close();
			}//end if
			
			if(con != null) {
				con.close();
			}//end if
		}//end finally
		
		
		return name;
	}//login
	
}//class
