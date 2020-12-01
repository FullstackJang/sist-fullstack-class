package day1201;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

public class Homework {

   private String path;
   private FileInputStream fis;
   private JTextArea jta;
   private JScrollPane jsp;
    public Homework(){
        jta = new JTextArea(10,100);
        jsp = new JScrollPane(jta);
        getPath();
    }//Homework

    public void getPath(){
          path = JOptionPane.showInputDialog("경로를 입력해주세요");
          File file = new File(path);

          if (file.exists() && file.isDirectory()) {
              String[] dir = file.list();

              jta.append("|이름|\t|수정한날짜|\t|유형|\t|크기|\n");
              jta.append("--------------------------------------------------------------------------\n");

              for (String name : dir) {
                  File file1 = new File(file, name);
                  String flag = (file1.isFile() ? "파일" : "폴더");
                  jta.append("|" + name + "|\t|" + new Date(file1.lastModified()) + "|" + flag + "|" + file1.length() + "\n");
              }
              JOptionPane.showMessageDialog(null, jsp);
          }//end if
        else{
            JOptionPane.showMessageDialog(null,"경로를 확인하세요.");
          }

    }//getpPath
    public static void main(String[] args) {
        new Homework();
    }
}
