package day1116;

import java.util.List;
import java.util.Vector;

/**
 * - 검색의 기능이 있으며, 중복 데이터를 저장할 수 있는 List의 사용
 * - 가변길이형: 데이터의 추가, 삭제작업에 따라 방의 갯수가 변경된다.
 */
public class UseList {
    /**
     * Multi Thread에서 동시 접근 불가능 (동기화)
     * 속도가 ArrayList보다 느리다.
     */
    public void useVector() {
        //1. 생성 : Generic은 기본형을 사용할 수 없음 / 기본형 대신 Wrapper Class를 사용
        Vector<Integer> vec = new Vector<Integer>(3);

        //기본 방의 크기, size로 방의 크기가 나오지 않음, 데이터가 추가되면 방의 크기가 늘어난다.
        List<String> list = new Vector<String>();

        System.out.println("벡터의 크기" + vec.size());
        System.out.println("리스트의 크기" + list.size());

        //2. 값 추가: Generic으로 설정 된 데이터형만 추가 가능
        vec.add(10); // 기본형 데이터형을 추가하면, 컴파일러가
        // 기본형 데이터형을 추가하면,JVM이 기본형 데이터형에 대응되는 Wrpper Class를 사용하여 객체를 만들고 추가한다. JDK1.5에서부터 추가 된 autoboxing이라고 한다.
        vec.add(20); // => vec.add(new Integer(20));으로 변경된다.
        System.out.println("벡터의 크기" + vec.size()); // size 2
        vec.add(30);
        vec.add(10); // 위에 Capacity의 크기를 3으로 지정하였지만, capacity의 크기를 초과하더라도 방이 증가하여 추가된다.
        System.out.println("벡터의 크기" + vec.size()); // size 4
        System.out.println(vec); // Object.toString()를 Vector가 Override하여 주소가 아닌 값이 출력

        list.add("사나");
        list.add("모모");
        list.add("츠치");
        list.add("미나");
        list.add("다현");
        System.out.println("list 크기: " + list.size() + ", " + list);

        //---배열로 복사
        //배열을 리스트의 크기로 설정
        //        int[] arr = new int[vec.size()]; //int와 Integer은 동일 데이터형이 아니다.
        Integer[] arr1 = new Integer[vec.size()];
        String[] arr = new String[list.size()];

        //복사: Generic을 사용하지 않고 복사하면(에러)경고가 발생한다.
            list.toArray(arr);
            vec.toArray(arr1);

        //3. 값 얻기: Unboxing
        String name = list.get(0); //입력데이터형과 저장하는 데이터형 같다면 Unboxing 동작 x
        System.out.println(name);

        int num = vec.get(0); // Wrapper Class가 Generic으로 설정되어 있을 때 기본형 데이터형으로 값을 얻으면 JVM이 Wrapper Class에서 기본형으로 값을 얻어내는 Unboxing을 수행 함

        //int num = vec.get(0).intValue(); // ((Integer)vec.get(0)).intValue();

        System.out.println(name + "/" + num);

        //4. 일괄처리
        for (int i = 0; i < vec.size(); i++) {
            System.out.println(vec.get(i));
        }//end for

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }//end for

        //값 삭제
        //index
        vec.remove(1); //20삭제
        list.remove(3); //"츠치"삭제
        System.out.println(vec);
        System.out.println(list);

        //Ojbect
        vec.remove(new Integer(30)); // 30이 삭제 되었습니다.  //정수가 들어갔다면 Wrapper로 객체를 만들어서 지우면 된다. JDK 1.8까지
        vec.remove(Integer.valueOf(30)); // 30이 삭제 JDK9 이후에는 생성자가 비추천으로 변경되어 static method사용
        list.remove("사나");
        System.out.println(vec);
        System.out.println(list);//사나삭제

        System.out.println("vec가 비었는가?" + vec.isEmpty());
        System.out.println("list가 비었는가?" + list.isEmpty());

        //모든 방의 값을 삭제
        vec.clear();
        list.clear();
        System.out.println("vec가 비었는가?" + vec.isEmpty());
        System.out.println("list가 비었는가?" + list.isEmpty());

        System.out.println(list.size() == 0);

        System.out.println("------배열에 복사한 내용--------");
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);

        }     for(int i = 0; i < arr1.length; i++){
            System.out.println(arr1[i]);
        }
    }//useVector

    /**
     * Multi Thread는 동시 접근 가능 (비동기화)
     * 속도가 Vector보다 빠르다.
     */
    public void useArrayList() {
    }//useArrayList

    public static void main(String[] args) {

        UseList ul = new UseList();

        ul.useVector();
        System.out.println("--------------------");
        ul.useArrayList();

    }//main
}//class
