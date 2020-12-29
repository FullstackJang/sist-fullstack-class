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
	 * 외부에서 생성할 수 없는 객체 생성자.
	 */
	private StatementDAO() {
	}// StatementDAO

	/**
	 * 하나로 관리되는 객체를 반환하는 일
	 * 
	 * @return singleton 객체
	 */
	public static StatementDAO getInstance() {
		if (sDAO == null) {
			sDAO = new StatementDAO();
		}
		return sDAO;
	}// StatementDAO

	private Connection getConnection() throws SQLException {

		// 1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch

		// 2. 커넥션 얻기
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
			// 1. 드라이브 로딩
			// 2. 커넥션 얻기
			getConnection();

			// 3. 쿼리문 생성 객체 얻기
			stmt = con.createStatement();

			// 4. 쿼리문 수행 후 결과 얻기
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
			// 6. 연결끊기

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