package day0105;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleTypes;

/**
 * procedure�� ����� CRUD
 * @author owner
 *
 */
public class UseCallableStatementDAO {
	
	private static UseCallableStatementDAO ucsDAO;
	
	private UseCallableStatementDAO() {
		
	}//UseCallableStatementDAO
	
	public static UseCallableStatementDAO getInstance() {
		
		if(ucsDAO == null) {
			ucsDAO = new UseCallableStatementDAO();
		}
		
			return ucsDAO;
	}//getInstance
	
	public Connection getConnection() throws SQLException{
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}//end catch
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String id = "scott";
		String pass = "tiger";
		
		con = DriverManager.getConnection(url,id,pass);
		
		return con;
	}//getConnection
	
	
	public void insertTestProc() throws SQLException{
		
		Connection con = null;
		CallableStatement cstmt = null;
		
		int empno = 1111;
		String ename = "������";
		int sal = 2800;
		
		try {
		//1.
		//2.
			con = getConnection();
		//3. ������ ������ü ���
			//procedure�� �θ������� {} �߰�ȣ�� �־��ش�.
			cstmt = con.prepareCall("{ call insert_proc(?,?,?,?,?) }");
		//4. ���ε� ������ �� �ֱ�
			//in parameter : ���ν����� �Է��ϴ� �� ����
			cstmt.setInt(1, empno);
			cstmt.setString(2, ename);
			cstmt.setInt(3, sal);
			//out parameter : ���ν����� ó���� ������� �ޱ����� ����
			cstmt.registerOutParameter(4, Types.NUMERIC);
			cstmt.registerOutParameter(5, Types.VARCHAR);

		//5. ���� ���� : procedureȣ��
			cstmt.execute();
		//6. out parameter ������ �� �ޱ�
			int cnt = cstmt.getInt(4);
			String msg = cstmt.getString(5);
			
			System.out.println(cnt);
			System.out.println(msg);
		}finally {
		//7. ���� ����
			if( cstmt != null) {
				cstmt.close();
			}//end if
			if ( con != null) {
				con.close();
			}//end if
		}
	}//insertTestProc
	
	public int updateTestProc()throws SQLException{
		int cnt = 0;
		
		Connection con = null;
		CallableStatement cstmt = null;
		int empno = 1111;
		String ename = "����";
		int sal = 3000;
		try {
		//1.
		//2.
			con = getConnection();
		//3.
			cstmt = con.prepareCall("{ call update_proc(?,?,?,?,?)}");
		//4. ���ε� ������ �� ����
			//in parameter
			cstmt.setInt(1, empno);
			cstmt.setString(2, ename);
			cstmt.setInt(3, sal);
			//out parameter
			cstmt.registerOutParameter(4, Types.NUMERIC);
			cstmt.registerOutParameter(5, Types.VARCHAR);
			
		//5.
			cstmt.execute();
		//6. out parameter ������ �� �ޱ�
			cnt = cstmt.getInt(4);
			String msg = cstmt.getString(5);
			System.out.println("Procedure���� ���� ��");
			System.out.println(cnt + "/" + msg);
		}finally {
		//7. �������
			if(cstmt != null) {
				cstmt.close();
			}//end if
			if(con != null) {
				con.close();
			}//end if
			
		}
		
		return cnt;
	}//updateTestProc
	
	public int deleteTestProc() throws SQLException {
		int cnt = 0;
		
		Connection con = null;
		CallableStatement cstmt = null;
		int empno = 1111;
		//1.
		//2.
		try {
			con = getConnection();
		//3.
			cstmt = con.prepareCall("{ call delete_proc(?,?,?)}");
		//4. ���ε� ������ �� ����
			//in parameter
			cstmt.setInt(1, empno);
			//out parameter
			cstmt.registerOutParameter(2, Types.NUMERIC);
			cstmt.registerOutParameter(3, Types.VARCHAR);
		//5.
			cstmt.execute();

		//6. out parameter ������ �� �ޱ�
			cnt = cstmt.getInt(2);
			String msg = cstmt.getString(3);
			System.out.println("Procedure���� ���� ��");
			System.out.println(cnt + "/" + msg);
		}finally{
			//7.���� ����
			if(cstmt != null) {
				cstmt.close();
			}//end close
			if(con != null) {
				con.close();
			}//end if
		}//end finally
		return cnt;
	}
	
	//��ȸ
	public List<ProcedureVO> selectProcedure(String hiredate) throws SQLException{
		List<ProcedureVO> list = new ArrayList<ProcedureVO>();
	
			Connection con = null;
			CallableStatement cstmt = null;
			ResultSet rs = null;
		
			try {
			//1.
			//2.
				con = getConnection();
			//3.
				cstmt = con.prepareCall("{ call select_proc (?,?,?)}");
			//4. ���ε庯���� �� ����
				//in parameter
					cstmt.setString(1, hiredate);
				//out parameter
//					cstmt.registerOutParameter(2, Types.REF_CURSOR);//Java���� �����ϴ� Ŀ���� ����� �� ����.
					//SYS_REFCURSOR�� �ޱ����� OracleTypes.CURSOR�� ����Ѵ�.
					cstmt.registerOutParameter(2, OracleTypes.CURSOR);
					cstmt.registerOutParameter(3, Types.VARCHAR);
						
			//5. ���� ����
					cstmt.execute();
			//6. out parameter�� ������ �� �ޱ�
					rs = (ResultSet)cstmt.getObject(2);
					String msg = cstmt.getString(3);
					System.out.println(msg);
					
					ProcedureVO pVO = null;
					
					while(rs.next()) {
						pVO = new ProcedureVO(rs.getInt("deptno"),rs.getInt("empno"),rs.getString("dname"),rs.getString("loc"),rs.getString("ename"),rs.getString("hiredate"));
						
						list.add(pVO);
					}//end while
					
			}finally {
			//7. �������
				if(rs != null) {
					rs.close();
				}//end if
				if(cstmt != null) {
					cstmt.close();
				}//end if
				if(con != null) {
					con.close();
				}//end if
			}//end finally
		
		return list;
	}//selectProcedure
	
	
	public static void main(String[] args) {
		
		UseCallableStatementDAO uscDAO = UseCallableStatementDAO.getInstance();
		
		String hiredate = "1987";
		try {
			List<ProcedureVO> list = uscDAO.selectProcedure(hiredate);
			
			System.out.println(hiredate);
			if(list.isEmpty()) {
				System.out.println("�ش� �⵵�� �Ի��� ����� �����ϴ�.");
			}//end if
			
			
			for(ProcedureVO pVO : list) {
				System.out.println(pVO.getDeptno()+ "/" + pVO.getDname() + "/" + pVO.getLoc()+ "/" + pVO.getEmpno()+ "/" + pVO.getEname() + "/" + pVO.getHiredate());
			}//end for
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		// ����
//		try {
//			int cnt = uscDAO.deleteTestProc();
//			if(cnt != 0) {
//				System.out.println("������� ���� ����");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		//������Ʈ
//		try {
//			int cnt = uscDAO.updateTestProc();
//			if(cnt != 0) {
//				System.out.println("������� ���� ����");
//			}else {
//				System.out.println("�����ȣ�� Ȯ���ϼ���.");
//			}
//		} catch (SQLException e) {
//			System.out.println("������ ���� �� ���� �߻�");
//			e.printStackTrace();
//		}//end catch
		
		// �� �߰�
//		try {
//			uscDAO.insertTestProc();
//			System.out.println("�߰�����");
//		} catch (SQLException e) {
//			System.out.println("�����߻�." + e);
//			e.printStackTrace();
//		}//end catch
	}
}
