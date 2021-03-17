package day1126;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FileDialogEvt extends WindowAdapter implements ActionListener {

	private UseFileDialog ufd;

	/**
	 * 디자인 클래스와 이벤트처리 클래스를 has a관계로 설정하는 생성자
	 * 
	 * @param ufd
	 */
	public FileDialogEvt(UseFileDialog ufd) {
		this.ufd = ufd;
	}// FileDialogEvt

	@Override
	public void actionPerformed(ActionEvent ae) {

		// 이벤트가 발생 했을 때 비교할 목적의 코드만 정의해야 비교하는 이벤트의 목록을 손쉽게 알 수 있다.
		if (ae.getSource() == ufd.getJbtnFileopen()) {// 열기버튼에서 이벤트 발생
			openFileDialog();
		} // end if

		if (ae.getSource() == ufd.getJbtnFileSave()) {// 저장버튼에서 이벤트 발생
			saveFileDialog();
		} // end if

	}// actionPerformed

	@Override
	public void windowClosing(WindowEvent e) {
		ufd.dispose();
	}// windowClosing

	private void openFileDialog() {
		// 1. Dialog 생성
		FileDialog fdOpen = new FileDialog(ufd, "파일 열기", FileDialog.LOAD);

		// 2. 사용자에게 보여주기
		fdOpen.setVisible(true);

		String dir = fdOpen.getDirectory(); //폴더명
		String fileName = fdOpen.getFile(); //파일명
		
		if(dir != null) {
		//선택한 파일명을 JTextArea에 추가
		
//			ufd.getJtaFileList().append("열기: "+dir + "" + fileName + "\n");	
		StringBuilder sb = new StringBuilder();
		sb.append("열기 :").append(dir).append(fileName).append("\n");
		ufd.getJtaFileList().append(sb.toString());
		
		//JFrame의 title bar를 변경한다.
		ufd.setTitle("파일다이얼로그 - 열기");
		}//end if
		
	}// openFileDialog

	private void saveFileDialog() {
		// 1. Dialog 생성
		FileDialog fdSave = new FileDialog(ufd, "파일 저장", FileDialog.SAVE);

		// 2. 사용자에게 보여주기
		fdSave.setVisible(true);
		
		String dir = fdSave.getDirectory(); //폴더명
		String fileName = fdSave.getFile(); //파일명
		
		if(dir != null) {
		
		StringBuilder sb = new StringBuilder("저장: ");
		sb.append(dir).append(fileName).append("\n");
		ufd.getJtaFileList().append(sb.toString());
		
		//선택한 파일명을 JTextArea에 추가
//		ufd.getJtaFileList().append("저장: "+dir + "" + fileName + "\n");
		
		//JFrame의 title bar를 변경한다.
		ufd.setTitle("파일다이얼로그 - 저장");
		}//end if

	}// saveFileDialog

}// class
