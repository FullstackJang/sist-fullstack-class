package day0105;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestTransacition {
	
	private Connection con;
	
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
	
	/**
	 * DB�۾� : insert �ΰ��� ��� �����Ͽ��� ������ transaction�Ϸ�
	 * @return
	 * @throws SQLException 
	 */
	public int dbJob() throws SQLException {
		int totalCnt = 0;
		
		PreparedStatement pstmt = null;
		try {
		//1.
		//2.
			con = getConnection();
			// autocommit�� ����
			con.setAutoCommit(false); //false�� �����ڰ� �������� commit rollback�� ������Ѵ�.
			int cnt1 = 0, cnt2 = 0;
			String name = "������4";
			String addr = "����� ������";
			String insert1 = "insert into transaction1(name,addr)values(?,?)";
		//3.
			pstmt = con.prepareStatement(insert1);
		//4.
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
	
		//5.
			cnt1 = pstmt.executeUpdate();
			
			pstmt.close();
			String insert2 = "insert into transaction2(name,addr)values(?,?)";
		//3.
			pstmt = con.prepareStatement(insert2);
		//4.
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
		//5.
			cnt2= pstmt.executeUpdate();
			System.out.println(cnt1 + "/" + cnt2);

			totalCnt = cnt1 + cnt2;
		}finally {
		//6. ���� ����
			if(pstmt != null) {
				pstmt.close();
			}//end if
		}//end finally
		
		
		return totalCnt;
	}//dbJob
	
	/**
	 * DBMS�� ����ϴ� ��������(�������)
	 */
	public void businessLogicJob() {
		int totalCnt = 0;
		try {
			totalCnt = dbJob();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//��ǥ���� ���� ���� ����Ǿ����� Ȯ��
				if(totalCnt == 2) {
					con.commit();
				}else {
					con.rollback();
				}//end else
				
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end catch
		}//end finally
		
	}//businessLogicJob
	
	public static void main(String[] args) {
		new TestTransacition().businessLogicJob();
	}//main
}//class
