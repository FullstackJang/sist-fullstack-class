package pad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Homework {				

	private JTextArea jta = new JTextArea();
	private JScrollPane jsp = new JScrollPane(jta); 
	private List<String> student = new ArrayList<String>();
	private boolean loop = true;
    private final int NUM_1 = 1;
    private final int NUM_2 = 2;
    private final int NUM_3 = 3;
    private BufferedReader br;
    
	public Homework() {
		jta.append("이름\n");
		jta.append("======\n");
		getBufferedReader();
	}
	
	public void getBufferedReader() {
		
		System.out.println("메뉴 : 1.이름 입력  2.출력  3.종료");
		br = new BufferedReader(new InputStreamReader(System.in));
		int idx = 3;
		while(idx == NUM_3) {
			try {
			  switch(Integer.parseInt(br.readLine())){
	            case NUM_1:
	                            String StudentName = JOptionPane.showInputDialog("이름을 입력하세요.");
	                            student.add(StudentName);
	                            jta.append(StudentName + "\n");
	                            break;
	            case NUM_2:
	                            JOptionPane.showMessageDialog(null,jsp);
	                            break;

	            case NUM_3:   int flag2 =  JOptionPane.showConfirmDialog(null,"정말종료하시겠습니까?");
	                            switch(flag2){
	                                case JOptionPane.OK_OPTION:
	                                    System.out.println("감사합니다.");
	                                    
	                                    break;
	                                case JOptionPane.NO_OPTION: System.out.println("아니오");
	                                case JOptionPane.CANCEL_OPTION: System.out.println("취소");
	                            }//end switch
	                            break;
	        }//end switch
			}catch(NumberFormatException nfe) {
	    		System.out.println("1 2 3 중에 입력 부탁드립니다.");
			}catch(IOException ie) {
				System.out.println("오류가 발생했습니다.");
			}
		}
	}
	
	
	
	public static void main(String[] args) {
			new Homework();
	}

}
