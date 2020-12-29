package day1229.HomeWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StatementDAO {

	private static StatementDAO sDAO;

	/**
	 * �ܺο��� ������ �� ���� ��ü ������.
	 */
	private StatementDAO() {
	}// StatementDAO

	/**
	 * �ϳ��� �����Ǵ� ��ü�� ��ȯ�ϴ� ��
	 * 
	 * @return singleton ��ü
	 */
	public static StatementDAO getInstance() {
		if (sDAO == null) {
			sDAO = new StatementDAO();
		}
		return sDAO;
	}// StatementDAO

	private Connection getConnection() throws SQLException {

		// 1. ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch

		// 2. Ŀ�ؼ� ���
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";

		con = DriverManager.getConnection(url, id, pass);

		return con;
	}// getConnection

	public List<EmpSearchVO> selectEmp() throws SQLException {
		List<EmpSearchVO> list = new ArrayList<EmpSearchVO>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 1. ����̺� �ε�
			// 2. Ŀ�ؼ� ���
			getConnection();

			// 3. ������ ���� ��ü ���
			stmt = con.createStatement();

			// 4. ������ ���� �� ��� ���
			StringBuilder selectEmp = new StringBuilder();

			selectEmp.append("SELECT empno, ename, deptno, sal, comm, job FROM EMP");

			rs = stmt.executeQuery(selectEmp.toString());

			int empno = 0;
			String ename = "";
			int deptno = 0;
			int sal = 0;
			int comm = 0;
			String job = "";
			EmpSearchVO esVO = null;

			while (rs.next()) {
				empno = rs.getInt("empno");
				ename = rs.getString("ename");
				deptno = rs.getInt("deptno");
				sal = rs.getInt("sal");
				comm = rs.getInt("comm");
				job = rs.getString("job");

				esVO = new EmpSearchVO(empno, ename, deptno, sal, comm, job);

				list.add(esVO);

			} // end while

		} finally {
			// 6. �������

			if (rs != null) {
				rs.close();
			} // end if

			if (stmt != null) {
				stmt.close();
			} // end if
			if (con != null) {
				con.close();
			}

		} // end finally

		return list;

	}// searchEmp
}// class