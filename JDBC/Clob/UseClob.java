package day0105;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UseClob {

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
	
	public UseClob() throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		//1.
		//2.
			con = getConnection();
		//3.
			String select = "select subject, contents, writer, to_char(input_date,'yyyy-mm-dd') input_date FROM test_clob";
			pstmt = con.prepareStatement(select);
			
		//4. ���ε庯�� ���ֱ� // ���ε� ����������

		//5.
			rs = pstmt.executeQuery();
			
			String subject = "";
			String contents = "";
			String writer = "";
			String input_date = "";
			
			BufferedReader br = null;

			while(rs.next()) {
				subject = rs.getString("subject");
//				contents = rs.getString("contents"); //local�ΰ�쿡�� ���� ������ ����.
				//clob ���������� �о���̱� ���ؼ� Stream�� ����
				br = new BufferedReader(rs.getClob("contents").getCharacterStream());
				writer = rs.getString("writer");
				input_date = rs.getString("input_date");
				
				System.out.println("-------------------------------------------");

				System.out.println("����:" + subject);
//				System.out.println("����:" + contents);
				System.out.print("����: ");
				try {
				while( (contents = br.readLine()) != null) {
					System.out.println(contents);
				}//end while
				}catch(IOException ie) {
					System.out.println("��縦 �о���� �� �����ϴ�.");
				}finally {
					try {
						if (br != null) {br.close();}//end if
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("�ۼ���:" + input_date +"\n" +"�ۼ���:" + writer);
			}//end while
			
		}finally {
		//6. ���� ����
			if(rs != null) {
				rs.close();
			}//end if
			if(pstmt != null) {
				pstmt.close();
			}//end if
			if(con != null) {
				con.close();
			}//end if
		}
	}//UseClob
	
	
	public static void main(String[] args) {
		try {
			new UseClob();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//main
}//class
