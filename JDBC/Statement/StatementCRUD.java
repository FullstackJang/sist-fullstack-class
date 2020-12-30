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
		// 1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end catch

		// 2. 로딩된 드라이버를 사용하여 Connection을 얻기
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";

		try {
			con = DriverManager.getConnection(url, id, pass);
//			System.out.println("DB연결");

			// 3. Connection으로 부터 쿼리문 생성객체 얻기
			stmt = con.createStatement();

			// 4. 쿼리문 실행 후 결과 받기
//			String insertQuery = "insert into cp_dept(deptno,dname,loc) values("+cdVO.getDeptno()+",'"+cdVO.getDname()+"','"+cdVO.getLoc()+"')";

			StringBuilder insertQuery = new StringBuilder();
			insertQuery.append("insert into cp_dept(deptno,dname,loc) values(").append(cdVO.getDeptno()).append(",' ")
					.append(cdVO.getDname()).append("',' ").append(cdVO.getLoc()).append("') ");

			int cnt = stmt.executeUpdate(insertQuery.toString());

			System.out.println(cnt + "건 추가되었습니다.");

		} finally {
			// 5.연결 끊기
			if (stmt != null) { // 2번에서 예외가 터지면 NullPointException을 뿌리기 때문에 if문으로 null아닐 시 끊어야한다.
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} // end finally

	}// insertProcess

	public int updateProcess(CpDeptVo cdVO) throws SQLException {
		int rowCnt = 0;

		// 1. 드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection con = null;
		Statement stmt = null;

		try {
			// 2. 커넥션얻기
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";

			con = DriverManager.getConnection(url, id, pass);

			// 3. 쿼리문 생성 객체 얻기
			stmt = con.createStatement();
			// 4. 쿼리문 수행 후 결과 얻기
			StringBuilder updateCpDept = new StringBuilder();

			updateCpDept.append("	update cp_dept ").append("	set dname='").append(cdVO.getDname()).append("', loc='")
					.append(cdVO.getLoc()).append("' ").append("	where deptno =").append(cdVO.getDeptno());

			rowCnt = stmt.executeUpdate(updateCpDept.toString());

		} finally {
			// 5. 연결 끊기
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

		// 1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end catch

		Connection con = null;
		Statement stmt = null;

		try {
			// 2.커넥션 얻기
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";

			con = DriverManager.getConnection(url, id, pass);
			// 3.쿼리문 생성 객체 얻기
			stmt = con.createStatement();

			// 4.쿼리문 수행 후 결과 얻기
			StringBuilder deleteCpDept = new StringBuilder();
			deleteCpDept.append("delete from cp_dept where deptno=").append(deptno);

			rowCnt = stmt.executeUpdate(deleteCpDept.toString());

			return rowCnt;
		} finally {
			// 5.연결 끊기
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

		// 1.드라이브 로딩
		try {
			// 패키지에 존재하는 클래스
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // end catch

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 2. 커넥션 얻기
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";

			con = DriverManager.getConnection(url, id, pass);

			// 3. 쿼리문 생성객체 얻기
			stmt = con.createStatement();

			// 4. 쿼리문 수행 후 결과 얻기
			String selectCpdept = "SELECT deptno, dname, loc l FROM cp_dept";
			rs = stmt.executeQuery(selectCpdept);

			int deptno = 0;
			String dname = "";
			String loc = "";

			CpDeptVo cdVO = null;

			while (rs.next()) { // 조회된 레코드가 존재한다면

				// 컬럼 값을 얻어와서 변수에 저장
				
				//컬럼의 인덱스는 1번부터 시작 (커서가 0번째)
				//인덱스로 값을 얻는건 권장하지않는다. 어떤 컬럼인지 알수 가 없다.
//				deptno = rs.getInt(1);
//				dname = rs.getString(2);
//				loc = rs.getString(3);
				
				deptno = rs.getInt("deptno"); //컬럼명을 명시하여 값 얻기
				dname = rs.getString("dname");
				loc = rs.getString("l");

				// 분할된 컬럼 값을 VO에 저장하여 묶어서 관리
				cdVO = new CpDeptVo(deptno, dname, loc);

				list.add(cdVO); // 이전에 발생한 모든 값을 저장

			} // end while

		} finally {
			// 5. 연결 끊기
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
			// 2. 커넥션 얻기
			con = DriverManager.getConnection(url, id, pass);
			// 3. 쿼리문 생성객체 얻기
			stmt = con.createStatement();
			// 4. 쿼리문 수행 후 결과 얻기
			StringBuilder selectCpDept = new StringBuilder();
			selectCpDept.append("SELECT dname, loc FROM cp_dept WHERE deptno=").append(deptno);

			rs = stmt.executeQuery(selectCpDept.toString());
			
			String dname = "";
			String loc = "";
			
			if(rs.next()) {// 조회된 행이 존재한다면
				//컬럼의 값을 받는다.
				dname = rs.getString("dname");
				loc = rs.getString("loc");
				
				cddVO = new CpDeptDnameVO(dname,loc);
				
			}//end if
			
		} finally {
			// 5. 연결 끊기
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

		return cddVO; //조회결과를 가진 VO 또는 null
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
