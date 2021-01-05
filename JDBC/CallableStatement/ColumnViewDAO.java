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
		// 1. ����̺� �ε�
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
			// 4. ���ε庯���� ���� 
				
			// 5. 
				rs = pstmt.executeQuery(); //������ ������ rs�� ������� �޾ƿ´�. rs�� �����͸� ������ �ִ�.
				while(rs.next()) {
					list.add(rs.getString("tname"));
				}//end while
				
		} finally {
			// 5. ���� ����
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
//			String selectTable = "select * from ?"; //���̺���� ���ε庯��(?)�� ó���� �� ����.
			StringBuilder selectTable = new StringBuilder();
			//���̺���̳� �÷����� ���ε庯���� ������� �ʰ� �������� ���� �־� �ڵ�
			selectTable.append("SELECT * FROM ").append(tableName);
			pstmt = con.prepareStatement(selectTable.toString());
		//4.
//			pstmt.setString(1, tableName);
		//5.
			rs = pstmt.executeQuery();
			
			//////////////////////// ResultSetMetaData�� ��� ////////////////////////////
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
			//6. ���� ����
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
