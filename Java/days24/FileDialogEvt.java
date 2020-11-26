package day1126;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FileDialogEvt extends WindowAdapter implements ActionListener {

	private UseFileDialog ufd;

	/**
	 * ������ Ŭ������ �̺�Ʈó�� Ŭ������ has a����� �����ϴ� ������
	 * 
	 * @param ufd
	 */
	public FileDialogEvt(UseFileDialog ufd) {
		this.ufd = ufd;
	}// FileDialogEvt

	@Override
	public void actionPerformed(ActionEvent ae) {

		// �̺�Ʈ�� �߻� ���� �� ���� ������ �ڵ常 �����ؾ� ���ϴ� �̺�Ʈ�� ����� �ս��� �� �� �ִ�.
		if (ae.getSource() == ufd.getJbtnFileopen()) {// �����ư���� �̺�Ʈ �߻�
			openFileDialog();
		} // end if

		if (ae.getSource() == ufd.getJbtnFileSave()) {// �����ư���� �̺�Ʈ �߻�
			saveFileDialog();
		} // end if

	}// actionPerformed

	@Override
	public void windowClosing(WindowEvent e) {
		ufd.dispose();
	}// windowClosing

	private void openFileDialog() {
		// 1. Dialog ����
		FileDialog fdOpen = new FileDialog(ufd, "���� ����", FileDialog.LOAD);

		// 2. ����ڿ��� �����ֱ�
		fdOpen.setVisible(true);

		String dir = fdOpen.getDirectory(); //������
		String fileName = fdOpen.getFile(); //���ϸ�
		
		if(dir != null) {
		//������ ���ϸ��� JTextArea�� �߰�
		
//			ufd.getJtaFileList().append("����: "+dir + "" + fileName + "\n");	
		StringBuilder sb = new StringBuilder();
		sb.append("���� :").append(dir).append(fileName).append("\n");
		ufd.getJtaFileList().append(sb.toString());
		
		//JFrame�� title bar�� �����Ѵ�.
		ufd.setTitle("���ϴ��̾�α� - ����");
		}//end if
		
	}// openFileDialog

	private void saveFileDialog() {
		// 1. Dialog ����
		FileDialog fdSave = new FileDialog(ufd, "���� ����", FileDialog.SAVE);

		// 2. ����ڿ��� �����ֱ�
		fdSave.setVisible(true);
		
		String dir = fdSave.getDirectory(); //������
		String fileName = fdSave.getFile(); //���ϸ�
		
		if(dir != null) {
		
		StringBuilder sb = new StringBuilder("����: ");
		sb.append(dir).append(fileName).append("\n");
		ufd.getJtaFileList().append(sb.toString());
		
		//������ ���ϸ��� JTextArea�� �߰�
//		ufd.getJtaFileList().append("����: "+dir + "" + fileName + "\n");
		
		//JFrame�� title bar�� �����Ѵ�.
		ufd.setTitle("���ϴ��̾�α� - ����");
		}//end if

	}// saveFileDialog

}// class
