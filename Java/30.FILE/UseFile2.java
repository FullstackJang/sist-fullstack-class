package day1201;

import java.io.File;

/**
 * 파일의 조작
 */
public class UseFile2 {

    public UseFile2(){

    }//UseFile2

    public void makeDirectory(){
        //1.생성할 디렉토리를 가진 File class를 생성
        File file = new File("c:/ilkyu");

        //2. 생성
       boolean flag = file.mkdir();
        System.out.println(flag);
        
        
    }//makeDirectory

    public void removeFile(){
        
        //삭제할 파일 생성
        File file = new File("C:\\Users\\jewel\\OneDrive\\문서\\temp\\java_read1.txt");

        //삭제
        System.out.println(file.delete());


    }//removeFile

    public void rename(){
        //1. 파일객체 생성
        File file = new File("C:\\Users\\jewel\\OneDrive\\문서\\temp\\java_read.txt");
        //변경할 이름을 가진 파일객체 생성
//        File rfile = new File("C:\\Users\\jewel\\OneDrive\\문서\\temp\\java_read1.txt");
        System.out.println(file.renameTo(new File("C:\\Users\\jewel\\OneDrive\\문서\\temp\\java_read1.txt")));

    }//rename

    public static void main(String[] args) {
           UseFile2 uf =  new UseFile2();
//           uf.makeDirectory();
//           uf.removeFile();
             uf.rename();
    }//main
}//class
