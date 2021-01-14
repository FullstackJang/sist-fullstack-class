package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.BoardVo;

public class BoardDao {
	
	// 모든 레코드를 검색하여 반환하는 메소드를 정의
	// SELECT * FROM board
	public ArrayList<BoardVo> arrRecord(){
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		
		try {
			String sql = "select * from board";
			
			//1. jdbc 드라이버를 메모리로 로드한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. db서버에 연결한다.
			String url = "jdbc:oracle:thin@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			
			Connection conn = DriverManager.getConnection(url,user,pwd);
			
			//3. Statement객체를 생성한다.
			Statement stmt = conn.createStatement();
			//4. sql명령을 실행한다.
			ResultSet rs = stmt.executeQuery(sql);
				
			// rs에 담긴 수 만큼 list에 담아 줍니다.
			// cursor가 한행씩 가리킨다.
			while(rs.next()) { //다음 레코드가 있으면 true 다음 레코드가 없으면 false
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
			
			//5. 사용했던 자원들을 닫아 준다.
			rs.close();
			stmt.close();
			conn.close();
			
		}catch(Exception e){
			System.out.println("예외발생:" + e.getMessage());
		}
		
		return null;
	}
	
	// insert를 위해서는
	// Statement 클래스의 executeUpdate메소드를 사용합니다.
	// 이 메소드는 성공적으로 sql을 실행한 레코드의 수를 반환한다.
	// 우리도 성공여부를 int로 반환하기로 해요.
	
	public int insertBoard(BoardVo bv) {
		int re = -1;

		try {
			String sql = "insert into board values(seq_board.nextval,?,?,?,?,?,?)";
			
			//1. jdbc 드라이버를 메모리로 로드한다.
			Class.forName("oracle.jdbc.OracleDriver");

			//2. db Server에 연결한다.
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection conn = DriverManager.getConnection(url,user,pwd);
		
			//3. sql 실행을 위한 Statement(PreparedStatement)객체를 생성한다.
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. 각각의 ?에 값을 설정한다.
			pstmt.setString(1, bv.getName());
			pstmt.setString(2, bv.getPwd());
			pstmt.setString(3, bv.getEmail());
			pstmt.setString(4, bv.getTitle());
			pstmt.setString(5, bv.getContent());
			pstmt.setString(6, bv.getFname());
			
			//5. sql명령을 실행시킨다.
			// executeUpdate ==> 데이터베이스에 변동이 있는 명령(insert, update, delete)
			//				 ==> int를 반환(성공적으로 명령을 수행한 행의 수)
			// executeQuery ==> 데이터베이스에 조회 명령 (select)
			//				==> 검색한 결과를 ResultSet으로 반환
			
			//re = pstmt.executeUpdate(sql); 매개변수있는걸 사용하면 안된다.
			re = pstmt.executeUpdate();
			
			//6. 사용했던 자원을 닫아준다.
			//나중에 연결한것부터 먼저 닫는다.
			pstmt.close();
			conn.close();
		}catch (Exception e) {
			System.out.println("예외발생" + e.getMessage());
		}//end catch
		
		return re;
	}

}//class