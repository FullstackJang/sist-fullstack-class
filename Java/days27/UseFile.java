package day1201;

import java.io.File;
import java.io.IOException;

/**
 * HDD에 존재하는 File의 정보를 얻거나 조작할 때 사용하는 File 클래스 사용법
 */
public class UseFile {

    public UseFile(){

        //1.생성
        File file = new File("c:\\Users\\jewel\\OneDrive\\문서\\temp\\java_read.txt");
                    //폴더는 파일 저장한 파일이다.

        System.out.println(file); // 객체 경로가 나오는 이유: toString을 Override해서 주소가 아닌 경로가 나오는 것

        if(file.exists()) { //파일이 존재하는 지
            System.out.println("파일 크기 " + file.length());
            System.out.println("절대경로" + file.getAbsolutePath());
            System.out.println(file.getAbsoluteFile());
            try {
                System.out.println(file.getCanonicalPath());
            } catch (IOException ie) {
                ie.printStackTrace();
            }//end try catch
            //파일 경로
            System.out.println("파일경로:" + file.getPath());

            //파일이 존재하는 경로명:
            System.out.println("파일이 존재하는 경로명: " + file.getParent());

            //파일명
            System.out.println("파일명: " + file.getName());
            
            //파일인지
            System.out.println("파일인지: " + file.isFile());
            System.out.println(file.isFile() ? "파일" : "폴더");

            //폴더인지
            System.out.println("폴더인지: " + file.isDirectory());
            System.out.println(file.isDirectory() ? "폴더" : "파일");
            
            //실행 가능한지?
            System.out.println("실행가능: " + file.canExecute());

            //읽기 가능한지?
            System.out.println("읽기가능: " + file.canRead());
            
            //쓰기 가능(해당 파일에 글을 쓸 수 있는지 ?)
            System.out.println("쓰기가능: " + file.canWrite());

            System.out.println("숨김파일: " + file.isHidden());

        }else {
            System.out.println(file + "파일 경로나 파일명을 확인하세요");
        }
    }//UseFile

    public static void main(String[] args) {
            new UseFile();
    }//main

}//class
