package day1202;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 16bit Stream을 사용하여 문자열 데이터를 파일에 기록
 */
public class UseBufferedWriter {

    public UseBufferedWriter() throws IOException {

        BufferedWriter bw = null;
        try {
            //1. 파일에 스트림 연결
            bw = new BufferedWriter(new FileWriter(new File("C:\\Users\\jewel\\OneDrive\\문서\\temp\\string_data.txt")));
            //2. 데이터를 스트림에 기록
            String msg = "코로나 추가확진자 511명 국내 496명 해외 18명";
            bw.write(msg);
            //3. 스트림에 내용을 목적지로 분출
                bw.flush();
            System.out.println("파일에 기록이 완료");
            /*flust()를 안쓰고 close()를 하면 내용이 써지는 이유는
             * flush()에서 내용을 분출하고 혹시나 연결을 끊을 때 분출할 내용이 있으면 분출한다.
             * flush()는 써주자.
             * */
        }finally {
            //4. 연결 끊기
            if(bw != null){ //finally여서 반드시 실행됨 / 객체가 생성되어있다면 끊는다.
                bw.close();
            }//end if
        }//end finally
    }//UseFileWriter

    public static void main(String[] args) {
        try {
            new UseBufferedWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }//end catch
    }//main
}//class
