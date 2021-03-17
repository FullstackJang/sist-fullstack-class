package day1117;

import java.util.*;

/**
 * 키와 값의 쌍으로 데이터가 존재하는 Map의 사용
 */
public class UseMap {

    /**
     * 기본생성자를 사용하여 객체를 생성하면 11개의 행이 생성되는 Hashtable을 사용
     * HashMap보다 속도가 느리다.
     */
    public void useHashtable() {

        //1.생성
        Map<String,String> map = new Hashtable<String,String>(); //Capacity(용량)을 100개로 잡아도 저장되어있는 키행 크기만 나온다.

        //2. 값 할당 : 순서대로 추가되지 않는다.
        map.put("Java","OOP언어");
        map.put("Oracle", "대용량 데이터 베이스");
        map.put("HTML","웹페이지의 구조설정");
        map.put("CSS","웹페이지의 통일성 있는 디자인 설정");

        //값은 중복 된다.
        map.put("Python","OOP언어");

        //키는 중복될 수 없다.: 같은 키가 존재하면 해당 키에 덮어 쓴다.
        map.put("Java","완벽한 OOP언어");


        //map.size 행의 크기
        System.out.println(map.size() +  "/" + map);

        //3. 행의 수
        System.out.println(map.size()+ "행");

        //4. 값 얻기
        System.out.println(map.get("Oracle"));  // 값이 나오거나 존재하는 키가 없으면 null이 나옴

        //5. 키가 존재하는 지?
        System.out.println(map.containsKey("Oracle"));

        //6. 모든 키 얻기
        Set<String> set = map.keySet();
        System.out.println("모든 키" + set);

        //7. 모든 값 얻기
        Iterator<String> ita = set.iterator();

        while(ita.hasNext()){
            System.out.println(map.get(ita.next()));
        }//end while

    }//useHashtable

    public void useHashMap() {
        //1.생성
        Map<String,String> map = new HashMap<String,String>(); //Capacity(용량)을 100개로 잡아도 저장되어있는 키행 크기만 나온다.

        //2. 값 할당 : 순서대로 추가되지 않는다.
        map.put("Java","OOP언어");
        map.put("Oracle", "대용량 데이터 베이스");
        map.put("HTML","웹페이지의 구조설정");
        map.put("CSS","웹페이지의 통일성 있는 디자인 설정");

        //값은 중복 된다.
        map.put("Python","OOP언어");

        //키는 중복될 수 없다.: 같은 키가 존재하면 해당 키에 덮어 쓴다.
        map.put("Java","완벽한 OOP언어");


        //map.size 행의 크기
        System.out.println(map.size() +  "/" + map);

        //3. 행의 수
        System.out.println(map.size()+ "행");

        //4. 값 얻기
        System.out.println(map.get("Oracle"));  // 값이 나오거나 존재하는 키가 없으면 null이 나옴

        //5. 키가 존재하는 지?
        System.out.println(map.containsKey("Oracle"));

        //6. 모든 키 얻기
        Set<String> set = map.keySet();
        System.out.println("모든 키" + set);

        //7. 모든 값 얻기
        Iterator<String> ita = set.iterator();

        while(ita.hasNext()){
            System.out.println(map.get(ita.next()));
        }//end while

    }//useHashTable

    public static void main(String[] args) {
        UseMap um = new UseMap();

        um.useHashtable();
        System.out.println("------------------------------------------------------------");
        um.useHashMap();

    }//main
}//class
