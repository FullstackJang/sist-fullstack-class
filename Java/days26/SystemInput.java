package day1130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**
 * �Է��� �ٿ� �� �ý����� �Է��� Ű���忡�� �Էµ� �� �ޱ�
 * @author owner
 */
public class SystemInput {

	public SystemInput() {

		System.out.println("�ƹ�Ű�� ������ ����.");
		
		try {
//			int keyCode = System.in.read();
//			System.out.println("�Է°�: " + keyCode);
			
//			int 0keyCode = 0;
//			
//			//�о� ���� �� ���� ���� �����ϸ� read()�� -1�� ���ϵȴ�.
//			while((keyCode=System.in.read()) != 13) {
//				System.out.println((char)keyCode);
//			}//end while
			
			//1 Ű�����Է��� �о� ���� �� �ִ� 8bit stream�� �� ������ �о� ���� �� �ִ� 16bit stream�� �����Ͽ� 
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//2 �� ������ �о�鿩
			String msg = br.readLine();
			//3 ����Ѵ�.
			System.out.println(msg);
			
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
	}//SystemInput
	
	public static void main(String[] args) {

		JTextArea jta = new JTextArea(10,30); // row, cols
		JScrollPane jsp = new JScrollPane(jta);
		jta.append("JAVA\n");
		jta.append("Oracle\n");
		jta.append("JSP");
		
		JOptionPane.showMessageDialog(null, jsp);
		
		new SystemInput();
		


		
	}//main
	
}//class