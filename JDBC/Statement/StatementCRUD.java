package day1228;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementCRUD {
	private Connection con = null;
	private Statement stmt = null;
	
	public void insertProcess(CpDeptVo cdVO) throws SQLException {
		//1. ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end catch
		
		//2. �ε��� ����̹��� ����Ͽ� Connection�� ���
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		
		
		try {
			con = DriverManager.getConnection(url,id,pass);
//			System.out.println("DB����");
			
			//3. Connection���� ���� ������ ������ü ���
			stmt = con.createStatement();
		
			//4. ������ ���� �� ��� �ޱ�
//			String insertQuery = "insert into cp_dept(deptno,dname,loc) values("+cdVO.getDeptno()+",'"+cdVO.getDname()+"','"+cdVO.getLoc()+"')";
			
			StringBuilder insertQuery = new StringBuilder();
			insertQuery
			.append( "insert into cp_dept(deptno,dname,loc) values(")
			.append(cdVO.getDeptno()).append(",' ")
			.append(cdVO.getDname()).append("',' ")
			.append(cdVO.getLoc()).append("') ");
			
			int cnt = stmt.executeUpdate(insertQuery.toString());
			
			System.out.println(cnt+"�� �߰��Ǿ����ϴ�.");
			
		}finally {
			//5.���� ����
			if(stmt != null) { //2������ ���ܰ� ������ NullPointException�� �Ѹ��� ������ if������ null�ƴ� �� ������Ѵ�.
				stmt.close();
			}
			if(con != null) {
				con.close();	
			}
		}//end finally
				
	}//insertProcess
	
	public int updateProcess(CpDeptVo cdVO) throws SQLException{
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
			StringBuilder updateCpDept = new StringBuilder();
			
			updateCpDept
			.append("	update cp_dept ")
			.append("	set dname='").append(cdVO.getDname()).append("', loc='")
			.append(cdVO.getLoc()).append("' ")
			.append("	where deptno =").append(cdVO.getDeptno());
		
			rowCnt = stmt.executeUpdate(updateCpDept.toString());

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
	
	public int deleteProcess(int deptno) throws SQLException {
		int rowCnt = 0;
		
		//1.����̹� �ε�
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
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
			StringBuilder deleteCpDept = new StringBuilder();
			deleteCpDept.append("delete from cp_dept where deptno=").append(deptno);
		
			rowCnt = stmt.executeUpdate(deleteCpDept.toString());

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
	}//deleteProcess
	
	
}//class
