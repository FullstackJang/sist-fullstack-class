package day1201;

import java.io.*;

/**
 * 16bit stream을 사용하여 파일의 모든 내용을 읽기.
 */
public class UseFileReader {
    //File 클래스를 사용하여 File이 존재하는지 확인하기 때문에 예외를 날리지 않아도 된다.
    public UseFileReader() throws /*FileNotFoundException,*/ IOException {
        File file = new File("C:\\Prj\\src\\day1201\\UseFileReader.java");

        //1. 파일에 스트림 연결
        if (file.exists()) { //파일이 존재한다면
            //1. 파일에 스트림 연결
            FileInputStream fis = new FileInputStream(file);

            //2. CharacterSet을 Encoding하는 기능의 스트림을 사용
            //Encoding charset은 원본 파일의 charset으로 설정
            InputStreamReader isr = new InputStreamReader(fis,"UTF-8");// 원본파일에 charset이 MS949이면 MS949로 맞춰야함

            //3. 줄단위로 연결들이는 기능이 있는 스트림을 연결
            BufferedReader br = new BufferedReader(isr);

            //4. 스트림을 사용하여 입력의 근원에서 한줄을 읽어 들임
//            System.out.println(br.readLine());
//            System.out.println(br.readLine());
//            System.out.println(br.readLine());
//            System.out.println(br.readLine());

            String str = "";
            while((str =br.readLine()) != null){ //파일의 끝(EOF)에는 null이 나온다.
                System.out.println(str);
            }//end while


            //5. 스트림 사용이 완료되었으면, 연결된 스트림을 끊는다.
            br.close();
        } else {
            System.out.println(file + "이 존재하지 않습니다.");
        }
    }//UseFileReader

    public static void main(String[] args) {
        try {
            new UseFileReader();
//        }  catch(FileNotFoundException fnfe){
//            System.err.println("파일이 존재하지 않습니다.");
//            fnfe.printStackTrace();
        } catch (IOException ie) {
            System.err.println("파일의 내용을 읽어 들일 수 없습니다.");
            ie.printStackTrace();
        }
    }

}//UseFileReader
