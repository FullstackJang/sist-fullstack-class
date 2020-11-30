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
		jta.append("�̸�\n");
		jta.append("======\n");
		getBufferedReader();
	}
	
	public void getBufferedReader() {
		
		System.out.println("�޴� : 1.�̸� �Է�  2.���  3.����");
		br = new BufferedReader(new InputStreamReader(System.in));
		int idx = 3;
		while(idx == NUM_3) {
			try {
			  switch(Integer.parseInt(br.readLine())){
	            case NUM_1:
	                            String StudentName = JOptionPane.showInputDialog("�̸��� �Է��ϼ���.");
	                            student.add(StudentName);
	                            jta.append(StudentName + "\n");
	                            break;
	            case NUM_2:
	                            JOptionPane.showMessageDialog(null,jsp);
	                            break;

	            case NUM_3:   int flag2 =  JOptionPane.showConfirmDialog(null,"���������Ͻðڽ��ϱ�?");
	                            switch(flag2){
	                                case JOptionPane.OK_OPTION:
	                                    System.out.println("�����մϴ�.");
	                                    
	                                    break;
	                                case JOptionPane.NO_OPTION: System.out.println("�ƴϿ�");
	                                case JOptionPane.CANCEL_OPTION: System.out.println("���");
	                            }//end switch
	                            break;
	        }//end switch
			}catch(NumberFormatException nfe) {
	    		System.out.println("1 2 3 �߿� �Է� ��Ź�帳�ϴ�.");
			}catch(IOException ie) {
				System.out.println("������ �߻��߽��ϴ�.");
			}
		}
	}
	
	
	
	public static void main(String[] args) {
			new Homework();
	}

}
