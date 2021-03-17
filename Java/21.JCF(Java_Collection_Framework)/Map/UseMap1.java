package day1117;

import java.util.HashMap;
import java.util.Map;

public class UseMap1 {

    public void useHashMap(){
        
        //1. 맵 생성
        Map<String,String> map = new HashMap<String,String>();
        
        //2. 값 할당. 키와 값을 쌍으로 입력=> entry
        map.put("A","세심하다. 친절하다.");
        map.put("B","성질 드럽다.");
        map.put("AB","싸이코");
        map.put("O","우유부단");

        //키가 같다면 덮어 써진다.
        map.put("B","터프하다");
        map.put("AB","바보 아니면 천재");
        map.put("O","개그욕심");

        //String literal인 ""는 String class에서 제공하는 모든 method를 사용할 수 있다.
        String bloodType = "ab".toUpperCase(); // 체인 형식도 가능
        String s = bloodType.toUpperCase();

        if(map.containsKey(s)){ //키가 존재하는지?
            System.out.println(s + "형의 특징은 " + map.get(s));
        }else{
            System.out.println(bloodType + "은 사람의 혈액형이 아닙니다.");
        }

    }//useHashMap

    public static void main(String[] args) {

        UseMap1 um1 = new UseMap1();

        um1.useHashMap();

    }
}
