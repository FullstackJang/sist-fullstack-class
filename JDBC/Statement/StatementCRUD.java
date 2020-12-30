package day1228;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StatementCRUD {
	private Connection con = null;
	private Statement stmt = null;

	public void insertProcess(CpDeptVo cdVO) throws SQLException {
		// 1. ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end catch

		// 2. �ε��� ����̹��� ����Ͽ� Connection�� ���
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";

		try {
			con = DriverManager.getConnection(url, id, pass);
//			System.out.println("DB����");

			// 3. Connection���� ���� ������ ������ü ���
			stmt = con.createStatement();

			// 4. ������ ���� �� ��� �ޱ�
//			String insertQuery = "insert into cp_dept(deptno,dname,loc) values("+cdVO.getDeptno()+",'"+cdVO.getDname()+"','"+cdVO.getLoc()+"')";

			StringBuilder insertQuery = new StringBuilder();
			insertQuery.append("insert into cp_dept(deptno,dname,loc) values(").append(cdVO.getDeptno()).append(",' ")
					.append(cdVO.getDname()).append("',' ").append(cdVO.getLoc()).append("') ");

			int cnt = stmt.executeUpdate(insertQuery.toString());

			System.out.println(cnt + "�� �߰��Ǿ����ϴ�.");

		} finally {
			// 5.���� ����
			if (stmt != null) { // 2������ ���ܰ� ������ NullPointException�� �Ѹ��� ������ if������ null�ƴ� �� ������Ѵ�.
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} // end finally

	}// insertProcess

	public int updateProcess(CpDeptVo cdVO) throws SQLException {
		int rowCnt = 0;

		// 1. ����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection con = null;
		Statement stmt = null;

		try {
			// 2. Ŀ�ؼǾ��
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";

			con = DriverManager.getConnection(url, id, pass);

			// 3. ������ ���� ��ü ���
			stmt = con.createStatement();
			// 4. ������ ���� �� ��� ���
			StringBuilder updateCpDept = new StringBuilder();

			updateCpDept.append("	update cp_dept ").append("	set dname='").append(cdVO.getDname()).append("', loc='")
					.append(cdVO.getLoc()).append("' ").append("	where deptno =").append(cdVO.getDeptno());

			rowCnt = stmt.executeUpdate(updateCpDept.toString());

		} finally {
			// 5. ���� ����
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} // finally

		return rowCnt;
	}// updateProcess

	public int deleteProcess(int deptno) throws SQLException {
		int rowCnt = 0;

		// 1.����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end catch

		Connection con = null;
		Statement stmt = null;

		try {
			// 2.Ŀ�ؼ� ���
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";

			con = DriverManager.getConnection(url, id, pass);
			// 3.������ ���� ��ü ���
			stmt = con.createStatement();

			// 4.������ ���� �� ��� ���
			StringBuilder deleteCpDept = new StringBuilder();
			deleteCpDept.append("delete from cp_dept where deptno=").append(deptno);

			rowCnt = stmt.executeUpdate(deleteCpDept.toString());

			return rowCnt;
		} finally {
			// 5.���� ����
			if (stmt != null) {
				stmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		}
	}// deleteProcess

	public List<CpDeptVo> selectAllCpDept() throws SQLException {
		List<CpDeptVo> list = new ArrayList<CpDeptVo>();

		// 1.����̺� �ε�
		try {
			// ��Ű���� �����ϴ� Ŭ����
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 2. Ŀ�ؼ� ���
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";

			con = DriverManager.getConnection(url, id, pass);

			// 3. ������ ������ü ���
			stmt = con.createStatement();

			// 4. ������ ���� �� ��� ���
			String selectCpdept = "SELECT deptno, dname, loc l FROM cp_dept";
			rs = stmt.executeQuery(selectCpdept);

			int deptno = 0;
			String dname = "";
			String loc = "";

			CpDeptVo cdVO = null;

			while (rs.next()) { // ��ȸ�� ���ڵ尡 �����Ѵٸ�

				// �÷� ���� ���ͼ� ������ ����
				
				//�÷��� �ε����� 1������ ���� (Ŀ���� 0��°)
				//�ε����� ���� ��°� ���������ʴ´�. � �÷����� �˼� �� ����.
//				deptno = rs.getInt(1);
//				dname = rs.getString(2);
//				loc = rs.getString(3);
				
				deptno = rs.getInt("deptno"); //�÷����� ����Ͽ� �� ���
				dname = rs.getString("dname");
				loc = rs.getString("l");

				// ���ҵ� �÷� ���� VO�� �����Ͽ� ��� ����
				cdVO = new CpDeptVo(deptno, dname, loc);

				list.add(cdVO); // ������ �߻��� ��� ���� ����

			} // end while

		} finally {
			// 5. ���� ����
			if (rs != null) {
				rs.close();
			} // end if

			if (stmt != null) {
				stmt.close();
			} // end if

			if (con != null) {
				con.close();
			} // end if
		} // end finally

		return list;
	}// selectAllCpDept

	public CpDeptDnameVO selectCpDeptOne(int deptno) throws SQLException {
		CpDeptDnameVO cddVO = null;

		// 1.
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 2. Ŀ�ؼ� ���
			con = DriverManager.getConnection(url, id, pass);
			// 3. ������ ������ü ���
			stmt = con.createStatement();
			// 4. ������ ���� �� ��� ���
			StringBuilder selectCpDept = new StringBuilder();
			selectCpDept.append("SELECT dname, loc FROM cp_dept WHERE deptno=").append(deptno);

			rs = stmt.executeQuery(selectCpDept.toString());
			
			String dname = "";
			String loc = "";
			
			if(rs.next()) {// ��ȸ�� ���� �����Ѵٸ�
				//�÷��� ���� �޴´�.
				dname = rs.getString("dname");
				loc = rs.getString("loc");
				
				cddVO = new CpDeptDnameVO(dname,loc);
				
			}//end if
			
		} finally {
			// 5. ���� ����
			if (rs != null) {
				rs.close();
			} // end if
			if (stmt != null) {
				stmt.close();
			} // end if
			if (con != null) {
				con.close();
			} // end if
		} // end finally

		return cddVO; //��ȸ����� ���� VO �Ǵ� null
	}// selectCpDeptOne

	public static void main(String[] args ) {
		try {
		StatementCRUD st = new StatementCRUD();
		System.out.println(st.selectAllCpDept());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}// class
