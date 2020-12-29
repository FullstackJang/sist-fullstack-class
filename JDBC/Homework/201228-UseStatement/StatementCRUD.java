package Homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import day1228.CpDeptVo;

public class StatementCRUD {
	
	private Connection con = null;
	private Statement stmt = null;
	
	//===================== INSERT ==============================
	public void insertProcess(CpEmpVO ceVO) throws SQLException {
		
		//1. 드라이버 로딩
		 try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		 
		//2. 로딩된 드라이버를 사용하여 Connection을 얻기
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
			
		con = DriverManager.getConnection(url,id,pass); // DB 연결
		
		//3. Connection으로 부터 쿼리문 생성객체 얻기
		stmt = con.createStatement();

		//4. 쿼리문 실행 후 결과 받기
		try {
		StringBuilder insertQeury = new StringBuilder();
		
		insertQeury.append("INSERT INTO cp_emp3(empno,ename,hiredate,deptno,job,sal) VALUES('")
		.append(ceVO.getEmpno()).append("', '")
		.append(ceVO.getEname()).append("', ")
		.append(ceVO.getHiredate()).append(", '")
		.append(ceVO.getDeptno()).append("', '")
		.append(ceVO.getJob()).append("', '")
		.append(ceVO.getSal()).append("')");
		
		int cnt = stmt.executeUpdate(insertQeury.toString());
		
		System.out.println(cnt+"건 추가되었습니다.");
		}finally {
			if(stmt != null) {
				stmt.close();
			}//end if
			if(con != null) {
				con.close();
			}
		}
	}//insertProcess
	
	//=======================UPDATE==========================
	public int updateProcess(CpEmpVO ceVO) throws SQLException{
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
			StringBuilder updateC_emp = new StringBuilder();
		
			updateC_emp.append("Update cp_emp3 ")
			.append("SET deptno = 50, ")
			.append("job = '주임',")
			.append("sal= 3200 ")
			.append("WHERE EMPNO =2222");
			
			rowCnt = stmt.executeUpdate(updateC_emp.toString());

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
	
	public int deleteProcess(CpEmpVO ceVO) throws SQLException {
		int rowCnt = 0;
		
		//1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
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
		StringBuilder deleteC_emp = new StringBuilder();
		deleteC_emp.append("delete from cp_emp3 where empno= '").append("2222").append("' ");
	
		rowCnt = stmt.executeUpdate(deleteC_emp.toString());

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
	}
	


}//class
