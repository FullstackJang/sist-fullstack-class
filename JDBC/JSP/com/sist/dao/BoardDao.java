package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.BoardVo;

public class BoardDao {
	
	// ��� ���ڵ带 �˻��Ͽ� ��ȯ�ϴ� �޼ҵ带 ����
	// SELECT * FROM board
	public ArrayList<BoardVo> arrRecord(){
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		
		try {
			String sql = "select * from board";
			
			//1. jdbc ����̹��� �޸𸮷� �ε��Ѵ�.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. db������ �����Ѵ�.
			String url = "jdbc:oracle:thin@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			
			Connection conn = DriverManager.getConnection(url,user,pwd);
			
			//3. Statement��ü�� �����Ѵ�.
			Statement stmt = conn.createStatement();
			//4. sql����� �����Ѵ�.
			ResultSet rs = stmt.executeQuery(sql);
				
			// rs�� ��� �� ��ŭ list�� ��� �ݴϴ�.
			// cursor�� ���྿ ����Ų��.
			while(rs.next()) { //���� ���ڵ尡 ������ true ���� ���ڵ尡 ������ false
				BoardVo b = new BoardVo();
				b.setNo(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setPwd(rs.getString(3));
				b.setEmail(rs.getString(4));
				b.setTitle(rs.getString(5));
				b.setContent(rs.getString(6));
				b.setFname(rs.getString(7));
				
				list.add(b);
			}//end while
			
			//5. ����ߴ� �ڿ����� �ݾ� �ش�.
			rs.close();
			stmt.close();
			conn.close();
			
		}catch(Exception e){
			System.out.println("���ܹ߻�:" + e.getMessage());
		}
		
		return null;
	}
	
	// insert�� ���ؼ���
	// Statement Ŭ������ executeUpdate�޼ҵ带 ����մϴ�.
	// �� �޼ҵ�� ���������� sql�� ������ ���ڵ��� ���� ��ȯ�Ѵ�.
	// �츮�� �������θ� int�� ��ȯ�ϱ�� �ؿ�.
	
	public int insertBoard(BoardVo bv) {
		int re = -1;

		try {
			String sql = "insert into board values(seq_board.nextval,?,?,?,?,?,?)";
			
			//1. jdbc ����̹��� �޸𸮷� �ε��Ѵ�.
			Class.forName("oracle.jdbc.OracleDriver");

			//2. db Server�� �����Ѵ�.
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection conn = DriverManager.getConnection(url,user,pwd);
		
			//3. sql ������ ���� Statement(PreparedStatement)��ü�� �����Ѵ�.
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. ������ ?�� ���� �����Ѵ�.
			pstmt.setString(1, bv.getName());
			pstmt.setString(2, bv.getPwd());
			pstmt.setString(3, bv.getEmail());
			pstmt.setString(4, bv.getTitle());
			pstmt.setString(5, bv.getContent());
			pstmt.setString(6, bv.getFname());
			
			//5. sql����� �����Ų��.
			// executeUpdate ==> �����ͺ��̽��� ������ �ִ� ���(insert, update, delete)
			//				 ==> int�� ��ȯ(���������� ����� ������ ���� ��)
			// executeQuery ==> �����ͺ��̽��� ��ȸ ��� (select)
			//				==> �˻��� ����� ResultSet���� ��ȯ
			
			//re = pstmt.executeUpdate(sql); �Ű������ִ°� ����ϸ� �ȵȴ�.
			re = pstmt.executeUpdate();
			
			//6. ����ߴ� �ڿ��� �ݾ��ش�.
			//���߿� �����Ѱͺ��� ���� �ݴ´�.
			pstmt.close();
			conn.close();
		}catch (Exception e) {
			System.out.println("���ܹ߻�" + e.getMessage());
		}//end catch
		
		return re;
	}

}//class