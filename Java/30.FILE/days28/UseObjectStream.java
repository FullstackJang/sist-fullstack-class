package day1203;

import java.io.*;

/**
 * 객체를 JVM외부로 내보내거나, JVM외부에 존재하는 객체를 읽어들일 때 사용하는 Stream
 */
public class UseObjectStream {

    /**
     * 입력받은 객체를 JVM외부로 내보내는 일
     *
     * @param md
     */
    public void writeObj(MyData md) throws IOException, NotSerializableException {

        //1.객체를 내보내는 스트림 생성
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\jewel\\OneDrive\\문서\\temp\\obj.dat"));

            //2. 객체를 Stream에 쓰기 (직렬화가 된다.)
            oos.writeObject(md);

            //3. Stream의 남아있는 내용을 목적지로 분출
            oos.flush();
            System.out.println("객체가 JVM외부로 저장되었습니다.");
        } finally {
            //4.연결 끊기
            if (oos != null) {
                oos.close();
            }//end if
        }//end finally
    }//writeObject

    /**
     * JVM외부의 객체를 읽어 들여 반환하는 일
     *
     * @return
     */
    public MyData readObj() throws IOException, ClassNotFoundException {
        MyData md = null;

        ObjectInputStream ois = null;

        try {
            //1. 스트림 연결
            ois = new ObjectInputStream(new FileInputStream("C:\\Users\\jewel\\OneDrive\\문서\\temp\\obj.dat"));

            //2. 객체 읽기
            md = (MyData) ois.readObject(); //쪼개져 있는 객체가 합쳐진다.(역직렬화)

        } finally {
            if (ois != null) {
                ois.close();
            }//end if
        }//end finally

        return md;
    }//readObj

    public static void main(String[] args) {
        UseObjectStream uos = new UseObjectStream();

        MyData md = new MyData("류수정", 23, 160, 40);

        try {
            System.out.println("내보낸 객체:" + md);
            uos.writeObj(md); //객체 쓰기

            MyData md1 = uos.readObj();
            System.out.println("읽어들인 객체 " + md1);
        } catch (NotSerializableException ne) {
            System.err.println("객체가 직렬화되지 않습니다.");
            ne.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.err.println("읽어들인 값이 객체가 아닙니다.");
            cnfe.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }//end catch

    }//main

}//class
