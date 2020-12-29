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
		
		//1. ����̹� �ε�
		 try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		 
		//2. �ε��� ����̹��� ����Ͽ� Connection�� ���
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
			
		con = DriverManager.getConnection(url,id,pass); // DB ����
		
		//3. Connection���� ���� ������ ������ü ���
		stmt = con.createStatement();

		//4. ������ ���� �� ��� �ޱ�
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
		
		System.out.println(cnt+"�� �߰��Ǿ����ϴ�.");
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
		
		//1. ����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection con = null;
		Statement stmt = null;
		
		try {
		//2. Ŀ�ؼǾ��
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";

			con = DriverManager.getConnection(url,id,pass);
			
			
		//3. ������ ���� ��ü ���
			stmt = con.createStatement();
		//4. ������ ���� �� ��� ���
			StringBuilder updateC_emp = new StringBuilder();
		
			updateC_emp.append("Update cp_emp3 ")
			.append("SET deptno = 50, ")
			.append("job = '����',")
			.append("sal= 3200 ")
			.append("WHERE EMPNO =2222");
			
			rowCnt = stmt.executeUpdate(updateC_emp.toString());

		}finally {
		//5. ���� ����
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
		
		//1.����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch

		Connection con = null;
		Statement stmt = null;
		
	try {
	//2.Ŀ�ؼ� ���
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";

		con = DriverManager.getConnection(url,id,pass);
	//3.������ ���� ��ü ���
		stmt = con.createStatement();

	//4.������ ���� �� ��� ���
		StringBuilder deleteC_emp = new StringBuilder();
		deleteC_emp.append("delete from cp_emp3 where empno= '").append("2222").append("' ");
	
		rowCnt = stmt.executeUpdate(deleteC_emp.toString());

		return rowCnt;
		
	}finally {
	//5.���� ����
		if(stmt != null) {
			stmt.close();
		}//end if
		if(con != null) {
			con.close();
		}//end if
	}
	}
	


}//class
