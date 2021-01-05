package day0105;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestTransacition {
	
	private Connection con;
	
	public Connection getConnection() throws SQLException{
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		
		con = DriverManager.getConnection(url,id,pass);
		
		return con;
	}//getConnection
	
	/**
	 * DB작업 : insert 두개가 모두 성공하였을 때에만 transaction완료
	 * @return
	 * @throws SQLException 
	 */
	public int dbJob() throws SQLException {
		int totalCnt = 0;
		
		PreparedStatement pstmt = null;
		try {
		//1.
		//2.
			con = getConnection();
			// autocommit을 해제
			con.setAutoCommit(false); //false시 개발자가 수동으로 commit rollback을 해줘야한다.
			int cnt1 = 0, cnt2 = 0;
			String name = "류수정4";
			String addr = "서울시 마포구";
			String insert1 = "insert into transaction1(name,addr)values(?,?)";
		//3.
			pstmt = con.prepareStatement(insert1);
		//4.
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
	
		//5.
			cnt1 = pstmt.executeUpdate();
			
			pstmt.close();
			String insert2 = "insert into transaction2(name,addr)values(?,?)";
		//3.
			pstmt = con.prepareStatement(insert2);
		//4.
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
		//5.
			cnt2= pstmt.executeUpdate();
			System.out.println(cnt1 + "/" + cnt2);

			totalCnt = cnt1 + cnt2;
		}finally {
		//6. 연결 끊기
			if(pstmt != null) {
				pstmt.close();
			}//end if
		}//end finally
		
		
		return totalCnt;
	}//dbJob
	
	/**
	 * DBMS를 사용하는 업무로직(연산수행)
	 */
	public void businessLogicJob() {
		int totalCnt = 0;
		try {
			totalCnt = dbJob();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//목표로한 행의 수가 수행되었는지 확인
				if(totalCnt == 2) {
					con.commit();
				}else {
					con.rollback();
				}//end else
				
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end catch
		}//end finally
		
	}//businessLogicJob
	
	public static void main(String[] args) {
		new TestTransacition().businessLogicJob();
	}//main
}//class
