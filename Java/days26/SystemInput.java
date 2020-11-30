package day1130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**
 * 입력의 근원 중 시스템의 입력인 키보드에서 입력된 값 받기
 * @author owner
 */
public class SystemInput {

	public SystemInput() {

		System.out.println("아무키나 누르고 엔터.");
		
		try {
//			int keyCode = System.in.read();
//			System.out.println("입력값: " + keyCode);
			
//			int 0keyCode = 0;
//			
//			//읽어 들일 수 없는 값이 존재하면 read()에 -1이 리턴된다.
//			while((keyCode=System.in.read()) != 13) {
//				System.out.println((char)keyCode);
//			}//end while
			
			//1 키보드입력을 읽어 들일 수 있는 8bit stream과 줄 단위로 읽어 들일 수 있는 16bit stream을 연결하여 
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			//2 줄 단위로 읽어들여
			String msg = br.readLine();
			//3 출력한다.
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