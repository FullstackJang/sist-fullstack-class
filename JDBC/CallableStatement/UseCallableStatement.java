package day0104;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Procedure 호출
 * @author owner
 */
public class UseCallableStatement {
	
	public UseCallableStatement() throws SQLException{
		
		//1. 드라이브 로딩
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end catch

			Connection con = null;
			CallableStatement cstmt = null;
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";
		try {
		//2. 커넥션얻기
			con = DriverManager.getConnection(url,id,pass);
		//3. 커리문생성객체얻기
			//plus_proc 호출 plus_proc(num1 NUMBER, num2 NUMBER, num3 OUT NUMBER)
			cstmt = con.prepareCall("{call plus_proc(?,?,?)}");
		//4. 바인드 변수에 값 설정
			int num1 = 100;
			int num2 = 300;
			//in parameter
				cstmt.setInt(1, num1);
				cstmt.setInt(2, num2);
			//out parameter : PL/SQL에서는 var로 선언하는 bind 변수
				cstmt.registerOutParameter(3, Types.NUMERIC);
		//5. 프로시저를 실행
				cstmt.execute();
		//6. out parameter에 설정된 값 받기
				int result = cstmt.getInt(3);
				System.out.println(num1 + "+" + num2 + "=" + result);
		}finally {
		//7. 연결 끊기
			if(cstmt != null) {
				cstmt.close();
			}//end if
			if(con != null) {
				con.close();
			}//end if
		}//end finally
	}//UseCallableStatement
	
	public static void main(String[] args) {
		try {
			new UseCallableStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//main
}//class
