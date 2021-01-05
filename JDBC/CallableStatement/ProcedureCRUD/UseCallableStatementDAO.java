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
 * procedure를 사용한 CRUD
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
		String ename = "류수정";
		int sal = 2800;
		
		try {
		//1.
		//2.
			con = getConnection();
		//3. 쿼리문 생성객체 얻기
			//procedure을 부를때에는 {} 중괄호를 넣어준다.
			cstmt = con.prepareCall("{ call insert_proc(?,?,?,?,?) }");
		//4. 바인드 변수에 값 넣기
			//in parameter : 프로시저에 입력하는 값 설정
			cstmt.setInt(1, empno);
			cstmt.setString(2, ename);
			cstmt.setInt(3, sal);
			//out parameter : 프로시저가 처리한 결과값을 받기위한 설정
			cstmt.registerOutParameter(4, Types.NUMERIC);
			cstmt.registerOutParameter(5, Types.VARCHAR);

		//5. 쿼리 실행 : procedure호출
			cstmt.execute();
		//6. out parameter 설정된 값 받기
			int cnt = cstmt.getInt(4);
			String msg = cstmt.getString(5);
			
			System.out.println(cnt);
			System.out.println(msg);
		}finally {
		//7. 연결 끊기
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
		String ename = "수정";
		int sal = 3000;
		try {
		//1.
		//2.
			con = getConnection();
		//3.
			cstmt = con.prepareCall("{ call update_proc(?,?,?,?,?)}");
		//4. 바인드 변수에 값 설정
			//in parameter
			cstmt.setInt(1, empno);
			cstmt.setString(2, ename);
			cstmt.setInt(3, sal);
			//out parameter
			cstmt.registerOutParameter(4, Types.NUMERIC);
			cstmt.registerOutParameter(5, Types.VARCHAR);
			
		//5.
			cstmt.execute();
		//6. out parameter 설정된 값 받기
			cnt = cstmt.getInt(4);
			String msg = cstmt.getString(5);
			System.out.println("Procedure에서 받은 값");
			System.out.println(cnt + "/" + msg);
		}finally {
		//7. 연결끊기
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
		//4. 바인드 변수에 값 설정
			//in parameter
			cstmt.setInt(1, empno);
			//out parameter
			cstmt.registerOutParameter(2, Types.NUMERIC);
			cstmt.registerOutParameter(3, Types.VARCHAR);
		//5.
			cstmt.execute();

		//6. out parameter 설정된 값 받기
			cnt = cstmt.getInt(2);
			String msg = cstmt.getString(3);
			System.out.println("Procedure에서 받은 값");
			System.out.println(cnt + "/" + msg);
		}finally{
			//7.연결 끊기
			if(cstmt != null) {
				cstmt.close();
			}//end close
			if(con != null) {
				con.close();
			}//end if
		}//end finally
		return cnt;
	}
	
	//조회
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
			//4. 바인드변수에 값 설정
				//in parameter
					cstmt.setString(1, hiredate);
				//out parameter
//					cstmt.registerOutParameter(2, Types.REF_CURSOR);//Java에서 제공하는 커서는 사용할 수 없다.
					//SYS_REFCURSOR를 받기위해 OracleTypes.CURSOR를 사용한다.
					cstmt.registerOutParameter(2, OracleTypes.CURSOR);
					cstmt.registerOutParameter(3, Types.VARCHAR);
						
			//5. 쿼리 실행
					cstmt.execute();
			//6. out parameter에 설정된 값 받기
					rs = (ResultSet)cstmt.getObject(2);
					String msg = cstmt.getString(3);
					System.out.println(msg);
					
					ProcedureVO pVO = null;
					
					while(rs.next()) {
						pVO = new ProcedureVO(rs.getInt("deptno"),rs.getInt("empno"),rs.getString("dname"),rs.getString("loc"),rs.getString("ename"),rs.getString("hiredate"));
						
						list.add(pVO);
					}//end while
					
			}finally {
			//7. 연결끊기
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
				System.out.println("해당 년도에 입사한 사원이 없습니다.");
			}//end if
			
			
			for(ProcedureVO pVO : list) {
				System.out.println(pVO.getDeptno()+ "/" + pVO.getDname() + "/" + pVO.getLoc()+ "/" + pVO.getEmpno()+ "/" + pVO.getEname() + "/" + pVO.getHiredate());
			}//end for
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		// 삭제
//		try {
//			int cnt = uscDAO.deleteTestProc();
//			if(cnt != 0) {
//				System.out.println("사원정보 삭제 성공");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		//업데이트
//		try {
//			int cnt = uscDAO.updateTestProc();
//			if(cnt != 0) {
//				System.out.println("사원정보 변경 성공");
//			}else {
//				System.out.println("사원번호를 확인하세요.");
//			}
//		} catch (SQLException e) {
//			System.out.println("쿼리문 실행 중 문제 발생");
//			e.printStackTrace();
//		}//end catch
		
		// 값 추가
//		try {
//			uscDAO.insertTestProc();
//			System.out.println("추가성공");
//		} catch (SQLException e) {
//			System.out.println("문제발생." + e);
//			e.printStackTrace();
//		}//end catch
	}
}
