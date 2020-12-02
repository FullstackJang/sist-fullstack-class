package day1202;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * JVM안에서 발생한 데이터를 파일에 기록
 */
public class UseFileOutputStream {
    FileOutputStream fos = null;

    public UseFileOutputStream() throws IOException{
        try {
            File path = new File("C:\\Users\\jewel\\OneDrive\\문서\\temp");
            if(!path.exists()) { //파일을 생성할 폴더가 없다면 
                path.mkdirs(); //폴더를 생성
            }//end if

            //생성된 경로를 사용하여 파일 생성.
            File file = new File(path.getAbsolutePath()+"text.txt");

            //1. 스트림 생성 (덮어쓰거나, 생성한다.)
            fos = new FileOutputStream(file);
                int i = 98;
                //2. 스트림에 목적지로 보낼 내용을 쓴다.(기본형은 flush를 하지않아도 목적지로 분출되고, 참조형은 반드시 flush를 해야  목적지로 분출된다.)
                fos.write(65); //IOException
                //3. 스트림에 기록된 내용을 목적지로 분출
                fos.flush();//IOException

                System.out.println("파일에 기록되었습니다.");
            } finally {
                if(fos != null) { //nullpointerexception대신 fos가 null이 아니면 fos를 끊어라
                    fos.close(); }//end if
        }//end finally
    }//UseFileOutptStream


    public static void main(String[] args) {
        try {
            new UseFileOutputStream();
        } catch (IOException e) {
            //생성자안에서 발생한 IOException을 모아서 처리할 수 있다.(코드를 집중할 수 있다.)
            //예외가 발생한 코드와 예외를 처리할 코드를 분리할 수 있음.(복잡도가 낮아진다.)
            e.printStackTrace();
        }
    }
}
