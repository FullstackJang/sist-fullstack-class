package day0104;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Procedure ȣ��
 * @author owner
 */
public class UseCallableStatement {
	
	public UseCallableStatement() throws SQLException{
		
		//1. ����̺� �ε�
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
		//2. Ŀ�ؼǾ��
			con = DriverManager.getConnection(url,id,pass);
		//3. Ŀ����������ü���
			//plus_proc ȣ�� plus_proc(num1 NUMBER, num2 NUMBER, num3 OUT NUMBER)
			cstmt = con.prepareCall("{call plus_proc(?,?,?)}");
		//4. ���ε� ������ �� ����
			int num1 = 100;
			int num2 = 300;
			//in parameter
				cstmt.setInt(1, num1);
				cstmt.setInt(2, num2);
			//out parameter : PL/SQL������ var�� �����ϴ� bind ����
				cstmt.registerOutParameter(3, Types.NUMERIC);
		//5. ���ν����� ����
				cstmt.execute();
		//6. out parameter�� ������ �� �ޱ�
				int result = cstmt.getInt(3);
				System.out.println(num1 + "+" + num2 + "=" + result);
		}finally {
		//7. ���� ����
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
