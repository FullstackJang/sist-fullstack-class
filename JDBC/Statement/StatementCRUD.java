package day1228;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementCRUD {
	private Connection con = null;
	private Statement stmt = null;
	
	public void insertProcess(CpDeptVo cdVO) throws SQLException {
		//1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end catch
		
		//2. 로딩된 드라이버를 사용하여 Connection을 얻기
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		
		
		try {
			con = DriverManager.getConnection(url,id,pass);
//			System.out.println("DB연결");
			
			//3. Connection으로 부터 쿼리문 생성객체 얻기
			stmt = con.createStatement();
		
			//4. 쿼리문 실행 후 결과 받기
//			String insertQuery = "insert into cp_dept(deptno,dname,loc) values("+cdVO.getDeptno()+",'"+cdVO.getDname()+"','"+cdVO.getLoc()+"')";
			
			StringBuilder insertQuery = new StringBuilder();
			insertQuery
			.append( "insert into cp_dept(deptno,dname,loc) values(")
			.append(cdVO.getDeptno()).append(",' ")
			.append(cdVO.getDname()).append("',' ")
			.append(cdVO.getLoc()).append("') ");
			
			int cnt = stmt.executeUpdate(insertQuery.toString());
			
			System.out.println(cnt+"건 추가되었습니다.");
			
		}finally {
			//5.연결 끊기
			if(stmt != null) { //2번에서 예외가 터지면 NullPointException을 뿌리기 때문에 if문으로 null아닐 시 끊어야한다.
				stmt.close();
			}
			if(con != null) {
				con.close();	
			}
		}//end finally
				
	}//insertProcess
	
	public int updateProcess(CpDeptVo cdVO) throws SQLException{
		int rowCnt = 0;
		
		//1. 드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection con = null;
		Statement stmt = null;
		
		try {
		//2. 커넥션얻기
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";

			con = DriverManager.getConnection(url,id,pass);
			
			
		//3. 쿼리문 생성 객체 얻기
			stmt = con.createStatement();
		//4. 쿼리문 수행 후 결과 얻기
			StringBuilder updateCpDept = new StringBuilder();
			
			updateCpDept
			.append("	update cp_dept ")
			.append("	set dname='").append(cdVO.getDname()).append("', loc='")
			.append(cdVO.getLoc()).append("' ")
			.append("	where deptno =").append(cdVO.getDeptno());
		
			rowCnt = stmt.executeUpdate(updateCpDept.toString());

		}finally {
		//5. 연결 끊기
			if(stmt != null) {
				stmt.close();
			}
			if(con != null) {
				con.close();
			}
		}//finally
		
		return rowCnt;
	}//updateProcess
	
	public int deleteProcess(int deptno) throws SQLException {
		int rowCnt = 0;
		
		//1.드라이버 로딩
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end catch

			Connection con = null;
			Statement stmt = null;
			
		try {
		//2.커넥션 얻기
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";

			con = DriverManager.getConnection(url,id,pass);
		//3.쿼리문 생성 객체 얻기
			stmt = con.createStatement();

		//4.쿼리문 수행 후 결과 얻기
			StringBuilder deleteCpDept = new StringBuilder();
			deleteCpDept.append("delete from cp_dept where deptno=").append(deptno);
		
			rowCnt = stmt.executeUpdate(deleteCpDept.toString());

			return rowCnt;
		}finally {
		//5.연결 끊기
			if(stmt != null) {
				stmt.close();
			}//end if
			if(con != null) {
				con.close();
			}//end if
		}
	}//deleteProcess
	
	
}//class
