package day0104;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColumnViewDAO {

	private static ColumnViewDAO cvDAO;

	private ColumnViewDAO() {

	}// ColumnViewDAO

	public static ColumnViewDAO getInstance() {
		if (cvDAO == null) {
			cvDAO = new ColumnViewDAO();
		} // end if

		return cvDAO;
	}// getInstance

	private Connection getConnection() throws SQLException {
		Connection con = null;
		// 1. 드라이브 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2.
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";

		con = DriverManager.getConnection(url, id, pass);

		return con;
	}// getConnection

	public List<String> selectAllTableName() throws SQLException {
		List<String> list = new ArrayList<String>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1.
			// 2.
				con = getConnection();
			// 3.
				String selectTable = "SELECT tname FROM tab";
				
				pstmt = con.prepareStatement(selectTable);
			// 4. 바인드변수가 없음 
				
			// 5. 
				rs = pstmt.executeQuery(); //쿼리를 실행후 rs에 제어권을 받아온다. rs는 포인터를 가지고 있다.
				while(rs.next()) {
					list.add(rs.getString("tname"));
				}//end while
				
		} finally {
			// 5. 연결 끊기
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
	}// selectAllTableName
	
	public List<ColumnVO> selectOneTable(String tableName) throws SQLException{
		
		List<ColumnVO> list = new ArrayList<ColumnVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		//1.
		//2.
			con = getConnection();
		//3.
//			String selectTable = "select * from ?"; //테이블명을 바인드변수(?)로 처리할 수 없다.
			StringBuilder selectTable = new StringBuilder();
			//테이블명이나 컬럼명은 바인드변수로 사용하지 않고 쿼리문에 직접 넣어 코딩
			selectTable.append("SELECT * FROM ").append(tableName);
			pstmt = con.prepareStatement(selectTable.toString());
		//4.
//			pstmt.setString(1, tableName);
		//5.
			rs = pstmt.executeQuery();
			
			//////////////////////// ResultSetMetaData의 사용 ////////////////////////////
			ResultSetMetaData rsmd = rs.getMetaData();
//			System.out.println(rsmd.getColumnCount());
//			System.out.println(rsmd.getColumnName(3));
//			System.out.println(rsmd.getColumnTypeName(3));
//			System.out.println(rsmd.getPrecision(3));
			
			ColumnVO cVO = null;
			for(int i = 1; i <= rsmd.getColumnCount(); i++) {
				cVO = new ColumnVO(rsmd.getColumnName(i),rsmd.getColumnTypeName(i),rsmd.getPrecision(i),rsmd.isNullable(i));
	
				list.add(cVO);
			}
			
//			for(int i = 1; i <= rsmd.getColumnCount(); i++) {
//				System.out.println(rsmd.getColumnName(i) + "/"
//						+ rsmd.getColumnTypeName(i) + "/"
//						+ rsmd.getPrecision(i) + (rsmd.isNullable(i) == 0 ? "N.N":"null"));
//			}//end for
			
		}finally {
			//6. 연결 끊기
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
		}
		
		return list;
	}//selectOneTable
	
}// class
