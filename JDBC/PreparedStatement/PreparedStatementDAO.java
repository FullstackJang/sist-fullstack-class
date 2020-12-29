package day1229;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * PreparedStatement�� ����Ͽ�
 * 
 * @author owner
 *
 */
public class PreparedStatementDAO {

	private static PreparedStatementDAO psDAO;

	/**
	 * �ܺο��� ��ü������ �� ���� ������
	 */
	private PreparedStatementDAO() {

	}// PreparedStatementDAO

	/**
	 * �ϳ��� �����Ǵ� ��ü�� ��ȯ�ϴ� ��
	 * 
	 * @return singleton ��ü
	 */
	public static PreparedStatementDAO getInstance() {

		if (psDAO == null) {
			psDAO = new PreparedStatementDAO();
		} // end if

		return psDAO;
	}// PreparedStatementDAO

	/**
	 * Connection�� ��ȯ�ϴ� ��
	 * 
	 * @return Connection
	 * @throws SQLException
	 */
	private Connection getConnection() throws SQLException {
		// 1. ����̹��ε�
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // end catch

		// 2. Connection ���
		Connection con = null;

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";

		con = DriverManager.getConnection(url, id, pass);

		return con;
	}// getConnection

	/**
	 * CP_EMP2���̺� ���ڵ带 �߰�.
	 * 
	 * @param ceaVO �߰��� ��
	 * @throws SQLException
	 */
	public void insertCpEmp(CpEmpAddVO ceaVO) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			// 1.����̹� �ε�
			// 2.Ŀ�ؼ� ���
			con = getConnection();
			// 3.������ ������ü ���
			String insertCpEmp = "INSERT INTO cp_emp2(empno, ename, job, sal, comm, hiredate) Values(?,?,?,?,?,sysdate)";

			pstmt = con.prepareStatement(insertCpEmp);

			// 4.���ε� ������ ���ֱ�
			pstmt.setInt(1, ceaVO.getEmpno());
			pstmt.setString(2, ceaVO.getEname());
			pstmt.setString(3, ceaVO.getJob());
			pstmt.setInt(4, ceaVO.getSal());
			pstmt.setInt(5, ceaVO.getComm());

			// 5.���� ���� �İ�� ���

			// pstmt.executeUpdate(String) �θ𲨸� ����ϸ� ������ �ȳ����� ������ �ȵȴ�.
			pstmt.executeUpdate();

		} finally {
			// 6.���� ����

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
	 * �����ȣ, ����, ���� ,���ʽ��� �Է¹޾� ����� ������ ����
	 * 
	 * @param cemVO ������ ���� ���� VO
	 * @return ����� ���� ��(�� ���� �ٲ������)
	 * @throws SQLException
	 */
	public int updateCpEmp(CpEmpModifyVO cemVO) throws SQLException {
		int rowCnt = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			// 1. ����̹� �ε�
			// 2. Ŀ�ؼ� ���
			con = getConnection();
			// 3. ������ ������ü ���
			StringBuilder updateCpEmp = new StringBuilder();
			updateCpEmp.append(" UPDATE cp_emp2 ")
			.append(" SET job=?, sal=?, comm=? ")
			.append(" WHERE	 empno =? ");

			pstmt = con.prepareStatement(updateCpEmp.toString());

			// 4. ���ε� ������ �� �ֱ�
			pstmt.setString(1, cemVO.getJob());
			pstmt.setInt(2, cemVO.getSal());
			pstmt.setInt(3, cemVO.getComm());
			pstmt.setInt(4, cemVO.getEmpno());
			
			System.out.println(cemVO.getJob());
			// 5. ������ ���� �� ��� ���
			System.out.println(rowCnt);
			rowCnt = pstmt.executeUpdate();
			System.out.println(rowCnt);
		} finally {
			// 6. ���� ����
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
	 * �����ȣ�� �Է¹޾� ����� ����
	 * @param empno ������ �����ȣ
	 * @return ������ ���� ��
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
			
		//4. ���ε庯���� �� �ֱ�
			pstmt.setInt(1, empno);
		//5. 
			rowCnt = pstmt.executeUpdate();
		}finally {
		//6. ���� ����
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
