package day1229;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * PreparedStatement를 사용하여
 * 
 * @author owner
 *
 */
public class PreparedStatementDAO {

	private static PreparedStatementDAO psDAO;

	/**
	 * 외부에서 객체생성할 수 없는 생성자
	 */
	private PreparedStatementDAO() {

	}// PreparedStatementDAO

	/**
	 * 하나로 관리되는 객체를 반환하는 일
	 * 
	 * @return singleton 객체
	 */
	public static PreparedStatementDAO getInstance() {

		if (psDAO == null) {
			psDAO = new PreparedStatementDAO();
		} // end if

		return psDAO;
	}// PreparedStatementDAO

	/**
	 * Connection을 반환하는 일
	 * 
	 * @return Connection
	 * @throws SQLException
	 */
	private Connection getConnection() throws SQLException {
		// 1. 드라이버로딩
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end catch

		// 2. Connection 얻기
		Connection con = null;

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";

		con = DriverManager.getConnection(url, id, pass);

		return con;
	}// getConnection

	/**
	 * CP_EMP2테이블에 레코드를 추가.
	 * 
	 * @param ceaVO 추가할 값
	 * @throws SQLException
	 */
	public void insertCpEmp(CpEmpAddVO ceaVO) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			// 1.드라이버 로딩
			// 2.커넥션 얻기
			con = getConnection();
			// 3.쿼리문 생성객체 얻기
			String insertCpEmp = "INSERT INTO cp_emp2(empno, ename, job, sal, comm, hiredate) Values(?,?,?,?,?,sysdate)";

			pstmt = con.prepareStatement(insertCpEmp);

			// 4.바인드 변수에 값넣기
			pstmt.setInt(1, ceaVO.getEmpno());
			pstmt.setString(2, ceaVO.getEname());
			pstmt.setString(3, ceaVO.getJob());
			pstmt.setInt(4, ceaVO.getSal());
			pstmt.setInt(5, ceaVO.getComm());

			// 5.쿼리 수행 후결과 얻기

			// pstmt.executeUpdate(String) 부모꺼를 사용하면 오류는 안나지만 실행이 안된다.
			pstmt.executeUpdate();

		} finally {
			// 6.연결 끊기

			if (pstmt != null) {
				pstmt.close();
			} // end if

			if (con != null) {
				con.close();
			} // end if
		} // end finally

	}// inserCpEmp

	public List<CpEmpAllVO> selectAllCpEmp(int empno) throws SQLException {

		return null;
	}// selectAllCpEmp

	public CpEmpOneVO selectOneCpEmp(int empno) throws SQLException {

		return null;
	}// selectOneCpEmp

	/**
	 * 사원번호, 직무, 연봉 ,보너스를 입력받아 사원의 정보를 변경
	 * 
	 * @param cemVO 변경할 값을 가진 VO
	 * @return 변경된 행의 수(몇 행이 바뀌었는지)
	 * @throws SQLException
	 */
	public int updateCpEmp(CpEmpModifyVO cemVO) throws SQLException {
		int rowCnt = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			// 1. 드라이버 로딩
			// 2. 커넥션 얻기
			con = getConnection();
			// 3. 쿼리문 생성객체 얻기
			StringBuilder updateCpEmp = new StringBuilder();
			updateCpEmp.append(" UPDATE cp_emp2 ")
			.append(" SET job=?, sal=?, comm=? ")
			.append(" WHERE	 empno =? ");

			pstmt = con.prepareStatement(updateCpEmp.toString());

			// 4. 바인드 변수에 값 넣기
			pstmt.setString(1, cemVO.getJob());
			pstmt.setInt(2, cemVO.getSal());
			pstmt.setInt(3, cemVO.getComm());
			pstmt.setInt(4, cemVO.getEmpno());
			
			System.out.println(cemVO.getJob());
			// 5. 쿼리문 수행 후 결과 얻기
			System.out.println(rowCnt);
			rowCnt = pstmt.executeUpdate();
			System.out.println(rowCnt);
		} finally {
			// 6. 연결 끊기
			if (pstmt != null) {
				pstmt.close();
			} // end if

			if (con != null) {
				con.close();
			} // end if

		} // end finally

		return rowCnt;
	}// updateCpEmp

	
	/**
	 * 사원번호를 입력받아 사원을 삭제
	 * @param empno 삭제할 사원번호
	 * @return 삭제된 행의 수
	 * @throws SQLException
	 */
	public int deleteCpEmp(int empno) throws SQLException {
		int rowCnt = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
		//1.
		//2.
			con = getConnection();
		//3.
			String deleteCpEmp = "DELETE FROM cp_emp2 WHERE empno = ?";
			
			pstmt = con.prepareStatement(deleteCpEmp.toString());
			
		//4. 바인드변수에 값 넣기
			pstmt.setInt(1, empno);
		//5. 
			rowCnt = pstmt.executeUpdate();
		}finally {
		//6. 연결 끊기
			if(pstmt != null) {
				pstmt.close();
			}//end if
			if(con != null) {
				con.close();
			}//end if
		}//end finally
		
		return rowCnt;
	}// deleteCpEmp
}// class
