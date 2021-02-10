package com.sist.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.sist.Vo.GoodsVO;

public class GoodsDAO {
	
	
	private static GoodsDAO dao;
	private GoodsDAO() {
		
	}
	
	public static GoodsDAO getInstance() {
		if(dao == null) {
			dao = new GoodsDAO();
		}
		return dao;
	}

	public int insert(GoodsVO g) {
		int re = -1;
		String sql = " INSERT INTO goods VALUES(?,?,?,?,?) ";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url ="jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			
			Connection conn = DriverManager.getConnection(url,user,pwd);

			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,g.getNo());
			pstmt.setString(2, g.getName());
			pstmt.setInt(3, g.getQty());
			pstmt.setInt(4, g.getPrice());
			pstmt.setString(5,g.getFname());
			
			re = pstmt.executeUpdate();
			
			if(pstmt != null) {
				pstmt.close();
			}
			
			if(conn != null) {
				conn.close();
			}
			
		}catch (Exception e) {
			System.out.println("오류내용 : " + e.getMessage());
		}
		return re;
	}
	
	
	
	
	
}
