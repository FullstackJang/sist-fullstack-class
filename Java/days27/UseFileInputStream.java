package day1201;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 8bit stream을 사용하여 HDD의 존재하는 File 내용 읽기
 */
public class UseFileInputStream {

    public UseFileInputStream(){
        try {
            //1. 파일스트림 생성
            FileInputStream fis = new FileInputStream(new File("C:\\Users\\jewel\\OneDrive\\문서\\temp\\java_read.txt"));
                                                    //파일에 이미지는 출력할 수 없다.
        //2. 파일의 내용 읽기
//            System.out.println((char)fis.read());
            int temp = 0;
            while((temp = fis.read()) != -1) {
                System.out.print((char)temp); //영어,숫자,특수문자는 잘나오지만, 2byte쓰는 한글은 깨져서 나온다.
            }
        }catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }catch(IOException ie){
            ie.printStackTrace();
        }//end catch

    }//UseFileInputStream

    public static void main(String[] args) {
            new UseFileInputStream();
    }//main
}//class
